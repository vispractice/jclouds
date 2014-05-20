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

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

/**
 * @author liwei
 */
public class TrafficMonitor {
	public static Builder<?> builder() {
		return new ConcreteBuilder();
	}

	public Builder<?> toBuilder() {
		return new ConcreteBuilder().fromTrafficMonitor(this);
	}

	public abstract static class Builder<T extends Builder<T>> {
		protected abstract T self();

		protected String id;
		protected String ipAddress;
		protected long numRetries;
		protected long timeout;
		protected String zoneId;

		public T id(String id) {
			this.id = id;
			return self();
		}

		public T ipAddress(String ipAddress) {
			this.ipAddress = ipAddress;
			return self();
		}

		public T numRetries(long numRetries) {
			this.numRetries = numRetries;
			return self();
		}

		public T timeout(long timeout) {
			this.timeout = timeout;
			return self();
		}

		public T zoneId(String zoneId) {
			this.zoneId = zoneId;
			return self();
		}

		public TrafficMonitor build() {
			return new TrafficMonitor(id, ipAddress, numRetries, timeout,
					zoneId);
		}

		public T fromTrafficMonitor(TrafficMonitor in) {
			return this.id(in.getId()).ipAddress(in.getIpAddress())
					.numRetries(in.getNumRetries())
					.timeout(in.getTimeout())
					.zoneId(in.getZoneId());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	private final String id;
	private final String ipAddress;
	private final long numRetries;
	private final long timeout;
	private final String zoneId;

	@ConstructorProperties({ "id", "ipaddress", "numretries", "timeout",
			"zoneid" })
	protected TrafficMonitor(String id, String ipAddress, long numRetries,
			long timeout, String zoneId) {
		this.id = id;
		this.ipAddress = ipAddress;
		this.numRetries = numRetries;
		this.timeout = timeout;
		this.zoneId = zoneId;
	}

	/**
	 * @return the ID of the external firewall
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the management IP address of the external firewall
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * @return the number of times to retry requests to the external firewall
	 */
	public long getNumRetries() {
		return numRetries;
	}

	/**
	 * @return the timeout (in seconds) for requests to the external firewall
	 */
	public long getTimeout() {
		return timeout;
	}

	/**
	 * @return the zone ID of the external firewall
	 */
	public String getZoneId() {
		return zoneId;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id, ipAddress, numRetries, timeout, zoneId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		TrafficMonitor that = TrafficMonitor.class.cast(obj);
		return Objects.equal(this.id, that.id)
				&& Objects.equal(this.ipAddress, that.ipAddress)
				&& Objects.equal(this.numRetries, that.numRetries)
				&& Objects.equal(this.timeout, that.timeout)
				&& Objects.equal(this.zoneId, that.zoneId);
	}

	protected ToStringHelper string() {
		return Objects.toStringHelper(this).omitNullValues()
				.add("id", id)
				.add("ipAddress", ipAddress)
				.add("numRetries", numRetries)
				.add("timeout", timeout)
				.add("zoneId", zoneId);
	}

	@Override
	public String toString() {
		return string().toString();
	}
}
