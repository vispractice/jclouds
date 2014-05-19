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
package org.jclouds.cloudstack.features;

import java.util.Set;

import org.jclouds.cloudstack.domain.NetworkService;
import org.jclouds.cloudstack.domain.NetworkService.Provider;
import org.jclouds.cloudstack.domain.PhysicalNetwork;
import org.jclouds.cloudstack.domain.StorageIPRange;
import org.jclouds.cloudstack.internal.BaseCloudStackApiLiveTest;
import org.testng.annotations.Test;

/**
 * Tests behavior of {@code GlobalNetworkApi}
 *
 * @author liwei
 */
@Test(groups = "live", singleThreaded = true, testName = "GlobalNetworkApiLiveTest")
public class GlobalNetworkApiLiveTest extends BaseCloudStackApiLiveTest {

   @Test(groups = "live", enabled = false)
   public void testListPhysicalNetworks() throws Exception {
      skipIfNotGlobalAdmin();

      Set<PhysicalNetwork> pns = globalAdminClient.getNetworkApi().listPhysicalNetworks();
      
   }
   
   @Test(groups = "live", enabled = false)
   public void testListSupportedNetworkServices() throws Exception {
      skipIfNotGlobalAdmin();

      Set<NetworkService> pns = globalAdminClient.getNetworkApi().listSupportedNetworkServices();
      
   }
   
   @Test(groups = "live", enabled = false)
   public void testListNetworkServiceProviders() throws Exception {
      skipIfNotGlobalAdmin();

      Set<Provider> pns = globalAdminClient.getNetworkApi().listNetworkServiceProviders();
      
   }
   
   @Test(groups = "live", enabled = true)
   public void testListStorageNetworkIpRange() throws Exception {
      skipIfNotGlobalAdmin();

      Set<StorageIPRange> pns = globalAdminClient.getNetworkApi().listStorageNetworkIpRange();
      
   }

}
