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

import static com.google.common.base.Preconditions.checkNotNull;

import java.beans.ConstructorProperties;
import java.util.Date;

import org.jclouds.javax.annotation.Nullable;

import com.google.common.base.CaseFormat;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

/**
 * Class VMSnapshot
 *
 * @author liwei
 */
public class VMSnapshot {

	/**
    */
	public static enum State {

		READY, BACKED_UP, CREATING, BACKING_UP, UNRECOGNIZED;

		@Override
		public String toString() {
			return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL,
					name());
		}

		public static State fromValue(String state) {
			try {
				return valueOf(CaseFormat.UPPER_CAMEL.to(
						CaseFormat.UPPER_UNDERSCORE,
						checkNotNull(state, "state")));
			} catch (IllegalArgumentException e) {
				return UNRECOGNIZED;
			}
		}
	}

	/**
    */
	public static enum Type {

		DISK, MEMORY, DISK_AND_MEMORY, UNRECOGNIZED;

		public static Type fromValue(String type) {
			try {
				return valueOf(CaseFormat.UPPER_CAMEL.to(
                        CaseFormat.UPPER_UNDERSCORE,
                        checkNotNull(type, "type")));
			} catch (IllegalArgumentException e) {
				return UNRECOGNIZED;
			}
		}
	}

	public static Builder<?> builder() {
		return new ConcreteBuilder();
	}

	public Builder<?> toBuilder() {
		return new ConcreteBuilder().fromVMSnapshot(this);
	}

	public abstract static class Builder<T extends Builder<T>> {
		protected abstract T self();

		protected String id;
		protected String account;
		protected Date created;
		protected boolean current;
		protected String description;
		protected String displayName;
		protected String domain;
		protected String domainId;
		protected String name;
		protected String parent;
		protected String parentName;
		protected String project;
		protected String projectId;
		protected VMSnapshot.Type type;
		protected VMSnapshot.State state;
		protected String virtualMachineId;
		protected String zoneId;

		public T id(String id) {
			this.id = id;
			return self();
		}

		public T account(String account) {
			this.account = account;
			return self();
		}

		public T created(Date created) {
			this.created = created;
			return self();
		}

		public T current(boolean current) {
			this.current = current;
			return self();
		}

		public T description(String description) {
			this.description = description;
			return self();
		}

		public T displayName(String displayName) {
			this.displayName = displayName;
			return self();
		}

		public T domain(String domain) {
			this.domain = domain;
			return self();
		}

		public T domainId(String domainId) {
			this.domainId = domainId;
			return self();
		}

		public T name(String name) {
			this.name = name;
			return self();
		}

		public T parent(String parent) {
			this.parent = parent;
			return self();
		}

		public T parentName(String parentName) {
			this.parentName = parentName;
			return self();
		}

		public T project(String project) {
			this.project = project;
			return self();
		}

		public T projectId(String projectId) {
			this.projectId = projectId;
			return self();
		}

		public T type(VMSnapshot.Type type) {
			this.type = type;
			return self();
		}

		public T state(VMSnapshot.State state) {
			this.state = state;
			return self();
		}

		public T virtualMachineId(String virtualMachineId) {
			this.virtualMachineId = virtualMachineId;
			return self();
		}

		public T zoneId(String zoneId) {
			this.zoneId = zoneId;
			return self();
		}

		public VMSnapshot build() {
			return new VMSnapshot(id, account, created, current, description,
					displayName, domain, domainId, name, parent, parentName,
					project, projectId, type, state, virtualMachineId,
					zoneId);
		}

		public T fromVMSnapshot(VMSnapshot in) {
			return this.id(in.getId()).account(in.getAccount())
					.created(in.getCreated()).domain(in.getDomain())
					.domainId(in.getDomainId())
					.description(in.getDescription())
					.displayName(in.getDisplayName()).parent(in.getParent())
					.name(in.getName()).type(in.getType())
					.state(in.getState()).parentName(in.getParentName())
					.virtualMachineId(in.getVirtualMachineId())
					.zoneId(in.getZoneId()).project(in.getProject())
					.projectId(in.getProjectId());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	private final String id;
	private final String account;
	private final Date created;
	private final boolean current;
	private final String description;
	private final String displayName;
	private final String domain;
	private final String domainId;
	private final String name;
	private final String parent;
	private final String parentName;
	private final String project;
	private final String projectId;
	private final VMSnapshot.Type type;
	private final VMSnapshot.State state;
	private final String virtualMachineId;
	private final String zoneId;

	@ConstructorProperties({ "id", "account", "created", "current",
			"description", "displayname", "domain", "domainid", "name",
			"parent", "parentName", "project", "projectid", "type",
			"state", "virtualmachineid", "zoneid" })
	protected VMSnapshot(String id, @Nullable String account,
			@Nullable Date created, boolean current,
			@Nullable String description, @Nullable String displayName,
			@Nullable String domain, @Nullable String domainId,
			@Nullable String name, @Nullable String parent,
			@Nullable String parentName, @Nullable String project,
			@Nullable String projectId, @Nullable VMSnapshot.Type type,
			@Nullable VMSnapshot.State state,
			@Nullable String virtualMachineId, @Nullable String zoneId) {
		this.id = checkNotNull(id, "id");
		this.account = account;
		this.created = created;
		this.current = current;
		this.description = description;
		this.displayName = displayName;
		this.domain = domain;
		this.domainId = domainId;
		this.name = name;
		this.parent = parent;
		this.parentName = parentName;
		this.project = project;
		this.projectId = projectId;
		this.type = type;
		this.state = state;
		this.virtualMachineId = virtualMachineId;
		this.zoneId = zoneId;
	}

	/**
	 * @return ID of the snapshot
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @return the account associated with the snapshot
	 */
	@Nullable
	public String getAccount() {
		return this.account;
	}

	/**
	 * @return the date the snapshot was created
	 */
	@Nullable
	public Date getCreated() {
		return this.created;
	}

	/**
	 * @return the domain name of the snapshot's account
	 */
	@Nullable
	public String getDomain() {
		return this.domain;
	}

	/**
	 * @return the domain ID of the snapshot's account
	 */
	@Nullable
	public String getDomainId() {
		return this.domainId;
	}

	/**
	 * @return name of the snapshot
	 */
	@Nullable
	public String getName() {
		return this.name;
	}

	/**
	 * @return the type of the snapshot
	 */
	@Nullable
	public VMSnapshot.Type getType() {
		return this.type;
	}

	/**
	 * @return the state of the snapshot. BackedUp means that snapshot is ready
	 *         to be used; Creating - the snapshot is being allocated on the
	 *         primary storage; BackingUp - the snapshot is being backed up on
	 *         secondary storage
	 */
	@Nullable
	public VMSnapshot.State getState() {
		return this.state;
	}

	/**
	 * @return the project name of the snapshot
	 */
	public String getProject() {
		return project;
	}

	/**
	 * @return the project id of the snapshot
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * @return indiates if this is current snapshot
	 */
	public boolean isCurrent() {
		return current;
	}

	/**
	 * @return the description of the vm snapshot
	 */
	@Nullable
	public String getDescription() {
		return description;
	}

	/**
	 * @return the display name of the vm snapshot
	 */
	@Nullable
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @return the parent ID of the vm snapshot
	 */
	@Nullable
	public String getParent() {
		return parent;
	}

	/**
	 * @return the parent displayName of the vm snapshot
	 */
	@Nullable
	public String getParentName() {
		return parentName;
	}

	/**
	 * @return the vm ID of the vm snapshot
	 */
	@Nullable
	public String getVirtualMachineId() {
		return virtualMachineId;
	}

	/**
	 * @return the Zone ID of the vm snapshot
	 */
	@Nullable
	public String getZoneId() {
		return zoneId;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id, account, created, current, description,
				displayName, domain, domainId, name, parent, parentName,
				project, projectId, type, state, virtualMachineId,
				zoneId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		VMSnapshot that = VMSnapshot.class.cast(obj);
		return Objects.equal(this.id, that.id)
				&& Objects.equal(this.account, that.account)
				&& Objects.equal(this.created, that.created)
				&& Objects.equal(this.domain, that.domain)
				&& Objects.equal(this.domainId, that.domainId)
				&& Objects.equal(this.description, that.description)
				&& Objects.equal(this.displayName, that.displayName)
				&& Objects.equal(this.parent, that.parent)
				&& Objects.equal(this.name, that.name)
				&& Objects.equal(this.type, that.type)
				&& Objects.equal(this.state, that.state)
				&& Objects.equal(this.parentName, that.parentName)
				&& Objects.equal(this.virtualMachineId, that.virtualMachineId)
				&& Objects.equal(this.zoneId, that.zoneId)
				&& Objects.equal(this.project, that.project)
				&& Objects.equal(this.projectId, that.projectId);
	}

	protected ToStringHelper string() {
		return Objects.toStringHelper(this).add("id", id)
				.add("account", account).add("created", created)
				.add("domain", domain).add("domainId", domainId)
				.add("description", description)
				.add("displayName", displayName).add("parent", parent)
				.add("name", name).add("snapshotType", type)
				.add("state", state).add("parentName", parentName)
				.add("virtualMachineId", virtualMachineId)
				.add("zoneId", zoneId).add("project", project)
				.add("projectId", projectId);
	}

	@Override
	public String toString() {
		return string().toString();
	}

}
