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
import org.jclouds.cloudstack.filters.AuthenticationFilter;
import org.jclouds.cloudstack.options.MigrateVirtualMachineOptions;
import org.jclouds.cloudstack.options.MigrateVirtualMachineWithVolumeOptions;
import org.jclouds.rest.annotations.QueryParams;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.SelectJson;

import com.google.common.annotations.Beta;

/**
 * Provides synchronous access to cloudstack virtual machine via their REST API.
 * <p/>
 * 
 * @see <a href=
 *      "http://cloudstack.apache.org/docs/api/apidocs-4.3/TOC_Root_Admin.html"
 *      />
 * @author liwei
 */
@RequestFilters(AuthenticationFilter.class)
@QueryParams(keys = "response", values = "json")
public interface GlobalVirtualMachineApi extends DomainVirtualMachineApi {

	/**
	 * Cleanups VM reservations in the database.
	 */
	@Beta
	@Named("cleanVMReservations")
	@GET
	@QueryParams(keys = "command", values = "cleanVMReservations")
	@SelectJson({ "cleanvmreservations", "cleanvmreservationsresponse" })
	@Consumes(MediaType.APPLICATION_JSON)
	AsyncCreateResponse cleanVMReservations();
	
	/**
	 * Attempts Migration of a VM to a different host or Root volume of the vm to a different storage pool
	 * @param virtualMachineId the ID of the virtual machine
	 */
	@Beta
	@Named("migrateVirtualMachine")
	@GET
	@QueryParams(keys = "command", values = "migrateVirtualMachine")
	@SelectJson({ "migratevirtualmachine", "migratevirtualmachineresponse" })
	@Consumes(MediaType.APPLICATION_JSON)
	AsyncCreateResponse migrateVirtualMachine(@QueryParam("virtualmachineid") String virtualMachineId,
			MigrateVirtualMachineOptions... options);
	
	/**
	 * Attempts Migration of a VM with its volumes to a different host
	 * @param hostId Destination Host ID to migrate VM to.
	 * @param virtualMachineId the ID of the virtual machine
	 */
	@Beta
	@Named("migrateVirtualMachineWithVolume")
	@GET
	@QueryParams(keys = "command", values = "migrateVirtualMachineWithVolume")
	@SelectJson({ "migratevirtualmachinewithvolume", "migratevirtualmachinewithvolumeresponse" })
	@Consumes(MediaType.APPLICATION_JSON)
	AsyncCreateResponse migrateVirtualMachine(@QueryParam("hostid") String hostId,
			@QueryParam("virtualmachineid") String virtualMachineId,
			MigrateVirtualMachineWithVolumeOptions... options);
	
}
