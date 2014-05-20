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
import java.util.Map;

import org.jclouds.javax.annotation.Nullable;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;

/**
 * Represents a usage record from CloudStack
 *
 * @author Richard Downer
 * @author liwei
 */
public class UsageRecord {

	/**
    */
	public static enum UsageType {
		RUNNING_VM(1), ALLOCATED_VM(2), IP_ADDRESS(3), NETWORK_BYTES_SENT(4), NETWORK_BYTES_RECEIVED(
				5), VOLUME(6), TEMPLATE(7), ISO(8), SNAPSHOT(9), SECURITY_GROUP(
				10), LOAD_BALANCER_POLICY(11), PORT_FORWARDING_RULE(12), NETWORK_OFFERING(
				13), VPN_USERS(14), UNRECOGNIZED(0);

		private int code;

		private static final Map<Integer, UsageType> INDEX = Maps.uniqueIndex(
				ImmutableSet.copyOf(UsageType.values()),
				new Function<UsageType, Integer>() {

					@Override
					public Integer apply(UsageType input) {
						return input.code;
					}

				});

		UsageType(int code) {
			this.code = code;
		}

		@Override
		public String toString() {
			return "" + code;
		}

		public static UsageType fromValue(String usageType) {
			Integer code = Integer
					.valueOf(checkNotNull(usageType, "usageType"));
			return INDEX.containsKey(code) ? INDEX.get(code) : UNRECOGNIZED;
		}

	}

	public static Builder<?> builder() {
		return new ConcreteBuilder();
	}

	public Builder<?> toBuilder() {
		return new ConcreteBuilder().fromUsageRecord(this);
	}

	public abstract static class Builder<T extends Builder<T>> {
		protected abstract T self();

		protected String id;
		protected String description;
		protected String accountId;
		protected String accountName;
		protected String domainId;
		protected Date startDate;
		protected Date endDate;
		protected Date assignDate;
		protected String releaseDate;
		protected String zoneId;
		protected String virtualMachineId;
		protected String virtualMachineName;
		protected String serviceOfferingId;
		protected String templateId;
		protected String ipAddress;
		protected boolean isSourceNAT;
		protected double rawUsageHours;
		protected String usage;
		protected String type;
		protected UsageType usageType;

		protected String domain;
		protected boolean isDefault;
		protected boolean isSystem;
		protected String name;
		protected String networkId;
		protected String project;
		protected String projectId;
		protected long size;
		protected long virtualSize;

		/**
		 * @see UsageRecord#getId()
		 */
		public T id(String id) {
			this.id = id;
			return self();
		}

		/**
		 * @see UsageRecord#getDescription()
		 */
		public T description(String description) {
			this.description = description;
			return self();
		}

		/**
		 * @see UsageRecord#getAccountId()
		 */
		public T accountId(String accountId) {
			this.accountId = accountId;
			return self();
		}

		/**
		 * @see UsageRecord#getAccountName()
		 */
		public T accountName(String accountName) {
			this.accountName = accountName;
			return self();
		}

		/**
		 * @see UsageRecord#getDomainId()
		 */
		public T domainId(String domainId) {
			this.domainId = domainId;
			return self();
		}

		/**
		 * @see UsageRecord#getStartDate()
		 */
		public T startDate(Date startDate) {
			this.startDate = startDate;
			return self();
		}

		/**
		 * @see UsageRecord#getEndDate()
		 */
		public T endDate(Date endDate) {
			this.endDate = endDate;
			return self();
		}

		/**
		 * @see UsageRecord#getAssignDate()
		 */
		public T assignDate(Date assignDate) {
			this.assignDate = assignDate;
			return self();
		}

		/**
		 * @see UsageRecord#getReleaseDate()
		 */
		public T releaseDate(String releaseDate) {
			this.releaseDate = releaseDate;
			return self();
		}

		/**
		 * @see UsageRecord#getZoneId()
		 */
		public T zoneId(String zoneId) {
			this.zoneId = zoneId;
			return self();
		}

		/**
		 * @see UsageRecord#getVirtualMachineId()
		 */
		public T virtualMachineId(String virtualMachineId) {
			this.virtualMachineId = virtualMachineId;
			return self();
		}

		/**
		 * @see UsageRecord#getVirtualMachineName()
		 */
		public T virtualMachineName(String virtualMachineName) {
			this.virtualMachineName = virtualMachineName;
			return self();
		}

		/**
		 * @see UsageRecord#getServiceOfferingId()
		 */
		public T serviceOfferingId(String serviceOfferingId) {
			this.serviceOfferingId = serviceOfferingId;
			return self();
		}

		/**
		 * @see UsageRecord#getTemplateId()
		 */
		public T templateId(String templateId) {
			this.templateId = templateId;
			return self();
		}

		/**
		 * @see UsageRecord#getIpAddress()
		 */
		public T ipAddress(String ipAddress) {
			this.ipAddress = ipAddress;
			return self();
		}

		/**
		 * @see UsageRecord#isSourceNAT()
		 */
		public T isSourceNAT(boolean isSourceNAT) {
			this.isSourceNAT = isSourceNAT;
			return self();
		}

		/**
		 * @see UsageRecord#getRawUsageHours()
		 */
		public T rawUsageHours(double rawUsageHours) {
			this.rawUsageHours = rawUsageHours;
			return self();
		}

		/**
		 * @see UsageRecord#getUsage()
		 */
		public T usage(String usage) {
			this.usage = usage;
			return self();
		}

		/**
		 * @see UsageRecord#getType()
		 */
		public T type(String type) {
			this.type = type;
			return self();
		}

		/**
		 * @see UsageRecord#getUsageType()
		 */
		public T usageType(UsageType usageType) {
			this.usageType = usageType;
			return self();
		}

		public T domain(String domain) {
			this.domain = domain;
			return self();
		}

		public T isDefault(boolean isDefault) {
			this.isDefault = isDefault;
			return self();
		}

		public T isSystem(boolean isSystem) {
			this.isSystem = isSystem;
			return self();
		}

		public T name(String name) {
			this.name = name;
			return self();
		}

		public T networkId(String networkId) {
			this.networkId = networkId;
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

		public T size(long size) {
			this.size = size;
			return self();
		}

		public T virtualSize(long virtualSize) {
			this.virtualSize = virtualSize;
			return self();
		}

		public UsageRecord build() {
			return new UsageRecord(id, description, accountId, accountName,
					domainId, startDate, endDate, assignDate, releaseDate,
					zoneId, virtualMachineId, virtualMachineName,
					serviceOfferingId, templateId, ipAddress, isSourceNAT,
					rawUsageHours, usage, type, usageType, domain, isDefault,
					isSystem, name, networkId, project, projectId, size,
					virtualSize);
		}

		public T fromUsageRecord(UsageRecord in) {
			return this.id(in.getId()).description(in.getDescription())
					.accountId(in.getAccountId())
					.accountName(in.getAccountName())
					.domainId(in.getDomainId()).startDate(in.getStartDate())
					.endDate(in.getEndDate()).assignDate(in.getAssignDate())
					.releaseDate(in.getReleaseDate()).zoneId(in.getZoneId())
					.virtualMachineId(in.getVirtualMachineId())
					.virtualMachineName(in.getVirtualMachineName())
					.serviceOfferingId(in.getServiceOfferingId())
					.templateId(in.getTemplateId())
					.ipAddress(in.getIpAddress()).isSourceNAT(in.isSourceNAT())
					.rawUsageHours(in.getRawUsageHours()).usage(in.getUsage())
					.type(in.getType()).usageType(in.getUsageType())
					.domain(in.getDomain()).isDefault(in.isDefault())
					.type(in.getType()).usageType(in.getUsageType())
					.isSystem(in.isSystem()).name(in.getName())
					.networkId(in.getNetworkId()).project(in.getProject())
					.projectId(in.getProjectId()).size(in.getSize())
					.virtualSize(in.getVirtualSize());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	private final String id;
	private final String description;
	private final String accountId;
	private final String accountName;
	private final String domainId;
	private final Date startDate;
	private final Date endDate;
	private final Date assignDate;
	private final String releaseDate;
	private final String zoneId;
	private final String virtualMachineId;
	private final String virtualMachineName;
	private final String serviceOfferingId;
	private final String templateId;
	private final String ipAddress;
	private final boolean isSourceNAT;
	private final double rawUsageHours;
	private final String usage;
	private final String type;
	private final UsageType usageType;

	private final String domain;
	private final boolean isDefault;
	private final boolean isSystem;
	private final String name;
	private final String networkId;
	private final String project;
	private final String projectId;
	private final long size;
	private final long virtualSize;

	@ConstructorProperties({ "usageid", "description", "accountid", "account",
			"domainid", "startdate", "enddate", "assigndate", "releasedate",
			"zoneid", "virtualmachineid", "name", "offeringid", "templateid",
			"ipaddress", "issourcenat", "rawusage", "usage", "type",
			"usagetype", "domain", "isdefault", "issystem", "name",
			"networkid", "project", "projectid", "size", "virtualsize" })
	protected UsageRecord(String id, @Nullable String description,
			@Nullable String accountId, @Nullable String accountName,
			@Nullable String domainId, @Nullable Date startDate,
			@Nullable Date endDate, @Nullable Date assignDate,
			@Nullable String releaseDate, @Nullable String zoneId,
			@Nullable String virtualMachineId,
			@Nullable String virtualMachineName,
			@Nullable String serviceOfferingId, @Nullable String templateId,
			@Nullable String ipAddress, boolean isSourceNAT,
			double rawUsageHours, @Nullable String usage,
			@Nullable String type, @Nullable UsageType usageType,
			@Nullable String domain, boolean isDefault, boolean isSystem,
			@Nullable String name, @Nullable String networkId,
			@Nullable String project, @Nullable String projectId, long size,
			long virtualSize) {
		this.id = id;
		this.description = description;
		this.accountId = accountId;
		this.accountName = accountName;
		this.domainId = domainId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.assignDate = assignDate;
		this.releaseDate = releaseDate;
		this.zoneId = zoneId;
		this.virtualMachineId = virtualMachineId;
		this.virtualMachineName = virtualMachineName;
		this.serviceOfferingId = serviceOfferingId;
		this.templateId = templateId;
		this.ipAddress = ipAddress;
		this.isSourceNAT = isSourceNAT;
		this.rawUsageHours = rawUsageHours;
		this.usage = usage;
		this.type = type;
		this.usageType = usageType;
		this.domain = domain;
		this.isDefault = isDefault;
		this.isSystem = isSystem;
		this.name = name;
		this.networkId = networkId;
		this.project = project;
		this.projectId = projectId;
		this.size = size;
		this.virtualSize = virtualSize;
	}

	public String getId() {
		return this.id;
	}

	@Nullable
	public String getDescription() {
		return this.description;
	}

	@Nullable
	public String getAccountId() {
		return this.accountId;
	}

	@Nullable
	public String getAccountName() {
		return this.accountName;
	}

	@Nullable
	public String getDomainId() {
		return this.domainId;
	}

	@Nullable
	public Date getStartDate() {
		return this.startDate;
	}

	@Nullable
	public Date getEndDate() {
		return this.endDate;
	}

	@Nullable
	public Date getAssignDate() {
		return this.assignDate;
	}

	@Nullable
	public String getReleaseDate() {
		return this.releaseDate;
	}

	@Nullable
	public String getZoneId() {
		return this.zoneId;
	}

	@Nullable
	public String getVirtualMachineId() {
		return this.virtualMachineId;
	}

	@Nullable
	public String getVirtualMachineName() {
		return this.virtualMachineName;
	}

	@Nullable
	public String getServiceOfferingId() {
		return this.serviceOfferingId;
	}

	@Nullable
	public String getTemplateId() {
		return this.templateId;
	}

	@Nullable
	public String getIpAddress() {
		return this.ipAddress;
	}

	public boolean isSourceNAT() {
		return this.isSourceNAT;
	}

	public double getRawUsageHours() {
		return this.rawUsageHours;
	}

	@Nullable
	public String getUsage() {
		return this.usage;
	}

	@Nullable
	public String getType() {
		return this.type;
	}

	@Nullable
	public UsageType getUsageType() {
		return this.usageType;
	}

	/**
	 * @return the domain the resource is associated with
	 */
	@Nullable
	public String getDomain() {
		return domain;
	}

	/**
	 * @return True if the resource is default
	 */
	public boolean isDefault() {
		return isDefault;
	}

	/**
	 * @return True if the IPAddress is system IP - allocated during vm deploy
	 *         or lb rule create
	 */
	public boolean isSystem() {
		return isSystem;
	}

	/**
	 * @return virtual machine name
	 */
	@Nullable
	public String getName() {
		return name;
	}

	/**
	 * @return id of the network
	 */
	@Nullable
	public String getNetworkId() {
		return networkId;
	}

	/**
	 * @return the project name of the resource
	 */
	@Nullable
	public String getProject() {
		return project;
	}

	/**
	 * @return the project id of the resource
	 */
	@Nullable
	public String getProjectId() {
		return projectId;
	}

	/**
	 * @return resource size
	 */
	public long getSize() {
		return size;
	}

	/**
	 * @return virtual size of resource
	 */
	public long getVirtualSize() {
		return virtualSize;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id, description, accountId, accountName,
				domainId, startDate, endDate, assignDate, releaseDate, zoneId,
				virtualMachineId, virtualMachineName, serviceOfferingId,
				templateId, ipAddress, isSourceNAT, rawUsageHours, usage, type,
				usageType, domain, isDefault, isSystem, name, networkId,
				project, projectId, size, virtualSize);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		UsageRecord that = UsageRecord.class.cast(obj);
		return Objects.equal(this.id, that.id)
				&& Objects.equal(this.description, that.description)
				&& Objects.equal(this.accountId, that.accountId)
				&& Objects.equal(this.accountName, that.accountName)
				&& Objects.equal(this.domainId, that.domainId)
				&& Objects.equal(this.startDate, that.startDate)
				&& Objects.equal(this.endDate, that.endDate)
				&& Objects.equal(this.assignDate, that.assignDate)
				&& Objects.equal(this.releaseDate, that.releaseDate)
				&& Objects.equal(this.zoneId, that.zoneId)
				&& Objects.equal(this.virtualMachineId, that.virtualMachineId)
				&& Objects.equal(this.virtualMachineName,
						that.virtualMachineName)
				&& Objects
						.equal(this.serviceOfferingId, that.serviceOfferingId)
				&& Objects.equal(this.templateId, that.templateId)
				&& Objects.equal(this.ipAddress, that.ipAddress)
				&& Objects.equal(this.isSourceNAT, that.isSourceNAT)
				&& Objects.equal(this.rawUsageHours, that.rawUsageHours)
				&& Objects.equal(this.usage, that.usage)
				&& Objects.equal(this.type, that.type)
				&& Objects.equal(this.usageType, that.usageType)
				&& Objects.equal(this.domain, that.domain)
				&& Objects.equal(this.isDefault, that.isDefault)
				&& Objects.equal(this.isSystem, that.isSystem)
				&& Objects.equal(this.name, that.name)
				&& Objects.equal(this.networkId, that.networkId)
				&& Objects.equal(this.project, that.project)
				&& Objects.equal(this.projectId, that.projectId)
				&& Objects.equal(this.size, that.size)
				&& Objects.equal(this.virtualSize, that.virtualSize);
	}

	protected ToStringHelper string() {
		return Objects.toStringHelper(this).add("id", id)
				.add("description", description).add("accountId", accountId)
				.add("accountName", accountName).add("domainId", domainId)
				.add("startDate", startDate).add("endDate", endDate)
				.add("assignDate", assignDate).add("releaseDate", releaseDate)
				.add("zoneId", zoneId)
				.add("virtualMachineId", virtualMachineId)
				.add("virtualMachineName", virtualMachineName)
				.add("serviceOfferingId", serviceOfferingId)
				.add("templateId", templateId).add("ipAddress", ipAddress)
				.add("isSourceNAT", isSourceNAT)
				.add("rawUsageHours", rawUsageHours).add("usage", usage)
				.add("type", type).add("usageType", usageType)
				.add("domain", domain).add("isDefault", isDefault)
				.add("isSystem", isSystem).add("name", name)
				.add("networkId", networkId).add("project", project)
				.add("projectId", projectId).add("size", size)
				.add("virtualSize", virtualSize);
	}

	@Override
	public String toString() {
		return string().toString();
	}

}
