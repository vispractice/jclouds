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
package org.jclouds.cloudstack.domain;

import java.beans.ConstructorProperties;

import org.jclouds.javax.annotation.Nullable;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

/**
 * Class ResourceTag
 *
 * @author liwei
 */
public class ResourceTag {

	public static Builder<?> builder() {
		return new ConcreteBuilder();
	}

	public Builder<?> toBuilder() {
		return new ConcreteBuilder().fromResourceTag(this);
	}

	public abstract static class Builder<T extends Builder<T>> {
		protected abstract T self();

		protected String key;
		protected String value;
		protected String resourceType;
		protected String resourceId;
		protected String accountName;
		protected String projectId;
		protected String project;
		protected String domainId;
		protected String domain;
		protected String customer;

		public T key(String key) {
			this.key = key;
			return self();
		}

		public T value(String value) {
			this.value = value;
			return self();
		}

		public T resourceType(String resourceType) {
			this.resourceType = resourceType;
			return self();
		}

		public T resourceId(String resourceId) {
			this.resourceId = resourceId;
			return self();
		}

		public T accountName(String accountName) {
			this.accountName = accountName;
			return self();
		}

		public T projectId(String projectId) {
			this.projectId = projectId;
			return self();
		}

		public T project(String project) {
			this.project = project;
			return self();
		}

		public T domainId(String domainId) {
			this.domainId = domainId;
			return self();
		}

		public T domain(String domain) {
			this.domain = domain;
			return self();
		}

		public T customer(String customer) {
			this.customer = customer;
			return self();
		}

		public ResourceTag build() {
			return new ResourceTag(key, value, resourceType, resourceId,
					accountName, projectId, project, domainId, domain, customer);
		}

		public T fromResourceTag(ResourceTag in) {
			return this.key(in.getKey()).value(in.getValue())
					.resourceType(in.getResourceType())
					.resourceId(in.getResourceId())
					.accountName(in.getAccountName())
					.projectId(in.getProject()).project(in.getProject())
					.domainId(in.getDomainId()).domain(in.getDomain())
					.customer(in.getCustomer());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	private final String key;
	private final String value;
	private final String resourceType;
	private final String resourceId;
	private final String accountName;
	private final String projectId;
	private final String project;
	private final String domainId;
	private final String domain;
	private final String customer;

	@ConstructorProperties({ "key", "value", "resourcetype", "resourceid",
			"accountname", "projectid", "project", "domainid", "domain",
			"customer" })
	protected ResourceTag(String key, @Nullable String value,
			@Nullable String resourceType, @Nullable String resourceId,
			@Nullable String accountName, @Nullable String projectId,
			@Nullable String projectName, @Nullable String domainId,
			@Nullable String domainName, @Nullable String customer) {
		this.key = key;
		this.value = value;
		this.resourceType = resourceType;
		this.resourceId = resourceId;
		this.accountName = accountName;
		this.projectId = projectId;
		this.project = projectName;
		this.domainId = domainId;
		this.domain = domainName;
		this.customer = customer;
	}

	/**
	 * @return tag key name
	 */
	@Nullable
	public String getKey() {
		return key;
	}

	/**
	 * @return tag value
	 */
	@Nullable
	public String getValue() {
		return value;
	}

	/**
	 * @return resource type
	 */
	@Nullable
	public String getResourceType() {
		return resourceType;
	}

	/**
	 * @return id of the resource
	 */
	@Nullable
	public String getResourceId() {
		return resourceId;
	}

	/**
	 * @return the account associated with the tag
	 */
	@Nullable
	public String getAccountName() {
		return accountName;
	}

	/**
	 * @return the project id the tag belongs to
	 */
	@Nullable
	public String getProjectId() {
		return projectId;
	}

	/**
	 * @return the project name where tag belongs to
	 */
	@Nullable
	public String getProject() {
		return project;
	}

	/**
	 * @return the ID of the domain associated with the tag
	 */
	@Nullable
	public String getDomainId() {
		return domainId;
	}

	/**
	 * @return the domain associated with the tag
	 */
	@Nullable
	public String getDomain() {
		return domain;
	}

	/**
	 * @return
	 */
	@Nullable
	public String getCustomer() {
		return customer;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(key, value, resourceType, resourceId,
				accountName, projectId, project, domainId, domain, customer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		ResourceTag that = ResourceTag.class.cast(obj);
		return Objects.equal(this.key, that.key)
				&& Objects.equal(this.value, that.value)
				&& Objects.equal(this.resourceType, that.resourceType)
				&& Objects.equal(this.resourceId, that.resourceId)
				&& Objects.equal(this.accountName, that.accountName)
				&& Objects.equal(this.projectId, that.projectId)
				&& Objects.equal(this.project, that.project)
				&& Objects.equal(this.domainId, that.domainId)
				&& Objects.equal(this.domain, that.domain)
				&& Objects.equal(this.customer, that.customer);
	}

	protected ToStringHelper string() {
		return Objects.toStringHelper(this).add("key", key).add("value", value)
				.add("resourceType", resourceType)
				.add("resourceId", resourceId).add("accountName", accountName)
				.add("projectId", projectId).add("project", project)
				.add("domainId", domainId).add("domain", domain)
				.add("customer", customer);
	}

	@Override
	public String toString() {
		return string().toString();
	}

}
