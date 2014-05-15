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
package org.jclouds.cloudstack.options;

import com.google.common.collect.ImmutableSet;

/**
 * Options used to upload volume
 *
 * @author liwei
 */
public class UploadVolumeOptions extends AccountInDomainOptions {

	public static final UploadVolumeOptions NONE = new UploadVolumeOptions();

	/**
	 * @param checksum
	 *            the MD5 checksum value of this volume
	 */
	public UploadVolumeOptions checksum(String checksum) {
		this.queryParameters.replaceValues("checksum",
				ImmutableSet.of(checksum));
		return this;
	}

	/**
	 * @param imageStoreUuid
	 *            Image store uuid
	 */
	public UploadVolumeOptions imageStoreUuid(String imageStoreUuid) {
		this.queryParameters.replaceValues("imagestoreuuid",
				ImmutableSet.of(imageStoreUuid));
		return this;
	}

	/**
	 * @param projectId
	 *            Upload volume for the project
	 */
	public UploadVolumeOptions projectId(String projectId) {
		this.queryParameters.replaceValues("projectid",
				ImmutableSet.of(projectId));
		return this;
	}

	public static class Builder {

		/**
		 * @see UploadVolumeOptions#accountInDomain
		 */
		public static UploadVolumeOptions accountInDomain(String account,
				String domain) {
			UploadVolumeOptions options = new UploadVolumeOptions();
			return options.accountInDomain(account, domain);
		}

		/**
		 * @see UploadVolumeOptions#domainId
		 */
		public static UploadVolumeOptions domainId(String id) {
			UploadVolumeOptions options = new UploadVolumeOptions();
			return options.domainId(id);
		}

		/**
		 * @see UploadVolumeOptions#checksum
		 */
		public static UploadVolumeOptions checksum(String checksum) {
			UploadVolumeOptions options = new UploadVolumeOptions();
			return options.checksum(checksum);
		}

		/**
		 * @see UploadVolumeOptions#imageStoreUuid
		 */
		public static UploadVolumeOptions imageStoreUuid(String imageStoreUuid) {
			UploadVolumeOptions options = new UploadVolumeOptions();
			return options.imageStoreUuid(imageStoreUuid);
		}

		/**
		 * @see UploadVolumeOptions#projectId(String)
		 */
		public static UploadVolumeOptions projectId(String id) {
			UploadVolumeOptions options = new UploadVolumeOptions();
			return options.projectId(id);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UploadVolumeOptions accountInDomain(String account, String domain) {
		return UploadVolumeOptions.class.cast(super.accountInDomain(account,
				domain));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UploadVolumeOptions domainId(String domainId) {
		return UploadVolumeOptions.class.cast(super.domainId(domainId));
	}
}
