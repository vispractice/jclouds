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
 * Options for add nic to virtual machines.
 * 
 * @see <a
 *      href="http://cloudstack.apache.org/docs/api/apidocs-4.3/user/addNicToVirtualMachine.html"
 *      />
 * @author liwei
 */
public class AddNicToVirtualMachineOptions extends BaseHttpRequestOptions {

   public static final AddNicToVirtualMachineOptions NONE = new AddNicToVirtualMachineOptions();

   /**
    * @param ipAddress
    *           IP Address for the new network
    */
   public AddNicToVirtualMachineOptions ipAddress(String ipAddress) {
      this.queryParameters.replaceValues("ipaddress", ImmutableSet.of(ipAddress));
      return this;
   }

   public static class Builder {

      /**
       * @see AddNicToVirtualMachineOptions#ipAddress
       */
      public static AddNicToVirtualMachineOptions ipAddress(String ipAddress) {
         AddNicToVirtualMachineOptions options = new AddNicToVirtualMachineOptions();
         return options.ipAddress(ipAddress);
      }

   }
}
