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

import org.jclouds.cloudstack.domain.ResourceTag;
import org.jclouds.cloudstack.domain.TemplateFilter;

import com.google.common.annotations.Beta;
import com.google.common.collect.ImmutableSet;

/**
 * Options used to control what tags information is returned
 * 
 * @see <a href="http://cloudstack.apache.org/docs/api/apidocs-4.3/TOC_User.html"/>
 * @author gaozheng
 */
public class ListResourceTagsOptions extends AccountInDomainOptions {
   public static final ListResourceTagsOptions NONE = new ListResourceTagsOptions();
   
   /**
    * @param customer list by customer name
    */
   public ListResourceTagsOptions customer(String customer) {
      this.queryParameters.replaceValues("customer", ImmutableSet.of(customer));
      return this;
   }
   
   /**
    * @param isRecursive defaults to false, but if true, lists all resources from the parent specified by the domainId till leaves.
    */
   public ListResourceTagsOptions isRecursive(boolean isRecursive) {
       this.queryParameters.replaceValues("isrecursive", ImmutableSet.of(isRecursive + ""));
       return this;
    }

   /**
    * @param key list by key
    */
   public ListResourceTagsOptions key(String key) {
      this.queryParameters.replaceValues("key", ImmutableSet.of(key));
      return this;
   }

   /**
    * @param keyword list by keyword
    */
   public ListResourceTagsOptions keyword(String keyword) {
      this.queryParameters.replaceValues("keyword", ImmutableSet.of(keyword));
      return this;
   }

   /**
    * @param page
    */
   public ListResourceTagsOptions page(long page) {
      this.queryParameters.replaceValues("page", ImmutableSet.of(page + ""));
      return this;

   }

   /**
    * @param pageSize
    */
   public ListResourceTagsOptions pageSize(long pageSize) {
      this.queryParameters.replaceValues("pagesize", ImmutableSet.of(pageSize + ""));
      return this;

   }

   /**
    * @param projectId list objects by project
    */
   public ListResourceTagsOptions projectId(String projectId) {
      this.queryParameters.replaceValues("projectid", ImmutableSet.of(projectId));
      return this;
   }
   
   /**
    * @param resourceid list by resource id
    */
   public ListResourceTagsOptions resourceId(String resourceId) {
       this.queryParameters.replaceValues("resourceid", ImmutableSet.of(resourceId));
       return this;
    }
   
   /**
    * @param resourceid list by resource type
    */
   public ListResourceTagsOptions resourceType(ResourceTag.Type resourceType) {
       this.queryParameters.replaceValues("resourcetype", ImmutableSet.of(resourceType.toString()));
       return this;
    }
   
   /**
    * @param resourceid list by value
    */
   public ListResourceTagsOptions value(String value) {
       this.queryParameters.replaceValues("value", ImmutableSet.of(value));
       return this;
    }

   public static class Builder {

      /**
       * @see ListResourceTagsOptions#filter
       */
      public static ListResourceTagsOptions customer(String customer) {
         ListResourceTagsOptions options = new ListResourceTagsOptions();
         return options.customer(customer);
      }

      /**
       * @see ListResourceTagsOptions#domainId
       */
      public static ListResourceTagsOptions domainId(String id) {
         ListResourceTagsOptions options = new ListResourceTagsOptions();
         return options.domainId(id);
      }

      /**
       * @see ListResourceTagsOptions#accountInDomain
       */
      public static ListResourceTagsOptions accountInDomain(String account, String domain) {
         ListResourceTagsOptions options = new ListResourceTagsOptions();
         return options.accountInDomain(account, domain);
      }

      /**
       * @see ListResourceTagsOptions#id
       */
      public static ListResourceTagsOptions isRecursive(boolean isRecursive) {
         ListResourceTagsOptions options = new ListResourceTagsOptions();
         return options.isRecursive(isRecursive);
      }

      /**
       * @see ListResourceTagsOptions#name
       */
      public static ListResourceTagsOptions key(String key) {
         ListResourceTagsOptions options = new ListResourceTagsOptions();
         return options.key(key);
      }

      /**
       * @see ListResourceTagsOptions#zoneId
       */
      public static ListResourceTagsOptions keyword(String keyword) {
         ListResourceTagsOptions options = new ListResourceTagsOptions();
         return options.keyword(keyword);
      }

      /**
       * @see ListResourceTagsOptions#projectId(String)
       */
      public static ListResourceTagsOptions resourceId(String resourceId) {
         ListResourceTagsOptions options = new ListResourceTagsOptions();
         return options.resourceId(resourceId);
      }

      /**
       * @see ListResourceTagsOptions#hypervisor
       */
      public static ListResourceTagsOptions page(long page) {
         ListResourceTagsOptions options = new ListResourceTagsOptions();
         return options.page(page);
      }
      
      public static ListResourceTagsOptions pageSize(long pageSize) {
          ListResourceTagsOptions options = new ListResourceTagsOptions();
          return options.pageSize(pageSize);
       }
      
      public static ListResourceTagsOptions projectId(String projectId) {
          ListResourceTagsOptions options = new ListResourceTagsOptions();
          return options.projectId(projectId);
       }
      
      public static ListResourceTagsOptions resourceType(ResourceTag.Type resourceType) {
          ListResourceTagsOptions options = new ListResourceTagsOptions();
          return options.resourceType(resourceType);
       }
      
      public static ListResourceTagsOptions value(String value) {
          ListResourceTagsOptions options = new ListResourceTagsOptions();
          return options.value(value);
       }
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public ListResourceTagsOptions accountInDomain(String account, String domain) {
      return ListResourceTagsOptions.class.cast(super.accountInDomain(account, domain));
   }
   
   /**
    * {@inheritDoc}
    */
   @Override
   public ListResourceTagsOptions domainId(String domainId) {
      return ListResourceTagsOptions.class.cast(super.domainId(domainId));
   }
}
