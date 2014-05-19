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
package org.jclouds.cloudstack.domain;

import static com.google.common.base.Preconditions.checkNotNull;

import java.beans.ConstructorProperties;
import java.net.URI;
import java.util.List;
import java.util.Set;

import org.jclouds.javax.annotation.Nullable;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;

/**
 * Class Network
 *
 * @author Adrian Cole
 * @author liwei
 */
public class Network {

	public static Builder<?> builder() {
		return new ConcreteBuilder();
	}

	public Builder<?> toBuilder() {
		return new ConcreteBuilder().fromNetwork(this);
	}

	public abstract static class Builder<T extends Builder<T>> {
		protected abstract T self();

		protected String id;
		protected String account;
		protected String broadcastDomainType;
		protected URI broadcastURI;
		protected String displayText;
		protected String DNS1;
		protected String DNS2;
		protected String domain;
		protected String domainId;
		protected String endIP;
		protected String gateway;
		protected boolean isDefault;
		protected boolean isShared;
		protected boolean isSystem;
		protected String netmask;
		protected String networkDomain;
		protected String networkOfferingAvailability;
		protected String networkOfferingDisplayText;
		protected String networkOfferingId;
		protected String networkOfferingName;
		protected String related;
		protected String startIP;
		protected String name;
		protected String state;
		protected GuestIPType guestIPType;
		protected String VLAN;
		protected TrafficType trafficType;
		protected String zoneId;
		protected ImmutableSet.Builder<String> tags = ImmutableSet
				.<String> builder();
		protected boolean securityGroupEnabled;
		protected Set<? extends NetworkService> services = ImmutableSortedSet
				.of();

		protected String aclId;
		protected String aclType;
		protected boolean canUseForDeploy;
		protected String cidr;
		protected boolean displayNetwork;
		protected String ip6Cidr;
		protected String ip6Gateway;
		protected boolean isPersistent;
		protected String networkCidr;
		protected boolean networkOfferingConserveMode;
		protected String physicalNetworkId;
		protected String project;
		protected String projectId;
		protected String reservedIpRange;
		protected boolean restartRequired;
		protected boolean specifyIpRanges;
		protected boolean subDomainAccess;
		protected String vpcId;

		/**
		 * @see Network#getId()
		 */
		public T id(String id) {
			this.id = id;
			return self();
		}

		/**
		 * @see Network#getAccount()
		 */
		public T account(String account) {
			this.account = account;
			return self();
		}

		/**
		 * @see Network#getBroadcastDomainType()
		 */
		public T broadcastDomainType(String broadcastDomainType) {
			this.broadcastDomainType = broadcastDomainType;
			return self();
		}

		/**
		 * @see Network#getBroadcastURI()
		 */
		public T broadcastURI(URI broadcastURI) {
			this.broadcastURI = broadcastURI;
			return self();
		}

		/**
		 * @see Network#getDisplayText()
		 */
		public T displayText(String displayText) {
			this.displayText = displayText;
			return self();
		}

		/**
		 * @return the DNS for the Network
		 */
		public T DNS(List<String> DNS) {
			if (!DNS.isEmpty())
				this.DNS1 = DNS.get(0);
			if (DNS.size() > 1)
				this.DNS2 = DNS.get(1);
			return self();
		}

		/**
		 * @see Network#getDomain()
		 */
		public T domain(String domain) {
			this.domain = domain;
			return self();
		}

		/**
		 * @see Network#getDomainId()
		 */
		public T domainId(String domainId) {
			this.domainId = domainId;
			return self();
		}

		/**
		 * @see Network#getEndIP()
		 */
		public T endIP(String endIP) {
			this.endIP = endIP;
			return self();
		}

		/**
		 * @see Network#getGateway()
		 */
		public T gateway(String gateway) {
			this.gateway = gateway;
			return self();
		}

		/**
		 * @see Network#isDefault()
		 */
		public T isDefault(boolean isDefault) {
			this.isDefault = isDefault;
			return self();
		}

		/**
		 * @see Network#isShared()
		 */
		public T isShared(boolean isShared) {
			this.isShared = isShared;
			return self();
		}

		/**
		 * @see Network#isSystem()
		 */
		public T isSystem(boolean isSystem) {
			this.isSystem = isSystem;
			return self();
		}

		/**
		 * @see Network#getNetmask()
		 */
		public T netmask(String netmask) {
			this.netmask = netmask;
			return self();
		}

		/**
		 * @see Network#getNetworkDomain()
		 */
		public T networkDomain(String networkDomain) {
			this.networkDomain = networkDomain;
			return self();
		}

		/**
		 * @see Network#getNetworkOfferingAvailability()
		 */
		public T networkOfferingAvailability(String networkOfferingAvailability) {
			this.networkOfferingAvailability = networkOfferingAvailability;
			return self();
		}

		/**
		 * @see Network#getNetworkOfferingDisplayText()
		 */
		public T networkOfferingDisplayText(String networkOfferingDisplayText) {
			this.networkOfferingDisplayText = networkOfferingDisplayText;
			return self();
		}

		/**
		 * @see Network#getNetworkOfferingId()
		 */
		public T networkOfferingId(String networkOfferingId) {
			this.networkOfferingId = networkOfferingId;
			return self();
		}

		/**
		 * @see Network#getNetworkOfferingName()
		 */
		public T networkOfferingName(String networkOfferingName) {
			this.networkOfferingName = networkOfferingName;
			return self();
		}

		/**
		 * @see Network#getRelated()
		 */
		public T related(String related) {
			this.related = related;
			return self();
		}

		/**
		 * @see Network#getStartIP()
		 */
		public T startIP(String startIP) {
			this.startIP = startIP;
			return self();
		}

		/**
		 * @see Network#getName()
		 */
		public T name(String name) {
			this.name = name;
			return self();
		}

		/**
		 * @see Network#getState()
		 */
		public T state(String state) {
			this.state = state;
			return self();
		}

		/**
		 * @see Network#getGuestIPType()
		 */
		public T guestIPType(GuestIPType guestIPType) {
			this.guestIPType = guestIPType;
			return self();
		}

		/**
		 * @see Network#getVLAN()
		 */
		public T VLAN(String VLAN) {
			this.VLAN = VLAN;
			return self();
		}

		/**
		 * @see Network#getTrafficType()
		 */
		public T trafficType(TrafficType trafficType) {
			this.trafficType = trafficType;
			return self();
		}

		/**
		 * @see Network#getZoneId()
		 */
		public T zoneId(String zoneId) {
			this.zoneId = zoneId;
			return self();
		}

		/**
		 * @see Network#getTags()
		 */
		public T tags(Iterable<String> tags) {
			this.tags = ImmutableSet.<String> builder().addAll(tags);
			return self();
		}

		/**
		 * @see Network#getTags()
		 */
		public T tag(String tag) {
			this.tags.add(tag);
			return self();
		}

		/**
		 * @see Network#isSecurityGroupEnabled()
		 */
		public T securityGroupEnabled(boolean securityGroupEnabled) {
			this.securityGroupEnabled = securityGroupEnabled;
			return self();
		}

		/**
		 * @see Network#getServices()
		 */
		public T services(Set<? extends NetworkService> services) {
			this.services = services;
			return self();
		}

		public T aclId(String aclId) {
			this.aclId = aclId;
			return self();
		}

		public T aclType(String aclType) {
			this.aclType = aclType;
			return self();
		}

		public T canUseForDeploy(boolean canUseForDeploy) {
			this.canUseForDeploy = canUseForDeploy;
			return self();
		}

		public T cidr(String cidr) {
			this.cidr = cidr;
			return self();
		}

		public T displayNetwork(boolean displayNetwork) {
			this.displayNetwork = displayNetwork;
			return self();
		}

		public T ip6Cidr(String ip6Cidr) {
			this.ip6Cidr = ip6Cidr;
			return self();
		}

		public T ip6Gateway(String ip6Gateway) {
			this.ip6Gateway = ip6Gateway;
			return self();
		}

		public T isPersistent(boolean isPersistent) {
			this.isPersistent = isPersistent;
			return self();
		}

		public T networkCidr(String networkCidr) {
			this.networkCidr = networkCidr;
			return self();
		}

		public T networkOfferingConserveMode(boolean networkOfferingConserveMode) {
			this.networkOfferingConserveMode = networkOfferingConserveMode;
			return self();
		}

		public T physicalNetworkId(String physicalNetworkId) {
			this.physicalNetworkId = physicalNetworkId;
			return self();
		}

		public T project(String project) {
			this.project = project;
			return self();
		}

		public T projectId(String projectId) {
			this.projectId = projectId;
			return self();
		}

		public T reservedIpRange(String reservedIpRange) {
			this.reservedIpRange = reservedIpRange;
			return self();
		}

		public T restartRequired(boolean restartRequired) {
			this.restartRequired = restartRequired;
			return self();
		}

		public T specifyIpRanges(boolean specifyIpRanges) {
			this.specifyIpRanges = specifyIpRanges;
			return self();
		}

		public T subDomainAccess(boolean subDomainAccess) {
			this.subDomainAccess = subDomainAccess;
			return self();
		}

		public T vpcId(String vpcId) {
			this.vpcId = vpcId;
			return self();
		}

		public Network build() {
			return new Network(id, account, broadcastDomainType, broadcastURI,
					displayText, DNS1, DNS2, domain, domainId, endIP, gateway,
					isDefault, isShared, isSystem, netmask, networkDomain,
					networkOfferingAvailability, networkOfferingDisplayText,
					networkOfferingId, networkOfferingName, related, startIP,
					name, state, guestIPType, VLAN, trafficType, zoneId,
					tags.build(), securityGroupEnabled, services, aclId,
					aclType, canUseForDeploy, cidr, displayNetwork, ip6Cidr,
					ip6Gateway, isPersistent, networkCidr,
					networkOfferingConserveMode, physicalNetworkId, project,
					projectId, reservedIpRange, restartRequired,
					specifyIpRanges, subDomainAccess, vpcId);
		}

		public T fromNetwork(Network in) {
			return this
					.id(in.getId())
					.account(in.getAccount())
					.broadcastDomainType(in.getBroadcastDomainType())
					.broadcastURI(in.getBroadcastURI())
					.displayText(in.getDisplayText())
					.DNS(in.getDNS())
					.domain(in.getDomain())
					.domainId(in.getDomainId())
					.endIP(in.getEndIP())
					.gateway(in.getGateway())
					.isDefault(in.isDefault())
					.isShared(in.isShared())
					.isSystem(in.isSystem())
					.netmask(in.getNetmask())
					.networkDomain(in.getNetworkDomain())
					.networkOfferingAvailability(
							in.getNetworkOfferingAvailability())
					.networkOfferingDisplayText(
							in.getNetworkOfferingDisplayText())
					.networkOfferingId(in.getNetworkOfferingId())
					.networkOfferingName(in.getNetworkOfferingName())
					.related(in.getRelated())
					.startIP(in.getStartIP())
					.name(in.getName())
					.state(in.getState())
					.guestIPType(in.getGuestIPType())
					.VLAN(in.getVLAN())
					.trafficType(in.getTrafficType())
					.zoneId(in.getZoneId())
					.tags(in.getTags())
					.securityGroupEnabled(in.isSecurityGroupEnabled())
					.services(in.getServices())
					.aclId(in.getAclId())
					.aclType(in.getAclType())
					.canUseForDeploy(in.isCanUseForDeploy())
					.cidr(in.getCidr())
					.displayNetwork(in.isDisplayNetwork())
					.ip6Cidr(in.getIp6Cidr())
					.ip6Gateway(in.getIp6Gateway())
					.isPersistent(in.isPersistent())
					.networkCidr(in.getNetworkCidr())
					.networkOfferingConserveMode(
							in.isNetworkOfferingConserveMode())
					.physicalNetworkId(in.getPhysicalNetworkId())
					.project(in.getProject()).projectId(in.getProjectId())
					.reservedIpRange(in.getReservedIpRange())
					.restartRequired(in.isRestartRequired())
					.specifyIpRanges(in.isSpecifyIpRanges())
					.subDomainAccess(in.isSubDomainAccess())
					.vpcId(in.getVpcId());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	private final String id;
	private final String account;
	private final String broadcastDomainType;
	private final URI broadcastURI;
	private final String displayText;
	private final String DNS1;
	private final String DNS2;
	private final String domain;
	private final String domainId;
	private final String endIP;
	private final String gateway;
	private final boolean isDefault;
	private final boolean isShared;
	private final boolean isSystem;
	private final String netmask;
	private final String networkDomain;
	private final String networkOfferingAvailability;
	private final String networkOfferingDisplayText;
	private final String networkOfferingId;
	private final String networkOfferingName;
	private final String related;
	private final String startIP;
	private final String name;
	private final String state;
	private final GuestIPType guestIPType;
	private final String VLAN;
	private final TrafficType trafficType;
	private final String zoneId;
	private final Set<String> tags;
	private final boolean securityGroupEnabled;
	private final Set<? extends NetworkService> services;

	private final String aclId;
	private final String aclType;
	private final boolean canUseForDeploy;
	private final String cidr;
	private final boolean displayNetwork;
	private final String ip6Cidr;
	private final String ip6Gateway;
	private final boolean isPersistent;
	private final String networkCidr;
	private final boolean networkOfferingConserveMode;
	private final String physicalNetworkId;
	private final String project;
	private final String projectId;
	private final String reservedIpRange;
	private final boolean restartRequired;
	private final boolean specifyIpRanges;
	private final boolean subDomainAccess;
	private final String vpcId;

	@ConstructorProperties({ "id", "account", "broadcastdomaintype",
			"broadcasturi", "displaytext", "dns1", "dns2", "domain",
			"domainid", "endip", "gateway", "isdefault", "isshared",
			"issystem", "netmask", "networkdomain",
			"networkofferingavailability", "networkofferingdisplaytext",
			"networkofferingid", "networkofferingname", "related", "startip",
			"name", "state", "type", "vlan", "traffictype", "zoneid", "tags",
			"securitygroupenabled", "service", "aclid", "acltype",
			"canusefordeploy", "cidr", "displaynetwork", "ip6cidr",
			"ip6gateway", "ispersistent", "networkcidr",
			"networkofferingconservemode", "physicalnetworkid", "project",
			"projectid", "reservediprange", "restartrequired",
			"specifyipranges", "subdomainaccess", "vpcid" })
	protected Network(String id, @Nullable String account,
			@Nullable String broadcastDomainType, @Nullable URI broadcastURI,
			@Nullable String displayText, @Nullable String DNS1,
			@Nullable String DNS2, @Nullable String domain,
			@Nullable String domainId, @Nullable String endIP,
			@Nullable String gateway, boolean isDefault, boolean isShared,
			boolean isSystem, @Nullable String netmask,
			@Nullable String networkDomain,
			@Nullable String networkOfferingAvailability,
			@Nullable String networkOfferingDisplayText,
			@Nullable String networkOfferingId,
			@Nullable String networkOfferingName, @Nullable String related,
			@Nullable String startIP, @Nullable String name,
			@Nullable String state, @Nullable GuestIPType guestIPType,
			@Nullable String VLAN, @Nullable TrafficType trafficType,
			@Nullable String zoneId, @Nullable Iterable<String> tags,
			boolean securityGroupEnabled,
			Set<? extends NetworkService> services, @Nullable String aclId,
			@Nullable String aclType, boolean canUseForDeploy,
			@Nullable String cidr, boolean displayNetwork,
			@Nullable String ip6Cidr, @Nullable String ip6Gateway,
			boolean isPersistent, @Nullable String networkCidr,
			boolean networkOfferingConserveMode,
			@Nullable String physicalNetworkId, @Nullable String project,
			@Nullable String projectId, @Nullable String reservedIpRange,
			boolean restartRequired, boolean specifyIpRanges,
			boolean subDomainAccess, @Nullable String vpcId) {
		this.id = checkNotNull(id, "id");
		this.account = account;
		this.broadcastDomainType = broadcastDomainType;
		this.broadcastURI = broadcastURI;
		this.displayText = displayText;
		this.DNS1 = DNS1;
		this.DNS2 = DNS2;
		this.domain = domain;
		this.domainId = domainId;
		this.endIP = endIP;
		this.gateway = gateway;
		this.isDefault = isDefault;
		this.isShared = isShared;
		this.isSystem = isSystem;
		this.netmask = netmask;
		this.networkDomain = networkDomain;
		this.networkOfferingAvailability = networkOfferingAvailability;
		this.networkOfferingDisplayText = networkOfferingDisplayText;
		this.networkOfferingId = networkOfferingId;
		this.networkOfferingName = networkOfferingName;
		this.related = related;
		this.startIP = startIP;
		this.name = name;
		this.state = state;
		this.guestIPType = guestIPType;
		this.VLAN = VLAN;
		this.trafficType = trafficType;
		this.zoneId = zoneId;
		this.tags = tags != null ? ImmutableSet.copyOf(tags) : ImmutableSet
				.<String> of();
		this.securityGroupEnabled = securityGroupEnabled;
		this.services = ImmutableSortedSet.copyOf(services);

		this.aclId = aclId;
		this.aclType = aclType;
		this.canUseForDeploy = canUseForDeploy;
		this.cidr = cidr;
		this.displayNetwork = displayNetwork;
		this.ip6Cidr = ip6Cidr;
		this.ip6Gateway = ip6Gateway;
		this.isPersistent = isPersistent;
		this.networkCidr = networkCidr;
		this.networkOfferingConserveMode = networkOfferingConserveMode;
		this.physicalNetworkId = physicalNetworkId;
		this.project = project;
		this.projectId = projectId;
		this.reservedIpRange = reservedIpRange;
		this.restartRequired = restartRequired;
		this.specifyIpRanges = specifyIpRanges;
		this.subDomainAccess = subDomainAccess;
		this.vpcId = vpcId;
	}

	/**
	 * @return network id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @return the account associated with the network
	 */
	@Nullable
	public String getAccount() {
		return this.account;
	}

	/**
	 * @return Broadcast domain type of the network
	 */
	@Nullable
	public String getBroadcastDomainType() {
		return this.broadcastDomainType;
	}

	/**
	 * @return broadcast uri of the network
	 */
	@Nullable
	public URI getBroadcastURI() {
		return this.broadcastURI;
	}

	/**
	 * @return the display text of the zone
	 */
	@Nullable
	public String getDisplayText() {
		return this.displayText;
	}

	public List<String> getDNS() {
		ImmutableList.Builder<String> builder = ImmutableList.builder();
		if (DNS1 != null && !"".equals(DNS1))
			builder.add(DNS1);
		if (DNS2 != null && !"".equals(DNS2))
			builder.add(DNS2);
		return builder.build();
	}

	/**
	 * @return Domain name for the Network
	 */
	@Nullable
	public String getDomain() {
		return this.domain;
	}

	/**
	 * @return the domain id of the Network
	 */
	@Nullable
	public String getDomainId() {
		return this.domainId;
	}

	/**
	 * @return the end ip of the network
	 */
	@Nullable
	public String getEndIP() {
		return this.endIP;
	}

	/**
	 * @return the network's gateway
	 */
	@Nullable
	public String getGateway() {
		return this.gateway;
	}

	/**
	 * @return true if network offering is default, false otherwise
	 */
	public boolean isDefault() {
		return this.isDefault;
	}

	/**
	 * @return true if network offering is shared, false otherwise
	 */
	public boolean isShared() {
		return this.isShared;
	}

	/**
	 * @return true if network offering is system, false otherwise
	 */
	public boolean isSystem() {
		return this.isSystem;
	}

	/**
	 * @return the network's netmask
	 */
	@Nullable
	public String getNetmask() {
		return this.netmask;
	}

	/**
	 * @return the network domain
	 */
	@Nullable
	public String getNetworkDomain() {
		return this.networkDomain;
	}

	/**
	 * @return availability of the network offering the network is created from
	 */
	@Nullable
	public String getNetworkOfferingAvailability() {
		return this.networkOfferingAvailability;
	}

	/**
	 * @return display text of the network offering the network is created from
	 */
	@Nullable
	public String getNetworkOfferingDisplayText() {
		return this.networkOfferingDisplayText;
	}

	/**
	 * @return network offering id the network is created from
	 */
	@Nullable
	public String getNetworkOfferingId() {
		return this.networkOfferingId;
	}

	/**
	 * @return name of the network offering the network is created from
	 */
	@Nullable
	public String getNetworkOfferingName() {
		return this.networkOfferingName;
	}

	/**
	 * @return related to what other network configuration
	 */
	@Nullable
	public String getRelated() {
		return this.related;
	}

	/**
	 * @return the start ip of the network
	 */
	@Nullable
	public String getStartIP() {
		return this.startIP;
	}

	/**
	 * @return network name
	 */
	@Nullable
	public String getName() {
		return this.name;
	}

	/**
	 * @return state of the network
	 */
	@Nullable
	public String getState() {
		return this.state;
	}

	/**
	 * @return the GuestIPType of the network
	 */
	public GuestIPType getGuestIPType() {
		return this.guestIPType;
	}

	/**
	 * @return the vlan range of the zone
	 */
	@Nullable
	public String getVLAN() {
		return this.VLAN;
	}

	/**
	 * @return the traffic type for this network offering
	 */
	@Nullable
	public TrafficType getTrafficType() {
		return this.trafficType;
	}

	/**
	 * @return zone id of the network
	 */
	@Nullable
	public String getZoneId() {
		return this.zoneId;
	}

	/**
	 * @return the tags for the Network
	 */
	public Set<String> getTags() {
		return this.tags;
	}

	/**
	 * @return true if security group is enabled, false otherwise
	 */
	public boolean isSecurityGroupEnabled() {
		return this.securityGroupEnabled;
	}

	/**
	 * @return the list of services
	 */
	public Set<? extends NetworkService> getServices() {
		return this.services;
	}

	/**
	 * @return ACL Id associated with the VPC network
	 */
	public String getAclId() {
		return aclId;
	}

	/**
	 * @return acl type - access type to the network
	 */
	public String getAclType() {
		return aclType;
	}

	/**
	 * @return list networks available for vm deployment
	 */
	public boolean isCanUseForDeploy() {
		return canUseForDeploy;
	}

	/**
	 * @return Cloudstack managed address space, all CloudStack managed VMs get
	 *         IP address from CIDR
	 */
	public String getCidr() {
		return cidr;
	}

	/**
	 * @return an optional field, whether to the display the network to the end
	 *         user or not.
	 */
	public boolean isDisplayNetwork() {
		return displayNetwork;
	}

	/**
	 * @return the cidr of IPv6 network
	 */
	public String getIp6Cidr() {
		return ip6Cidr;
	}

	/**
	 * @return the gateway of IPv6 network
	 */
	public String getIp6Gateway() {
		return ip6Gateway;
	}

	/**
	 * @return list networks that are persistent
	 */
	public boolean isPersistent() {
		return isPersistent;
	}

	/**
	 * @return the network CIDR of the guest network configured with IP
	 *         reservation. It is the summation of CIDR and RESERVED_IP_RANGE
	 */
	public String getNetworkCidr() {
		return networkCidr;
	}

	/**
	 * @return true if network offering is ip conserve mode enabled
	 */
	public boolean isNetworkOfferingConserveMode() {
		return networkOfferingConserveMode;
	}

	/**
	 * @return the physical network id
	 */
	public String getPhysicalNetworkId() {
		return physicalNetworkId;
	}

	/**
	 * @return the project name of the address
	 */
	public String getProject() {
		return project;
	}

	/**
	 * @return the project id of the ipaddress
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * @return the network's IP range not to be used by CloudStack guest VMs and
	 *         can be used for non CloudStack purposes
	 */
	public String getReservedIpRange() {
		return reservedIpRange;
	}

	/**
	 * @return true network requires restart
	 */
	public boolean isRestartRequired() {
		return restartRequired;
	}

	/**
	 * @return true if network supports specifying ip ranges, false otherwise
	 */
	public boolean isSpecifyIpRanges() {
		return specifyIpRanges;
	}

	/**
	 * @return true if users from subdomains can access the domain level network
	 */
	public boolean isSubDomainAccess() {
		return subDomainAccess;
	}

	/**
	 * @return VPC the network belongs to
	 */
	public String getVpcId() {
		return vpcId;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id, account, broadcastDomainType, broadcastURI,
				displayText, DNS1, DNS2, domain, domainId, endIP, gateway,
				isDefault, isShared, isSystem, netmask, networkDomain,
				networkOfferingAvailability, networkOfferingDisplayText,
				networkOfferingId, networkOfferingName, related, startIP, name,
				state, guestIPType, VLAN, trafficType, zoneId, tags,
				securityGroupEnabled, services, aclId, aclType,
				canUseForDeploy, cidr, displayNetwork, ip6Cidr, ip6Gateway,
				isPersistent, networkCidr, networkOfferingConserveMode,
				physicalNetworkId, project, projectId, reservedIpRange,
				restartRequired, specifyIpRanges, subDomainAccess, vpcId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Network that = Network.class.cast(obj);
		return Objects.equal(this.id, that.id)
				&& Objects.equal(this.account, that.account)
				&& Objects.equal(this.broadcastDomainType,
						that.broadcastDomainType)
				&& Objects.equal(this.broadcastURI, that.broadcastURI)
				&& Objects.equal(this.displayText, that.displayText)
				&& Objects.equal(this.DNS1, that.DNS1)
				&& Objects.equal(this.DNS2, that.DNS2)
				&& Objects.equal(this.domain, that.domain)
				&& Objects.equal(this.domainId, that.domainId)
				&& Objects.equal(this.endIP, that.endIP)
				&& Objects.equal(this.gateway, that.gateway)
				&& Objects.equal(this.isDefault, that.isDefault)
				&& Objects.equal(this.isShared, that.isShared)
				&& Objects.equal(this.isSystem, that.isSystem)
				&& Objects.equal(this.netmask, that.netmask)
				&& Objects.equal(this.networkDomain, that.networkDomain)
				&& Objects.equal(this.networkOfferingAvailability,
						that.networkOfferingAvailability)
				&& Objects.equal(this.networkOfferingDisplayText,
						that.networkOfferingDisplayText)
				&& Objects
						.equal(this.networkOfferingId, that.networkOfferingId)
				&& Objects.equal(this.networkOfferingName,
						that.networkOfferingName)
				&& Objects.equal(this.related, that.related)
				&& Objects.equal(this.startIP, that.startIP)
				&& Objects.equal(this.name, that.name)
				&& Objects.equal(this.state, that.state)
				&& Objects.equal(this.guestIPType, that.guestIPType)
				&& Objects.equal(this.VLAN, that.VLAN)
				&& Objects.equal(this.trafficType, that.trafficType)
				&& Objects.equal(this.zoneId, that.zoneId)
				&& Objects.equal(this.tags, that.tags)
				&& Objects.equal(this.securityGroupEnabled,
						that.securityGroupEnabled)
				&& Objects.equal(this.services, that.services);
	}

	protected ToStringHelper string() {
		return Objects
				.toStringHelper(this)
				.add("id", id)
				.add("account", account)
				.add("broadcastDomainType", broadcastDomainType)
				.add("broadcastURI", broadcastURI)
				.add("displayText", displayText)
				.add("DNS1", DNS1)
				.add("DNS2", DNS2)
				.add("domain", domain)
				.add("domainId", domainId)
				.add("endIP", endIP)
				.add("gateway", gateway)
				.add("isDefault", isDefault)
				.add("isShared", isShared)
				.add("isSystem", isSystem)
				.add("netmask", netmask)
				.add("networkDomain", networkDomain)
				.add("networkOfferingAvailability", networkOfferingAvailability)
				.add("networkOfferingDisplayText", networkOfferingDisplayText)
				.add("networkOfferingId", networkOfferingId)
				.add("networkOfferingName", networkOfferingName)
				.add("related", related).add("startIP", startIP)
				.add("name", name).add("state", state)
				.add("guestIPType", guestIPType).add("VLAN", VLAN)
				.add("trafficType", trafficType).add("zoneId", zoneId)
				.add("tags", tags)
				.add("securityGroupEnabled", securityGroupEnabled)
				.add("services", services)
				.add("aclId", aclId)
				.add("aclType", aclType)
				.add("canUseForDeploy", canUseForDeploy)
				.add("cidr", cidr)
				.add("displayNetwork", displayNetwork)
				.add("ip6Cidr", ip6Cidr)
				.add("ip6Gateway", ip6Gateway)
				.add("isPersistent", isPersistent)
				.add("networkOfferingConserveMode", networkOfferingConserveMode)
				.add("physicalNetworkId", physicalNetworkId)
				.add("project", project)
				.add("projectId", projectId)
				.add("reservedIpRange", reservedIpRange)
				.add("restartRequired", restartRequired)
				.add("specifyIpRanges", specifyIpRanges)
				.add("subDomainAccess", subDomainAccess)
				.add("vpcId", vpcId);
	}

	@Override
	public String toString() {
		return string().toString();
	}

}
