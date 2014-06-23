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

import org.jclouds.http.options.BaseHttpRequestOptions;

import com.google.common.collect.ImmutableSet;

/**
 * Options used to update resource limit
 *
 * @author gaozheng
 */
public class UpdateResourceLimitOptions extends BaseHttpRequestOptions {

	public static final UpdateResourceLimitOptions NONE = new UpdateResourceLimitOptions();

	/**
	 * @param account Update resource for a specified account. Must be used with the domainId parameter.
	 */
	public UpdateResourceLimitOptions account(String account) {
		this.queryParameters.replaceValues("account", ImmutableSet.of(account));
		return this;
	}
	
	/**
	 * @param domainId Update resource limits for all accounts in specified domain. If used with the account parameter, updates resource limits for a specified account in specified domain.
	 */
	public UpdateResourceLimitOptions domainId(String domainId) {
		this.queryParameters.replaceValues("domainid", ImmutableSet.of(domainId));
		return this;
	}
	
	/**
	 * @param max Maximum resource limit.
	 */
	public UpdateResourceLimitOptions max(int max) {
		this.queryParameters.replaceValues("max", ImmutableSet.of(max + ""));
		return this;
	}
	
	/**
	 * @param projectId Update resource limits for project
	 */
	public UpdateResourceLimitOptions projectId(String projectId) {
		this.queryParameters.replaceValues("projectid", ImmutableSet.of(projectId));
		return this;
	}

	public static class Builder {

		/**
		 * @see UpdateResourceLimitOptions#account
		 */
		public static UpdateResourceLimitOptions account(String account) {
			UpdateResourceLimitOptions options = new UpdateResourceLimitOptions();
			return options.account(account);
		}
		
		/**
		 * @see UpdateResourceLimitOptions#domainId
		 */
		public static UpdateResourceLimitOptions domainId(String domainId) {
			UpdateResourceLimitOptions options = new UpdateResourceLimitOptions();
			return options.domainId(domainId);
		}
		
		/**
		 * @see UpdateResourceLimitOptions#max
		 */
		public static UpdateResourceLimitOptions max(int max) {
			UpdateResourceLimitOptions options = new UpdateResourceLimitOptions();
			return options.max(max);
		}
		
		/**
		 * @see UpdateResourceLimitOptions#projectId
		 */
		public static UpdateResourceLimitOptions projectId(String projectId) {
			UpdateResourceLimitOptions options = new UpdateResourceLimitOptions();
			return options.projectId(projectId);
		}
	}

}
