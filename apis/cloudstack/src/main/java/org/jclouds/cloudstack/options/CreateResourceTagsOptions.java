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

import org.jclouds.cloudstack.domain.ResourceTag;
import org.jclouds.http.options.BaseHttpRequestOptions;

import com.google.common.collect.ImmutableSet;

/**
 * Optional fields for tags creation
 * 
 * @see <a href="http://cloudstack.apache.org/docs/api/apidocs-4.3/TOC_User.html"/>
 * @author gaozheng
 */
public class CreateResourceTagsOptions extends BaseHttpRequestOptions {
   public static final CreateResourceTagsOptions NONE = new CreateResourceTagsOptions();
   
   /**
    * @param resourceIds 
    *           list of resources to create the tags for
    */
   public CreateResourceTagsOptions resourceIds(String resourceIds) {
       this.queryParameters.replaceValues("resourceids", ImmutableSet.of(resourceIds));
       return this;
    }
   
   /**
    * @param resourceType 
    *           type of the resource
    */
   public CreateResourceTagsOptions resourceType(ResourceTag.Type resourceType) {
       this.queryParameters.replaceValues("resourcetype", ImmutableSet.of(resourceType.toString()));
       return this;
    }
   
   /**
    * @param resourceIds 
    *           Map of tags (key/value pairs)
    */
   public CreateResourceTagsOptions tags(Map<String, String> tagMap) {
       int count = 0;
       for (Map.Entry<String, String> entry : tagMap.entrySet()) {
           this.queryParameters.replaceValues(String.format("tags[%d].key", count), ImmutableSet.of(entry.getKey()));
           if(entry.getValue() != null && !entry.getValue().trim().equals("")){
               this.queryParameters.replaceValues(String.format("tags[%d].value", count), ImmutableSet.of(entry.getValue()));
           }
          count += 1;
       }
       return this;
    }
   
   /**
    * @param customer 
    *           identifies client specific tag. When the value is not null, the tag can't be used by cloudStack code internally
    */
   public CreateResourceTagsOptions customer(String customer) {
       this.queryParameters.replaceValues("customer", ImmutableSet.of(customer));
       return this;
    }

   public static class Builder {

      /**
       * @see CreateResourceTagsOptions#filter
       */
      public static CreateResourceTagsOptions resourceIds(String resourceIds) {
         CreateResourceTagsOptions options = new CreateResourceTagsOptions();
         return options.resourceIds(resourceIds);
      }

      /**
       * @see CreateResourceTagsOptions#domainId
       */
      public static CreateResourceTagsOptions resourceType(ResourceTag.Type resourceType) {
         CreateResourceTagsOptions options = new CreateResourceTagsOptions();
         return options.resourceType(resourceType);
      }

      /**
       * @see CreateResourceTagsOptions#accountInDomain
       */
      public static CreateResourceTagsOptions tags(Map<String, String> tagMap) {
         CreateResourceTagsOptions options = new CreateResourceTagsOptions();
         return options.tags(tagMap);
      }

      /**
       * @see CreateResourceTagsOptions#id
       */
      public static CreateResourceTagsOptions customer(String customer) {
         CreateResourceTagsOptions options = new CreateResourceTagsOptions();
         return options.customer(customer);
      }
   }
}
