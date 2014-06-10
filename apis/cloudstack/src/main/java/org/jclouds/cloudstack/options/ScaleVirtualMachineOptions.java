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

import java.util.Map;

import org.jclouds.http.options.BaseHttpRequestOptions;

import com.google.common.collect.ImmutableSet;

/**
 * Optional fields for scale virtual machine
 * 
 * @see <a href="http://cloudstack.apache.org/docs/api/apidocs-4.3/root_admin/scaleVirtualMachine.html"/>
 * @author liwei
 */
public class ScaleVirtualMachineOptions extends BaseHttpRequestOptions {
   public static final CreateResourceTagsOptions NONE = new CreateResourceTagsOptions();
   
   /**
    * @param details 
    *           name value pairs of custom parameters for cpu,memory and cpunumber. example details[i].name=value
    */
   public ScaleVirtualMachineOptions details(Map<String, Object> detailsMap) {
       int count = 0;
       for (Map.Entry<String, Object> entry : detailsMap.entrySet()) {
           if(entry.getValue() != null && !entry.getValue().toString().trim().equals("")){
               this.queryParameters.replaceValues(String.format("details[%d].%s", count, entry.getKey()), ImmutableSet.of(entry.getValue().toString()));
           }
       }
       return this;
    }

   public static class Builder {

      public static ScaleVirtualMachineOptions details(Map<String, Object> detailsMap) {
    	  ScaleVirtualMachineOptions options = new ScaleVirtualMachineOptions();
         return options.details(detailsMap);
      }
   }
}
