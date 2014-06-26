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

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jclouds.cloudstack.domain.AsyncCreateResponse;
import org.jclouds.cloudstack.domain.VirtualMachine;
import org.jclouds.cloudstack.filters.AuthenticationFilter;
import org.jclouds.cloudstack.options.AssignVirtualMachineOptions;
import org.jclouds.rest.annotations.QueryParams;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.SelectJson;

import com.google.common.annotations.Beta;

/**
 * Provides synchronous access to cloudstack virtual machine via their REST API.
 * <p/>
 * 
 * @see <a href=
 *      "http://cloudstack.apache.org/docs/api/apidocs-4.3/TOC_Domain_Admin.html"
 *      />
 * @author liwei
 */
@RequestFilters(AuthenticationFilter.class)
@QueryParams(keys = "response", values = "json")
public interface DomainVirtualMachineApi extends VirtualMachineApi {

	/**
	 * Re-assign a virtual machine to a different account/domain.
	 * 
	 * @param virtualMachineId
	 *            VirtualMachine to re-assign
	 * @param options
	 *            AssignVirtualMachineOptions specifying account and domain to
	 *            transfer to, and optional network and security group IDs.
	 * @return VirtualMachine or null if not found
	 */
	@Named("assignVirtualMachine")
	@GET
	@QueryParams(keys = "command", values = "assignVirtualMachine")
	@SelectJson("virtualmachine")
	@Consumes(MediaType.APPLICATION_JSON)
	VirtualMachine assignVirtualMachine(
			@QueryParam("virtualmachineid") String virtualMachineId,
			AssignVirtualMachineOptions... options);

	/**
	 * Recovers a virtual machine.
	 * 
	 * @param id
	 *            The ID of the virtual machine
	 */
	@Named("recoverVirtualMachine")
	@GET
	@QueryParams(keys = "command", values = "recoverVirtualMachine")
	@SelectJson("virtualmachine")
	@Consumes(MediaType.APPLICATION_JSON)
	VirtualMachine recoverVirtualMachine(@QueryParam("id") String id);

	/**
	 * Expunge a virtual machine. Once expunged, it cannot be recoverd.
	 * @param id The ID of the virtual machine
	 */
	@Named("expungeVirtualMachine")
	@GET
	@QueryParams(keys = "command", values = "expungeVirtualMachine")
	@SelectJson({ "expungevirtualmachineresponse"})
	@Consumes(MediaType.APPLICATION_JSON)
	AsyncCreateResponse expungeVirtualMachine(@QueryParam("id") String id);
}
