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
 * Options used to add traffic type
 * 
 * @see <a href=
 *      "http://cloudstack.apache.org/docs/api/apidocs-4.3/root_admin/listTrafficTypeImplementors.html"
 *      />
 * @author liwei
 */
public class ListTrafficTypeImplementorsOptions extends BaseHttpRequestOptions {

   public static final ListTrafficTypeImplementorsOptions NONE = new ListTrafficTypeImplementorsOptions();

   /**
    * @param keyword
    *           List by keyword
    */
   public ListTrafficTypeImplementorsOptions keyword(String keyword) {
      this.queryParameters.replaceValues("keyword", ImmutableSet.of(keyword));
      return this;
   }
   
   /**
    * @param trafficType
    *           Optional. The network traffic type, if specified, return its implementor. Otherwise, return all traffic types with their implementor
    */
   public ListTrafficTypeImplementorsOptions trafficType(String trafficType) {
      this.queryParameters.replaceValues("traffictype", ImmutableSet.of(trafficType));
      return this;
   }

   public static class Builder {

      /**
       * @see ListTrafficTypeImplementorsOptions#keyword
       */
      public static ListTrafficTypeImplementorsOptions keyword(String keyword) {
         ListTrafficTypeImplementorsOptions options = new ListTrafficTypeImplementorsOptions();
         return options.keyword(keyword);
      }
      
      /**
       * @see ListTrafficTypeImplementorsOptions#trafficType
       */
      public static ListTrafficTypeImplementorsOptions trafficType(String trafficType) {
         ListTrafficTypeImplementorsOptions options = new ListTrafficTypeImplementorsOptions();
         return options.trafficType(trafficType);
      }
   }
}
