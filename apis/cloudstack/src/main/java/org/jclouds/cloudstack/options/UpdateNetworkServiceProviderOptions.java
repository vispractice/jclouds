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
 *      href="http://cloudstack.apache.org/docs/api/apidocs-4.3/root_admin/updateNetworkServiceProvider.html"
 *      />
 * @author liwei
 */
public class UpdateNetworkServiceProviderOptions extends BaseHttpRequestOptions {

   public static final UpdateNetworkServiceProviderOptions NONE = new UpdateNetworkServiceProviderOptions();

   /**
    * @param id
    *          network service provider id
    */
   public UpdateNetworkServiceProviderOptions id(String id) {
      this.queryParameters.replaceValues("id", ImmutableSet.of(id));
      return this;
   }

   /**
    * @param serviceList
    *          the list of services to be enabled for this physical network service provider
    */
   public UpdateNetworkServiceProviderOptions serviceList(String serviceList) {
      this.queryParameters.replaceValues("servicelist", ImmutableSet.of(serviceList));
      return this;
   }

   /**
    * @param state
    *          Enabled/Disabled/Shutdown the physical network service provider
    */
   public UpdateNetworkServiceProviderOptions state(String state) {
      this.queryParameters.replaceValues("state", ImmutableSet.of(state));
      return this;
   }

   public static class Builder {
      /**
       * @see UpdateNetworkServiceProviderOptions#id
       */
      public static UpdateNetworkServiceProviderOptions id(String id) {
         UpdateNetworkServiceProviderOptions options = new UpdateNetworkServiceProviderOptions();
         return options.id(id);
      }

      /**
       * @see UpdateNetworkServiceProviderOptions#serviceList
       */
      public static UpdateNetworkServiceProviderOptions serviceList(String serviceList) {
         UpdateNetworkServiceProviderOptions options = new UpdateNetworkServiceProviderOptions();
         return options.serviceList(serviceList);
      }

      /**
       * @see UpdateNetworkServiceProviderOptions#state(String)
       */
      public static UpdateNetworkServiceProviderOptions state(String state) {
         UpdateNetworkServiceProviderOptions options = new UpdateNetworkServiceProviderOptions();
         return options.state(state);
      }
   }
}
