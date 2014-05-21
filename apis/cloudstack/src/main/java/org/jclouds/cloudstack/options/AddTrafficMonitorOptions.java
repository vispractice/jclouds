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
 * Options used to add traffic monitor
 * 
 * @see <a href=
 *      "http://cloudstack.apache.org/docs/api/apidocs-4.3/root_admin/addTrafficMonitor.html"
 *      />
 * @author liwei
 */
public class AddTrafficMonitorOptions extends BaseHttpRequestOptions {

   public static final AddTrafficMonitorOptions NONE = new AddTrafficMonitorOptions();

   /**
    * @param excludeZones
    *           Traffic going into the listed zones will not be metered
    */
   public AddTrafficMonitorOptions excludeZones(String excludeZones) {
      this.queryParameters.replaceValues("excludezones", ImmutableSet.of(excludeZones));
      return this;
   }
   
   /**
    * @param includeZones
    *          Traffic going into the listed zones will be metered
    */
   public AddTrafficMonitorOptions includeZones(String includeZones) {
      this.queryParameters.replaceValues("includezones", ImmutableSet.of(includeZones));
      return this;
   }

   public static class Builder {

      /**
       * @see AddTrafficMonitorOptions#excludeZones
       */
      public static AddTrafficMonitorOptions excludeZones(String excludeZones) {
         AddTrafficMonitorOptions options = new AddTrafficMonitorOptions();
         return options.excludeZones(excludeZones);
      }
      
      /**
       * @see AddTrafficMonitorOptions#includeZones
       */
      public static AddTrafficMonitorOptions includeZones(String includeZones) {
         AddTrafficMonitorOptions options = new AddTrafficMonitorOptions();
         return options.includeZones(includeZones);
      }
   }
}
