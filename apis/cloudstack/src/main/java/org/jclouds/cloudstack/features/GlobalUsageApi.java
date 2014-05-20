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

import java.util.Date;
import java.util.Set;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jclouds.cloudstack.domain.JobResult;
import org.jclouds.cloudstack.domain.NetworkTrafficType;
import org.jclouds.cloudstack.domain.TrafficMonitor;
import org.jclouds.cloudstack.domain.TrafficType;
import org.jclouds.cloudstack.domain.TrafficTypeImplementor;
import org.jclouds.cloudstack.domain.UsageType;
import org.jclouds.cloudstack.filters.AuthenticationFilter;
import org.jclouds.cloudstack.functions.DateToYyyyMmDd;
import org.jclouds.cloudstack.options.AddTrafficMonitorOptions;
import org.jclouds.cloudstack.options.AddTrafficTypeOptions;
import org.jclouds.cloudstack.options.GenerateUsageRecordsOptions;
import org.jclouds.cloudstack.options.ListTrafficTypeImplementorsOptions;
import org.jclouds.cloudstack.options.ListTrafficTypesOptions;
import org.jclouds.cloudstack.options.UpdateTrafficTypeOptions;
import org.jclouds.rest.annotations.ParamParser;
import org.jclouds.rest.annotations.QueryParams;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.SelectJson;

import com.google.common.annotations.Beta;

/**
 * Provides synchronous access to CloudStack usage features.
 * <p/>
 *
 * @see <a href="http://cloudstack.apache.org/docs/api/apidocs-4.3/TOC_Root_Admin.html" />
 * @author Richard Downer
 * @author liwei
 */
@RequestFilters(AuthenticationFilter.class)
@QueryParams(keys = "response", values = "json")
public interface GlobalUsageApi extends DomainUsageApi{

	/**
	 * Generates usage records. This will generate records only if there any records to be generated, i.e if the scheduled usage job was not run or failed
	 * @param start Start date range for usage record query. Use yyyy-MM-dd as the date format, e.g. startDate=2009-06-01.
	 * @param end End date range for usage record query. Use yyyy-MM-dd as the date format, e.g. startDate=2009-06-03.
	 */
   @Named("generateUsageRecords")
   @GET
   @QueryParams(keys = "command", values = "generateUsageRecords")
   @SelectJson("generateusagerecordsresponse")
   @Consumes(MediaType.APPLICATION_JSON)
   JobResult generateUsageRecords(@QueryParam("startdate") @ParamParser(DateToYyyyMmDd.class) Date start, @QueryParam("enddate") @ParamParser(DateToYyyyMmDd.class) Date end, GenerateUsageRecordsOptions... options);

   /**
    * Adds traffic type to a physical network
    * @param physicalNetworkId the Physical Network ID
    * @param trafficType the trafficType to be added to the physical network
    */
   @Beta
   @Named("addTrafficType")
   @GET
   @QueryParams(keys = "command", values = "addTrafficType")
   @SelectJson("addtraffictyperesponse")
   @Consumes(MediaType.APPLICATION_JSON)
   NetworkTrafficType addTrafficType(@QueryParam("physicalnetworkid") String physicalNetworkId,
		   @QueryParam("traffictype") TrafficType trafficType,
		   AddTrafficTypeOptions... options);
   
   /**
    * Deletes traffic type of a physical network
    * @param id traffic type id
    */
   @Beta
   @Named("deleteTrafficType")
   @GET
   @QueryParams(keys = "command", values = "deleteTrafficType")
   @Consumes(MediaType.APPLICATION_JSON)
   JobResult deleteTrafficType(@QueryParam("id") String id);
   
   /**
    * Lists traffic types of a given physical network.
    * @param physicalNetworkId the Physical Network ID
    */
   @Beta
   @Named("listTrafficTypes")
   @GET
   @QueryParams(keys = "command", values = "listTrafficTypes")
   @SelectJson("listtraffictypesresponse")
   @Consumes(MediaType.APPLICATION_JSON)
   Set<NetworkTrafficType> listTrafficTypes(
		   @QueryParam("physicalnetworkid") String physicalNetworkId,
		   ListTrafficTypesOptions... options);
   
   /**
    * Updates traffic type of a physical network
    * @param id traffic type id
    */
   @Beta
   @Named("updateTrafficType")
   @GET
   @QueryParams(keys = "command", values = "updateTrafficType")
   @SelectJson("updatetraffictyperesponse")
   @Consumes(MediaType.APPLICATION_JSON)
   NetworkTrafficType updateTrafficType(@QueryParam("id") String id,
		   UpdateTrafficTypeOptions... options);
   
   /**
    * Lists implementors of implementor of a network traffic type or implementors of all network traffic types
    */
   @Beta
   @Named("listTrafficTypeImplementors")
   @GET
   @QueryParams(keys = "command", values = "listTrafficTypeImplementors")
   @SelectJson("traffictypeimplementorresponse")
   @Consumes(MediaType.APPLICATION_JSON)
   Set<TrafficTypeImplementor> listTrafficTypeImplementors(ListTrafficTypeImplementorsOptions... options);
   
   /**
    * List Usage Types
    */
   @Beta
   @Named("listUsageTypes")
   @GET
   @QueryParams(keys = "command", values = "listUsageTypes")
   @SelectJson("listusagetypesresponse")
   @Consumes(MediaType.APPLICATION_JSON)
   Set<UsageType> listUsageTypes();
   
   /**
    * Adds Traffic Monitor Host for Direct Network Usage
    * @param url URL of the traffic monitor Host
    * @param zoneId Zone in which to add the external firewall appliance.
    */
   @Beta
   @Named("addTrafficMonitor")
   @GET
   @QueryParams(keys = "command", values = "addTrafficMonitor")
   @SelectJson("addtrafficmonitorresponse")
   @Consumes(MediaType.APPLICATION_JSON)
   TrafficMonitor addTrafficMonitor(@QueryParam("url") String url,
		   @QueryParam("zoneid") String zoneId,
		   AddTrafficMonitorOptions... options);
   
   /**
    * Deletes an traffic monitor host.
    * @param id Id of the Traffic Monitor Host.
    */
   @Beta
   @Named("deleteTrafficMonitor")
   @GET
   @QueryParams(keys = "command", values = "deleteTrafficMonitor")
   @Consumes(MediaType.APPLICATION_JSON)
   JobResult deleteTrafficMonitor(@QueryParam("id") String id);
   
   /**
    * List traffic monitor Hosts.
    * @param zoneId zone Id
    */
   @Beta
   @Named("listTrafficMonitors")
   @GET
   @QueryParams(keys = "command", values = "listTrafficMonitors")
   @SelectJson("listtrafficmonitorsresponse")
   @Consumes(MediaType.APPLICATION_JSON)
   Set<TrafficMonitor> listTrafficMonitors(@QueryParam("zoneid") String zoneId);
}
