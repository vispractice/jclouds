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
import java.util.Map;
import java.util.Set;

import org.jclouds.javax.annotation.Nullable;

import com.google.common.base.CaseFormat;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;

/**
 * Class Account
 *
 * @author Adrian Cole
 */
public class Account extends ForwardingSet<User> {

	/**
    */
	public static enum State {
		ENABLED, DISABLED, LOCKED, UNRECOGNIZED;

		@Override
		public String toString() {
			return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_HYPHEN,
					name());
		}

		public static State fromValue(String state) {
			try {
				return valueOf(CaseFormat.LOWER_HYPHEN.to(
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
		/**
		 * API access for all the resources associated with their account. There
		 * may be many users in a domain, many domains in a deployment, and many
		 * users in a deployment. This is typically the end user
		 */
		USER(0),
		/**
		 * full API access. This is typically a service administrator or code
		 * that executes with complete trust in the service operator's
		 * environment.
		 */
		ADMIN(1),
		/**
		 * full API access within a domain. This is the most privileged user
		 * that a given customer has. This may be a reseller for the service
		 * provider.
		 */
		DOMAIN_ADMIN(2), UNRECOGNIZED(Integer.MAX_VALUE);

		private int code;

		private static final Map<Integer, Type> INDEX = Maps.uniqueIndex(
				ImmutableSet.copyOf(Type.values()),
				new Function<Type, Integer>() {

					@Override
					public Integer apply(Type input) {
						return input.code;
					}

				});

		Type(int code) {
			this.code = code;
		}

		@Override
		public String toString() {
			return "" + code;
		}

		public static Type fromValue(String type) {
			Integer code = Integer.valueOf(checkNotNull(type, "type"));
			return INDEX.containsKey(code) ? INDEX.get(code) : UNRECOGNIZED;
		}

	}

	public static Builder<?> builder() {
		return new ConcreteBuilder();
	}

	public Builder<?> toBuilder() {
		return new ConcreteBuilder().fromAccount(this);
	}

	public abstract static class Builder<T extends Builder<T>> {
		protected abstract T self();

		protected String id;
		protected String name;

		protected Long cpuAvailable;
		protected Long cpuLimit;
		protected long cpuTotal;

		protected String domain;
		protected String domainId;

		protected Long ipAvailable;
		protected Long ipLimit;
		protected long ipTotal;

		protected boolean isDefault;

		protected Long memoryAvailable;
		protected Long memoryLimit;
		protected long memoryTotal;

		protected Long networkAvailable;
		protected Long networkLimit;
		protected long networkTotal;

		protected Long primaryStorageAvailable;
		protected Long primaryStorageLimit;
		protected long primaryStorageTotal;

		protected Long projectAvailable;
		protected Long projectLimit;
		protected long projectTotal;

		protected Long secondaryStorageAvailable;
		protected Long secondaryStorageLimit;
		protected long secondaryStorageTotal;

		protected Long snapshotAvailable;
		protected Long snapshotLimit;
		protected long snapshotTotal;

		protected Account.State state;

		protected Long templateAvailable;
		protected Long templateLimit;
		protected long templateTotal;

		protected Long vmAvailable;
		protected Long vmLimit;
		protected long vmTotal;

		protected Long volumeAvailable;
		protected Long volumeLimit;
		protected long volumeTotal;

		protected Long vpcAvailable;
		protected Long vpcLimit;
		protected long vpcTotal;

		protected long receivedBytes;
		protected long sentBytes;

		protected Account.Type type;

		protected Set<User> users = ImmutableSet.of();

		public T id(String id) {
			this.id = id;
			return self();
		}

		public T name(String name) {
			this.name = name;
			return self();
		}

		public T cpuAvailable(Long cpuAvailable) {
			this.cpuAvailable = cpuAvailable;
			return self();
		}

		public T cpuLimit(Long cpuLimit) {
			this.cpuLimit = cpuLimit;
			return self();
		}

		public T cpuTotal(long cpuTotal) {
			this.cpuTotal = cpuTotal;
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

		public T ipAvailable(Long ipAvailable) {
			this.ipAvailable = ipAvailable;
			return self();
		}

		public T ipLimit(Long ipLimit) {
			this.ipLimit = ipLimit;
			return self();
		}

		public T ipTotal(long ipTotal) {
			this.ipTotal = ipTotal;
			return self();
		}

		public T isDefault(boolean isDefault) {
			this.isDefault = isDefault;
			return self();
		}

		public T memoryAvailable(Long memoryAvailable) {
			this.memoryAvailable = memoryAvailable;
			return self();
		}

		public T memoryLimit(Long memoryLimit) {
			this.memoryLimit = memoryLimit;
			return self();
		}

		public T memoryTotal(long memoryTotal) {
			this.memoryTotal = memoryTotal;
			return self();
		}

		public T networkAvailable(Long networkAvailable) {
			this.networkAvailable = networkAvailable;
			return self();
		}

		public T networkLimit(Long networkLimit) {
			this.networkLimit = networkLimit;
			return self();
		}

		public T networkTotal(long networkTotal) {
			this.networkTotal = networkTotal;
			return self();
		}

		public T primaryStorageAvailable(Long primaryStorageAvailable) {
			this.primaryStorageAvailable = primaryStorageAvailable;
			return self();
		}

		public T primaryStorageLimit(Long primaryStorageLimit) {
			this.primaryStorageLimit = primaryStorageLimit;
			return self();
		}

		public T primaryStorageTotal(long primaryStorageTotal) {
			this.primaryStorageTotal = primaryStorageTotal;
			return self();
		}

		public T projectAvailable(Long projectAvailable) {
			this.projectAvailable = projectAvailable;
			return self();
		}

		public T projectLimit(Long projectLimit) {
			this.projectLimit = projectLimit;
			return self();
		}

		public T projectTotal(long projectTotal) {
			this.projectTotal = projectTotal;
			return self();
		}

		public T secondaryStorageAvailable(Long secondaryStorageAvailable) {
			this.secondaryStorageAvailable = secondaryStorageAvailable;
			return self();
		}

		public T secondaryStorageLimit(Long secondaryStorageLimit) {
			this.secondaryStorageLimit = secondaryStorageLimit;
			return self();
		}

		public T secondaryStorageTotal(long secondaryStorageTotal) {
			this.secondaryStorageTotal = secondaryStorageTotal;
			return self();
		}

		public T snapshotAvailable(Long snapshotAvailable) {
			this.snapshotAvailable = snapshotAvailable;
			return self();
		}

		public T snapshotLimit(Long snapshotLimit) {
			this.snapshotLimit = snapshotLimit;
			return self();
		}

		public T snapshotTotal(long snapshotTotal) {
			this.snapshotTotal = snapshotTotal;
			return self();
		}

		public T state(Account.State state) {
			this.state = state;
			return self();
		}

		public T templateAvailable(Long templateAvailable) {
			this.templateAvailable = templateAvailable;
			return self();
		}

		public T templateLimit(Long templateLimit) {
			this.templateLimit = templateLimit;
			return self();
		}

		public T templateTotal(long templateTotal) {
			this.templateTotal = templateTotal;
			return self();
		}

		public T vmAvailable(Long vmAvailable) {
			this.vmAvailable = vmAvailable;
			return self();
		}

		public T vmLimit(Long vmLimit) {
			this.vmLimit = vmLimit;
			return self();
		}

		public T vmTotal(long vmTotal) {
			this.vmTotal = vmTotal;
			return self();
		}

		public T volumeAvailable(Long volumeAvailable) {
			this.volumeAvailable = volumeAvailable;
			return self();
		}

		public T volumeLimit(Long volumeLimit) {
			this.volumeLimit = volumeLimit;
			return self();
		}

		public T volumeTotal(long volumeTotal) {
			this.volumeTotal = volumeTotal;
			return self();
		}

		public T vpcAvailable(Long vpcAvailable) {
			this.vpcAvailable = vpcAvailable;
			return self();
		}

		public T vpcLimit(Long vpcLimit) {
			this.vpcLimit = vpcLimit;
			return self();
		}

		public T vpcTotal(long vpcTotal) {
			this.vpcTotal = vpcTotal;
			return self();
		}

		public T type(Account.Type type) {
			this.type = type;
			return self();
		}

		public T users(Set<User> users) {
			this.users = ImmutableSet.copyOf(checkNotNull(users, "users"));
			return self();
		}

		public T receivedBytes(long receivedBytes) {
			this.receivedBytes = receivedBytes;
			return self();
		}

		public T sentBytes(long sentBytes) {
			this.sentBytes = sentBytes;
			return self();
		}

		public T users(User... in) {
			return users(ImmutableSet.copyOf(in));
		}

		public Account build() {
			return new Account(id, name, cpuAvailable, cpuLimit, cpuTotal,
					domain, domainId, ipAvailable, ipLimit, ipTotal, isDefault,
					memoryAvailable, memoryLimit, memoryTotal,
					networkAvailable, networkLimit, networkTotal,
					primaryStorageAvailable, primaryStorageLimit,
					primaryStorageTotal, projectAvailable, projectLimit,
					projectTotal, secondaryStorageAvailable,
					secondaryStorageLimit, secondaryStorageTotal,
					snapshotAvailable, snapshotLimit, snapshotTotal, state,
					templateAvailable, templateLimit, templateTotal,
					vmAvailable, vmLimit, vmTotal, volumeAvailable,
					volumeLimit, volumeTotal, vpcAvailable, vpcLimit, vpcTotal,
					sentBytes, receivedBytes, type, users);
		}

		public T fromAccount(Account in) {
			return this
					.id(in.getId())
					.name(in.getName())
					.cpuAvailable(in.getCpuAvailable())
					.cpuLimit(in.getCpuLimit())
					.cpuTotal(in.getCpuTotal())
					.domain(in.getDomain())
					.domainId(in.getDomainId())
					.ipAvailable(in.getIpAvailable())
					.ipLimit(in.getIpLimit())
					.ipTotal(in.getIpTotal())
					.isDefault(in.isDefault())
					.memoryAvailable(in.getMemoryAvailable())
					.memoryLimit(in.getMemoryLimit())
					.memoryTotal(in.getMemoryTotal())
					.networkAvailable(in.getNetworkAvailable())
					.networkLimit(in.getNetworkLimit())
					.networkTotal(in.getNetworkTotal())
					.primaryStorageAvailable(in.getPrimaryStorageAvailable())
					.primaryStorageLimit(in.getPrimaryStorageLimit())
					.primaryStorageTotal(in.getPrimaryStorageTotal())
					.projectAvailable(in.getProjectAvailable())
					.projectLimit(in.getProjectLimit())
					.projectTotal(in.getProjectTotal())
					.secondaryStorageAvailable(
							in.getSecondaryStorageAvailable())
					.secondaryStorageLimit(in.getSecondaryStorageLimit())
					.secondaryStorageTotal(in.getSecondaryStorageTotal())
					.snapshotAvailable(in.getSnapshotAvailable())
					.snapshotLimit(in.getSnapshotLimit())
					.snapshotTotal(in.getSnapshotTotal()).state(in.getState())
					.templateAvailable(in.getTemplateAvailable())
					.templateLimit(in.getTemplateLimit())
					.templateTotal(in.getTemplateTotal())
					.vmAvailable(in.getVmAvailable()).vmLimit(in.getVmLimit())
					.vmTotal(in.getVmTotal())
					.volumeAvailable(in.getVolumeAvailable())
					.volumeLimit(in.getVolumeLimit())
					.volumeTotal(in.getVolumeTotal())
					.vpcAvailable(in.getVpcAvailable())
					.vpcLimit(in.getVpcLimit()).vpcTotal(in.getVpcTotal())
					.sentBytes(in.getSentBytes())
					.receivedBytes(in.getReceivedBytes()).type(in.getType())
					.users(in.getUsers());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	private final String id;
	private final String name;

	private final Long cpuAvailable;
	private final Long cpuLimit;
	private final long cpuTotal;

	private final String domain;
	private final String domainId;

	private final Long ipAvailable;
	private final Long ipLimit;
	private final long ipTotal;

	private final boolean isDefault;

	private final Long memoryAvailable;
	private final Long memoryLimit;
	private final long memoryTotal;

	private final Long networkAvailable;
	private final Long networkLimit;
	private final long networkTotal;

	private final Long primaryStorageAvailable;
	private final Long primaryStorageLimit;
	private final long primaryStorageTotal;

	private final Long projectAvailable;
	private final Long projectLimit;
	private final long projectTotal;

	private final Long secondaryStorageAvailable;
	private final Long secondaryStorageLimit;
	private final long secondaryStorageTotal;

	private final Long snapshotAvailable;
	private final Long snapshotLimit;
	private final long snapshotTotal;

	private final Account.State state;

	private final Long templateAvailable;
	private final Long templateLimit;
	private final long templateTotal;

	private final Long vmAvailable;
	private final Long vmLimit;
	private final long vmTotal;

	private final Long volumeAvailable;
	private final Long volumeLimit;
	private final long volumeTotal;

	private final Long vpcAvailable;
	private final Long vpcLimit;
	private final long vpcTotal;

	private final long receivedBytes;
	private final long sentBytes;

	private final Account.Type type;

	private final Set<User> users;

	@ConstructorProperties({ "id", "name", "cpuavailable", "cpulimit",
			"cputotal", "domain", "domainid", "ipavailable", "iplimit",
			"iptotal", "isdefault", "memoryavailable", "memorylimit",
			"memorytotal", "networkavailable", "networklimit", "networktotal",
			"primarystorageavailable", "primaryStoragelimit",
			"primarystoragetotal", "projectavailable", "projectlimit",
			"projecttotal", "secondarystorageavailable",
			"secondarystoragelimit", "secondarystoragetotal",
			"snapshotavailable", "snapshotlimit", "snapshottotal", "state",
			"templateavailable", "templatelimit", "templatetotal",
			"vmavailable", "vmlimit", "vmtotal", "volumeavailable",
			"volumelimit", "volumetotal", "vpcavailable", "vpclimit",
			"vpctotal", "receivedBytes", "sentBytes", "accounttype", "user" })
	private Account(String id, @Nullable String name,
			@Nullable String cpuAvailable, @Nullable String cpuLimit,
			long cpuTotal, @Nullable String domain, @Nullable String domainId,
			@Nullable String ipAvailable, @Nullable String ipLimit,
			long ipTotal, boolean isDefault, @Nullable String memoryAvailable,
			@Nullable String memoryLimit, long memoryTotal,
			@Nullable String networkAvailable, @Nullable String networkLimit,
			long networkTotal, @Nullable String primaryStorageAvailable,
			@Nullable String primaryStorageLimit, long primaryStorageTotal,
			@Nullable String projectAvailable, @Nullable String projectLimit,
			long projectTotal, @Nullable String secondaryStorageAvailable,
			@Nullable String secondaryStorageLimit, long secondaryStorageTotal,
			@Nullable String snapshotAvailable, @Nullable String snapshotLimit,
			long snapshotTotal, State state,
			@Nullable String templateAvailable, @Nullable String templateLimit,
			long templateTotal, @Nullable String vmAvailable,
			@Nullable String vmLimit, long vmTotal,
			@Nullable String volumeAvailable, @Nullable String volumeLimit,
			long volumeTotal, @Nullable String vpcAvailable,
			@Nullable String vpcLimit, long vpcTotal, long receivedBytes, 
			long sentBytes,Type type, Set<User> users) {
		this(id, name, toLongNullIfUnlimited(cpuAvailable),
				toLongNullIfUnlimited(cpuLimit), cpuTotal, domain, domainId,
				toLongNullIfUnlimited(ipAvailable),
				toLongNullIfUnlimited(ipLimit), ipTotal, isDefault,
				toLongNullIfUnlimited(memoryAvailable),
				toLongNullIfUnlimited(memoryLimit), memoryTotal,
				toLongNullIfUnlimited(networkAvailable),
				toLongNullIfUnlimited(networkLimit), networkTotal,
				toLongNullIfUnlimited(primaryStorageAvailable),
				toLongNullIfUnlimited(primaryStorageLimit),
				primaryStorageTotal, toLongNullIfUnlimited(projectAvailable),
				toLongNullIfUnlimited(projectLimit), projectTotal,
				toLongNullIfUnlimited(secondaryStorageAvailable),
				toLongNullIfUnlimited(secondaryStorageLimit),
				secondaryStorageTotal,
				toLongNullIfUnlimited(snapshotAvailable),
				toLongNullIfUnlimited(snapshotLimit), snapshotTotal, state,
				toLongNullIfUnlimited(templateAvailable),
				toLongNullIfUnlimited(templateLimit), templateTotal,
				toLongNullIfUnlimited(vmAvailable),
				toLongNullIfUnlimited(vmLimit), vmTotal,
				toLongNullIfUnlimited(volumeAvailable),
				toLongNullIfUnlimited(volumeLimit), volumeTotal,
				toLongNullIfUnlimited(vpcAvailable),
				toLongNullIfUnlimited(vpcLimit), vpcTotal, 
				receivedBytes, sentBytes, type, users);
	}

	private static Long toLongNullIfUnlimited(String in) {
		return in == null || "Unlimited".equals(in) ? null : Long.valueOf(in);
	}

	protected Account(String id, @Nullable String name,
			@Nullable Long cpuAvailable, @Nullable Long cpuLimit,
			long cpuTotal, @Nullable String domain, @Nullable String domainId,
			@Nullable Long ipAvailable, @Nullable Long ipLimit, long ipTotal,
			boolean isDefault, @Nullable Long memoryAvailable,
			@Nullable Long memoryLimit, long memoryTotal,
			@Nullable Long networkAvailable, @Nullable Long networkLimit,
			long networkTotal, @Nullable Long primaryStorageAvailable,
			@Nullable Long primaryStorageLimit, long primaryStorageTotal,
			@Nullable Long projectAvailable, @Nullable Long projectLimit,
			long projectTotal, @Nullable Long secondaryStorageAvailable,
			@Nullable Long secondaryStorageLimit, long secondaryStorageTotal,
			@Nullable Long snapshotAvailable, @Nullable Long snapshotLimit,
			long snapshotTotal, Account.State state,
			@Nullable Long templateAvailable, @Nullable Long templateLimit,
			long templateTotal, @Nullable Long vmAvailable,
			@Nullable Long vmLimit, long vmTotal,
			@Nullable Long volumeAvailable, @Nullable Long volumeLimit,
			long volumeTotal, @Nullable Long vpcAvailable,
			@Nullable Long vpcLimit, long vpcTotal, long receivedBytes,
			long sentBytes, Account.Type type, Set<User> users) {
		super();
		this.id = checkNotNull(id, "id");
		this.name = name;
		this.cpuAvailable = cpuAvailable;
		this.cpuLimit = cpuLimit;
		this.cpuTotal = cpuTotal;
		this.domain = domain;
		this.domainId = domainId;
		this.ipAvailable = ipAvailable;
		this.ipLimit = ipLimit;
		this.ipTotal = ipTotal;
		this.isDefault = isDefault;
		this.memoryAvailable = memoryAvailable;
		this.memoryLimit = memoryLimit;
		this.memoryTotal = memoryTotal;
		this.networkAvailable = networkAvailable;
		this.networkLimit = networkLimit;
		this.networkTotal = networkTotal;
		this.primaryStorageAvailable = primaryStorageAvailable;
		this.primaryStorageLimit = primaryStorageLimit;
		this.primaryStorageTotal = primaryStorageTotal;
		this.projectAvailable = projectAvailable;
		this.projectLimit = projectLimit;
		this.projectTotal = projectTotal;
		this.secondaryStorageAvailable = secondaryStorageAvailable;
		this.secondaryStorageLimit = secondaryStorageLimit;
		this.secondaryStorageTotal = secondaryStorageTotal;
		this.snapshotAvailable = snapshotAvailable;
		this.snapshotLimit = snapshotLimit;
		this.snapshotTotal = snapshotTotal;
		this.state = state;
		this.templateAvailable = templateAvailable;
		this.templateLimit = templateLimit;
		this.templateTotal = templateTotal;
		this.vmAvailable = vmAvailable;
		this.vmLimit = vmLimit;
		this.vmTotal = vmTotal;
		this.volumeAvailable = volumeAvailable;
		this.volumeLimit = volumeLimit;
		this.volumeTotal = volumeTotal;
		this.vpcAvailable = vpcAvailable;
		this.vpcLimit = vpcLimit;
		this.vpcTotal = vpcTotal;
		this.receivedBytes = receivedBytes;
		this.sentBytes = sentBytes;
		this.type = type;
		this.users = users == null ? ImmutableSet.<User> of() : ImmutableSet
				.copyOf(users);
	}

	/**
	 * @return the id of the account
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @return account type (admin, domain-admin, user)
	 */
	@Nullable
	public Account.Type getType() {
		return this.type;
	}

	/**
	 * @return name of the Domain the account belongs to
	 */
	@Nullable
	public String getDomain() {
		return this.domain;
	}

	/**
	 * @return id of the Domain the account belongs to
	 */
	@Nullable
	public String getDomainId() {
		return this.domainId;
	}

	/**
	 * @return the name of the account
	 */
	@Nullable
	public String getName() {
		return this.name;
	}

	/**
	 * @return the total number of snapshots which can be stored by this
	 *         account, or null if unlimited
	 */
	@Nullable
	public Long getSnapshotLimit() {
		return this.snapshotLimit;
	}

	/**
	 * @return the state of the account
	 */
	@Nullable
	public State getState() {
		return this.state;
	}

	/**
	 * @return the total number of templates which can be created by this
	 *         account, or null if unlimited
	 */
	@Nullable
	public Long getTemplateLimit() {
		return this.templateLimit;
	}

	/**
	 * @return the total volume which can be used by this account, or null if
	 *         unlimited
	 */
	@Nullable
	public Long getVolumeLimit() {
		return this.volumeLimit;
	}

	/**
	 * @return the list of users associated with account
	 */
	public Set<User> getUsers() {
		return this.users;
	}

	/**
	 * @return the total number of cpu cores available to be created for this
	 *         account
	 */
	public Long getCpuAvailable() {
		return cpuAvailable;
	}

	/**
	 * @return the total number of cpu cores the account can own
	 */
	public Long getCpuLimit() {
		return cpuLimit;
	}

	/**
	 * @return the total number of cpu cores owned by account
	 */
	public long getCpuTotal() {
		return cpuTotal;
	}

	/**
	 * @return the total number of public ip addresses available for this
	 *         account to acquire
	 */
	public Long getIpAvailable() {
		return ipAvailable;
	}

	/**
	 * @return the total number of public ip addresses this account can acquire
	 */
	public Long getIpLimit() {
		return ipLimit;
	}

	/**
	 * @return the total number of public ip addresses allocated for this
	 *         account
	 */
	public long getIpTotal() {
		return ipTotal;
	}

	/**
	 * @return true if account is default, false otherwise
	 */
	public boolean isDefault() {
		return isDefault;
	}

	/**
	 * @return the total memory (in MB) available to be created for this account
	 */
	public Long getMemoryAvailable() {
		return memoryAvailable;
	}

	/**
	 * @return the total memory (in MB) the account can own
	 */
	public Long getMemoryLimit() {
		return memoryLimit;
	}

	/**
	 * @return the total memory (in MB) owned by account
	 */
	public long getMemoryTotal() {
		return memoryTotal;
	}

	/**
	 * @return the total number of networks available to be created for this
	 *         account
	 */
	public Long getNetworkAvailable() {
		return networkAvailable;
	}

	/**
	 * @return the total number of networks the account can own
	 */
	public Long getNetworkLimit() {
		return networkLimit;
	}

	/**
	 * @return the total number of networks owned by account
	 */
	public long getNetworkTotal() {
		return networkTotal;
	}

	/**
	 * @return the total primary storage space (in GiB) available to be used for
	 *         this account
	 */
	public Long getPrimaryStorageAvailable() {
		return primaryStorageAvailable;
	}

	/**
	 * @return the total primary storage space (in GiB) the account can own
	 */
	public Long getPrimaryStorageLimit() {
		return primaryStorageLimit;
	}

	/**
	 * @return the total primary storage space (in GiB) owned by account
	 */
	public long getPrimaryStorageTotal() {
		return primaryStorageTotal;
	}

	/**
	 * @return the total number of projects available for administration by this
	 *         account
	 */
	public Long getProjectAvailable() {
		return projectAvailable;
	}

	/**
	 * @return the total number of projects the account can own
	 */
	public Long getProjectLimit() {
		return projectLimit;
	}

	/**
	 * @return the total number of projects being administrated by this account
	 */
	public long getProjectTotal() {
		return projectTotal;
	}

	/**
	 * @return the total secondary storage space (in GiB) available to be used
	 *         for this account
	 */
	public Long getSecondaryStorageAvailable() {
		return secondaryStorageAvailable;
	}

	/**
	 * @return the total secondary storage space (in GiB) the account can own
	 */
	public Long getSecondaryStorageLimit() {
		return secondaryStorageLimit;
	}

	/**
	 * @return the total secondary storage space (in GiB) owned by account
	 */
	public long getSecondaryStorageTotal() {
		return secondaryStorageTotal;
	}

	/**
	 * @return the total number of snapshots available for this account
	 */
	public Long getSnapshotAvailable() {
		return snapshotAvailable;
	}

	/**
	 * @return the total number of snapshots stored by this account
	 */
	public long getSnapshotTotal() {
		return snapshotTotal;
	}

	/**
	 * @return the total number of templates available to be created by this
	 *         account
	 */
	public Long getTemplateAvailable() {
		return templateAvailable;
	}

	/**
	 * @return the total number of templates which have been created by this
	 *         account
	 */
	public long getTemplateTotal() {
		return templateTotal;
	}

	/**
	 * @return the total number of virtual machines available for this account
	 *         to acquire
	 */
	public Long getVmAvailable() {
		return vmAvailable;
	}

	/**
	 * @return the total number of virtual machines that can be deployed by this
	 *         account
	 */
	public Long getVmLimit() {
		return vmLimit;
	}

	/**
	 * @return the total number of virtual machines deployed by this account
	 */
	public long getVmTotal() {
		return vmTotal;
	}

	/**
	 * @return the total volume available for this account
	 */
	public Long getVolumeAvailable() {
		return volumeAvailable;
	}

	/**
	 * @return the total volume being used by this account
	 */
	public long getVolumeTotal() {
		return volumeTotal;
	}

	/**
	 * @return the total number of vpcs available to be created for this account
	 */
	public Long getVpcAvailable() {
		return vpcAvailable;
	}

	/**
	 * @return the total number of vpcs the account can own
	 */
	public Long getVpcLimit() {
		return vpcLimit;
	}

	/**
	 * @return the total number of vpcs owned by account
	 */
	public long getVpcTotal() {
		return vpcTotal;
	}

	/**
	 * @return the total number of network traffic bytes received
	 */
	public long getReceivedBytes() {
		return receivedBytes;
	}

	/**
	 * @return the total number of network traffic bytes sent
	 */
	public long getSentBytes() {
		return sentBytes;
	}

	@Override
	protected Set<User> delegate() {
		return this.users;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id, name, cpuAvailable, cpuLimit, cpuTotal,
				domain, domainId, ipAvailable, ipLimit, ipTotal, isDefault,
				memoryAvailable, memoryLimit, memoryTotal, networkAvailable,
				networkLimit, networkTotal, primaryStorageAvailable,
				primaryStorageLimit, primaryStorageTotal, projectAvailable,
				projectLimit, projectTotal, secondaryStorageAvailable,
				secondaryStorageLimit, secondaryStorageTotal,
				snapshotAvailable, snapshotLimit, snapshotTotal, state,
				templateAvailable, templateLimit, templateTotal, vmAvailable,
				vmLimit, vmTotal, volumeAvailable, volumeLimit, volumeTotal,
				vpcAvailable, vpcLimit, vpcTotal, receivedBytes, sentBytes, type, users);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Account that = Account.class.cast(obj);
		return Objects.equal(this.id, that.id)
				&& Objects.equal(this.name, that.name)
				&& Objects.equal(this.cpuAvailable, that.cpuAvailable)
				&& Objects.equal(this.cpuLimit, that.cpuLimit)
				&& Objects.equal(this.cpuTotal, that.cpuTotal)
				&& Objects.equal(this.domain, that.domain)
				&& Objects.equal(this.domainId, that.domainId)
				&& Objects.equal(this.ipAvailable, that.ipAvailable)
				&& Objects.equal(this.ipLimit, that.ipLimit)
				&& Objects.equal(this.name, that.name)
				&& Objects.equal(this.ipTotal, that.ipTotal)
				&& Objects.equal(this.isDefault, that.isDefault)
				&& Objects.equal(this.memoryAvailable, that.memoryAvailable)
				&& Objects.equal(this.memoryLimit, that.memoryLimit)
				&& Objects.equal(this.memoryTotal, that.memoryTotal)
				&& Objects.equal(this.networkAvailable, that.networkAvailable)
				&& Objects.equal(this.networkLimit, that.networkLimit)
				&& Objects.equal(this.networkTotal, that.networkTotal)
				&& Objects.equal(this.primaryStorageAvailable,that.primaryStorageAvailable)
				&& Objects.equal(this.primaryStorageLimit,that.primaryStorageLimit)
				&& Objects.equal(this.primaryStorageTotal,that.primaryStorageTotal)
				&& Objects.equal(this.projectAvailable, that.projectAvailable)
				&& Objects.equal(this.projectLimit, that.projectLimit)
				&& Objects.equal(this.projectTotal, that.projectTotal)
				&& Objects.equal(this.secondaryStorageAvailable, that.secondaryStorageAvailable)
				&& Objects.equal(this.secondaryStorageLimit, that.secondaryStorageLimit)
				&& Objects.equal(this.secondaryStorageTotal, that.secondaryStorageTotal)
				&& Objects
						.equal(this.snapshotAvailable, that.snapshotAvailable)
				&& Objects.equal(this.snapshotLimit, that.snapshotLimit)
				&& Objects.equal(this.snapshotTotal, that.snapshotTotal)
				&& Objects.equal(this.state, that.state)
				&& Objects.equal(this.templateAvailable, that.templateAvailable)
				&& Objects.equal(this.templateLimit, that.templateLimit)
				&& Objects.equal(this.templateTotal, that.templateTotal)
				&& Objects.equal(this.vmAvailable, that.vmAvailable)
				&& Objects.equal(this.vmLimit, that.vmLimit)
				&& Objects.equal(this.vmTotal, that.vmTotal)
				&& Objects.equal(this.volumeAvailable, that.volumeAvailable)
				&& Objects.equal(this.volumeLimit, that.volumeLimit)
				&& Objects.equal(this.volumeTotal, that.volumeTotal)
				&& Objects.equal(this.vpcAvailable, that.vpcAvailable)
				&& Objects.equal(this.vpcLimit, that.vpcLimit)
				&& Objects.equal(this.vpcTotal, that.vpcTotal)
				&& Objects.equal(this.receivedBytes, that.receivedBytes)
				&& Objects.equal(this.sentBytes, that.sentBytes)
				&& Objects.equal(this.type, that.type)
				&& Objects.equal(this.users, that.users);
	}

	protected ToStringHelper string() {
		return Objects.toStringHelper(this).add("id", id).add("name", name)
				.add("cpuAvailable", cpuAvailable).add("cpuLimit", cpuLimit)
				.add("cpuTotal", cpuTotal).add("domain", domain)
				.add("domainId", domainId).add("ipAvailable", ipAvailable)
				.add("ipLimit", ipLimit).add("ipTotal", ipTotal)
				.add("isDefault", isDefault)
				.add("memoryAvailable", memoryAvailable)
				.add("memoryLimit", memoryLimit)
				.add("memoryTotal", memoryTotal)
				.add("networkAvailable", networkAvailable)
				.add("networkLimit", networkLimit)
				.add("networkTotal", networkTotal)
				.add("primaryStorageAvailable", primaryStorageAvailable)
				.add("primaryStorageLimit", primaryStorageLimit)
				.add("primaryStorageTotal", primaryStorageTotal)
				.add("projectAvailable", projectAvailable)
				.add("projectLimit", projectLimit)
				.add("projectTotal", projectTotal)
				.add("secondaryStorageAvailable", secondaryStorageAvailable)
				.add("projectAvailable", projectAvailable)
				.add("projectLimit", projectLimit)
				.add("projectTotal", projectTotal)
				.add("secondaryStorageAvailable", secondaryStorageAvailable)
				.add("secondaryStorageLimit", secondaryStorageLimit)
				.add("secondaryStorageTotal", secondaryStorageTotal)
				.add("snapshotAvailable", snapshotAvailable)
				.add("snapshotLimit", snapshotLimit)
				.add("snapshotTotal", snapshotTotal).add("state", state)
				.add("templateAvailable", templateAvailable)
				.add("templateLimit", templateLimit)
				.add("templateTotal", templateTotal)
				.add("vmAvailable", vmAvailable).add("vmLimit", vmLimit)
				.add("vmTotal", vmTotal)
				.add("volumeAvailable", volumeAvailable)
				.add("volumeLimit", volumeLimit)
				.add("volumeTotal", volumeTotal)
				.add("vpcAvailable", vpcAvailable).add("vpcLimit", vpcLimit)
				.add("receivedBytes", receivedBytes).add("sentBytes", sentBytes)
				.add("vpcTotal", vpcTotal).add("type", type)
				.add("users", users);
	}

	@Override
	public String toString() {
		return string().toString();
	}

}
