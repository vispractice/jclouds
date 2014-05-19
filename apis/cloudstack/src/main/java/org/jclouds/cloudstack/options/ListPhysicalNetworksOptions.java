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
 *      href="http://cloudstack.apache.org/docs/api/apidocs-4.3/root_admin/listSupportedNetworkServices.html"
 *      />
 * @author liwei
 */
public class ListPhysicalNetworksOptions extends BaseHttpRequestOptions {

   public static final ListPhysicalNetworksOptions NONE = new ListPhysicalNetworksOptions();

   /**
    * @param provider
    *          network service provider name
    */
   public ListPhysicalNetworksOptions provider(String provider) {
      this.queryParameters.replaceValues("provider", ImmutableSet.of(provider));
      return this;
   }

   /**
    * @param keyword
    *           List by keyword
    */
   public ListPhysicalNetworksOptions keyword(String keyword) {
      this.queryParameters.replaceValues("keyword", ImmutableSet.of(keyword));
      return this;
   }

   /**
    * @param service
    *           network service name to list providers and capabilities of
    */
   public ListPhysicalNetworksOptions service(String service) {
      this.queryParameters.replaceValues("service", ImmutableSet.of(service));
      return this;
   }

   public static class Builder {
      /**
       * @see ListPhysicalNetworksOptions#provider
       */
      public static ListPhysicalNetworksOptions provider(String provider) {
         ListPhysicalNetworksOptions options = new ListPhysicalNetworksOptions();
         return options.provider(provider);
      }

      /**
       * @see ListPhysicalNetworksOptions#keyword
       */
      public static ListPhysicalNetworksOptions keyword(String keyword) {
         ListPhysicalNetworksOptions options = new ListPhysicalNetworksOptions();
         return options.keyword(keyword);
      }

      /**
       * @see ListPhysicalNetworksOptions#service(String)
       */
      public static ListPhysicalNetworksOptions service(String service) {
         ListPhysicalNetworksOptions options = new ListPhysicalNetworksOptions();
         return options.service(service);
      }

   }
}
