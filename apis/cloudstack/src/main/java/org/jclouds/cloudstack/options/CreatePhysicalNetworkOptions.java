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
 * Optional fields for create physical network
 * 
 * @see <a
 *      href="http://cloudstack.apache.org/docs/api/apidocs-4.3/root_admin/createPhysicalNetwork.html"
 *      />
 * @author liwei
 */
public class CreatePhysicalNetworkOptions extends BaseHttpRequestOptions {

   public static final CreatePhysicalNetworkOptions NONE = new CreatePhysicalNetworkOptions();

   /**
    * @param broadcastDomainRange
    *         the broadcast domain range for the physical network[Pod or Zone]. In Acton release it can be Zone only in Advance zone, and Pod in Basic
    */
   public CreatePhysicalNetworkOptions broadcastDomainRange(String broadcastDomainRange) {
      this.queryParameters.replaceValues("broadcastdomainrange", ImmutableSet.of(broadcastDomainRange));
      return this;
   }

   /**
    * @param domainId
    *           the isolation method for the physical network[VLAN/L3/GRE]
    */
   public CreatePhysicalNetworkOptions isolationMethods(String isolationMethods) {
      this.queryParameters.replaceValues("isolationmethods", ImmutableSet.of(isolationMethods));
      return this;
   }
   
   /**
    * @param domainId
    *          domain ID of the account owning a physical network
    */
   public CreatePhysicalNetworkOptions domainId(String domainId) {
      this.queryParameters.replaceValues("domainid", ImmutableSet.of(domainId));
      return this;
   }

   /**
    * @param networkSpeed
    *          the speed for the physical network[1G/10G]
    */
   public CreatePhysicalNetworkOptions networkSpeed(String networkSpeed) {
      this.queryParameters.replaceValues("networkspeed", ImmutableSet.of(networkSpeed));
      return this;
   }

   /**
    * @param tags
    *           Tag the physical network
    */
   public CreatePhysicalNetworkOptions tags(String tags) {
      this.queryParameters.replaceValues("tags", ImmutableSet.of(tags));
      return this;
   }

   /**
    * @param vlan
    *         the VLAN for the physical network
    */
   public CreatePhysicalNetworkOptions vlan(String vlan) {
      this.queryParameters.replaceValues("vlan", ImmutableSet.of(vlan));
      return this;
   }

   public static class Builder {
      /**
       * @see CreatePhysicalNetworkOptions#broadcastDomainRange
       */
      public static CreatePhysicalNetworkOptions broadcastDomainRange(String broadcastDomainRange) {
         CreatePhysicalNetworkOptions options = new CreatePhysicalNetworkOptions();
         return options.broadcastDomainRange(broadcastDomainRange);
      }

      /**
       * @see CreatePhysicalNetworkOptions#isolationMethods
       */
      public static CreatePhysicalNetworkOptions isolationMethods(String isolationMethods) {
         CreatePhysicalNetworkOptions options = new CreatePhysicalNetworkOptions();
         return options.isolationMethods(isolationMethods);
      }

      /**
       * @see CreatePhysicalNetworkOptions#domainId(String)
       */
      public static CreatePhysicalNetworkOptions domainId(String domainId) {
         CreatePhysicalNetworkOptions options = new CreatePhysicalNetworkOptions();
         return options.domainId(domainId);
      }

      /**
       * @see CreatePhysicalNetworkOptions#networkSpeed(String)
       */
      public static CreatePhysicalNetworkOptions networkSpeed(String networkSpeed) {
         CreatePhysicalNetworkOptions options = new CreatePhysicalNetworkOptions();
         return options.networkSpeed(networkSpeed);
      }

      /**
       * @see CreatePhysicalNetworkOptions#tags(String)
       */
      public static CreatePhysicalNetworkOptions tags(String tags) {
         CreatePhysicalNetworkOptions options = new CreatePhysicalNetworkOptions();
         return options.tags(tags);
      }

      /**
       * @see CreatePhysicalNetworkOptions#vlan(String)
       */
      public static CreatePhysicalNetworkOptions vlan(String vlan) {
         CreatePhysicalNetworkOptions options = new CreatePhysicalNetworkOptions();
         return options.vlan(vlan);
      }

   }
}
