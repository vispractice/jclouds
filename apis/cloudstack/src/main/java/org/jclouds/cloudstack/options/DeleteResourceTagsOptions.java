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
 *  Options used to control how tags are deleted.
 * 
 * @see <a href="http://cloudstack.apache.org/docs/api/apidocs-4.3/TOC_User.html"/>
 * @author gaozheng
 */
public class DeleteResourceTagsOptions extends BaseHttpRequestOptions {
   public static final DeleteResourceTagsOptions NONE = new DeleteResourceTagsOptions();
   
   /**
    * @param resourceIds 
    *           Delete tags for resource id(s)
    */
   public DeleteResourceTagsOptions resourceIds(String resourceIds) {
       this.queryParameters.replaceValues("resourceids", ImmutableSet.of(resourceIds));
       return this;
    }
   
   /**
    * @param resourceType 
    *           Delete tag by resource type
    */
   public DeleteResourceTagsOptions resourceType(ResourceTag.Type resourceType) {
       this.queryParameters.replaceValues("resourcetype", ImmutableSet.of(resourceType.toString()));
       return this;
    }
   
   /**
    * @param resourceIds 
    *           Delete tags matching key/value pairs
    */
   public DeleteResourceTagsOptions tags(Map<String, String> tagMap) {
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

   public static class Builder {

      /**
       * @see DeleteResourceTagsOptions#filter
       */
      public static DeleteResourceTagsOptions resourceIds(String resourceIds) {
         DeleteResourceTagsOptions options = new DeleteResourceTagsOptions();
         return options.resourceIds(resourceIds);
      }

      /**
       * @see DeleteResourceTagsOptions#domainId
       */
      public static DeleteResourceTagsOptions resourceType(ResourceTag.Type resourceType) {
         DeleteResourceTagsOptions options = new DeleteResourceTagsOptions();
         return options.resourceType(resourceType);
      }

      /**
       * @see DeleteResourceTagsOptions#accountInDomain
       */
      public static DeleteResourceTagsOptions tags(Map<String, String> tagMap) {
         DeleteResourceTagsOptions options = new DeleteResourceTagsOptions();
         return options.tags(tagMap);
      }
   }
}
