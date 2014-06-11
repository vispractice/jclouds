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

import org.jclouds.Fallbacks.EmptySetOnNotFoundOr404;
import org.jclouds.cloudstack.domain.AsyncCreateResponse;
import org.jclouds.cloudstack.filters.AuthenticationFilter;
import org.jclouds.cloudstack.options.UpgradeRouterTemplateOptions;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.QueryParams;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.SelectJson;

import com.google.common.annotations.Beta;

/**
 * @author liwei
 */
@RequestFilters(AuthenticationFilter.class)
@QueryParams(keys = "response", values = "json")
public interface GlobalTemplateApi extends DomainTemplateApi {

	/**
	 * Load template into primary storage
	 */
	@Beta
	@Named("prepareTemplate")
	@GET
	@QueryParams(keys = "command", values = "prepareTemplate")
	@SelectJson("preparetemplateresponse")
	void prepareTemplate(@QueryParam("templateid") String templateId,
			@QueryParam("zoneid") String zoneId);

	/**
	 * Upgrades router to use newer template
	 */
	@Beta
	@Named("upgradeRouterTemplate")
	@GET
	@QueryParams(keys = { "command"}, values = { "upgradeRouterTemplate"})
	@SelectJson("upgraderoutertemplateresponse")
	@Consumes(MediaType.APPLICATION_JSON)
	@Fallback(EmptySetOnNotFoundOr404.class)
	AsyncCreateResponse upgradeRouterTemplate(UpgradeRouterTemplateOptions... options);
}