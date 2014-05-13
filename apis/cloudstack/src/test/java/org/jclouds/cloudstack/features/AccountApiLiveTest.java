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

import static org.testng.Assert.assertEquals;

import org.jclouds.cloudstack.domain.Account;
import org.jclouds.cloudstack.domain.User;
import org.jclouds.cloudstack.internal.BaseCloudStackApiLiveTest;
import org.testng.annotations.Test;

/**
 * Tests behavior of {@code AccountApi}
 * 
 * @author Adrian Cole
 */
@Test(groups = "live", singleThreaded = true, testName = "AccountApiLiveTest")
public class AccountApiLiveTest extends BaseCloudStackApiLiveTest {

   @Test
   public void testListAccounts() throws Exception {
      for (Account securityAccount : client.getAccountApi().listAccounts())
         checkAccount(securityAccount);
   }

   protected void checkAccount(Account account) {
      assert account.getId() != null : account;
      assertEquals(account.toString(), client.getAccountApi().getAccount(account.getId()).toString());
      assert account.getName() != null : account;
      assert account.getType() != null && account.getType() != Account.Type.UNRECOGNIZED : account;
      assert account.getDomain() != null : account;
      assert account.getDomainId() != null : account;
      assert account.getUsers() != null : account;
      for (User user : account.getUsers()) {
         assert user.getName() != null : user;
         assert user.getAccountType().equals(account.getType()) : user;
         assert user.getDomain().equals(account.getDomain()) : user;
         assert user.getDomainId().equals(account.getDomainId()) : user;
         assert user.getCreated() != null : user;
         assert user.getEmail() != null : user;
         assert user.getLastName() != null : user;
         assert user.getFirstName() != null : user;
         assert user.getId() != null : user;
         assert user.getState() != null : user;
      }
      assert account.getIpAvailable() == null || account.getIpAvailable() >= 0 : account;
      assert account.getIpLimit() == null || account.getIpLimit() >= 0 : account;
      assert account.getIpTotal() >= 0 : account;
      assert account.getReceivedBytes() >= 0 : account;
      assert account.getSentBytes() >= 0 : account;
      assert account.getSnapshotAvailable() == null || account.getSnapshotAvailable() >= 0 : account;
      assert account.getSnapshotLimit() == null || account.getSnapshotLimit() >= 0 : account;
      assert account.getSnapshotTotal() >= 0 : account;
      assert account.getState() != null && account.getState() != Account.State.UNRECOGNIZED : account;
      assert account.getTemplateAvailable() == null || account.getTemplateAvailable() >= 0 : account;
      assert account.getTemplateLimit() == null || account.getTemplateLimit() >= 0 : account;
      assert account.getTemplateTotal() >= 0 : account;
      assert account.getVmAvailable() == null || account.getVmAvailable() >= 0 : account;
      assert account.getVmLimit() == null || account.getVmLimit() >= 0 : account;
      assert account.getVmTotal() >= 0 : account;
      assert account.getVolumeAvailable() == null || account.getVolumeAvailable() >= 0 : account;
      assert account.getVolumeLimit() == null || account.getVolumeLimit() >= 0 : account;
      assert account.getVolumeTotal() >= 0 : account;
   }

}
