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

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jclouds.Fallbacks.EmptySetOnNotFoundOr404;
import org.jclouds.Fallbacks.NullOnNotFoundOr404;
import org.jclouds.Fallbacks.VoidOnNotFoundOr404;
import org.jclouds.cloudstack.binders.BindIdListToCommaDelimitedQueryParam;
import org.jclouds.cloudstack.binders.BindSnapshotPolicyScheduleToQueryParam;
import org.jclouds.cloudstack.domain.AsyncCreateResponse;
import org.jclouds.cloudstack.domain.Snapshot;
import org.jclouds.cloudstack.domain.SnapshotPolicy;
import org.jclouds.cloudstack.domain.SnapshotPolicySchedule;
import org.jclouds.cloudstack.filters.AuthenticationFilter;
import org.jclouds.cloudstack.options.CreateSnapshotOptions;
import org.jclouds.cloudstack.options.CreateVMSnapshotOptions;
import org.jclouds.cloudstack.options.ListSnapshotPoliciesOptions;
import org.jclouds.cloudstack.options.ListSnapshotsOptions;
import org.jclouds.rest.annotations.BinderParam;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.OnlyElement;
import org.jclouds.rest.annotations.QueryParams;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.SelectJson;
import org.jclouds.rest.annotations.Unwrap;

import com.google.common.annotations.Beta;

/**
 * Provides synchronous access to CloudStack Snapshot features.
 * <p/>
 * 
 * @see http://cloudstack.apache.org/docs/api/apidocs-4.3/TOC_User.html
 * @author Richard Downer
 * @author liwei
 */
@RequestFilters(AuthenticationFilter.class)
@QueryParams(keys = "response", values = "json")
public interface SnapshotApi {

   /**
    * Creates an instant snapshot of a volume.
    *
    * @param volumeId The ID of the disk volume
    * @param options optional arguments
    * @return an asynchronous job structure
    */
   @Named("createSnapshot")
   @GET
   @Consumes(MediaType.APPLICATION_JSON)
   @QueryParams(keys = "command", values = "createSnapshot")
   @Unwrap
   AsyncCreateResponse createSnapshot(@QueryParam("volumeid") String volumeId, CreateSnapshotOptions... options);

   /**
    * Lists all available snapshots for the account, matching the query described by the options.
    *
    * @param options optional arguments
    * @return the snapshots matching the query
    */
   @Named("listSnapshots")
   @GET
   @Consumes(MediaType.APPLICATION_JSON)
   @QueryParams(keys = { "command", "listAll" }, values = { "listSnapshots", "true" })
   @SelectJson("snapshot")
   @Unwrap
   @Fallback(EmptySetOnNotFoundOr404.class)
   Set<Snapshot> listSnapshots(ListSnapshotsOptions... options);

   /**
    * Gets a snapshot by its ID.
    *
    * @param id the snapshot ID
    * @return the snapshot with the requested ID
    */
   @Named("listSnapshots")
   @GET
   @Consumes(MediaType.APPLICATION_JSON)
   @QueryParams(keys = { "command", "listAll" }, values = { "listSnapshots", "true" })
   @SelectJson("snapshot")
   @OnlyElement
   @Fallback(NullOnNotFoundOr404.class)
   Snapshot getSnapshot(@QueryParam("id") String id);

   /**
    * Deletes a snapshot of a disk volume.
    *
    * @param id The ID of the snapshot
    * @return an asynchronous job structure
    */
   @Named("deleteSnapshot")
   @GET
   @Consumes(MediaType.APPLICATION_JSON)
   @QueryParams(keys = "command", values = "deleteSnapshot")
   @Fallback(VoidOnNotFoundOr404.class)
   void deleteSnapshot(@QueryParam("id") String id);

   /**
    * Creates a snapshot policy for the account.
    *
    * @param schedule how to schedule snapshots
    * @param numberToRetain maximum number of snapshots to retain
    * @param timezone Specifies a timezone for this command. For more information on the timezone parameter, see Time Zone Format.
    * @param volumeId the ID of the disk volume
    * @return the newly-created snapshot policy
    */
   @Named("createSnapshotPolicy")
   @GET
   @Consumes(MediaType.APPLICATION_JSON)
   @Unwrap
   @QueryParams(keys = "command", values = "createSnapshotPolicy")
   SnapshotPolicy createSnapshotPolicy(@BinderParam(BindSnapshotPolicyScheduleToQueryParam.class) SnapshotPolicySchedule schedule, @QueryParam("maxsnaps") String numberToRetain, @QueryParam("timezone") String timezone, @QueryParam("volumeid") String volumeId);

   /**
    * Deletes a snapshot policy for the account.
    *
    * @param id The ID of the snapshot policy
    * @return
    */
   @Named("deleteSnapshotPolicies")
   @GET
   @Consumes(MediaType.APPLICATION_JSON)
   @QueryParams(keys = "command", values = "deleteSnapshotPolicies")
   @Fallback(VoidOnNotFoundOr404.class)
   void deleteSnapshotPolicy(@QueryParam("id") String id);

   /**
    * Deletes snapshot policies for the account.
    *
    * @param id IDs of snapshot policies
    * @return
    */
   @Named("deleteSnapshotPolicies")
   @GET
   @Consumes(MediaType.APPLICATION_JSON)
   @QueryParams(keys = "command", values = "deleteSnapshotPolicies")
   @Fallback(VoidOnNotFoundOr404.class)
   void deleteSnapshotPolicies(@BinderParam(BindIdListToCommaDelimitedQueryParam.class) Iterable<String> id);

   /**
    * Lists snapshot policies.
    *
    * @param volumeId the ID of the disk volume
    * @param options optional arguments
    * @return the snapshot policies matching the query
    */
   @Named("listSnapshotPolicies")
   @GET
   @Consumes(MediaType.APPLICATION_JSON)
   @QueryParams(keys = { "command", "listAll" }, values = { "listSnapshotPolicies", "true" })
   @Unwrap
   @Fallback(EmptySetOnNotFoundOr404.class)
   Set<SnapshotPolicy> listSnapshotPolicies(@QueryParam("volumeid") String volumeId, ListSnapshotPoliciesOptions... options);
   
   /**
    * Revert a volume snapshot.
    * @param id The ID of the snapshot
    */
   @Beta
   @Named("revertSnapshot")
   @GET
   @Consumes(MediaType.APPLICATION_JSON)
   @QueryParams(keys = { "command"}, values = { "revertSnapshot"})
   @SelectJson("jobid")
   @Fallback(EmptySetOnNotFoundOr404.class)
   AsyncCreateResponse revertSnapshot(@QueryParam("id") String id);
   
   /**
    * List virtual machine snapshot by conditions
    */
   @Named("listVMSnapshot")
   @GET
   @Consumes(MediaType.APPLICATION_JSON)
   @QueryParams(keys = { "command"}, values = { "listVMSnapshot"})
   @SelectJson("snapshot")
   @Fallback(EmptySetOnNotFoundOr404.class)
   Set<Snapshot> listVMSnapshot(ListSnapshotsOptions... options);
   
   /**
    * Creates snapshot for a vm.
    * @param virtualMachineId The ID of the vm
    */
   @Beta
   @Named("createVMSnapshot")
   @GET
   @Consumes(MediaType.APPLICATION_JSON)
   @QueryParams(keys = { "command"}, values = { "createVMSnapshot"})
   AsyncCreateResponse createVMSnapshot(@QueryParam("virtualmachineid") String virtualMachineId,
		   CreateVMSnapshotOptions... options);
   
   /**
    * Deletes a vmsnapshot.
    * @param vmsnapshotid The ID of the VM snapshot
    */
   @Beta
   @Named("deleteVMSnapshot")
   @GET
   @Consumes(MediaType.APPLICATION_JSON)
   @QueryParams(keys = { "command"}, values = { "deleteVMSnapshot"})
   @Fallback(EmptySetOnNotFoundOr404.class)
   AsyncCreateResponse deleteVMSnapshot(@QueryParam("vmsnapshotid") String vmSnapshotId);
  
   /**
    * Revert VM from a vmsnapshot.
    * @param vmsnapshotid The ID of the VM snapshot
    */
   @Beta
   @Named("revertToVMSnapshot")
   @GET
   @Consumes(MediaType.APPLICATION_JSON)
   @QueryParams(keys = { "command"}, values = { "revertToVMSnapshot"})
   @Fallback(EmptySetOnNotFoundOr404.class)
   AsyncCreateResponse revertToVMSnapshot(@QueryParam("vmsnapshotid") String vmSnapshotId);
}
