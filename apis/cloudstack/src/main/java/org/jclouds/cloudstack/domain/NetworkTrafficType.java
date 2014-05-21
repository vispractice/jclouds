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
 * @author liwei
 */
public class NetworkTrafficType {
	public static Builder<?> builder() {
		return new ConcreteBuilder();
	}

	public Builder<?> toBuilder() {
		return new ConcreteBuilder().fromNetworkTrafficType(this);
	}

	public abstract static class Builder<T extends Builder<T>> {
		protected abstract T self();

		protected String id;
		protected String hypervNetworkLabel;
		protected String kvmNetworkLabel;
		protected String physicalNetworkId;
		protected TrafficType trafficType;
		protected String vmwareNetworkLabel;
		protected String xenNetworkLabel;

		/**
		 * @see org.jclouds.cloudstack.domain.Project#getId()
		 */
		public T id(String id) {
			this.id = id;
			return self();
		}

		public T hypervNetworkLabel(String hypervNetworkLabel) {
			this.hypervNetworkLabel = hypervNetworkLabel;
			return self();
		}

		public T kvmNetworkLabel(String kvmNetworkLabel) {
			this.kvmNetworkLabel = kvmNetworkLabel;
			return self();
		}

		public T physicalNetworkId(String physicalNetworkId) {
			this.physicalNetworkId = physicalNetworkId;
			return self();
		}

		public T trafficType(TrafficType trafficType) {
			this.trafficType = trafficType;
			return self();
		}

		public T vmwareNetworkLabel(String vmwareNetworkLabel) {
			this.vmwareNetworkLabel = vmwareNetworkLabel;
			return self();
		}

		public T xenNetworkLabel(String xenNetworkLabel) {
			this.xenNetworkLabel = xenNetworkLabel;
			return self();
		}

		public NetworkTrafficType build() {
			return new NetworkTrafficType(id, hypervNetworkLabel,
					kvmNetworkLabel, physicalNetworkId, trafficType,
					vmwareNetworkLabel, xenNetworkLabel);
		}

		public T fromNetworkTrafficType(NetworkTrafficType in) {
			return this.id(in.getId()).hypervNetworkLabel(in.getHypervNetworkLabel())
					.kvmNetworkLabel(in.getKvmNetworkLabel()).physicalNetworkId(in.getPhysicalNetworkId())
					.trafficType(in.getTrafficType()).vmwareNetworkLabel(in.getVmwareNetworkLabel())
					.xenNetworkLabel(in.getXenNetworkLabel());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	private final String id;
	private final String hypervNetworkLabel;
	private final String kvmNetworkLabel;
	private final String physicalNetworkId;
	private final TrafficType trafficType;
	private final String vmwareNetworkLabel;
	private final String xenNetworkLabel;

	@ConstructorProperties({ "id", "hypervnetworklabel", "kvmnetworklabel",
			"physicalnetworkid", "traffictype", "vmwarenetworklabel",
			"xennetworklabel" })
	protected NetworkTrafficType(String id, String hypervNetworkLabel,
			String kvmNetworkLabel, String physicalNetworkId,
			TrafficType trafficType, String vmwareNetworkLabel,
			String xenNetworkLabel) {
		this.id = checkNotNull(id, "id");
		this.hypervNetworkLabel = hypervNetworkLabel;
		this.kvmNetworkLabel = kvmNetworkLabel;
		this.physicalNetworkId = physicalNetworkId;
		this.trafficType = trafficType;
		this.vmwareNetworkLabel = vmwareNetworkLabel;
		this.xenNetworkLabel = xenNetworkLabel;
	}

	public String getId() {
		return this.id;
	}

	/**
	 * @return The network name label of the physical device dedicated to this
	 *         traffic on a HyperV host
	 */
	@Nullable
	public String getHypervNetworkLabel() {
		return hypervNetworkLabel;
	}

	/**
	 * @return The network name label of the physical device dedicated to this
	 *         traffic on a KVM host
	 */
	@Nullable
	public String getKvmNetworkLabel() {
		return kvmNetworkLabel;
	}

	/**
	 * @return the physical network this belongs to
	 */
	@Nullable
	public String getPhysicalNetworkId() {
		return physicalNetworkId;
	}

	/**
	 * @return the trafficType to be added to the physical network
	 */
	public TrafficType getTrafficType() {
		return trafficType;
	}

	/**
	 * @return The network name label of the physical device dedicated to this
	 *         traffic on a VMware host
	 */
	@Nullable
	public String getVmwareNetworkLabel() {
		return vmwareNetworkLabel;
	}

	/**
	 * @return The network name label of the physical device dedicated to this
	 *         traffic on a XenServer host
	 */
	@Nullable
	public String getXenNetworkLabel() {
		return xenNetworkLabel;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id, hypervNetworkLabel, kvmNetworkLabel,
				physicalNetworkId, trafficType, vmwareNetworkLabel,
				xenNetworkLabel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		NetworkTrafficType that = NetworkTrafficType.class.cast(obj);
		return Objects.equal(this.id, that.id)
				&& Objects.equal(this.hypervNetworkLabel,
						that.hypervNetworkLabel)
				&& Objects.equal(this.kvmNetworkLabel, that.kvmNetworkLabel)
				&& Objects
						.equal(this.physicalNetworkId, that.physicalNetworkId)
				&& Objects.equal(this.trafficType, that.trafficType)
				&& Objects.equal(this.vmwareNetworkLabel,
						that.vmwareNetworkLabel)
				&& Objects.equal(this.xenNetworkLabel, that.xenNetworkLabel);
	}

	protected ToStringHelper string() {
		return Objects.toStringHelper(this).omitNullValues().add("id", id)
				.add("hypervNetworkLabel", hypervNetworkLabel)
				.add("kvmNetworkLabel", kvmNetworkLabel)
				.add("physicalNetworkId", physicalNetworkId)
				.add("trafficType", trafficType)
				.add("vmwareNetworkLabel", vmwareNetworkLabel)
				.add("xenNetworkLabel", xenNetworkLabel);
	}

	@Override
	public String toString() {
		return string().toString();
	}
}
