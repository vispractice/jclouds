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
 * Optional fields for listing storage network ip range
 * 
 * @see <a
 *      href="http://cloudstack.apache.org/docs/api/apidocs-4.3/root_admin/updateStorageNetworkIpRange.html"
 *      />
 * @author liwei
 */
public class UpdateStorageNetworkIpRangeOptions extends BaseHttpRequestOptions {

   public static final UpdateStorageNetworkIpRangeOptions NONE = new UpdateStorageNetworkIpRangeOptions();

   /**
    * @param endIp
    *          the ending IP address
    */
   public UpdateStorageNetworkIpRangeOptions endIp(String endIp) {
      this.queryParameters.replaceValues("endip", ImmutableSet.of(endIp));
      return this;
   }

   /**
    * @param netmask
    *          the netmask for storage network
    */
   public UpdateStorageNetworkIpRangeOptions netmask(String netmask) {
      this.queryParameters.replaceValues("netmask", ImmutableSet.of(netmask));
      return this;
   }

   /**
    * @param startIp
    *           the beginning IP address
    */
   public UpdateStorageNetworkIpRangeOptions startIp(String startIp) {
      this.queryParameters.replaceValues("startip", ImmutableSet.of(startIp));
      return this;
   }
   
   /**
    * @param vlan
    *          Optional. the vlan the ip range sits on
    */
   public UpdateStorageNetworkIpRangeOptions vlan(String vlan) {
      this.queryParameters.replaceValues("vlan", ImmutableSet.of(vlan));
      return this;
   }

   public static class Builder {
      /**
       * @see UpdateStorageNetworkIpRangeOptions#endIp
       */
      public static UpdateStorageNetworkIpRangeOptions endIp(String endIp) {
         UpdateStorageNetworkIpRangeOptions options = new UpdateStorageNetworkIpRangeOptions();
         return options.endIp(endIp);
      }

      /**
       * @see UpdateStorageNetworkIpRangeOptions#netmask
       */
      public static UpdateStorageNetworkIpRangeOptions netmask(String netmask) {
         UpdateStorageNetworkIpRangeOptions options = new UpdateStorageNetworkIpRangeOptions();
         return options.netmask(netmask);
      }

      /**
       * @see UpdateStorageNetworkIpRangeOptions#startIp(String)
       */
      public static UpdateStorageNetworkIpRangeOptions startIp(String startIp) {
         UpdateStorageNetworkIpRangeOptions options = new UpdateStorageNetworkIpRangeOptions();
         return options.startIp(startIp);
      }
      
      /**
       * @see UpdateStorageNetworkIpRangeOptions#vlan(String)
       */
      public static UpdateStorageNetworkIpRangeOptions vlan(String vlan) {
         UpdateStorageNetworkIpRangeOptions options = new UpdateStorageNetworkIpRangeOptions();
         return options.vlan(vlan);
      }

   }
}
