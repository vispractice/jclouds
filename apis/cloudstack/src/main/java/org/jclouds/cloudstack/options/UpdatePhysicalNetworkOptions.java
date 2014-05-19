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
 * Optional fields for network update
 * 
 * @see <a
 *      href="http://cloudstack.apache.org/docs/api/apidocs-4.3/root_admin/updatePhysicalNetwork.html"
 *      />
 * @author liwei
 */
public class UpdatePhysicalNetworkOptions extends BaseHttpRequestOptions {

   public static final UpdatePhysicalNetworkOptions NONE = new UpdatePhysicalNetworkOptions();

   /**
    * @param id
    *          physical network id
    */
   public UpdatePhysicalNetworkOptions id(String id) {
      this.queryParameters.replaceValues("id", ImmutableSet.of(id));
      return this;
   }

   /**
    * @param networkSpeed
    *           the speed for the physical network[1G/10G]
    */
   public UpdatePhysicalNetworkOptions networkSpeed(String networkSpeed) {
      this.queryParameters.replaceValues("networkspeed", ImmutableSet.of(networkSpeed));
      return this;
   }

   /**
    * @param state
    *           Enabled/Disabled
    */
   public UpdatePhysicalNetworkOptions state(String state) {
      this.queryParameters.replaceValues("state", ImmutableSet.of(state));
      return this;
   }

   /**
    * @param tags
    *          Tag the physical network
    */
   public UpdatePhysicalNetworkOptions tags(String tags) {
      this.queryParameters.replaceValues("tags", ImmutableSet.of(tags));
      return this;
   }
   
   /**
    * @param vlan
    *          the VLAN for the physical network
    */
   public UpdatePhysicalNetworkOptions vlan(String vlan) {
      this.queryParameters.replaceValues("vlan", ImmutableSet.of(vlan));
      return this;
   }

   public static class Builder {
      /**
       * @see UpdatePhysicalNetworkOptions#id
       */
      public static UpdatePhysicalNetworkOptions id(String id) {
         UpdatePhysicalNetworkOptions options = new UpdatePhysicalNetworkOptions();
         return options.id(id);
      }

      /**
       * @see UpdatePhysicalNetworkOptions#networkSpeed
       */
      public static UpdatePhysicalNetworkOptions networkSpeed(String networkSpeed) {
         UpdatePhysicalNetworkOptions options = new UpdatePhysicalNetworkOptions();
         return options.networkSpeed(networkSpeed);
      }

      /**
       * @see UpdatePhysicalNetworkOptions#state(String)
       */
      public static UpdatePhysicalNetworkOptions state(String state) {
         UpdatePhysicalNetworkOptions options = new UpdatePhysicalNetworkOptions();
         return options.state(state);
      }

      /**
       * @see UpdatePhysicalNetworkOptions#tags(String)
       */
      public static UpdatePhysicalNetworkOptions tags(String tags) {
         UpdatePhysicalNetworkOptions options = new UpdatePhysicalNetworkOptions();
         return options.tags(tags);
      }

      /**
       * @see UpdatePhysicalNetworkOptions#vlan(String)
       */
      public static UpdatePhysicalNetworkOptions vlan(String vlan) {
         UpdatePhysicalNetworkOptions options = new UpdatePhysicalNetworkOptions();
         return options.vlan(vlan);
      }
   }
}
