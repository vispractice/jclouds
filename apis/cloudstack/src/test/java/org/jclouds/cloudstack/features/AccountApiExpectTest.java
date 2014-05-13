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

import java.util.Set;

import org.jclouds.cloudstack.CloudStackContext;
import org.jclouds.cloudstack.domain.Account;
import org.jclouds.cloudstack.domain.User;
import org.jclouds.cloudstack.internal.BaseCloudStackExpectTest;
import org.jclouds.date.internal.SimpleDateFormatDateService;
import org.jclouds.http.HttpRequest;
import org.jclouds.http.HttpResponse;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableSet;

/**
 * Test the CloudStack AccountApi
 *
 * @author Andrei Savu
 */
@Test(groups = "unit", testName = "AccountApiExpectTest")
public class AccountApiExpectTest extends BaseCloudStackExpectTest<AccountApi> {


   public void testListAccountsWhenResponseIs2xx() {

      AccountApi client = requestSendsResponse(
         HttpRequest.builder()
            .method("GET")
            .endpoint("http://localhost:8080/client/api?response=json&command=listAccounts&listAll=true&apiKey=identity&signature=yMZYMZxzFlaUsbfxtuppMwNhpXI%3D")
            .addHeader("Accept", "application/json")
            .build(),
         HttpResponse.builder()
            .statusCode(200)
            .payload(payloadFromResource("/listaccountsresponse.json"))
            .build());

      Set<User> users = ImmutableSet.of(
         User.builder()
            .id("e77e9753-824e-492f-a8e9-96952e32e1c6")
            .name("jclouds")
            .firstName("jming")
            .lastName("jxin")
            .email("jclouds@vispractice.com")
            .created(new SimpleDateFormatDateService().iso8601SecondsDateParse("2014-05-12T15:53:32+0800"))
            .state(User.State.ENABLED)
            .account("jclouds")
            .accountId("93e04821-b25c-4acf-ae09-219a6e0a7a8f")
            .accountType(Account.Type.ADMIN)
            .domainId("0a7e7be2-9d00-11e3-87a7-005056a03a33")
            .domain("ROOT")
            .apiKey("APIKEY")
            .secretKey("SECRETKEY")
            .isCallerChildDomain(false)
            .isDefault(false).build());

      assertEquals(client.listAccounts(),
         ImmutableSet.of(Account.builder()
            .id("93e04821-b25c-4acf-ae09-219a6e0a7a8f")
            .name("jclouds")
            .type(Account.Type.ADMIN)
            .domainId("457")
            .domain("0a7e7be2-9d00-11e3-87a7-005056a03a33")
            .receivedBytes(0)
            .sentBytes(0)
            .vmLimit(null)
            .vmTotal(0)
            .ipAvailable(null)
            .ipLimit(null)
            .ipTotal(0)
            .volumeLimit(null)
            .volumeTotal(0)
            .volumeAvailable(null)
            .snapshotLimit(null)
            .snapshotTotal(0)
            .snapshotAvailable(null)
            .templateLimit(null)
            .templateTotal(0)
            .templateAvailable(null)
            .vmAvailable(null)
            .state(Account.State.ENABLED)
            .users(users).build()));
   }

   @Override
   protected AccountApi clientFrom(CloudStackContext context) {
      return context.getApi().getAccountApi();
   }
}
