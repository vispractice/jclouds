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
 * @author liwei
 */
public class TrafficTypeImplementor {
	public static Builder<?> builder() {
		return new ConcreteBuilder();
	}

	public Builder<?> toBuilder() {
		return new ConcreteBuilder().fromNetworkTrafficType(this);
	}

	public abstract static class Builder<T extends Builder<T>> {
		protected abstract T self();

		protected TrafficType trafficType;
		protected String implementor;

		public T implementor(String implementor) {
			this.implementor = implementor;
			return self();
		}

		public T trafficType(TrafficType trafficType) {
			this.trafficType = trafficType;
			return self();
		}

		public TrafficTypeImplementor build() {
			return new TrafficTypeImplementor(trafficType, implementor);
		}

		public T fromNetworkTrafficType(TrafficTypeImplementor in) {
			return this.trafficType(in.getTrafficType()).implementor(in.getImplementor());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	private final TrafficType trafficType;
	private final String implementor;

	@ConstructorProperties({"traffictype", "implementor"})
	protected TrafficTypeImplementor(TrafficType trafficType, String implementor) {
		this.trafficType = trafficType;
		this.implementor = implementor;
	}

	/**
	 * @return the trafficType to be added to the physical network
	 */
	public TrafficType getTrafficType() {
		return trafficType;
	}

	/**
	 * @return implementor of network traffic type
	 */
	@Nullable
	public String getImplementor() {
		return implementor;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(trafficType, implementor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		TrafficTypeImplementor that = TrafficTypeImplementor.class.cast(obj);
		return Objects.equal(this.trafficType, that.trafficType)
				&& Objects.equal(this.implementor,
						that.implementor);
	}

	protected ToStringHelper string() {
		return Objects.toStringHelper(this).omitNullValues().add("trafficType", trafficType)
				.add("implementor", implementor);
	}

	@Override
	public String toString() {
		return string().toString();
	}
}
