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
 * Options used to add traffic type
 * 
 * @see <a href=
 *      "http://cloudstack.apache.org/docs/api/apidocs-4.3/root_admin/addTrafficType.html"
 *      />
 * @author liwei
 */
public class AddTrafficTypeOptions extends BaseHttpRequestOptions {

   public static final AddTrafficTypeOptions NONE = new AddTrafficTypeOptions();

   /**
    * @param hypervNetworkLabel
    *           The network name label of the physical device dedicated to this traffic on a Hyperv host
    */
   public AddTrafficTypeOptions hypervNetworkLabel(String hypervNetworkLabel) {
      this.queryParameters.replaceValues("hypervNetworkLabel", ImmutableSet.of(hypervNetworkLabel));
      return this;
   }

   /**
    * @param isolationMethod
    *           Used if physical network has multiple isolation types and traffic type is public. Choose which isolation method. Valid options currently 'vlan' or 'vxlan', defaults to 'vlan'.
    */
   public AddTrafficTypeOptions isolationMethod(String isolationMethod) {
      this.queryParameters.replaceValues("isolationmethod", ImmutableSet.of(isolationMethod));
      return this;

   }

   /**
    * @param kvmNetworkLabel
    *           The network name label of the physical device dedicated to this traffic on a KVM host
    */
   public AddTrafficTypeOptions kvmNetworkLabel(String kvmNetworkLabel) {
      this.queryParameters.replaceValues("kvmnetworklabel", ImmutableSet.of(kvmNetworkLabel));
      return this;
   }

   /**
    * @param vlan
    *           The VLAN id to be used for Management traffic by VMware host
    */
   public AddTrafficTypeOptions vlan(String vlan) {
      this.queryParameters.replaceValues("vlan", ImmutableSet.of(vlan));
      return this;
   }
   
   /**
    * @param vmwareNetworkLabel
    *           The network name label of the physical device dedicated to this traffic on a VMware host
    */
   public AddTrafficTypeOptions vmwareNetworkLabel(String vmwareNetworkLabel) {
      this.queryParameters.replaceValues("vmwarenetworklabel", ImmutableSet.of(vmwareNetworkLabel));
      return this;
   }
   
   /**
    * @param xenNetworkLabel
    *           The network name label of the physical device dedicated to this traffic on a XenServer host
    */
   public AddTrafficTypeOptions xenNetworkLabel(String xenNetworkLabel) {
      this.queryParameters.replaceValues("xennetworklabel", ImmutableSet.of(xenNetworkLabel));
      return this;
   }

   public static class Builder {

      /**
       * @see AddTrafficTypeOptions#hypervNetworkLabel
       */
      public static AddTrafficTypeOptions hypervNetworkLabel(String hypervNetworkLabel) {
         AddTrafficTypeOptions options = new AddTrafficTypeOptions();
         return options.hypervNetworkLabel(hypervNetworkLabel);
      }

      /**
       * @see AddTrafficTypeOptions#isolationMethod
       */
      public static AddTrafficTypeOptions isolationMethod(String isolationMethod) {
         AddTrafficTypeOptions options = new AddTrafficTypeOptions();
         return options.isolationMethod(isolationMethod);
      }

      /**
       * @see AddTrafficTypeOptions#kvmNetworkLabel
       */
      public static AddTrafficTypeOptions kvmNetworkLabel(String kvmNetworkLabel) {
         AddTrafficTypeOptions options = new AddTrafficTypeOptions();
         return options.kvmNetworkLabel(kvmNetworkLabel);
      }

      /**
       * @see AddTrafficTypeOptions#vlan
       */
      public static AddTrafficTypeOptions vlan(String vlan) {
         AddTrafficTypeOptions options = new AddTrafficTypeOptions();
         return options.vlan(vlan);
      }
      
      /**
       * @see AddTrafficTypeOptions#vmwareNetworkLabel
       */
      public static AddTrafficTypeOptions vmwareNetworkLabel(String vmwareNetworkLabel) {
         AddTrafficTypeOptions options = new AddTrafficTypeOptions();
         return options.vmwareNetworkLabel(vmwareNetworkLabel);
      }
      
      /**
       * @see AddTrafficTypeOptions#xenNetworkLabel
       */
      public static AddTrafficTypeOptions xenNetworkLabel(String xenNetworkLabel) {
         AddTrafficTypeOptions options = new AddTrafficTypeOptions();
         return options.xenNetworkLabel(xenNetworkLabel);
      }
   }
}
