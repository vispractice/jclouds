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
 * Options for restore virtual machines.
 * 
 * @see <a
 *      href="http://cloudstack.apache.org/docs/api/apidocs-4.3/user/restoreVirtualMachine.html"
 *      />
 * @author liwei
 */
public class RestoreVirtualMachineOptions extends BaseHttpRequestOptions {

   public static final RestoreVirtualMachineOptions NONE = new RestoreVirtualMachineOptions();

   /**
    * @param templateId
    *           an optional template Id to restore vm from the new template. This can be an ISO id in case of restore vm deployed using ISO
    */
   public RestoreVirtualMachineOptions templateId(String templateId) {
      this.queryParameters.replaceValues("templateid", ImmutableSet.of(templateId));
      return this;
   }

   public static class Builder {

      /**
       * @see RestoreVirtualMachineOptions#templateId
       */
      public static RestoreVirtualMachineOptions templateId(String templateId) {
         RestoreVirtualMachineOptions options = new RestoreVirtualMachineOptions();
         return options.templateId(templateId);
      }

   }
}
