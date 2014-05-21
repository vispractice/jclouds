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
 * Options used to update traffic type
 * 
 * @see <a href=
 *      "http://cloudstack.apache.org/docs/api/apidocs-4.3/root_admin/updateTrafficType.html"
 *      />
 * @author liwei
 */
public class UpdateTrafficTypeOptions extends BaseHttpRequestOptions {

   public static final UpdateTrafficTypeOptions NONE = new UpdateTrafficTypeOptions();

   /**
    * @param hypervNetworkLabel
    *           The network name label of the physical device dedicated to this traffic on a Hyperv host
    */
   public UpdateTrafficTypeOptions hypervNetworkLabel(String hypervNetworkLabel) {
      this.queryParameters.replaceValues("hypervNetworkLabel", ImmutableSet.of(hypervNetworkLabel));
      return this;
   }

   /**
    * @param kvmNetworkLabel
    *           The network name label of the physical device dedicated to this traffic on a KVM host
    */
   public UpdateTrafficTypeOptions kvmNetworkLabel(String kvmNetworkLabel) {
      this.queryParameters.replaceValues("kvmnetworklabel", ImmutableSet.of(kvmNetworkLabel));
      return this;
   }

   /**
    * @param vmwareNetworkLabel
    *           The network name label of the physical device dedicated to this traffic on a VMware host
    */
   public UpdateTrafficTypeOptions vmwareNetworkLabel(String vmwareNetworkLabel) {
      this.queryParameters.replaceValues("vmwarenetworklabel", ImmutableSet.of(vmwareNetworkLabel));
      return this;
   }
   
   /**
    * @param xenNetworkLabel
    *           The network name label of the physical device dedicated to this traffic on a XenServer host
    */
   public UpdateTrafficTypeOptions xenNetworkLabel(String xenNetworkLabel) {
      this.queryParameters.replaceValues("xennetworklabel", ImmutableSet.of(xenNetworkLabel));
      return this;
   }

   public static class Builder {

      /**
       * @see UpdateTrafficTypeOptions#hypervNetworkLabel
       */
      public static UpdateTrafficTypeOptions hypervNetworkLabel(String hypervNetworkLabel) {
         UpdateTrafficTypeOptions options = new UpdateTrafficTypeOptions();
         return options.hypervNetworkLabel(hypervNetworkLabel);
      }

      /**
       * @see UpdateTrafficTypeOptions#kvmNetworkLabel
       */
      public static UpdateTrafficTypeOptions kvmNetworkLabel(String kvmNetworkLabel) {
         UpdateTrafficTypeOptions options = new UpdateTrafficTypeOptions();
         return options.kvmNetworkLabel(kvmNetworkLabel);
      }
      
      /**
       * @see UpdateTrafficTypeOptions#vmwareNetworkLabel
       */
      public static UpdateTrafficTypeOptions vmwareNetworkLabel(String vmwareNetworkLabel) {
         UpdateTrafficTypeOptions options = new UpdateTrafficTypeOptions();
         return options.vmwareNetworkLabel(vmwareNetworkLabel);
      }
      
      /**
       * @see UpdateTrafficTypeOptions#xenNetworkLabel
       */
      public static UpdateTrafficTypeOptions xenNetworkLabel(String xenNetworkLabel) {
         UpdateTrafficTypeOptions options = new UpdateTrafficTypeOptions();
         return options.xenNetworkLabel(xenNetworkLabel);
      }
   }
}
