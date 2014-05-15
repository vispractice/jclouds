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
import org.jclouds.cloudstack.domain.AsyncCreateResponse;
import org.jclouds.cloudstack.domain.Cluster;
import org.jclouds.cloudstack.domain.Host;
import org.jclouds.cloudstack.filters.AuthenticationFilter;
import org.jclouds.cloudstack.options.AddClusterOptions;
import org.jclouds.cloudstack.options.AddHostOptions;
import org.jclouds.cloudstack.options.AddSecondaryStorageOptions;
import org.jclouds.cloudstack.options.DedicateHostOptions;
import org.jclouds.cloudstack.options.DeleteHostOptions;
import org.jclouds.cloudstack.options.ListClustersOptions;
import org.jclouds.cloudstack.options.ListHostsOptions;
import org.jclouds.cloudstack.options.UpdateClusterOptions;
import org.jclouds.cloudstack.options.UpdateHostOptions;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.QueryParams;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.SelectJson;

import com.google.common.annotations.Beta;

/**
 * Provides synchronous access to cloudstack via their REST API.
 * <p/>
 *
 * @see <a href="http://cloudstack.apache.org/docs/api/apidocs-4.3/TOC_Root_Admin.html" />
 * @author Andrei Savu
 */
@RequestFilters(AuthenticationFilter.class)
@QueryParams(keys = "response", values = "json")
public interface GlobalHostApi {

   /**
    * Lists hosts
    *
    * @param options
    *           if present, how to constrain the list.
    * @return hosts matching query, or empty set, if no service
    *         offerings are found
    */
   @Named("listHosts")
   @GET
   @QueryParams(keys = { "command", "listAll" }, values = { "listHosts", "true" })
   @SelectJson("host")
   @Consumes(MediaType.APPLICATION_JSON)
   @Fallback(EmptySetOnNotFoundOr404.class)
   Set<Host> listHosts(ListHostsOptions... options);

   /**
    * Adds a new host.
    *
    * @param zoneId the Zone ID for the host
    * @param url the host URL
    * @param hypervisor hypervisor type of the host
    * @param username the username for the host
    * @param password the password for the host
    * @param options optional arguments
    * @return the new host.
    */
   @Named("addHost")
   @GET
   @QueryParams(keys = "command", values = "addHost")
   @SelectJson("host")
   @Consumes(MediaType.APPLICATION_JSON)
   Host addHost(@QueryParam("zoneid") String zoneId, @QueryParam("url") String url, @QueryParam("hypervisor") String hypervisor, @QueryParam("username") String username, @QueryParam("password") String password, AddHostOptions... options);

   /**
    * Updates a host.
    *
    * @param hostId the ID of the host to update
    * @param options optional arguments
    * @return the modified host.
    */
   @Named("updateHost")
   @GET
   @QueryParams(keys = "command", values = "updateHost")
   @SelectJson("host")
   @Consumes(MediaType.APPLICATION_JSON)
   Host updateHost(@QueryParam("id") String hostId, UpdateHostOptions... options);

   /**
    * Update password of a host on management server.
    *
    * @param hostId the host ID
    * @param username the username for the host
    * @param password the password for the host
    */
   @Named("updateHostPassword")
   @GET
   @QueryParams(keys = "command", values = "updateHostPassword")
   @Consumes(MediaType.APPLICATION_JSON)
   void updateHostPassword(@QueryParam("hostid") String hostId, @QueryParam("username") String username, @QueryParam("password") String password);

   /**
    * Deletes a host.
    *
    * @param hostId the host ID
    * @param options optional arguments
    */
   @Named("deleteHost")
   @GET
   @QueryParams(keys = "command", values = "deleteHost")
   @Consumes(MediaType.APPLICATION_JSON)
   void deleteHost(@QueryParam("id") String hostId, DeleteHostOptions... options);

   /**
    * Prepares a host for maintenance.
    *
    * @param hostId the host ID
    * @return a job reference number for tracking this asynchronous job.
    */
   @Named("prepareHostForMaintenance")
   @GET
   @QueryParams(keys = "command", values = "prepareHostForMaintenance")
   @SelectJson("jobid")
   @Consumes(MediaType.APPLICATION_JSON)
   String prepareHostForMaintenance(@QueryParam("id") String hostId);

   /**
    * Cancels host maintenance.
    *
    * @param hostId the host ID
    * @return a job reference number for tracking this asynchronous job.
    */
   @Named("cancelHostMaintenance")
   @GET
   @QueryParams(keys = "command", values = "cancelHostMaintenance")
   @SelectJson("jobid")
   @Consumes(MediaType.APPLICATION_JSON)
   String cancelHostMaintenance(@QueryParam("id") String hostId);

   /**
    * Reconnects a host.
    *
    * @param hostId
    * @return a job reference number for tracking this asynchronous job.
    */
   @Named("reconnectHost")
   @GET
   @QueryParams(keys = "command", values = "reconnectHost")
   @SelectJson("jobid")
   @Consumes(MediaType.APPLICATION_JSON)
   String reconnectHost(@QueryParam("id") String hostId);

   /**
    * Adds secondary storage.
    *
    * @param url the URL for the secondary storage
    * @param options optional arguments
    * @return the host of the storage.
    */
   @Named("addSecondaryStorage")
   @GET
   @QueryParams(keys = "command", values = "addSecondaryStorage")
   @SelectJson("host")
   @Consumes(MediaType.APPLICATION_JSON)
   Host addSecondaryStorage(@QueryParam("url") String url, AddSecondaryStorageOptions... options);

   /**
    * @see GlobalHostApi#listClusters
    */
   @Named("listClusters")
   @GET
   @QueryParams(keys = { "command", "listAll" }, values = { "listClusters", "true" })
   @SelectJson("cluster")
   @Consumes(MediaType.APPLICATION_JSON)
   @Fallback(EmptySetOnNotFoundOr404.class)
   Set<Cluster> listClusters(ListClustersOptions... options);

   /**
    * Adds a new cluster.
    *
    * @param zoneId the Zone ID for the cluster
    * @param clusterName the cluster name
    * @param clusterType type of the cluster
    * @param hypervisor hypervisor type of the cluster
    * @param options optional arguments
    * @return the new cluster.
    */
   @Named("addCluster")
   @GET
   @QueryParams(keys = "command", values = "addCluster")
   @SelectJson("cluster")
   @Consumes(MediaType.APPLICATION_JSON)
   Cluster addCluster(@QueryParam("zoneid") String zoneId, @QueryParam("clustername") String clusterName, @QueryParam("clustertype") Host.ClusterType clusterType, @QueryParam("hypervisor") String hypervisor, AddClusterOptions... options);

   /**
    * Updates an existing cluster.
    *
    * @param clusterId the ID of the cluster
    * @param options optional arguments
    * @return the modified cluster
    */
   @Named("updateCluster")
   @GET
   @QueryParams(keys = "command", values = "updateCluster")
   @SelectJson("cluster")
   @Consumes(MediaType.APPLICATION_JSON)
   Cluster updateCluster(@QueryParam("id") String clusterId, UpdateClusterOptions... options);

   /**
    * Update password of a cluster on management server.
    *
    * @param clusterId the cluster ID
    * @param username the username for the cluster
    * @param password the password for the cluster
    */
   @Named("updateHostPassword")
   @GET
   @QueryParams(keys = "command", values = "updateHostPassword")
   @SelectJson("cluster")
   @Consumes(MediaType.APPLICATION_JSON)
   void updateClusterPassword(@QueryParam("clusterid") String clusterId, @QueryParam("username") String username, @QueryParam("password") String password);

   /**
    * Deletes a cluster.
    *
    * @param clusterId the cluster ID
    */
   @Named("deleteCluster")
   @GET
   @QueryParams(keys = "command", values = "deleteCluster")
   @Consumes(MediaType.APPLICATION_JSON)
   void deleteCluster(@QueryParam("id") String clusterId);

   /**
    * Find hosts suitable for migrating a virtual machine.
    * @param virtualMachineId find hosts to which this VM can be migrated and flag the hosts with enough CPU/RAM to host the VM
    */
   @Named("findHostsForMigration")
   @GET
   @QueryParams(keys = "command", values = "findHostsForMigration")
   @SelectJson("host")
   @Consumes(MediaType.APPLICATION_JSON)
   void findHostsForMigration(@QueryParam("virtualmachineid") String virtualMachineId);
   
   /**
    * Releases host reservation.
    * @param id the host ID
    */
   @Named("releaseHostReservation")
   @GET
   @QueryParams(keys = "command", values = "releaseHostReservation")
   @SelectJson({ "releasehostreservation", "releasehostreservationresponse" })
   @Consumes(MediaType.APPLICATION_JSON)
   AsyncCreateResponse releaseHostReservation(@QueryParam("id") String id);
   
   /**
    * Add a baremetal host.
    *
    * @param zoneId the Zone ID for the host
    * @param podId the Pod ID for the host
    * @param url the host URL
    * @param hypervisor hypervisor type of the host
    * @param username the username for the host
    * @param password the password for the host
    * @param options optional arguments
    * @return the new host.
    */
   @Beta
   @Named("addBaremetalHost")
   @GET
   @QueryParams(keys = "command", values = "addBaremetalHost")
   @SelectJson("host")
   @Consumes(MediaType.APPLICATION_JSON)
   Host addBaremetalHost(@QueryParam("zoneid") String zoneId, @QueryParam("podid") String podId, @QueryParam("url") String url, @QueryParam("hypervisor") String hypervisor, @QueryParam("username") String username, @QueryParam("password") String password, AddHostOptions... options);

   /**
    * Dedicates a host.
    * @param hostId the ID of the containing domain
    * @param domainId the ID of the host to update
    * @param options
    */
   @Beta
   @Named("dedicateHost")
   @GET
   @QueryParams(keys = "command", values = "dedicateHost")
   @Consumes(MediaType.APPLICATION_JSON)
   AsyncCreateResponse dedicateHost(@QueryParam("hostid") String hostId, @QueryParam("domainid") String domainId, DedicateHostOptions... options);
   
   /**
    * Release the dedication for host
    * @param hostId the ID of the host
    */
   @Beta
   @Named("releaseDedicatedHost")
   @GET
   @QueryParams(keys = "command", values = "releaseDedicatedHost")
   @Consumes(MediaType.APPLICATION_JSON)
   void releaseDedicatedHost(@QueryParam("hostid") String hostId);
   
   /**
    * Lists dedicated hosts.
    */
   @Beta
   @Named("listDedicatedHosts")
   @GET
   @QueryParams(keys = { "command"}, values = { "listDedicatedHosts" })
   @SelectJson("listdedicatedhostsresponse")
   @Consumes(MediaType.APPLICATION_JSON)
   @Fallback(EmptySetOnNotFoundOr404.class)
   Set<Host> listDedicatedHosts(ListHostsOptions... options);
}
