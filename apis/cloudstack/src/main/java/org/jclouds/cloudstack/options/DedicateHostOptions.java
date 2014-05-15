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
 * Options to the GlobalHostApi.dedicateHost() API call
 *
 * @author liwei
 */
public class DedicateHostOptions extends BaseHttpRequestOptions {

   public static final DedicateHostOptions NONE = new DedicateHostOptions();

   /**
    * @param the name of the account which needs dedication. Must be used with domainId.
    */
   public DedicateHostOptions account(String account) {
      this.queryParameters.replaceValues("account", ImmutableSet.of(account));
      return this;
   }

   public static class Builder {

      /**
       * @param the name of the account which needs dedication. Must be used with domainId.
       */
      public static DedicateHostOptions account(String account) {
         return new DedicateHostOptions().account(account);
      }

   }
}
