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
 * Optional fields for listing physical networks
 * 
 * @see <a
 *      href="http://cloudstack.apache.org/docs/api/apidocs-4.3/root_admin/addNetworkServiceProvider.html"
 *      />
 * @author liwei
 */
public class AddNetworkServiceProviderOptions extends BaseHttpRequestOptions {

   public static final AddNetworkServiceProviderOptions NONE = new AddNetworkServiceProviderOptions();

   /**
    * @param destinationPhysicalNetworkId
    *          the destination Physical Network ID to bridge to
    */
   public AddNetworkServiceProviderOptions destinationPhysicalNetworkId(String destinationPhysicalNetworkId) {
      this.queryParameters.replaceValues("destinationphysicalnetworkid", ImmutableSet.of(destinationPhysicalNetworkId));
      return this;
   }

   /**
    * @param servicelist
    *          the list of services to be enabled for this physical network service provider
    */
   public AddNetworkServiceProviderOptions serviceList(String serviceList) {
      this.queryParameters.replaceValues("servicelist", ImmutableSet.of(serviceList));
      return this;
   }

   public static class Builder {
      /**
       * @see AddNetworkServiceProviderOptions#destinationPhysicalNetworkId
       */
      public static AddNetworkServiceProviderOptions provider(String destinationPhysicalNetworkId) {
         AddNetworkServiceProviderOptions options = new AddNetworkServiceProviderOptions();
         return options.destinationPhysicalNetworkId(destinationPhysicalNetworkId);
      }

      /**
       * @see AddNetworkServiceProviderOptions#serviceList
       */
      public static AddNetworkServiceProviderOptions serviceList(String serviceList) {
         AddNetworkServiceProviderOptions options = new AddNetworkServiceProviderOptions();
         return options.serviceList(serviceList);
      }

   }
}
