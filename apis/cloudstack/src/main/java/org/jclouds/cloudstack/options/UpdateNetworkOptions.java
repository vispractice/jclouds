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
 *      href="http://cloudstack.apache.org/docs/api/apidocs-4.3/user/updateNetwork.html"
 *      />
 * @author liwei
 */
public class UpdateNetworkOptions extends BaseHttpRequestOptions {

   public static final UpdateNetworkOptions NONE = new UpdateNetworkOptions();

   /**
    * @param changeCidr
    *          Force update even if cidr type is different
    */
   public UpdateNetworkOptions changeCidr(boolean changeCidr) {
      this.queryParameters.replaceValues("changecidr", ImmutableSet.of(changeCidr + ""));
      return this;
   }

   /**
    * @param displayNetwork
    *           an optional field, whether to the display the network to the end user or not.
    */
   public UpdateNetworkOptions displayNetwork(boolean displayNetwork) {
      this.queryParameters.replaceValues("displaynetwork", ImmutableSet.of(displayNetwork + ""));
      return this;
   }

   /**
    * @param displayText
    *          the new display text for the network
    */
   public UpdateNetworkOptions displayText(String displayText) {
      this.queryParameters.replaceValues("displaytext", ImmutableSet.of(displayText));
      return this;
   }

   /**
    * @param guestVmCidr
    *           CIDR for Guest VMs,Cloudstack allocates IPs to Guest VMs only from this CIDR
    */
   public UpdateNetworkOptions guestVmCidr(String guestVmCidr) {
      this.queryParameters.replaceValues("guestvmcidr", ImmutableSet.of(guestVmCidr));
      return this;
   }

   /**
    * @param name
    *          the new name for the network
    */
   public UpdateNetworkOptions name(String name) {
      this.queryParameters.replaceValues("name", ImmutableSet.of(name));
      return this;
   }

   /**
    * @param networkOfferingId
    *           network offering ID
    */
   public UpdateNetworkOptions networkOfferingId(String networkOfferingId) {
      this.queryParameters.replaceValues("networkofferingid", ImmutableSet.of(networkOfferingId));
      return this;
   }

   /**
    * @param networkDomain
    *           network domain
    */
   public UpdateNetworkOptions networkDomain(String networkDomain) {
      this.queryParameters.replaceValues("networkdomain", ImmutableSet.of(networkDomain));
      return this;
   }

   public static class Builder {
      /**
       * @see UpdateNetworkOptions#changeCidr
       */
      public static UpdateNetworkOptions changeCidr(boolean changeCidr) {
         UpdateNetworkOptions options = new UpdateNetworkOptions();
         return options.changeCidr(changeCidr);
      }

      /**
       * @see UpdateNetworkOptions#displayNetwork
       */
      public static UpdateNetworkOptions displayNetwork(boolean displayNetwork) {
         UpdateNetworkOptions options = new UpdateNetworkOptions();
         return options.displayNetwork(displayNetwork);
      }

      /**
       * @see UpdateNetworkOptions#guestVmCidr(String)
       */
      public static UpdateNetworkOptions guestVmCidr(String guestVmCidr) {
         UpdateNetworkOptions options = new UpdateNetworkOptions();
         return options.guestVmCidr(guestVmCidr);
      }

      /**
       * @see UpdateNetworkOptions#name(String)
       */
      public static UpdateNetworkOptions name(String name) {
         UpdateNetworkOptions options = new UpdateNetworkOptions();
         return options.name(name);
      }

      /**
       * @see UpdateNetworkOptions#networkOfferingId(String)
       */
      public static UpdateNetworkOptions networkOfferingId(String networkOfferingId) {
         UpdateNetworkOptions options = new UpdateNetworkOptions();
         return options.networkOfferingId(networkOfferingId);
      }

      /**
       * @see UpdateNetworkOptions#networkDomain(String)
       */
      public static UpdateNetworkOptions networkDomain(String networkDomain) {
         UpdateNetworkOptions options = new UpdateNetworkOptions();
         return options.networkDomain(networkDomain);
      }

   }
}
