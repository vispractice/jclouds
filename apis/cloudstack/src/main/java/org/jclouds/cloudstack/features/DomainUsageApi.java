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

import org.jclouds.cloudstack.domain.UsageRecord;
import org.jclouds.cloudstack.filters.AuthenticationFilter;
import org.jclouds.cloudstack.functions.DateToYyyyMmDd;
import org.jclouds.cloudstack.options.ListUsageRecordsOptions;
import org.jclouds.rest.annotations.ParamParser;
import org.jclouds.rest.annotations.QueryParams;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.SelectJson;

/**
 * Provides synchronous access to CloudStack usage features.
 * <p/>
 *
 * @see <a href="http://cloudstack.apache.org/docs/api/apidocs-4.3/TOC_Domain_Admin.html" />
 * @author liwei
 */
@RequestFilters(AuthenticationFilter.class)
@QueryParams(keys = "response", values = "json")
public interface DomainUsageApi {
	
	/**
	 * Lists usage records for accounts
	 * @param start Start date range for usage record query. Use yyyy-MM-dd as the date format, e.g. startDate=2009-06-01.
	 * @param end End date range for usage record query. Use yyyy-MM-dd as the date format, e.g. startDate=2009-06-03.
	 */
   @Named("listUsageRecords")
   @GET
   @QueryParams(keys = { "command", "listAll" }, values = { "listUsageRecords", "true" })
   @SelectJson("usagerecord")
   @Consumes(MediaType.APPLICATION_JSON)
   Set<UsageRecord> listUsageRecords(@QueryParam("startdate") @ParamParser(DateToYyyyMmDd.class) Date start, @QueryParam("enddate") @ParamParser(DateToYyyyMmDd.class) Date end, ListUsageRecordsOptions... options);

}
