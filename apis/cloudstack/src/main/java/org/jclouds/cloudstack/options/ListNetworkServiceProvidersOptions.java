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
 *      href="http://cloudstack.apache.org/docs/api/apidocs-4.3/root_admin/listNetworkServiceProviders.html"
 *      />
 * @author liwei
 */
public class ListNetworkServiceProvidersOptions extends BaseHttpRequestOptions {

   public static final ListNetworkServiceProvidersOptions NONE = new ListNetworkServiceProvidersOptions();

   /**
    * @param name
    *          list providers by name
    */
   public ListNetworkServiceProvidersOptions name(String name) {
      this.queryParameters.replaceValues("name", ImmutableSet.of(name));
      return this;
   }

   /**
    * @param keyword
    *           List by keyword
    */
   public ListNetworkServiceProvidersOptions keyword(String keyword) {
      this.queryParameters.replaceValues("keyword", ImmutableSet.of(keyword));
      return this;
   }

   /**
    * @param state
    *          list providers by state
    */
   public ListNetworkServiceProvidersOptions state(String state) {
      this.queryParameters.replaceValues("state", ImmutableSet.of(state));
      return this;
   }
   
   /**
    * @param physicalNetworkId
    *          the Physical Network ID
    */
   public ListNetworkServiceProvidersOptions physicalNetworkId(String physicalNetworkId) {
      this.queryParameters.replaceValues("physicalnetworkid", ImmutableSet.of(physicalNetworkId));
      return this;
   }

   public static class Builder {
      /**
       * @see ListNetworkServiceProvidersOptions#name
       */
      public static ListNetworkServiceProvidersOptions name(String name) {
         ListNetworkServiceProvidersOptions options = new ListNetworkServiceProvidersOptions();
         return options.name(name);
      }

      /**
       * @see ListNetworkServiceProvidersOptions#keyword
       */
      public static ListNetworkServiceProvidersOptions keyword(String keyword) {
         ListNetworkServiceProvidersOptions options = new ListNetworkServiceProvidersOptions();
         return options.keyword(keyword);
      }

      /**
       * @see ListNetworkServiceProvidersOptions#state(String)
       */
      public static ListNetworkServiceProvidersOptions state(String state) {
         ListNetworkServiceProvidersOptions options = new ListNetworkServiceProvidersOptions();
         return options.state(state);
      }
      
      /**
       * @see ListNetworkServiceProvidersOptions#physicalNetworkId(String)
       */
      public static ListNetworkServiceProvidersOptions physicalNetworkId(String physicalNetworkId) {
         ListNetworkServiceProvidersOptions options = new ListNetworkServiceProvidersOptions();
         return options.physicalNetworkId(physicalNetworkId);
      }

   }
}
