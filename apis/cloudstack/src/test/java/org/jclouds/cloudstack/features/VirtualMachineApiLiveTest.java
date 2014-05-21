/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.cloudstack.features;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Predicates.in;
import static com.google.common.collect.Iterables.find;
import static com.google.common.collect.Iterables.get;
import static com.google.common.collect.Iterables.getFirst;
import static com.google.common.collect.Iterables.getOnlyElement;
import static com.google.common.collect.Sets.filter;
import static org.jclouds.cloudstack.options.ListNetworksOptions.Builder.isDefault;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

import org.jclouds.cloudstack.CloudStackApi;
import org.jclouds.cloudstack.domain.Account;
import org.jclouds.cloudstack.domain.AsyncCreateResponse;
import org.jclouds.cloudstack.domain.AsyncJob;
import org.jclouds.cloudstack.domain.GuestIPType;
import org.jclouds.cloudstack.domain.NIC;
import org.jclouds.cloudstack.domain.Network;
import org.jclouds.cloudstack.domain.NetworkOffering;
import org.jclouds.cloudstack.domain.ServiceOffering;
import org.jclouds.cloudstack.domain.Template;
import org.jclouds.cloudstack.domain.VirtualMachine;
import org.jclouds.cloudstack.domain.Zone;
import org.jclouds.cloudstack.internal.BaseCloudStackApiLiveTest;
import org.jclouds.cloudstack.options.AddNicToVirtualMachineOptions;
import org.jclouds.cloudstack.options.AssignVirtualMachineOptions;
import org.jclouds.cloudstack.options.CreateNetworkOptions;
import org.jclouds.cloudstack.options.DeployVirtualMachineOptions;
import org.jclouds.cloudstack.options.ListAccountsOptions;
import org.jclouds.cloudstack.options.ListNetworkOfferingsOptions;
import org.jclouds.cloudstack.options.ListNetworksOptions;
import org.jclouds.cloudstack.options.ListTemplatesOptions;
import org.jclouds.cloudstack.options.ListVirtualMachinesOptions;
import org.jclouds.cloudstack.options.RestoreVirtualMachineOptions;
import org.jclouds.util.InetAddresses2;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.Test;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Throwables;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.net.HostAndPort;
import com.google.common.net.HostSpecifier;

/**
 * Tests behavior of {@code VirtualMachineApiLiveTest}
 * 
 * @author Adrian Cole
 */
@Test(groups = "live", singleThreaded = true, testName = "VirtualMachineApiLiveTest")
public class VirtualMachineApiLiveTest extends BaseCloudStackApiLiveTest {
	private static final Logger logger = Logger.getAnonymousLogger();

	private VirtualMachine vm = null;

	private boolean needClean = true;

	private String existVmId = null;

	static final Ordering<ServiceOffering> DEFAULT_SIZE_ORDERING = new Ordering<ServiceOffering>() {
		public int compare(ServiceOffering left, ServiceOffering right) {
			return ComparisonChain.start()
					.compare(left.getCpuNumber(), right.getCpuNumber())
					.compare(left.getCpuSpeed(), right.getCpuSpeed())
					.compare(left.getMemory(), right.getMemory()).result();
		}
	};

	public static VirtualMachine createVirtualMachine(CloudStackApi client,
			String defaultTemplate, Predicate<String> jobComplete,
			Predicate<VirtualMachine> virtualMachineRunning) {
		Set<Network> networks = client.getNetworkApi().listNetworks(
				isDefault(true));
		if (networks.size() > 0) {
			Network network = get(filter(networks, new Predicate<Network>() {
				@Override
				public boolean apply(Network network) {
					return network != null
							&& (network.getState().equals("Implemented") || network
									.getState().equals("Setup"));
				}
			}), 0);
			return createVirtualMachineInNetwork(
					network,
					defaultTemplateOrPreferredInZone(defaultTemplate, client,
							network.getZoneId()), client, jobComplete,
					virtualMachineRunning);
		} else {
			String zoneId = find(client.getZoneApi().listZones(),
					new Predicate<Zone>() {

						@Override
						public boolean apply(Zone arg0) {
							return arg0.isSecurityGroupsEnabled();
						}

					}).getId();
			return createVirtualMachineWithSecurityGroupInZone(
					zoneId,
					defaultTemplateOrPreferredInZone(defaultTemplate, client,
							zoneId),
					get(client.getSecurityGroupApi().listSecurityGroups(), 0)
							.getId(), client, jobComplete,
					virtualMachineRunning);
		}
	}

	public static VirtualMachine createVirtualMachineWithSecurityGroupInZone(
			String zoneId, String templateId, String groupId,
			CloudStackApi client, Predicate<String> jobComplete,
			Predicate<VirtualMachine> virtualMachineRunning) {
		return createVirtualMachineWithOptionsInZone(
				new DeployVirtualMachineOptions().securityGroupId(groupId),
				zoneId, templateId, client, jobComplete, virtualMachineRunning);
	}

	public static VirtualMachine createVirtualMachineInNetwork(Network network,
			String templateId, CloudStackApi client,
			Predicate<String> jobComplete,
			Predicate<VirtualMachine> virtualMachineRunning) {
		DeployVirtualMachineOptions options = new DeployVirtualMachineOptions();
		String zoneId = network.getZoneId();
		options.networkId(network.getId());
		String name = "unit-" + UUID.randomUUID().toString();
		options.name(name);
		options.displayName(name);
		return createVirtualMachineWithOptionsInZone(options, zoneId,
				templateId, client, jobComplete, virtualMachineRunning);
	}

	public static VirtualMachine createVirtualMachineInNetworkWithIp(
			CloudStackApi client, String templateId, Set<Network> networks,
			Map<String, String> ipToNetwork, Predicate<String> jobComplete,
			Predicate<VirtualMachine> virtualMachineRunning) {

		DeployVirtualMachineOptions options = new DeployVirtualMachineOptions();

		String zoneId = getFirst(networks, null).getZoneId();
		options.networkIds(Iterables.transform(networks,
				new Function<Network, String>() {
					@Override
					public String apply(Network network) {
						return network.getId();
					}
				}));
		options.ipsToNetworks(ipToNetwork);

		return createVirtualMachineWithOptionsInZone(options, zoneId,
				templateId, client, jobComplete, virtualMachineRunning);
	}

	public static VirtualMachine createVirtualMachineWithOptionsInZone(
			DeployVirtualMachineOptions options, String zoneId,
			String templateId, CloudStackApi client,
			Predicate<String> jobComplete,
			Predicate<VirtualMachine> virtualMachineRunning) {
		String serviceOfferingId = DEFAULT_SIZE_ORDERING.min(
				client.getOfferingApi().listServiceOfferings()).getId();

		System.out.printf(
				"serviceOfferingId %s, templateId %s, zoneId %s, options %s%n",
				serviceOfferingId, templateId, zoneId, options);
		AsyncCreateResponse job = client.getVirtualMachineApi()
				.deployVirtualMachineInZone(zoneId, serviceOfferingId,
						templateId, options);
		assertTrue(jobComplete.apply(job.getJobId()));
		AsyncJob<VirtualMachine> jobWithResult = client.getAsyncJobApi()
				.<VirtualMachine> getAsyncJob(job.getJobId());
		if (jobWithResult.getError() != null)
			Throwables.propagate(new ExecutionException(String.format(
					"job %s failed with exception %s", job.getId(),
					jobWithResult.getError().toString())) {
			});
		VirtualMachine vm = jobWithResult.getResult();
		if (vm.isPasswordEnabled()) {
			assert vm.getPassword() != null : vm;
		}
		assertTrue(virtualMachineRunning.apply(vm));
		assertEquals(vm.getServiceOfferingId(), serviceOfferingId);
		assertEquals(vm.getTemplateId(), templateId);
		assertEquals(vm.getZoneId(), zoneId);
		return vm;
	}

	@Override
	protected Properties setupProperties() {
		Properties overrides = super.setupProperties();
		existVmId = setIfTestSystemPropertyPresent(overrides, provider
				+ ".exist-vm");
		return overrides;
	}

	@Test(enabled = false)
	public void testCreateVirtualMachine() throws Exception {
		String defaultTemplate = template != null ? template.getImageId()
				: null;
		vm = createVirtualMachine(client, defaultTemplate, jobComplete,
				virtualMachineRunning);
		if (vm.getPassword() != null) {
			conditionallyCheckSSH();
		}
		assert in(
				ImmutableSet.of("ROOT", "NetworkFilesystem", "IscsiLUN",
						"VMFS", "PreSetup")).apply(vm.getRootDeviceType()) : vm;
		checkVm(vm);
	}
	
	@Test(enabled = false)
	public void testGetVirtualMachine(){
		assert existVmId != null && !existVmId.equals("");
		VirtualMachine vm = client.getVirtualMachineApi().getVirtualMachine(existVmId);
		assert vm != null;
		this.vm = vm;
		System.out.println("found vm: " + vm);
	}

	@Test(enabled = false)
	public void testCreateVirtualMachineWithSpecificIp() throws Exception {
		skipIfNotGlobalAdmin();

		String defaultTemplate = template != null ? template.getImageId()
				: null;
		Network network = null;

		try {
			Template template = getOnlyElement(client.getTemplateApi()
					.listTemplates(
							ListTemplatesOptions.Builder.id(defaultTemplate)));
			logger.info("Using template: " + template);

			Set<Network> allSafeNetworksInZone = adminClient.getNetworkApi()
					.listNetworks(
							ListNetworksOptions.Builder.zoneId(
									template.getZoneId()).isSystem(false));
			for (Network net : allSafeNetworksInZone) {
				if (net.getName().equals(prefix + "-ip-network")) {
					logger.info("Deleting VMs in network: " + net);

					Set<VirtualMachine> machinesInNetwork = adminClient
							.getVirtualMachineApi().listVirtualMachines(
									ListVirtualMachinesOptions.Builder
											.networkId(net.getId()));

					for (VirtualMachine machine : machinesInNetwork) {
						if (machine.getState().equals(
								VirtualMachine.State.RUNNING)) {
							logger.info("Deleting VM: " + machine);
							destroyMachine(machine);
						}
					}

					assertTrue(adminJobComplete.apply(adminClient
							.getNetworkApi().deleteNetwork(net.getId())),
							net.toString());
				}
			}

			NetworkOffering offering = getFirst(
					client.getOfferingApi().listNetworkOfferings(
							ListNetworkOfferingsOptions.Builder.zoneId(
									template.getZoneId()).specifyVLAN(true)),
					null);
			checkNotNull(offering, "No network offering found");
			logger.info("Using network offering: " + offering);

			network = adminClient.getNetworkApi().createNetworkInZone(
					template.getZoneId(),
					offering.getId(),
					prefix + "-ip-network",
					"",
					CreateNetworkOptions.Builder.startIP("192.168.0.1")
							.endIP("192.168.0.5").netmask("255.255.255.0")
							.gateway("192.168.0.1").vlan("21"));
			logger.info("Created network: " + network);

			Network requiredNetwork = getOnlyElement(filter(
					adminClient.getNetworkApi().listNetworks(
							ListNetworksOptions.Builder.zoneId(template
									.getZoneId())), new Predicate<Network>() {
						@Override
						public boolean apply(Network network) {
							return network.isDefault()
									&& network.getGuestIPType() == GuestIPType.VIRTUAL;
						}
					}));
			logger.info("Required network: " + requiredNetwork);

			String ipAddress = "192.168.0.4";

			Map<String, String> ipsToNetworks = Maps.newHashMap();
			ipsToNetworks.put(ipAddress, network.getId());

			vm = createVirtualMachineInNetworkWithIp(adminClient,
					defaultTemplate, ImmutableSet.of(requiredNetwork, network),
					ipsToNetworks, adminJobComplete, adminVirtualMachineRunning);
			logger.info("Created VM: " + vm);

			boolean hasStaticIpNic = false;
			for (NIC nic : vm.getNICs()) {
				if (nic.getNetworkId() == network.getId()) {
					hasStaticIpNic = true;
					assertEquals(nic.getIPAddress(), ipAddress);
				}
			}
			assert hasStaticIpNic;
			checkVm(vm);

		} finally {
			if (vm != null) {
				destroyMachine(vm);
				vm = null;
			}
			if (network != null) {
				String jobId = adminClient.getNetworkApi().deleteNetwork(
						network.getId());
				adminJobComplete.apply(jobId);
				network = null;
			}
		}
	}
	
	private void destroyMachine(VirtualMachine virtualMachine) {
		assertTrue(adminJobComplete.apply(adminClient.getVirtualMachineApi()
				.destroyVirtualMachine(virtualMachine.getId())),
				virtualMachine.toString());
		assertTrue(adminVirtualMachineDestroyed.apply(virtualMachine));
	}

	private void conditionallyCheckSSH() {
		if (vm.getPassword() != null
				&& loginCredentials.getOptionalPassword() == null)
			loginCredentials = loginCredentials.toBuilder()
					.password(vm.getPassword()).build();
		assert HostSpecifier.isValid(vm.getIPAddress());
		if (!InetAddresses2.isPrivateIPAddress(vm.getIPAddress())) {
			// not sure if the network is public or not, so we have to test
			HostAndPort socket = HostAndPort.fromParts(vm.getIPAddress(), 22);
			System.err.printf("testing socket %s%n", socket);
			System.err.printf("testing ssh %s%n", socket);
			checkSSH(socket);
		} else {
			System.err.printf("skipping ssh %s, as private%n",
					vm.getIPAddress());
		}
	}
	
	private VirtualMachine getVm(String vmId){
		VirtualMachine vm = client.getVirtualMachineApi().getVirtualMachine(vmId);
		assert vm != null;
		return vm;
	}

	@Test(enabled = false, dependsOnMethods = "testCreateVirtualMachine")
	public void testStopVirtualMachine() throws Exception {
		String job = client.getVirtualMachineApi().stopVirtualMachine(
				vm.getId());
		assertTrue(jobComplete.apply(job));
		vm = getVm(this.vm.getId());
		assertEquals(vm.getState(), VirtualMachine.State.STOPPED);
	}

	@Test(enabled = false, dependsOnMethods = "testCreateVirtualMachine")
	public void testChangeServiceForVirtualMachine() throws Exception {
		VirtualMachine vm = getVm(this.vm.getId());
		String serviceOfferingId = vm.getServiceOfferingId();
		logger.info("original serviceoffering id: " + serviceOfferingId);
		Set<ServiceOffering> serviceOfferings = client.getOfferingApi().listServiceOfferings();
		assert serviceOfferings != null && serviceOfferings.size() > 0;
		List<ServiceOffering> serviceOfferingList = new ArrayList<ServiceOffering>(serviceOfferings);
		for(ServiceOffering so : serviceOfferingList){
			if(so.getId().equals(serviceOfferingId)){
				serviceOfferingList.remove(so);
				break;
			}
		}
		String newServiceOfferingId = DEFAULT_SIZE_ORDERING.min(serviceOfferingList).getId();
		assert newServiceOfferingId != null;
		logger.info("new serviceoffering id: " + newServiceOfferingId);
		vm = client.getVirtualMachineApi().changeServiceForVirtualMachine(
				this.vm.getId(), newServiceOfferingId);
		assert vm.getServiceOfferingId().equals(newServiceOfferingId);
	}

	@Test(enabled = false, dependsOnMethods = "testCreateVirtualMachine")
	public void testAddNicToVirtualMachine() throws Exception {
		Network newNetwork = getNewNetwork(vm.getId());
		
		AddNicToVirtualMachineOptions options = new AddNicToVirtualMachineOptions();
		AsyncCreateResponse job = client.getVirtualMachineApi()
				.addNicToVirtualMachine(newNetwork.getId(), vm.getId(), options);
		assertTrue(jobComplete.apply(job.getJobId()));

		AsyncJob<VirtualMachine> jobWithResult = client.getAsyncJobApi()
				.<VirtualMachine> getAsyncJob(job.getJobId());
		if (jobWithResult.getError() != null)
			Throwables.propagate(new ExecutionException(String.format(
					"job %s failed with exception %s", job.getId(),
					jobWithResult.getError().toString())) {
			});
		VirtualMachine vm = jobWithResult.getResult();
		assert vm != null;
		Set<NIC> nics = vm.getNICs();
		assert nics != null && nics.size() == 2;
		logger.info("nics: " + nics);
	}
	
	@Test(enabled = false, dependsOnMethods = "testAddNicToVirtualMachine")
	public void testUpdateDefaultNicForVirtual() throws Exception {
		VirtualMachine vm = getVm(this.vm.getId());
		Set<NIC> nics = vm.getNICs();
		assert nics != null && nics.size() >= 2;
		logger.info("before setting, nics: " + nics);
		NIC nonDefaultNic = null;
		Iterator<NIC> nicIterator = nics.iterator();
		while(nicIterator.hasNext()){
			NIC nic = nicIterator.next();
			if(!nic.isDefault()){
				nonDefaultNic = nic;
				break;
			}
		}
		assert nonDefaultNic != null;
		AsyncCreateResponse job = client.getVirtualMachineApi()
				.updateDefaultNicForVirtualMachine(nonDefaultNic.getId(), vm.getId());
		assertTrue(jobComplete.apply(job.getJobId()));
		
		vm = client.getVirtualMachineApi().getVirtualMachine(this.vm.getId());
		assert vm != null;
		
		Set<NIC> newNics = vm.getNICs();
		assert newNics != null && newNics.size() >= 2;
		logger.info("after setting, nics: " + newNics);
	}
	
	@Test(enabled = false, dependsOnMethods = "testUpdateDefaultNicForVirtual")
	public void testRemoveNicFromVirtualMachine() throws Exception {
		VirtualMachine vm = getVm(this.vm.getId());
		Set<NIC> nics = vm.getNICs();
		assert nics != null && nics.size() >= 2;
		NIC nic4Remove = null;
		Iterator<NIC> nicIterator = nics.iterator();
		while(nicIterator.hasNext()){
			NIC nic = nicIterator.next();
			if(!nic.isDefault()){
				nic4Remove = nic;
				break;
			}
		}
		assert nic4Remove != null;
		AsyncCreateResponse job = client.getVirtualMachineApi()
				.removeNicFromVirtualMachine(nic4Remove.getId(), vm.getId());
		assertTrue(jobComplete.apply(job.getJobId()));
		
		vm = getVm(this.vm.getId());
		
		Set<NIC> newNics = vm.getNICs();
		assert newNics != null && newNics.size() >= 1;
		logger.info("nics: " + newNics);
	}

	@Test(enabled = false, dependsOnMethods = "testCreateVirtualMachine")
	public void testRestorevirtualMachine() throws Exception {
		RestoreVirtualMachineOptions options = new RestoreVirtualMachineOptions();
		String jobId = client.getVirtualMachineApi().restoreVirtualMachine(this.vm.getId(), options);
		assertTrue(jobComplete.apply(jobId));
		vm = getVm(this.vm.getId());
		assertTrue(vm.getState().equals(VirtualMachine.State.RUNNING));
	}
	
	@Test(enabled = false, dependsOnMethods = "testCreateVirtualMachine")
	public void testRestorevirtualMachineToNewTemplate() throws Exception {
		Template oTemp = client.getTemplateApi().getTemplateInZone(this.vm.getTemplateId(), this.vm.getZoneId());
		assert oTemp != null;
		
		Set<Template> temps = client.getTemplateApi().listTemplates();
		assert temps != null && temps.size() >= 2;
		
		Iterator<Template> tempIterator = temps.iterator();
		Template newTemp = null;
		while(tempIterator.hasNext()){
			Template temp = tempIterator.next();
			if(!temp.getId().equals(oTemp.getId()) 
					&& temp.getHypervisor().equals(oTemp.getHypervisor())
					&& temp.isReady()){
				newTemp = temp;
			}
		}
		assert newTemp != null;
		
		RestoreVirtualMachineOptions options = new RestoreVirtualMachineOptions();
		options.templateId(newTemp.getId());
		String jobId = client.getVirtualMachineApi().restoreVirtualMachine(this.vm.getId(), options);
		assertTrue(jobComplete.apply(jobId));
		vm = getVm(this.vm.getId());
		assertTrue(vm.getState().equals(VirtualMachine.State.RUNNING));
	}

	@Test(enabled = false, dependsOnMethods = "testCreateVirtualMachine")
	public void testScaleVirtualMachine() throws Exception {
		VirtualMachine vm = getVm(this.vm.getId());
		String serviceOfferingId = vm.getServiceOfferingId();
		logger.info("original serviceoffering id: " + serviceOfferingId);
		ServiceOffering serviceOffering = client.getOfferingApi().getServiceOffering(serviceOfferingId);
		assert serviceOffering != null;
		
		Set<ServiceOffering> serviceOfferings = client.getOfferingApi().listServiceOfferings();
		assert serviceOfferings != null && serviceOfferings.size() > 0;
		List<ServiceOffering> serviceOfferingList = new ArrayList<ServiceOffering>(serviceOfferings);
		
		String newServiceOfferingId = null;
		while(serviceOfferingList.size() > 0){
			ServiceOffering newServiceOffering = DEFAULT_SIZE_ORDERING.min(serviceOfferingList);
			if(DEFAULT_SIZE_ORDERING.compare(newServiceOffering, serviceOffering) > 0){
				newServiceOfferingId = newServiceOffering.getId();
				break;
			}else{
				serviceOfferingList.remove(newServiceOffering);
			}
		}
		
		assert newServiceOfferingId != null;
		logger.info("new serviceoffering id: " + newServiceOfferingId);
		AsyncCreateResponse job = client.getVirtualMachineApi()
				.scaleVirtualMachine(this.vm.getId(), newServiceOfferingId);
		assertTrue(jobComplete.apply(job.getJobId()));
		vm = getVm(this.vm.getId());
		assert vm.getServiceOfferingId().equals(newServiceOfferingId);
	}

	@Test(enabled = false)
	public void testCleanVMReservations() throws Exception {
		throw new UnsupportedOperationException();
//		AsyncCreateResponse job = globalAdminClient.getVirtualMachineApi().cleanVMReservations();
//		assertTrue(jobComplete.apply(job.getJobId()));
	}

	@Test(enabled = false, dependsOnMethods = "testCreateVirtualMachine")
	public void testDestroyVirtualMachine() throws Exception {
		String jobId = client.getVirtualMachineApi().destroyVirtualMachine(this.vm.getId());
		assertTrue(jobComplete.apply(jobId));
		VirtualMachine vm = getVm(this.vm.getId());
		logger.info("vm state: " + vm.getState());
		assertEquals(vm.getState(), VirtualMachine.State.DESTROYED);
	}

	@Test(enabled = false, dependsOnMethods = "testDestroyVirtualMachine")
	public void testRecoverVirtualMachine() throws Exception {
		VirtualMachine vm = domainAdminClient
				.getVirtualMachineApi().recoverVirtualMachine(this.vm.getId());
		logger.info("vm state: " + vm.getState());
		assertEquals(vm.getState(), VirtualMachine.State.STOPPED);
	}
	
	@Test(enabled = false, dependsOnMethods = "testCreateVirtualMachine")
	public void testExpungeVirtualMachine() throws Exception {
		throw new UnsupportedOperationException();
//		AsyncCreateResponse job = domainAdminClient
//				.getVirtualMachineApi().expungeVirtualMachine(this.vm.getId());
//		assertTrue(jobComplete.apply(job.getJobId()));
	}
	
	@Test(enabled = false, dependsOnMethods = "testStopVirtualMachine")
	public void testMigrateVirtualMachine() throws Exception {
		throw new UnsupportedOperationException();
	}

	@Test(enabled = false, dependsOnMethods = "testCreateVirtualMachine")
	public void testMigrateVirtualMachineWithVolume() throws Exception {
		throw new UnsupportedOperationException();
	}
	
	@Test(enabled = false, dependsOnMethods = "testCreateVirtualMachine")
	public void testAssignVirtualMachine() throws Exception {
		String oAccount = this.vm.getAccount();
		String oDomainId = this.vm.getDomainId();
		Set<Account> accounts = globalAdminClient.getAccountApi().listAccounts(new ListAccountsOptions());
		assert accounts != null && accounts.size() >= 2;
		
		String newDomainId = null;
		String newAccount = null;
		Iterator<Account> accountIterator = accounts.iterator();
		while(accountIterator.hasNext()){
			Account account = accountIterator.next();
			if(!account.getName().equals(oAccount) 
					&& !account.getDomainId().equals(oDomainId)){
				newDomainId = account.getDomainId();
				newAccount = account.getName();
				break;
			}
		}
		assert newDomainId != null && newAccount != null;
		
		if(this.vm.getState().equals(VirtualMachine.State.RUNNING)){
			testStopVirtualMachine();
		}
		assertEquals(this.vm.getState(), VirtualMachine.State.STOPPED);
		
		AssignVirtualMachineOptions options = new AssignVirtualMachineOptions();
		options.accountInDomain(newAccount, newDomainId);
		vm = globalAdminClient.getVirtualMachineApi().assignVirtualMachine(this.vm.getId(), options);
		assert vm.getAccount().equals(newAccount) && vm.getDomainId().equals(newDomainId);
	}

	@Test(enabled = false, dependsOnMethods = "testCreateVirtualMachine")
	public void testLifeCycle() throws Exception {
		String job = client.getVirtualMachineApi().stopVirtualMachine(
				vm.getId());
		assertTrue(jobComplete.apply(job));
		vm = client.getVirtualMachineApi().getVirtualMachine(vm.getId());
		assertEquals(vm.getState(), VirtualMachine.State.STOPPED);

		if (vm.isPasswordEnabled()) {
			job = client.getVirtualMachineApi().resetPasswordForVirtualMachine(
					vm.getId());
			assertTrue(jobComplete.apply(job));
			vm = client.getAsyncJobApi().<VirtualMachine> getAsyncJob(job)
					.getResult();
			if (vm.getPassword() != null) {
				conditionallyCheckSSH();
			}
		}

		job = client.getVirtualMachineApi().startVirtualMachine(vm.getId());
		assertTrue(jobComplete.apply(job));
		vm = client.getVirtualMachineApi().getVirtualMachine(vm.getId());
		assertEquals(vm.getState(), VirtualMachine.State.RUNNING);

		job = client.getVirtualMachineApi().rebootVirtualMachine(vm.getId());
		assertTrue(jobComplete.apply(job));
		vm = client.getVirtualMachineApi().getVirtualMachine(vm.getId());
		assertEquals(vm.getState(), VirtualMachine.State.RUNNING);
	}

	@AfterGroups(groups = "live")
	@Override
	protected void tearDownContext() {
		if (vm != null && needClean) {
			destroyMachine(vm);
			vm = null;
		}
		super.tearDownContext();
	}

	@Test(enabled = false)
	public void testListVirtualMachines() throws Exception {
		Set<VirtualMachine> response = client.getVirtualMachineApi()
				.listVirtualMachines();
		assert null != response;
		assertTrue(response.size() >= 0);
		for (VirtualMachine vm : response) {
			VirtualMachine newDetails = getOnlyElement(client
					.getVirtualMachineApi().listVirtualMachines(
							ListVirtualMachinesOptions.Builder.id(vm.getId())));
			assertEquals(vm.getId(), newDetails.getId());
			checkVm(vm);
		}
	}
	
	protected Network getNewNetwork(String vmId){
		VirtualMachine vm = getVm(vmId);
		Set<NIC> oNics = vm.getNICs();
		Iterator<NIC> oNicIterator = oNics.iterator();
		List<String> networkIds = new ArrayList<String>();
		while(oNicIterator.hasNext()){
			NIC nic = oNicIterator.next();
			networkIds.add(nic.getId());
		}
		
		Network newNetwork = null;
		Set<Network> networks = client.getNetworkApi().listNetworks(new ListNetworksOptions());
		assert networks != null && networks.size() > 0;
		Iterator<Network> networkIterator = networks.iterator();
		while(networkIterator.hasNext()){
			Network network = networkIterator.next();
			if(!networks.contains(network.getId())){
				newNetwork = network;
				break;
			}
		}

		assert newNetwork != null;
		return newNetwork;
	}

	protected void checkVm(VirtualMachine vm) {
		assertEquals(vm.getId(), client.getVirtualMachineApi()
				.getVirtualMachine(vm.getId()).getId());
		assert vm.getId() != null : vm;
		assert vm.getName() != null : vm;
		// vm.getDisplayName() can be null, so skip that check.
		assert vm.getAccount() != null : vm;
		assert vm.getDomain() != null : vm;
		assert vm.getDomainId() != null : vm;
		assert vm.getCreated() != null : vm;
		assert vm.getState() != null : vm;
		assert vm.getZoneId() != null : vm;
		assert vm.getZoneName() != null : vm;
		assert vm.getTemplateId() != null : vm;
		assert vm.getTemplateName() != null : vm;
		assert vm.getServiceOfferingId() != null : vm;
		assert vm.getServiceOfferingName() != null : vm;
		assert vm.getCpuCount() > 0 : vm;
		assert vm.getCpuSpeed() > 0 : vm;
		assert vm.getMemory() > 0 : vm;
		assert vm.getGuestOSId() != null : vm;
		assert vm.getRootDeviceId() != null : vm;
		// assert vm.getRootDeviceType() != null : vm;
		if (vm.getJobId() != null)
			assert vm.getJobStatus() != null : vm;
		assert vm.getNICs() != null && vm.getNICs().size() > 0 : vm;
		for (NIC nic : vm.getNICs()) {
			assert nic.getId() != null : vm;
			assert nic.getNetworkId() != null : vm;
			assert nic.getTrafficType() != null : vm;
			assert nic.getGuestIPType() != null : vm;
			switch (vm.getState()) {
			case RUNNING:
				assert nic.getNetmask() != null : vm;
				assert nic.getGateway() != null : vm;
				assert nic.getIPAddress() != null : vm;
				break;
			case STARTING:
				assert nic.getNetmask() == null : vm;
				assert nic.getGateway() == null : vm;
				assert nic.getIPAddress() == null : vm;
				break;
			default:
				assert nic.getNetmask() != null : vm;
				assert nic.getGateway() != null : vm;
				assert nic.getIPAddress() != null : vm;
			}

		}
		assert vm.getSecurityGroups() != null
				&& vm.getSecurityGroups().size() >= 0 : vm;
		assert vm.getHypervisor() != null : vm;
	}
}
