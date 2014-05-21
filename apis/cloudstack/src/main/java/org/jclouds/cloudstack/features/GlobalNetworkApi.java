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

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jclouds.cloudstack.domain.AsyncCreateResponse;
import org.jclouds.cloudstack.domain.NetworkService;
import org.jclouds.cloudstack.domain.NetworkService.Provider;
import org.jclouds.cloudstack.domain.PhysicalNetwork;
import org.jclouds.cloudstack.domain.StorageIPRange;
import org.jclouds.cloudstack.domain.VlanIPRange;
import org.jclouds.cloudstack.filters.AuthenticationFilter;
import org.jclouds.cloudstack.options.AddNetworkServiceProviderOptions;
import org.jclouds.cloudstack.options.CreatePhysicalNetworkOptions;
import org.jclouds.cloudstack.options.CreateStorageNetworkIpRangeOptions;
import org.jclouds.cloudstack.options.DedicatePublicIpRangeOptions;
import org.jclouds.cloudstack.options.ListNetworkServiceProvidersOptions;
import org.jclouds.cloudstack.options.ListPhysicalNetworksOptions;
import org.jclouds.cloudstack.options.ListStorageNetworkIpRangeOptions;
import org.jclouds.cloudstack.options.UpdateNetworkServiceProviderOptions;
import org.jclouds.cloudstack.options.UpdatePhysicalNetworkOptions;
import org.jclouds.cloudstack.options.UpdateStorageNetworkIpRangeOptions;
import org.jclouds.rest.annotations.QueryParams;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.SelectJson;

import com.google.common.annotations.Beta;

/**
 * Provides synchronous access to cloudstack via their REST API.
 * <p/>
 * 
 * @see <a
 *      href="http://cloudstack.apache.org/docs/api/apidocs-4.3/TOC_Root_Admin.html"
 *      />
 * @author liwei
 */
@RequestFilters(AuthenticationFilter.class)
@QueryParams(keys = "response", values = "json")
public interface GlobalNetworkApi extends DomainNetworkApi {

	/**
	 * Dedicates a Public IP range to an account
	 * @param id the id of the VLAN IP range
	 * @param account account who will own the VLAN
	 * @param domainId domain ID of the account owning a VLAN
	 */
	@Beta
	@GET
	@QueryParams(keys = "command", values = "dedicatePublicIpRange")
	@Consumes(MediaType.APPLICATION_JSON)
	Set<VlanIPRange> dedicatePublicIpRange(@QueryParam("id") String id,
			@QueryParam("account") String account,
			@QueryParam("domainid") String domainId,
			DedicatePublicIpRangeOptions... options);
	
	/**
	 * @param id the id of the Public IP range
	 */
	@Beta
	@GET
	@QueryParams(keys = "command", values = "releasePublicIpRange")
	@Consumes(MediaType.APPLICATION_JSON)
	AsyncCreateResponse releasePublicIpRange(@QueryParam("id") String id);
	
	/**
	 * Creates a physical network
	 * @param name the name of the physical network
	 * @param zoneId the Zone ID for the physical network
	 */
	@Beta
	@GET
	@QueryParams(keys = "command", values = "createPhysicalNetwork")
	@Consumes(MediaType.APPLICATION_JSON)
	AsyncCreateResponse createPhysicalNetwork(@QueryParam("name") String name,
			@QueryParam("zoneid") String zoneId,
			CreatePhysicalNetworkOptions... options);
	
	/**
	 * Deletes a Physical Network.
	 * @param id the ID of the Physical network
	 */
	@Beta
	@GET
	@QueryParams(keys = "command", values = "deletePhysicalNetwork")
	@Consumes(MediaType.APPLICATION_JSON)
	AsyncCreateResponse deletePhysicalNetwork(@QueryParam("id") String id);
	
	/**
	 * Lists physical networks
	 */
	@GET
	@QueryParams(keys = "command", values = "listPhysicalNetworks")
	@Consumes(MediaType.APPLICATION_JSON)
	@SelectJson("physicalnetwork")
	Set<PhysicalNetwork> listPhysicalNetworks(ListPhysicalNetworksOptions... options);
	
	/**
	 * Updates a physical network
	 */
	@Beta
	@GET
	@QueryParams(keys = "command", values = "updatePhysicalNetwork")
	@Consumes(MediaType.APPLICATION_JSON)
	AsyncCreateResponse updatePhysicalNetwork(UpdatePhysicalNetworkOptions... options);
	
	/**
	 * Lists all network services provided by CloudStack or for the given Provider.
	 */
	@GET
	@QueryParams(keys = "command", values = "listSupportedNetworkServices")
	@Consumes(MediaType.APPLICATION_JSON)
	@SelectJson("networkservice")
	Set<NetworkService> listSupportedNetworkServices(ListPhysicalNetworksOptions... options);
	
	/**
	 * Adds a network serviceProvider to a physical network
	 * @param name the name for the physical network service provider
	 * @param physicalNetworkId the Physical Network ID to add the provider to
	 */
	@Beta
	@GET
	@QueryParams(keys = "command", values = "addNetworkServiceProvider")
	@Consumes(MediaType.APPLICATION_JSON)
	AsyncCreateResponse addNetworkServiceProvider(@QueryParam("name") String name,
			@QueryParam("physicalnetworkid") String physicalNetworkId,
			AddNetworkServiceProviderOptions...options);
	
	/**
	 * Deletes a Network Service Provider.
	 * @param id the ID of the network service provider
	 */
	@Beta
	@GET
	@QueryParams(keys = "command", values = "deleteNetworkServiceProvider")
	@Consumes(MediaType.APPLICATION_JSON)
	AsyncCreateResponse deleteNetworkServiceProvider(@QueryParam("id") String id);
	
	/**
	 * Lists network serviceproviders for a given physical network.
	 */
	@GET
	@QueryParams(keys = "command", values = "listNetworkServiceProviders")
	@Consumes(MediaType.APPLICATION_JSON)
	@SelectJson("networkserviceprovider")
	Set<Provider> listNetworkServiceProviders(ListNetworkServiceProvidersOptions... options);
	
	/**
	 * Updates a network serviceProvider of a physical network
	 */
	@Beta
	@GET
	@QueryParams(keys = "command", values = "updateNetworkServiceProvider")
	@Consumes(MediaType.APPLICATION_JSON)
	AsyncCreateResponse updateNetworkServiceProvider(UpdateNetworkServiceProviderOptions... options);
	
	/**
	 * Creates a Storage network IP range.
	 * @param gateway the gateway for storage network
	 * @param netmask the netmask for storage network
	 * @param podId UUID of pod where the ip range belongs to
	 * @param startIp the beginning IP address
	 */
	@Beta
	@GET
	@QueryParams(keys = "command", values = "createStorageNetworkIpRange")
	@Consumes(MediaType.APPLICATION_JSON)
	AsyncCreateResponse createStorageNetworkIpRange(@QueryParam("gateway") String gateway,
			@QueryParam("netmask") String netmask,
			@QueryParam("podid") String podId,
			@QueryParam("startip") String startIp,
			CreateStorageNetworkIpRangeOptions... options);
	
	/**
	 * Deletes a storage network IP Range.
	 * @param id the uuid of the storage network ip range
	 */
	@Beta
	@GET
	@QueryParams(keys = "command", values = "deleteStorageNetworkIpRange")
	@Consumes(MediaType.APPLICATION_JSON)
	AsyncCreateResponse deleteStorageNetworkIpRange(@QueryParam("id") String id);
	
	/**
	 * List a storage network IP range.
	 */
	@Beta
	@GET
	@QueryParams(keys = "command", values = "listStorageNetworkIpRange")
	@Consumes(MediaType.APPLICATION_JSON)
	@SelectJson("storagenetworkiprange")
	Set<StorageIPRange> listStorageNetworkIpRange(ListStorageNetworkIpRangeOptions... options);
	
	/**
	 * Update a Storage network IP range, only allowed when no IPs in this range have been allocated.
	 * @param id UUID of storage network ip range
	 */
	@Beta
	@GET
	@QueryParams(keys = "command", values = "updateStorageNetworkIpRange")
	@Consumes(MediaType.APPLICATION_JSON)
	AsyncCreateResponse updateStorageNetworkIpRange(@QueryParam("id") String id,
			UpdateStorageNetworkIpRangeOptions... options);
	
	/**
	 * Lists supported methods of network isolation
	 */
	@Beta
	@GET
	@QueryParams(keys = "command", values = "listNetworkIsolationMethods")
	@Consumes(MediaType.APPLICATION_JSON)
	Set<String> listNetworkIsolationMethods();
	
//	void listF5LoadBalancerNetworks();
//	
//	void listSrxFirewallNetworks();
//	
//	void listPaloAltoFirewallNetworks();
//	
//	void listNetscalerLoadBalancerNetworks();
//	
//	void listNiciraNvpDeviceNetworks();
}
