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
package org.jclouds.cloudstack;

import org.jclouds.cloudstack.features.GlobalAccountApi;
import org.jclouds.cloudstack.features.GlobalAlertApi;
import org.jclouds.cloudstack.features.GlobalCapacityApi;
import org.jclouds.cloudstack.features.GlobalConfigurationApi;
import org.jclouds.cloudstack.features.GlobalDomainApi;
import org.jclouds.cloudstack.features.GlobalHostApi;
import org.jclouds.cloudstack.features.GlobalLimitApi;
import org.jclouds.cloudstack.features.GlobalNetworkApi;
import org.jclouds.cloudstack.features.GlobalOfferingApi;
import org.jclouds.cloudstack.features.GlobalPodApi;
import org.jclouds.cloudstack.features.GlobalStoragePoolApi;
import org.jclouds.cloudstack.features.GlobalTemplateApi;
import org.jclouds.cloudstack.features.GlobalUsageApi;
import org.jclouds.cloudstack.features.GlobalUserApi;
import org.jclouds.cloudstack.features.GlobalVirtualMachineApi;
import org.jclouds.cloudstack.features.GlobalVlanApi;
import org.jclouds.cloudstack.features.GlobalVolumeApi;
import org.jclouds.cloudstack.features.GlobalZoneApi;
import org.jclouds.rest.annotations.Delegate;

/**
 * Provides synchronous access to CloudStack.
 * <p/>
 * 
 * @author Adrian Cole
 * @author liwei
 * @see <a href=
 *      "http://cloudstack.apache.org/docs/api/apidocs-4.3/TOC_Root_Admin.html"
 *      />
 */
public interface CloudStackGlobalApi extends CloudStackDomainApi {

   /**
    * Provides synchronous access to Accounts
    */
   @Delegate
   @Override
   GlobalAccountApi getAccountApi();

   /**
    * Provides synchronous access to Users
    */
   @Delegate
   @Override
   GlobalUserApi getUserApi();

   /**
    * Provides synchronous access to Alerts
    */
   @Delegate
   GlobalAlertApi getAlertApi();

   /**
    * Provides synchronous access to Capacities
    */
   @Delegate
   GlobalCapacityApi getCapacityApi();

   /**
    * Provides synchronous access to Offerings
    */
   @Delegate
   @Override
   GlobalOfferingApi getOfferingApi();

   /**
    * Provides synchronous access to Hosts
    */
   @Delegate
   GlobalHostApi getHostApi();

   /**
    * Provides synchronous access to Storage Pools
    */
   @Delegate
   GlobalStoragePoolApi getStoragePoolApi();

   /**
    * Provides synchronous access to Usage
    */
   @Delegate
   @Override
   GlobalUsageApi getUsageApi();

   /**
    * Provides synchronous access to Configuration
    */
   @Delegate
   @Override
   GlobalConfigurationApi getConfigurationApi();

   /**
    * Provides synchronous access to Domain
    */
   @Delegate
   @Override
   GlobalDomainApi getDomainApi();

   /**
    * Provides synchronous access to Zone
    */
   @Delegate
   @Override
   GlobalZoneApi getZoneApi();

   /**
    * Provides synchronous access to Pod
    */
   @Delegate
   GlobalPodApi getPodApi();

   /**
    * Provides synchronous access to Vlan
    */
   @Delegate
   GlobalVlanApi getVlanApi();
   
   /**
    * Provides synchronous access to Template features.
    */
   @Delegate
   GlobalTemplateApi getTemplateApi();
   
   /**
    * Provides synchronous access to VirtualMachine features.
    */
   @Delegate
   @Override
   GlobalVirtualMachineApi getVirtualMachineApi();
   
   /**
    * Provides synchronous access to Volumes
    */
   @Delegate
   @Override
   GlobalVolumeApi getVolumeApi();
   
   /**
    * Provides synchronous access to Network features.
    */
   @Delegate
   @Override
   GlobalNetworkApi getNetworkApi();
   
   /**
    * Provides synchronous access to Resource Limits
    */
   @Delegate
   @Override
   GlobalLimitApi getLimitApi();
}
