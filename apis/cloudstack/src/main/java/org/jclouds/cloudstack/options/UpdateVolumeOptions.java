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
 * Options used to update volume
 *
 * @author liwei
 */
public class UpdateVolumeOptions extends BaseHttpRequestOptions {

	public static final UpdateVolumeOptions NONE = new UpdateVolumeOptions();

	/**
	 * @param id the ID of the disk volume
	 */
	public UpdateVolumeOptions id(String id) {
		this.queryParameters.replaceValues("id", ImmutableSet.of(id));
		return this;
	}
	
	/**
	 * @param displayVolume an optional field, whether to the display the volume to the end user or not.
	 */
	public UpdateVolumeOptions displayVolume(String displayVolume) {
		this.queryParameters.replaceValues("displayvolume", ImmutableSet.of(displayVolume));
		return this;
	}
	
	/**
	 * @param path The path of the volume
	 */
	public UpdateVolumeOptions path(String path) {
		this.queryParameters.replaceValues("path", ImmutableSet.of(path));
		return this;
	}
	
	/**
	 * @param state The state of the volume
	 */
	public UpdateVolumeOptions state(String state) {
		this.queryParameters.replaceValues("state", ImmutableSet.of(state));
		return this;
	}
	
	/**
	 * @param storageId Destination storage pool UUID for the volume
	 */
	public UpdateVolumeOptions storageId(String storageId) {
		this.queryParameters.replaceValues("storageid", ImmutableSet.of(storageId));
		return this;
	}

	public static class Builder {

		/**
		 * @see UpdateVolumeOptions#id
		 */
		public static UpdateVolumeOptions id(String id) {
			UpdateVolumeOptions options = new UpdateVolumeOptions();
			return options.id(id);
		}
		
		/**
		 * @see UpdateVolumeOptions#displayVolume
		 */
		public static UpdateVolumeOptions displayVolume(String displayVolume) {
			UpdateVolumeOptions options = new UpdateVolumeOptions();
			return options.displayVolume(displayVolume);
		}
		
		/**
		 * @see UpdateVolumeOptions#path
		 */
		public static UpdateVolumeOptions path(String path) {
			UpdateVolumeOptions options = new UpdateVolumeOptions();
			return options.path(path);
		}
		
		/**
		 * @see UpdateVolumeOptions#state
		 */
		public static UpdateVolumeOptions state(String state) {
			UpdateVolumeOptions options = new UpdateVolumeOptions();
			return options.state(state);
		}
		
		/**
		 * @see UpdateVolumeOptions#storageId
		 */
		public static UpdateVolumeOptions storageId(String storageId) {
			UpdateVolumeOptions options = new UpdateVolumeOptions();
			return options.storageId(storageId);
		}
	}

}
