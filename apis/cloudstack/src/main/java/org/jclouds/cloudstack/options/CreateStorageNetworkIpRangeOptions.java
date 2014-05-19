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
 * Optional fields for listing service providers
 * 
 * @see <a
 *      href="http://cloudstack.apache.org/docs/api/apidocs-4.3/root_admin/createStorageNetworkIpRange.html"
 *      />
 * @author liwei
 */
public class CreateStorageNetworkIpRangeOptions extends BaseHttpRequestOptions {

   public static final CreateStorageNetworkIpRangeOptions NONE = new CreateStorageNetworkIpRangeOptions();

   /**
    * @param endIp
    *         the ending IP address
    */
   public CreateStorageNetworkIpRangeOptions endIp(String endIp) {
      this.queryParameters.replaceValues("endip", ImmutableSet.of(endIp));
      return this;
   }

   /**
    * @param vlan
    *          Optional. The vlan the ip range sits on, default to Null when it is not specificed which means you network is not on any Vlan. This is mainly for Vmware as other hypervisors can directly reterive bridge from pyhsical network traffic type table
    */
   public CreateStorageNetworkIpRangeOptions vlan(String vlan) {
      this.queryParameters.replaceValues("vlan", ImmutableSet.of(vlan));
      return this;
   }

   public static class Builder {
      /**
       * @see CreateStorageNetworkIpRangeOptions#endIp
       */
      public static CreateStorageNetworkIpRangeOptions endIp(String endIp) {
         CreateStorageNetworkIpRangeOptions options = new CreateStorageNetworkIpRangeOptions();
         return options.endIp(endIp);
      }

      /**
       * @see CreateStorageNetworkIpRangeOptions#vlan
       */
      public static CreateStorageNetworkIpRangeOptions vlan(String vlan) {
         CreateStorageNetworkIpRangeOptions options = new CreateStorageNetworkIpRangeOptions();
         return options.vlan(vlan);
      }
   }
}
