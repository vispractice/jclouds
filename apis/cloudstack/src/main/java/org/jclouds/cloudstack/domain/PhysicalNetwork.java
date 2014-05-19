/**
 * 
 */
package org.jclouds.cloudstack.domain;

import static com.google.common.base.Preconditions.checkNotNull;

import java.beans.ConstructorProperties;
import java.util.Set;

import org.jclouds.javax.annotation.Nullable;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.collect.ImmutableSet;

/**
 * Class PhysicalNetwork
 * 
 * @author liwei
 */
public class PhysicalNetwork {

	public static Builder<?> builder() {
		return new ConcreteBuilder();
	}

	public Builder<?> toBuilder() {
		return new ConcreteBuilder().fromPhysicalNetwork(this);
	}

	public abstract static class Builder<T extends Builder<T>> {
		protected abstract T self();

		protected String id;
		protected String name;
		protected String broadcastDomainRange;
		protected String zoneId;
		protected String state;
		protected String VLAN;
		protected String domainId;
		protected Set<String> tags;
		protected String isolationMethods;
		protected String networkSpeed;
		
		public T id(String id) {
			this.id = id;
			return self();
		}

		public T name(String name) {
			this.name = name;
			return self();
		}

		public T broadcastDomainRange(String broadcastDomainRange) {
			this.broadcastDomainRange = broadcastDomainRange;
			return self();
		}

		public T zoneId(String zoneId) {
			this.zoneId = zoneId;
			return self();
		}

		public T state(String state) {
			this.state = state;
			return self();
		}

		public T VLAN(String vLAN) {
			VLAN = vLAN;
			return self();
		}

		public T domainId(String domainId) {
			this.domainId = domainId;
			return self();
		}

		public T tags(Set<String> tags) {
			this.tags = tags;
			return self();
		}

		public T isolationMethods(String isolationMethods) {
			this.isolationMethods = isolationMethods;
			return self();
		}

		public T networkSpeed(String networkSpeed) {
			this.networkSpeed = networkSpeed;
			return self();
		}

		public PhysicalNetwork build() {
			return new PhysicalNetwork(id, name, broadcastDomainRange, zoneId, state,
					VLAN, domainId, isolationMethods, networkSpeed, tags);
		}

		public T fromPhysicalNetwork(PhysicalNetwork in) {
			return this.id(in.getId()).name(in.getName())
					.broadcastDomainRange(in.getBroadcastDomainRange()).zoneId(in.getZoneId())
					.state(in.getState())
					.VLAN(in.getVLAN()).domainId(in.getDomainId())
					.isolationMethods(in.getIsolationMethods())
					.networkSpeed(in.getNetworkSpeed())
					.tags(in.getTags());
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
	private final String broadcastDomainRange;
	private final String zoneId;
	private final String state;
	private final String VLAN;
	private final String domainId;
	private final Set<String> tags;
	private final String isolationMethods;
	private final String networkSpeed;

	@ConstructorProperties({ "id", "name", "broadcastdomainrange", "zoneid",
			"state", "vlan", "domainid", "isolationmethods", "networkspeed",
			"tags" })
	protected PhysicalNetwork(String id, @Nullable String name,
			@Nullable String broadcastDomainRange, @Nullable String zoneId,
			@Nullable String state, @Nullable String VLAN,
			@Nullable String domainId, @Nullable String isolationMethods,
			@Nullable String networkSpeed, @Nullable Iterable<String> tags) {
		this.id = checkNotNull(id, "id");
		this.name = name;
		this.broadcastDomainRange = broadcastDomainRange;
		this.zoneId = zoneId;
		this.state = state;
		this.VLAN = VLAN;
		this.domainId = domainId;
		this.isolationMethods = isolationMethods;
		this.networkSpeed = networkSpeed;
		this.tags = tags != null ? ImmutableSet.copyOf(tags) : ImmutableSet
				.<String> of();
	}

	/**
	 * @return the uuid of the physical network
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return name of the physical network
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return Broadcast domain range of the physical network
	 */
	public String getBroadcastDomainRange() {
		return broadcastDomainRange;
	}

	/**
	 * @return zone id of the physical network
	 */
	public String getZoneId() {
		return zoneId;
	}

	/**
	 * @return state of the physical network
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the vlan of the physical network
	 */
	public String getVLAN() {
		return VLAN;
	}

	/**
	 * @return the domain id of the physical network owner
	 */
	public String getDomainId() {
		return domainId;
	}

	/**
	 * @return comma separated tag
	 */
	public Set<String> getTags() {
		return tags;
	}

	/**
	 * @return isolation methods
	 */
	public String getIsolationMethods() {
		return isolationMethods;
	}

	/**
	 * @return the speed of the physical network
	 */
	public String getNetworkSpeed() {
		return networkSpeed;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id, name, broadcastDomainRange, zoneId, state,
				VLAN, domainId, isolationMethods, networkSpeed, tags);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		PhysicalNetwork that = PhysicalNetwork.class.cast(obj);
		return Objects.equal(this.id, that.id)
				&& Objects.equal(this.name, that.name)
				&& Objects.equal(this.broadcastDomainRange,
						that.broadcastDomainRange)
				&& Objects.equal(this.zoneId, that.zoneId)
				&& Objects.equal(this.state, that.state)
				&& Objects.equal(this.VLAN, that.VLAN)
				&& Objects.equal(this.domainId, that.domainId)
				&& Objects.equal(this.isolationMethods, that.isolationMethods)
				&& Objects.equal(this.networkSpeed, that.networkSpeed)
				&& Objects.equal(this.tags, that.tags);
	}

	protected ToStringHelper string() {
		return Objects.toStringHelper(this).add("id", id).add("name", name)
				.add("broadcastDomainRange", broadcastDomainRange)
				.add("zoneId", zoneId).add("state", state).add("VLAN", VLAN)
				.add("domainId", domainId)
				.add("isolationMethods", isolationMethods)
				.add("networkSpeed", networkSpeed).add("tags", tags);
	}

	@Override
	public String toString() {
		return string().toString();
	}
}
