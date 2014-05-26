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

import org.jclouds.cloudstack.domain.AsyncCreateResponse;
import org.jclouds.cloudstack.domain.IsolationMethod;
import org.jclouds.cloudstack.domain.NetworkService;
import org.jclouds.cloudstack.domain.NetworkService.Provider;
import org.jclouds.cloudstack.domain.PhysicalNetwork;
import org.jclouds.cloudstack.domain.StorageIPRange;
import org.jclouds.cloudstack.internal.BaseCloudStackApiLiveTest;
import org.jclouds.cloudstack.options.AddNetworkServiceProviderOptions;
import org.jclouds.cloudstack.options.CreateStorageNetworkIpRangeOptions;
import org.jclouds.cloudstack.options.ListNetworkServiceProvidersOptions;
import org.jclouds.cloudstack.options.UpdateNetworkServiceProviderOptions;
import org.jclouds.cloudstack.options.UpdatePhysicalNetworkOptions;
import org.jclouds.cloudstack.options.UpdateStorageNetworkIpRangeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests behavior of {@code GlobalNetworkApi}
 *
 * @author liwei
 */
@Test(groups = "live", singleThreaded = true, testName = "GlobalNetworkApiLiveTest")
public class GlobalNetworkApiLiveTest extends BaseCloudStackApiLiveTest {

   @Test(groups = "live", enabled = true)
   public void testListPhysicalNetworks() throws Exception {
      skipIfNotGlobalAdmin();

      Set<PhysicalNetwork> pns = globalAdminClient.getNetworkApi().listPhysicalNetworks();
      
   }
   
   @Test(groups = "live", enabled = false)
   public void testListSupportedNetworkServices() throws Exception {
      skipIfNotGlobalAdmin();

      Set<NetworkService> pns = globalAdminClient.getNetworkApi().listSupportedNetworkServices();
      
   }
   
   @Test(groups = "live", enabled = true)
   public void testListNetworkServiceProviders() throws Exception {
      skipIfNotGlobalAdmin();

      Set<Provider> pns = globalAdminClient.getNetworkApi().listNetworkServiceProviders(
    		  new ListNetworkServiceProvidersOptions().physicalNetworkId("938a3c3f-ba16-472e-a45f-7bb177228ab3"));
      Assert.assertTrue(pns.size() > 0);
   }
   
   @Test(groups = "live", enabled = true)
   public void testListStorageNetworkIpRange() throws Exception {
      skipIfNotGlobalAdmin();

      Set<StorageIPRange> pns = globalAdminClient.getNetworkApi().listStorageNetworkIpRange();
      Assert.assertTrue(pns.size() > 0);
   }
   
   @Test(groups = "live", enabled = false)
   public void testUpdateStorageNetworkIpRange() throws Exception {
      skipIfNotGlobalAdmin();

      AsyncCreateResponse pns = globalAdminClient.getNetworkApi().
    		  updateStorageNetworkIpRange("bc95b2df-dded-44c5-b4b9-d5e445dd830d", 
    				  new UpdateStorageNetworkIpRangeOptions().endIp("192.168.235.211"));
      Assert.assertNotNull(pns.getJobId());
   }
   
   @Test(groups = "live", enabled = false)
   public void testCreatePhysicalNetwork() throws Exception {
      skipIfNotGlobalAdmin();

      AsyncCreateResponse response = 
    		  globalAdminClient.getNetworkApi().createPhysicalNetwork("jclouds-p1", "a7237cc7-6a66-49a7-ad28-2180227c80a2");
      Assert.assertNotNull(response.getJobId());
   }
   
   @Test(groups = "live", enabled = false)
   public void testDeletePhysicalNetwork() throws Exception {
      skipIfNotGlobalAdmin();

      AsyncCreateResponse response = 
    		  globalAdminClient.getNetworkApi().deletePhysicalNetwork("60482748-97d4-4102-b795-de5c8612625e");
      Assert.assertNotNull(response.getJobId());
   }
   
   @Test(groups = "live", enabled = false)
   public void testUpdatePhysicalNetwork() throws Exception {
      skipIfNotGlobalAdmin();

      AsyncCreateResponse response = 
    		  globalAdminClient.getNetworkApi().updatePhysicalNetwork(
    				  new UpdatePhysicalNetworkOptions().id("60482748-97d4-4102-b795-de5c8612625e").networkSpeed("10"));
     Assert.assertNotNull(response.getJobId());
   }
   
   @Test(groups = "live", enabled = false)
   public void testDeleteNetworkServiceProvider() throws Exception {
      skipIfNotGlobalAdmin();

      AsyncCreateResponse response = 
    		  globalAdminClient.getNetworkApi().deleteNetworkServiceProvider("e0714cf0-7519-4bee-9cf2-a351b22cbd15");
     Assert.assertNotNull(response.getJobId());
   }
   
   @Test(groups = "live", enabled = false)
   public void testAddNetworkServiceProvider() throws Exception {
      skipIfNotGlobalAdmin();

      AsyncCreateResponse response = 
    		  globalAdminClient.getNetworkApi().addNetworkServiceProvider("VirtualRouter","938a3c3f-ba16-472e-a45f-7bb177228ab3",
    			new AddNetworkServiceProviderOptions().serviceList("Dhcp,Vpn"));
     Assert.assertNotNull(response.getJobId());
   }
   
   @Test(groups = "live", enabled = false)
   public void testUpdateNetworkServiceProvider() throws Exception {
      skipIfNotGlobalAdmin();

      AsyncCreateResponse response = 
    		  globalAdminClient.getNetworkApi().updateNetworkServiceProvider(
    				  new UpdateNetworkServiceProviderOptions().id("50ae7d01-2fbe-4a61-9751-c089e5249006").serviceList("Dhcp,Vpn,Dns"));
     Assert.assertNotNull(response.getJobId());
   }
   
   @Test(groups = "live", enabled = false)
   public void testCreateStorageNetworkIpRange() throws Exception {
      skipIfNotGlobalAdmin();

      AsyncCreateResponse response = 
    		  globalAdminClient.getNetworkApi().
    		  createStorageNetworkIpRange("192.168.1.1", "255.255.255.0", "bdf97097-f04e-46a7-b937-57c2b7546ecd", "192.168.1.20",
    				  new CreateStorageNetworkIpRangeOptions().endIp("192.168.1.29"));
     Assert.assertNotNull(response.getJobId());
   }
   
   @Test(groups = "live", enabled = false)
   public void testDeleteStorageNetworkIpRange() throws Exception {
      skipIfNotGlobalAdmin();

      AsyncCreateResponse response = 
    		  globalAdminClient.getNetworkApi().deleteStorageNetworkIpRange("16814506-9e54-4521-b118-cf9ac281e396");
     Assert.assertNotNull(response.getJobId());
   }

   @Test(groups = "live", enabled = true)
   public void testListNetworkIsolationMethods() throws Exception {
      skipIfNotGlobalAdmin();

      Set<IsolationMethod> pns = globalAdminClient.getNetworkApi().listNetworkIsolationMethods();
      Assert.assertTrue(pns.size() > 0);
   }
}
