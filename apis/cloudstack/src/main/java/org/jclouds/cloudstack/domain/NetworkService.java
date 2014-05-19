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

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Sets;

/**
 * TODO: Complete providers
 * Class NetworkService
 *
 * @author Adrian Cole
 * @author liwei
 */
public class NetworkService implements Comparable<NetworkService> {

	public static class Capability implements Comparable<Capability> {

		public static Builder<?> builder() {
			return new ConcreteBuilder();
		}

		public Builder<?> toBuilder() {
			return new ConcreteBuilder().fromCapability(this);
		}

		public abstract static class Builder<T extends Builder<T>> {
			protected abstract T self();

			protected String name;
			protected String value;
			protected boolean canChooseServiceCapability;

			/**
			 * @see Capability#getName()
			 */
			public T name(String name) {
				this.name = name;
				return self();
			}

			/**
			 * @see Capability#getValue()
			 */
			public T value(String value) {
				this.value = value;
				return self();
			}

			public T canChooseServiceCapability(
					boolean canChooseServiceCapability) {
				this.canChooseServiceCapability = canChooseServiceCapability;
				return self();
			}

			public Capability build() {
				return new Capability(name, value, canChooseServiceCapability);
			}

			public T fromCapability(Capability in) {
				return this
						.name(in.getName())
						.value(in.getValue())
						.canChooseServiceCapability(
								in.isCanChooseServiceCapability());
			}

		}

		private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
			@Override
			protected ConcreteBuilder self() {
				return this;
			}
		}

		private final String name;
		private final String value;
		private final boolean canChooseServiceCapability;

		@ConstructorProperties({ "name", "value", "canchooseservicecapability" })
		protected Capability(String name, @Nullable String value,
				boolean canChooseServiceCapability) {
			this.name = checkNotNull(name, "name");
			this.value = value;
			this.canChooseServiceCapability = canChooseServiceCapability;
		}

		public String getName() {
			return this.name;
		}

		@Nullable
		public String getValue() {
			return this.value;
		}

		public boolean isCanChooseServiceCapability() {
			return canChooseServiceCapability;
		}

		@Override
		public int hashCode() {
			return Objects.hashCode(name, value, canChooseServiceCapability);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null || getClass() != obj.getClass())
				return false;
			Capability that = Capability.class.cast(obj);
			return Objects.equal(this.name, that.name)
					&& Objects.equal(this.value, that.value)
					&& Objects.equal(this.canChooseServiceCapability,
							that.canChooseServiceCapability);
		}

		protected ToStringHelper string() {
			return Objects
					.toStringHelper(this)
					.add("name", name)
					.add("value", value)
					.add("canChooseServiceCapability",
							canChooseServiceCapability);
		}

		@Override
		public String toString() {
			return string().toString();
		}

		@Override
		public int compareTo(Capability o) {
			return name.compareTo(o.getName());
		}
	}

	public static class Provider implements Comparable<Provider> {

		public static Builder<?> builder() {
			return new ConcreteBuilder();
		}

		public Builder<?> toBuilder() {
			return new ConcreteBuilder().fromProvider(this);
		}

		public abstract static class Builder<T extends Builder<T>> {
			protected abstract T self();

			protected String id;
			protected String name;
			protected String physicalNetworkId;
			protected boolean canEnableIndividualService;
			protected boolean destinationPhysicalNetworkId;
			protected String serviceList;
			protected String state;

			public T id(String id) {
				this.id = id;
				return self();
			}

			public T name(String name) {
				this.name = name;
				return self();
			}

			public T physicalNetworkId(String physicalNetworkId) {
				this.physicalNetworkId = physicalNetworkId;
				return self();
			}

			public T canEnableIndividualService(
					boolean canEnableIndividualService) {
				this.canEnableIndividualService = canEnableIndividualService;
				return self();
			}

			public T destinationPhysicalNetworkId(
					boolean destinationPhysicalNetworkId) {
				this.destinationPhysicalNetworkId = destinationPhysicalNetworkId;
				return self();
			}

			public T serviceList(String serviceList) {
				this.serviceList = serviceList;
				return self();
			}

			public T state(String state) {
				this.state = state;
				return self();
			}

			public Provider build() {
				return new Provider(id, name, physicalNetworkId,
						canEnableIndividualService,
						destinationPhysicalNetworkId, serviceList, state);
			}

			public T fromProvider(Provider in) {
				return this
						.id(in.getId())
						.name(in.getName())
						.physicalNetworkId(in.getPhysicalNetworkId())
						.canEnableIndividualService(
								in.isCanEnableIndividualService())
						.destinationPhysicalNetworkId(
								in.isDestinationPhysicalNetworkId())
						.serviceList(in.getServiceList()).state(in.getState());
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
		private final String physicalNetworkId;
		private final boolean canEnableIndividualService;
		private final boolean destinationPhysicalNetworkId;
		private final String serviceList;
		private final String state;

		@ConstructorProperties({ "id", "name", "physicalnetworkid",
				"canenableindividualservice", "destinationphysicalnetworkid",
				"servicelist", "state" })
		protected Provider(String id, @Nullable String name,
				@Nullable String physicalNetworkId,
				boolean canEnableIndividualService,
				boolean destinationPhysicalNetworkId,
				@Nullable String serviceList, @Nullable String state) {
			this.id = checkNotNull(id, "id");
			this.name = name;
			this.physicalNetworkId = physicalNetworkId;
			this.canEnableIndividualService = canEnableIndividualService;
			this.destinationPhysicalNetworkId = destinationPhysicalNetworkId;
			this.serviceList = serviceList;
			this.state = state;
		}

		public String getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getPhysicalNetworkId() {
			return physicalNetworkId;
		}

		public boolean isCanEnableIndividualService() {
			return canEnableIndividualService;
		}

		public boolean isDestinationPhysicalNetworkId() {
			return destinationPhysicalNetworkId;
		}

		public String getServiceList() {
			return serviceList;
		}

		public String getState() {
			return state;
		}

		@Override
		public int hashCode() {
			return Objects.hashCode(id, name, physicalNetworkId,
					canEnableIndividualService, destinationPhysicalNetworkId,
					serviceList, state);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null || getClass() != obj.getClass())
				return false;
			Provider that = Provider.class.cast(obj);
			return Objects.equal(this.id, that.id)
					&& Objects.equal(this.name, that.name)
					&& Objects.equal(this.physicalNetworkId,
							that.physicalNetworkId)
					&& Objects.equal(this.canEnableIndividualService,
							that.canEnableIndividualService)
					&& Objects.equal(this.destinationPhysicalNetworkId,
							that.destinationPhysicalNetworkId)
					&& Objects.equal(this.serviceList, that.serviceList)
					&& Objects.equal(this.state, that.state);
		}

		protected ToStringHelper string() {
			return Objects
					.toStringHelper(this)
					.add("id", id)
					.add("name", name)
					.add("physicalNetworkId", physicalNetworkId)
					.add("canEnableIndividualService",
							canEnableIndividualService)
					.add("destinationPhysicalNetworkId",
							destinationPhysicalNetworkId)
					.add("serviceList", serviceList).add("state", state);
		}

		@Override
		public String toString() {
			return string().toString();
		}

		@Override
		public int compareTo(Provider o) {
			return name.compareTo(o.getName());
		}
	}

	public static Builder<?> builder() {
		return new ConcreteBuilder();
	}

	public Builder<?> toBuilder() {
		return new ConcreteBuilder().fromNetworkService(this);
	}

	public abstract static class Builder<T extends Builder<T>> {
		protected abstract T self();

		protected String name;
		protected Set<Capability> capabilities = Sets.newHashSet();
//		protected Set<Provider> providers = Sets.newHashSet();

		/**
		 * @see NetworkService#getName()
		 */
		public T name(String name) {
			this.name = name;
			return self();
		}

		/**
		 * @see NetworkService#getCapabilities()
		 */
		public T capabilities(Map<String, String> capabilities) {
			for (Map.Entry<String, String> entry : capabilities.entrySet()) {
				this.capabilities.add(Capability.builder().name(entry.getKey())
						.value(entry.getValue()).build());
			}
			return self();
		}

		public NetworkService build() {
			return new NetworkService(name, capabilities);
		}

		public T fromNetworkService(NetworkService in) {
			return this.name(in.getName()).capabilities(in.getCapabilities());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	private final String name;
	private final Set<Capability> capabilities;

	@ConstructorProperties({ "name", "capability" })
	protected NetworkService(String name, @Nullable Set<Capability> capabilities) {
		this.name = checkNotNull(name, "name");
		this.capabilities = capabilities == null ? ImmutableSet
				.<Capability> of() : ImmutableSortedSet.copyOf(capabilities);
	}

	public String getName() {
		return this.name;
	}

	public Map<String, String> getCapabilities() {
		// so tests and serialization comes out expected
		ImmutableSortedMap.Builder<String, String> returnVal = ImmutableSortedMap
				.naturalOrder();
		for (Capability capability : capabilities) {
			returnVal.put(capability.name, capability.value);
		}
		return returnVal.build();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(name, capabilities);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		NetworkService that = NetworkService.class.cast(obj);
		return Objects.equal(this.name, that.name)
				&& Objects.equal(this.capabilities, that.capabilities);
	}

	protected ToStringHelper string() {
		return Objects.toStringHelper(this).add("name", name)
				.add("capabilities", capabilities);
	}

	@Override
	public String toString() {
		return string().toString();
	}

	@Override
	public int compareTo(NetworkService o) {
		return name.compareTo(o.getName());
	}
}
