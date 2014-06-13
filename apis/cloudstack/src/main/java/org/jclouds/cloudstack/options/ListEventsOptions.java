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

import java.util.Date;

import org.jclouds.http.options.BaseHttpRequestOptions;

import com.google.common.collect.ImmutableSet;

/**
 * Options used to control what events are returned
 *
 * @author Vijay Kiran
 * @see <a href=
 *      "http://download.cloud.com/releases/2.2.0/api_2.2.12/user/listEvents.html"
 *      />
 */
public class ListEventsOptions extends AccountInDomainOptions {
   public static final ListEventsOptions NONE = new ListEventsOptions();

   public ListEventsOptions duration(String duration) {
      this.queryParameters.replaceValues("duration", ImmutableSet.of(duration));
      return this;
   }

   public ListEventsOptions endDate(String endDate) {
      this.queryParameters.replaceValues("enddate", ImmutableSet.of(endDate));
      return this;
   }

   public ListEventsOptions entryTime(Date entrytime) {
      this.queryParameters.replaceValues("entrytime", ImmutableSet.of(entrytime + ""));
      return this;
   }

   public ListEventsOptions id(String id) {
      this.queryParameters.replaceValues("id", ImmutableSet.of(id));
      return this;
   }

   public ListEventsOptions projectId(String projectId) {
      this.queryParameters.replaceValues("projectid", ImmutableSet.of(projectId + ""));
      return this;
   }

   public ListEventsOptions keyword(String keyword) {
      this.queryParameters.replaceValues("keyword", ImmutableSet.of(keyword));
      return this;
   }

   public ListEventsOptions level(String level) {
      this.queryParameters.replaceValues("level", ImmutableSet.of(level));
      return this;
   }

   public ListEventsOptions type(String type) {
      this.queryParameters.replaceValues("type", ImmutableSet.of(type));
      return this;
   }
   
   /**
    * @param page
    */
   public ListEventsOptions page(long page) {
      this.queryParameters.replaceValues("page", ImmutableSet.of(page + ""));
      return this;
   }

   /**
    * @param pageSize the page size
    */
   public ListEventsOptions pageSize(long pageSize) {
      this.queryParameters.replaceValues("pagesize", ImmutableSet.of(pageSize + ""));
      return this;
   }
   
   public ListEventsOptions isRecursive(boolean isRecursive) {
       this.queryParameters.replaceValues("isrecursive", ImmutableSet.of(isRecursive + ""));
       return this;
    }
   
   public ListEventsOptions startDate(String startDate) {
       this.queryParameters.replaceValues("startdate", ImmutableSet.of(startDate));
       return this;
    }
   
   /**
    * {@inheritDoc}
    */
   @Override
   public ListEventsOptions accountInDomain(String account, String domain) {
      return ListEventsOptions.class.cast(super.accountInDomain(account, domain));
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public ListEventsOptions domainId(String domainId) {
      return ListEventsOptions.class.cast(super.domainId(domainId));
   }

   public static class Builder {
      public static ListEventsOptions accountInDomain(String account, String domain) {
         final ListEventsOptions options = new ListEventsOptions();
         return options.accountInDomain(account, domain);
      }

      public static ListEventsOptions domainId(String domainId) {
         final ListEventsOptions options = new ListEventsOptions();
         return options.domainId(domainId);
      }

      public static ListEventsOptions duration(String duration) {
         final ListEventsOptions options = new ListEventsOptions();
         return options.duration(duration);
      }

      public static ListEventsOptions endDate(String endDate) {
         final ListEventsOptions options = new ListEventsOptions();
         return options.endDate(endDate);
      }

      public static ListEventsOptions entryTime(Date entrytime) {
         final ListEventsOptions options = new ListEventsOptions();
         return options.entryTime(entrytime);
      }

      public static ListEventsOptions id(String id) {
         final ListEventsOptions options = new ListEventsOptions();
         return options.id(id);
      }

      public static ListEventsOptions projectId(String projectId) {
         final ListEventsOptions options = new ListEventsOptions();
         return options.projectId(projectId);
      }

      public static ListEventsOptions keyword(String keyword) {
         final ListEventsOptions options = new ListEventsOptions();
         return options.keyword(keyword);
      }

      public static ListEventsOptions level(String level) {
         final ListEventsOptions options = new ListEventsOptions();
         return options.level(level);
      }

      public static ListEventsOptions type(String type) {
         final ListEventsOptions options = new ListEventsOptions();
         return options.type(type);
      }
      
      public static ListEventsOptions pageSize(long pageSize) {
          final ListEventsOptions options = new ListEventsOptions();
          return options.pageSize(pageSize);
       }
      
      public static ListEventsOptions page(long page) {
          final ListEventsOptions options = new ListEventsOptions();
          return options.page(page);
       }
      
      public static ListEventsOptions isRecursive(boolean isRecursive) {
          final ListEventsOptions options = new ListEventsOptions();
          return options.isRecursive(isRecursive);
       }
      
      public static ListEventsOptions startDate(String startDate) {
          final ListEventsOptions options = new ListEventsOptions();
          return options.startDate(startDate);
       }

   }

}

