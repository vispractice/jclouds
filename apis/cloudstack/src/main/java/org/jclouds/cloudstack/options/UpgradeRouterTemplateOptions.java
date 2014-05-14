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
package org.jclouds.cloudstack.options;

import com.google.common.collect.ImmutableSet;

/**
 * Options used to upgrades router to use newer template
 * 
 * @see <a href=
 *      "http://cloudstack.apache.org/docs/api/apidocs-4.3/root_admin/upgradeRouterTemplate.html"
 *      />
 * @author liwei
 */
public class UpgradeRouterTemplateOptions extends AccountInDomainOptions {

	public static final UpgradeRouterTemplateOptions NONE = new UpgradeRouterTemplateOptions();

	/**
	 * @param id
	 *            upgrades router with the specified Id
	 */
	public UpgradeRouterTemplateOptions id(String id) {
		this.queryParameters.replaceValues("id", ImmutableSet.of(id + ""));
		return this;
	}

	/**
	 * @param clusterId
	 *            upgrades all routers within the specified cluster
	 */
	public UpgradeRouterTemplateOptions clusterId(String clusterId) {
		this.queryParameters.replaceValues("clusterid", ImmutableSet.of(clusterId));
		return this;
	}

	/**
	 * @param zoneId
	 *            upgrades all routers within the specified zone
	 */
	public UpgradeRouterTemplateOptions zoneId(String zoneId) {
		this.queryParameters.replaceValues("zoneid", ImmutableSet.of(zoneId + ""));
		return this;
	}

	/**
	 * @param podId
	 *            upgrades all routers within the specified pod
	 */
	public UpgradeRouterTemplateOptions podId(String podId) {
		this.queryParameters.replaceValues("podid", ImmutableSet.of(podId + ""));
		return this;

	}

	public static class Builder {

		/**
		 * @see UpgradeRouterTemplateOptions#domainId
		 */
		public static UpgradeRouterTemplateOptions domainId(String id) {
			UpgradeRouterTemplateOptions options = new UpgradeRouterTemplateOptions();
			return options.domainId(id);
		}

		/**
		 * @see UpgradeRouterTemplateOptions#accountInDomain
		 */
		public static UpgradeRouterTemplateOptions accountInDomain(
				String account, String domain) {
			UpgradeRouterTemplateOptions options = new UpgradeRouterTemplateOptions();
			return options.accountInDomain(account, domain);
		}

		/**
		 * @see UpgradeRouterTemplateOptions#id
		 */
		public static UpgradeRouterTemplateOptions id(String id) {
			UpgradeRouterTemplateOptions options = new UpgradeRouterTemplateOptions();
			return options.id(id);
		}

		/**
		 * @see UpgradeRouterTemplateOptions#clusterId
		 */
		public static UpgradeRouterTemplateOptions clusterId(String name) {
			UpgradeRouterTemplateOptions options = new UpgradeRouterTemplateOptions();
			return options.clusterId(name);
		}

		/**
		 * @see UpgradeRouterTemplateOptions#zoneId
		 */
		public static UpgradeRouterTemplateOptions zoneId(String id) {
			UpgradeRouterTemplateOptions options = new UpgradeRouterTemplateOptions();
			return options.zoneId(id);
		}

		/**
		 * @see UpgradeRouterTemplateOptions#podId(String)
		 */
		public static UpgradeRouterTemplateOptions podId(String podId) {
			UpgradeRouterTemplateOptions options = new UpgradeRouterTemplateOptions();
			return options.podId(podId);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UpgradeRouterTemplateOptions accountInDomain(String account,
			String domain) {
		return UpgradeRouterTemplateOptions.class.cast(super.accountInDomain(
				account, domain));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UpgradeRouterTemplateOptions domainId(String domainId) {
		return UpgradeRouterTemplateOptions.class
				.cast(super.domainId(domainId));
	}
}
