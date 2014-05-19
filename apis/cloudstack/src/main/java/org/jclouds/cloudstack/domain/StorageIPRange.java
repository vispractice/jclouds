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

import org.jclouds.javax.annotation.Nullable;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

/**
 * Represents the data object used in CloudStack's "Storage" API.
 *
 * @author liwei
 */
public class StorageIPRange implements Comparable<StorageIPRange> {

	public static Builder<?> builder() {
		return new ConcreteBuilder();
	}

	public Builder<?> toBuilder() {
		return new ConcreteBuilder().fromStorageIPRange(this);
	}

	public abstract static class Builder<T extends Builder<T>> {
		protected abstract T self();

		protected String id;
		protected String zoneId;
		protected String vlan;
		protected String podId;
		protected String gateway;
		protected String netmask;
		protected String startIP;
		protected String endIP;
		protected String networkId;

		/**
		 * @see StorageIPRange#getId()
		 */
		public T id(String id) {
			this.id = id;
			return self();
		}

		/**
		 * @see StorageIPRange#getZoneId()
		 */
		public T zoneId(String zoneId) {
			this.zoneId = zoneId;
			return self();
		}

		/**
		 * @see StorageIPRange#getVlan()
		 */
		public T vlan(String vlan) {
			this.vlan = vlan;
			return self();
		}

		/**
		 * @see StorageIPRange#getPodId()
		 */
		public T podId(String podId) {
			this.podId = podId;
			return self();
		}

		/**
		 * @see StorageIPRange#getGateway()
		 */
		public T gateway(String gateway) {
			this.gateway = gateway;
			return self();
		}

		/**
		 * @see StorageIPRange#getNetmask()
		 */
		public T netmask(String netmask) {
			this.netmask = netmask;
			return self();
		}

		/**
		 * @see StorageIPRange#getStartIP()
		 */
		public T startIP(String startIP) {
			this.startIP = startIP;
			return self();
		}

		/**
		 * @see StorageIPRange#getEndIP()
		 */
		public T endIP(String endIP) {
			this.endIP = endIP;
			return self();
		}

		/**
		 * @see StorageIPRange#getNetworkId()
		 */
		public T networkId(String networkId) {
			this.networkId = networkId;
			return self();
		}

		public StorageIPRange build() {
			return new StorageIPRange(id, zoneId, vlan, podId, gateway,
					netmask, startIP, endIP, networkId);
		}

		public T fromStorageIPRange(StorageIPRange in) {
			return this.id(in.getId()).zoneId(in.getZoneId())
					.vlan(in.getVlan()).podId(in.getPodId())
					.gateway(in.getGateway()).netmask(in.getNetmask())
					.startIP(in.getStartIP()).endIP(in.getEndIP())
					.networkId(in.getNetworkId());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	private final String id;
	private final String zoneId;
	private final String vlan;
	private final String podId;
	private final String gateway;
	private final String netmask;
	private final String startIP;
	private final String endIP;
	private final String networkId;

	@ConstructorProperties({ "id", "zoneid", "vlan", "podid", "gateway",
			"netmask", "startip", "endip", "networkid" })
	protected StorageIPRange(String id, @Nullable String zoneId,
			@Nullable String vlan, @Nullable String podId,
			@Nullable String gateway, @Nullable String netmask,
			@Nullable String startIP, @Nullable String endIP,
			@Nullable String networkId) {
		this.id = checkNotNull(id, "id");
		this.zoneId = zoneId;
		this.vlan = vlan;
		this.podId = podId;
		this.gateway = gateway;
		this.netmask = netmask;
		this.startIP = startIP;
		this.endIP = endIP;
		this.networkId = networkId;
	}

	public String getId() {
		return this.id;
	}

	@Nullable
	public String getZoneId() {
		return this.zoneId;
	}

	@Nullable
	public String getVlan() {
		return this.vlan;
	}

	@Nullable
	public String getPodId() {
		return this.podId;
	}

	@Nullable
	public String getGateway() {
		return this.gateway;
	}

	@Nullable
	public String getNetmask() {
		return this.netmask;
	}

	@Nullable
	public String getStartIP() {
		return this.startIP;
	}

	@Nullable
	public String getEndIP() {
		return this.endIP;
	}

	@Nullable
	public String getNetworkId() {
		return this.networkId;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id, zoneId,
				vlan, podId, gateway,
				netmask, startIP, endIP, networkId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		StorageIPRange that = StorageIPRange.class.cast(obj);
		return Objects.equal(this.id, that.id)
				&& Objects.equal(this.zoneId, that.zoneId)
				&& Objects.equal(this.vlan, that.vlan)
				&& Objects.equal(this.podId, that.podId)
				&& Objects.equal(this.gateway, that.gateway)
				&& Objects.equal(this.netmask, that.netmask)
				&& Objects.equal(this.startIP, that.startIP)
				&& Objects.equal(this.endIP, that.endIP)
				&& Objects.equal(this.networkId, that.networkId);
	}

	protected ToStringHelper string() {
		return Objects.toStringHelper(this).add("id", id)
				.add("zoneId", zoneId).add("vlan", vlan)
				.add("netmask", netmask).add("startIP", startIP)
				.add("endIP", endIP).add("networkId", networkId);
	}

	@Override
	public String toString() {
		return string().toString();
	}

	@Override
	public int compareTo(StorageIPRange other) {
		return this.id.compareTo(other.id);
	}

}
