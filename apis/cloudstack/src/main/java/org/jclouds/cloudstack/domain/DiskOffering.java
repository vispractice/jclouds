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
import java.util.Set;

import org.jclouds.javax.annotation.Nullable;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.collect.ImmutableSet;

/**
 * Class DiskOffering
 * 
 * @author Adrian Cole
 */
public class DiskOffering implements Comparable<DiskOffering> {

	public static Builder<?> builder() {
		return new ConcreteBuilder();
	}

	public Builder<?> toBuilder() {
		return new ConcreteBuilder().fromDiskOffering(this);
	}

	public abstract static class Builder<T extends Builder<T>> {
		protected abstract T self();

		protected String id;
		protected String name;
		protected String displayText;
		protected Date created;
		protected String domain;
		protected String domainId;
		protected int diskSize;
		protected boolean customized;
		protected ImmutableSet.Builder<String> tags = ImmutableSet
				.<String> builder();
		protected long diskBytesReadRate;
		protected long diskBytesWriteRate;
		protected long diskIopsReadRate;
		protected long diskIopsWriteRate;
		protected boolean displayoffering;
		protected int maxiops;
		protected int miniops;
		protected StorageType storagetype;

		/**
		 * @see DiskOffering#getId()
		 */
		public T id(String id) {
			this.id = id;
			return self();
		}

		/**
		 * @see DiskOffering#getName()
		 */
		public T name(String name) {
			this.name = name;
			return self();
		}

		/**
		 * @see DiskOffering#getDisplayText()
		 */
		public T displayText(String displayText) {
			this.displayText = displayText;
			return self();
		}

		/**
		 * @see DiskOffering#getCreated()
		 */
		public T created(Date created) {
			this.created = created;
			return self();
		}

		/**
		 * @see DiskOffering#getDomain()
		 */
		public T domain(String domain) {
			this.domain = domain;
			return self();
		}

		/**
		 * @see DiskOffering#getDomainId()
		 */
		public T domainId(String domainId) {
			this.domainId = domainId;
			return self();
		}

		/**
		 * @see DiskOffering#getDiskSize()
		 */
		public T diskSize(int diskSize) {
			this.diskSize = diskSize;
			return self();
		}

		/**
		 * @see DiskOffering#isCustomized()
		 */
		public T customized(boolean customized) {
			this.customized = customized;
			return self();
		}

		/**
		 * @see DiskOffering#getTags()
		 */
		public T tags(Iterable<String> tags) {
			this.tags = ImmutableSet.<String> builder().addAll(tags);
			return self();
		}

		/**
		 * @see DiskOffering#getTags()
		 */
		public T tag(String tag) {
			this.tags.add(tag);
			return self();
		}

		public T diskBytesReadRate(long diskBytesReadRate) {
			this.diskBytesReadRate = diskBytesReadRate;
			return self();
		}

		public T diskBytesWriteRate(long diskBytesWriteRate) {
			this.diskBytesWriteRate = diskBytesWriteRate;
			return self();
		}

		public T diskIopsReadRate(long diskIopsReadRate) {
			this.diskIopsReadRate = diskIopsReadRate;
			return self();
		}

		public T diskIopsWriteRate(long diskIopsWriteRate) {
			this.diskIopsWriteRate = diskIopsWriteRate;
			return self();
		}

		public T displayoffering(boolean displayoffering) {
			this.displayoffering = displayoffering;
			return self();
		}

		public T maxiops(int maxiops) {
			this.maxiops = maxiops;
			return self();
		}

		public T miniops(int miniops) {
			this.miniops = miniops;
			return self();
		}

		public T storagetype(StorageType storagetype) {
			this.storagetype = storagetype;
			return self();
		}

		public DiskOffering build() {
			return new DiskOffering(id, name, displayText, created, domain,
					domainId, diskSize, customized, tags.build(),
					diskBytesReadRate, diskBytesWriteRate, diskIopsReadRate,
					diskIopsWriteRate, displayoffering, maxiops, miniops,
					storagetype);
		}

		public T fromDiskOffering(DiskOffering in) {
			return this.id(in.getId()).name(in.getName())
					.displayText(in.getDisplayText()).created(in.getCreated())
					.domain(in.getDomain()).domainId(in.getDomainId())
					.diskSize(in.getDiskSize()).customized(in.isCustomized())
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
	private final String displayText;
	private final Date created;
	private final String domain;
	private final String domainId;
	private final int diskSize;
	private final boolean customized;
	private final Set<String> tags;
	protected long diskBytesReadRate;
	protected long diskBytesWriteRate;
	protected long diskIopsReadRate;
	protected long diskIopsWriteRate;
	protected boolean displayoffering;
	protected int maxiops;
	protected int miniops;
	protected StorageType storagetype;

	@ConstructorProperties({ "id", "name", "displaytext", "created", "domain",
			"domainid", "disksize", "iscustomized", "tags",
			"diskBytesReadRate", "diskBytesWriteRate", "diskIopsReadRate",
			"diskIopsWriteRate", "displayoffering", "maxiops", "miniops",
			"storagetype" })
	protected DiskOffering(String id, @Nullable String name,
			@Nullable String displayText, @Nullable Date created,
			@Nullable String domain, @Nullable String domainId, int diskSize,
			boolean customized, @Nullable Iterable<String> tags,
			@Nullable long diskBytesReadRate,
			@Nullable long diskBytesWriteRate, @Nullable long diskIopsReadRate,
			@Nullable long diskIopsWriteRate,
			@Nullable boolean displayoffering, @Nullable int maxiops,
			@Nullable int miniops, @Nullable StorageType storagetype) {
		this.id = checkNotNull(id, "id");
		this.name = name;
		this.displayText = displayText;
		this.created = created;
		this.domain = domain;
		this.domainId = domainId;
		this.diskSize = diskSize;
		this.customized = customized;
		this.tags = tags != null ? ImmutableSet.copyOf(tags) : ImmutableSet
				.<String> of();
		this.diskBytesReadRate = diskBytesReadRate;
		this.diskBytesWriteRate = diskBytesWriteRate;
		this.diskIopsReadRate = diskIopsReadRate;
		this.diskIopsWriteRate = diskIopsWriteRate;
		this.displayoffering = displayoffering;
		this.maxiops = maxiops;
		this.miniops = miniops;
		this.storagetype = storagetype;
	}

	/**
	 * @return the id of the disk offering
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @return the name of the disk offering
	 */
	@Nullable
	public String getName() {
		return this.name;
	}

	/**
	 * @return an alternate display text of the disk offering.
	 */
	@Nullable
	public String getDisplayText() {
		return this.displayText;
	}

	/**
	 * @return the date this disk offering was created
	 */
	@Nullable
	public Date getCreated() {
		return this.created;
	}

	/**
	 * @return Domain name for the offering
	 */
	@Nullable
	public String getDomain() {
		return this.domain;
	}

	/**
	 * @return the domain id of the disk offering
	 */
	@Nullable
	public String getDomainId() {
		return this.domainId;
	}

	/**
	 * @return the size of the disk offering in GB
	 */
	public int getDiskSize() {
		return this.diskSize;
	}

	/**
	 * @return the ha support in the disk offering
	 */
	public boolean isCustomized() {
		return this.customized;
	}

	/**
	 * @return the tags for the disk offering
	 */
	public Set<String> getTags() {
		return this.tags;
	}

	public long getDiskBytesReadRate() {
		return diskBytesReadRate;
	}

	public long getDiskBytesWriteRate() {
		return diskBytesWriteRate;
	}

	public long getDiskIopsReadRate() {
		return diskIopsReadRate;
	}

	public long getDiskIopsWriteRate() {
		return diskIopsWriteRate;
	}

	public boolean isDisplayoffering() {
		return displayoffering;
	}

	public int getMaxiops() {
		return maxiops;
	}

	public int getMiniops() {
		return miniops;
	}

	public StorageType getStoragetype() {
		return storagetype;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id, name, displayText, created, domain,
				domainId, diskSize, customized, tags, diskBytesReadRate, diskBytesWriteRate, 
				diskIopsReadRate, diskIopsWriteRate, displayoffering, maxiops, miniops, storagetype);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiskOffering other = (DiskOffering) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (customized != other.customized)
			return false;
		if (diskBytesReadRate != other.diskBytesReadRate)
			return false;
		if (diskBytesWriteRate != other.diskBytesWriteRate)
			return false;
		if (diskIopsReadRate != other.diskIopsReadRate)
			return false;
		if (diskIopsWriteRate != other.diskIopsWriteRate)
			return false;
		if (diskSize != other.diskSize)
			return false;
		if (displayText == null) {
			if (other.displayText != null)
				return false;
		} else if (!displayText.equals(other.displayText))
			return false;
		if (displayoffering != other.displayoffering)
			return false;
		if (domain == null) {
			if (other.domain != null)
				return false;
		} else if (!domain.equals(other.domain))
			return false;
		if (domainId == null) {
			if (other.domainId != null)
				return false;
		} else if (!domainId.equals(other.domainId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (maxiops != other.maxiops)
			return false;
		if (miniops != other.miniops)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (storagetype == null) {
			if (other.storagetype != null)
				return false;
		} else if (!storagetype.equals(other.storagetype))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		return true;
	}

	protected ToStringHelper string() {
		return Objects.toStringHelper(this).add("id", id).add("name", name)
				.add("displayText", displayText).add("created", created)
				.add("domain", domain).add("domainId", domainId)
				.add("diskSize", diskSize).add("customized", customized)
				.add("tags", tags).add("diskBytesReadRate", diskBytesReadRate)
				.add("diskBytesWriteRate", diskBytesWriteRate).add("diskIopsReadRate", diskIopsReadRate)
				.add("diskIopsWriteRate", diskIopsWriteRate).add("displayoffering", displayoffering)
				.add("maxiops", maxiops).add("miniops", miniops).add("storagetype", storagetype);
	}

	@Override
	public String toString() {
		return string().toString();
	}

	@Override
	public int compareTo(DiskOffering other) {
		return id.compareTo(other.getId());
	}

}
