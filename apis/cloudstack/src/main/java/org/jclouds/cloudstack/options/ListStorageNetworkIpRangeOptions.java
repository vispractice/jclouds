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
 * Optional fields for listing storage network ip range
 * 
 * @see <a
 *      href="http://cloudstack.apache.org/docs/api/apidocs-4.3/root_admin/listStorageNetworkIpRange.html"
 *      />
 * @author liwei
 */
public class ListStorageNetworkIpRangeOptions extends BaseHttpRequestOptions {

   public static final ListStorageNetworkIpRangeOptions NONE = new ListStorageNetworkIpRangeOptions();

   /**
    * @param id
    *          optional parameter. Storaget network IP range uuid, if specicied, using it to search the range.
    */
   public ListStorageNetworkIpRangeOptions id(String id) {
      this.queryParameters.replaceValues("id", ImmutableSet.of(id));
      return this;
   }

   /**
    * @param keyword
    *           List by keyword
    */
   public ListStorageNetworkIpRangeOptions keyword(String keyword) {
      this.queryParameters.replaceValues("keyword", ImmutableSet.of(keyword));
      return this;
   }

   /**
    * @param podId
    *           optional parameter. Pod uuid, if specicied and range uuid is absent, using it to search the range.
    */
   public ListStorageNetworkIpRangeOptions podId(String podId) {
      this.queryParameters.replaceValues("podid", ImmutableSet.of(podId));
      return this;
   }
   
   /**
    * @param zoneId
    *          optional parameter. Zone uuid, if specicied and both pod uuid and range uuid are absent, using it to search the range.
    */
   public ListStorageNetworkIpRangeOptions zoneId(String zoneId) {
      this.queryParameters.replaceValues("zoneid", ImmutableSet.of(zoneId));
      return this;
   }

   public static class Builder {
      /**
       * @see ListStorageNetworkIpRangeOptions#id
       */
      public static ListStorageNetworkIpRangeOptions id(String id) {
         ListStorageNetworkIpRangeOptions options = new ListStorageNetworkIpRangeOptions();
         return options.id(id);
      }

      /**
       * @see ListStorageNetworkIpRangeOptions#keyword
       */
      public static ListStorageNetworkIpRangeOptions keyword(String keyword) {
         ListStorageNetworkIpRangeOptions options = new ListStorageNetworkIpRangeOptions();
         return options.keyword(keyword);
      }

      /**
       * @see ListStorageNetworkIpRangeOptions#podId(String)
       */
      public static ListStorageNetworkIpRangeOptions podId(String podId) {
         ListStorageNetworkIpRangeOptions options = new ListStorageNetworkIpRangeOptions();
         return options.podId(podId);
      }
      
      /**
       * @see ListStorageNetworkIpRangeOptions#zoneId(String)
       */
      public static ListStorageNetworkIpRangeOptions zoneId(String zoneId) {
         ListStorageNetworkIpRangeOptions options = new ListStorageNetworkIpRangeOptions();
         return options.zoneId(zoneId);
      }

   }
}
