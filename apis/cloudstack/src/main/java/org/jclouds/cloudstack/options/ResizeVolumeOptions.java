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

import org.jclouds.http.options.BaseHttpRequestOptions;

import com.google.common.collect.ImmutableSet;

/**
 * Options used to resize volume
 *
 * @author liwei
 */
public class ResizeVolumeOptions extends BaseHttpRequestOptions {

	public static final ResizeVolumeOptions NONE = new ResizeVolumeOptions();

	/**
	 * @param id the ID of the disk volume
	 */
	public ResizeVolumeOptions id(String id) {
		this.queryParameters.replaceValues("id", ImmutableSet.of(id));
		return this;
	}
	
	/**
	 * @param diskOfferingId new disk offering id
	 */
	public ResizeVolumeOptions diskOfferingId(String diskOfferingId) {
		this.queryParameters.replaceValues("diskofferingid", ImmutableSet.of(diskOfferingId));
		return this;
	}
	
	/**
	 * @param shrinkok Verify OK to Shrink
	 */
	public ResizeVolumeOptions shrinkok(boolean shrinkok) {
		this.queryParameters.replaceValues("shrinkok", ImmutableSet.of(shrinkok+""));
		return this;
	}
	
	/**
	 * @param size New volume size in G
	 */
	public ResizeVolumeOptions size(long size) {
		this.queryParameters.replaceValues("size", ImmutableSet.of(size+""));
		return this;
	}

	public static class Builder {

		/**
		 * @see ResizeVolumeOptions#id
		 */
		public static ResizeVolumeOptions id(String id) {
			ResizeVolumeOptions options = new ResizeVolumeOptions();
			return options.id(id);
		}
		
		/**
		 * @see ResizeVolumeOptions#diskOfferingId
		 */
		public static ResizeVolumeOptions diskOfferingId(String diskOfferingId) {
			ResizeVolumeOptions options = new ResizeVolumeOptions();
			return options.diskOfferingId(diskOfferingId);
		}
		
		/**
		 * @see ResizeVolumeOptions#shrinkok
		 */
		public static ResizeVolumeOptions shrinkok(boolean shrinkok) {
			ResizeVolumeOptions options = new ResizeVolumeOptions();
			return options.shrinkok(shrinkok);
		}
		
		/**
		 * @see ResizeVolumeOptions#size
		 */
		public static ResizeVolumeOptions size(long size) {
			ResizeVolumeOptions options = new ResizeVolumeOptions();
			return options.size(size);
		}
	}

}
