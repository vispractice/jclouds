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
 * Optional fields for network restart
 * 
 * @see <a
 *      href="http://cloudstack.apache.org/docs/api/apidocs-4.3/user/restartNetwork.html"
 *      />
 * @author liwei
 */
public class RestartNetworkOptions extends BaseHttpRequestOptions {

   public static final RestartNetworkOptions NONE = new RestartNetworkOptions();

   /**
    * @param cleanUp
    *         If cleanup old network elements
    */
   public RestartNetworkOptions cleanUp(boolean cleanUp) {
      this.queryParameters.replaceValues("cleanup", ImmutableSet.of(cleanUp + ""));
      return this;
   }

   public static class Builder {
      /**
       * @see RestartNetworkOptions#cleanUp
       */
      public static RestartNetworkOptions cleanUp(boolean cleanUp) {
         RestartNetworkOptions options = new RestartNetworkOptions();
         return options.cleanUp(cleanUp);
      }
   }
}
