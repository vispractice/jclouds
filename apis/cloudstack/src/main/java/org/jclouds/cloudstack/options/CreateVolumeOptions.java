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

import com.google.common.collect.ImmutableSet;

/**
 * Options used to control how a volume is created
 * 
 * @see <a href=
 *      "http://cloudstack.apache.org/docs/api/apidocs-4.3/user/createVolume.html"
 *      />
 * @author gaozheng
 */
public class CreateVolumeOptions extends AccountInDomainOptions {

   public static final CreateVolumeOptions NONE = new CreateVolumeOptions();

   public CreateVolumeOptions displayVolume(boolean displayVolume) {
      this.queryParameters.replaceValues("displayvolume", ImmutableSet.of(displayVolume + ""));
      return this;
   }

   public CreateVolumeOptions maxIops(long maxIops) {
      this.queryParameters.replaceValues("maxiops", ImmutableSet.of(maxIops + ""));
      return this;
   }
   
   public CreateVolumeOptions minIops(long minIops) {
       this.queryParameters.replaceValues("miniops", ImmutableSet.of(minIops + ""));
       return this;
    }
   
   public CreateVolumeOptions projectId(String projectId) {
       this.queryParameters.replaceValues("projectid", ImmutableSet.of(projectId));
       return this;
    }
   
   public CreateVolumeOptions virtualMachineId(String virtualMachineId) {
       this.queryParameters.replaceValues("virtualmachineid", ImmutableSet.of(virtualMachineId));
       return this;
    }
   
   @Override
   public CreateVolumeOptions accountInDomain(String account, String domain) {
      return CreateVolumeOptions.class.cast(super.accountInDomain(account, domain));
   }
   
   public static class Builder {
      public static CreateVolumeOptions displayVolume(boolean displayVolume) {
         CreateVolumeOptions options = new CreateVolumeOptions();
         return options.displayVolume(displayVolume);
      }
      
      public static CreateVolumeOptions maxIops(long maxIops) {
          CreateVolumeOptions options = new CreateVolumeOptions();
          return options.maxIops(maxIops);
       }
      
      public static CreateVolumeOptions minIops(long minIops) {
          CreateVolumeOptions options = new CreateVolumeOptions();
          return options.minIops(minIops);
       }
      
      public static CreateVolumeOptions projectId(String projectId) {
          CreateVolumeOptions options = new CreateVolumeOptions();
          return options.projectId(projectId);
       }
      
      public static CreateVolumeOptions virtualMachineId(String virtualMachineId) {
          CreateVolumeOptions options = new CreateVolumeOptions();
          return options.virtualMachineId(virtualMachineId);
       }
      
      public static CreateVolumeOptions accountInDomain(String account, String domain) {
          CreateVolumeOptions options = new CreateVolumeOptions();
          return options.accountInDomain(account, domain);
       }

   }
}
