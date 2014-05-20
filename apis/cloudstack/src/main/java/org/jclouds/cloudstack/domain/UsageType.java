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
public class UsageType {
	public static Builder<?> builder() {
		return new ConcreteBuilder();
	}

	public Builder<?> toBuilder() {
		return new ConcreteBuilder().fromUsageType(this);
	}

	public abstract static class Builder<T extends Builder<T>> {
		protected abstract T self();

		protected String description;
		protected String usageTypeId;

		public T usageTypeId(String usageTypeId) {
			this.usageTypeId = usageTypeId;
			return self();
		}

		public T description(String description) {
			this.description = description;
			return self();
		}

		public UsageType build() {
			return new UsageType(description, usageTypeId);
		}

		public T fromUsageType(UsageType in) {
			return this.description(in.getDescription()).usageTypeId(in.getUsageTypeId());
		}
	}

	private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
		@Override
		protected ConcreteBuilder self() {
			return this;
		}
	}

	private final String description;
	private final String usageTypeId;

	@ConstructorProperties({"description", "usagetypeid"})
	protected UsageType(String description, String usageTypeId) {
		this.description = description;
		this.usageTypeId = usageTypeId;
	}

	/**
	 * @return description of usage type
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return usage type
	 */
	@Nullable
	public String getUsageTypeId() {
		return usageTypeId;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(description, usageTypeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		UsageType that = UsageType.class.cast(obj);
		return Objects.equal(this.description, that.description)
				&& Objects.equal(this.usageTypeId,
						that.usageTypeId);
	}

	protected ToStringHelper string() {
		return Objects.toStringHelper(this).omitNullValues().add("description", description)
				.add("usageTypeId", usageTypeId);
	}

	@Override
	public String toString() {
		return string().toString();
	}
}
