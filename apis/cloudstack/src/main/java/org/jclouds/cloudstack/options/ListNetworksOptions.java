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

import org.jclouds.cloudstack.domain.GuestIPType;
import org.jclouds.cloudstack.domain.TrafficType;

import com.google.common.annotations.Beta;
import com.google.common.collect.ImmutableSet;

/**
 * Options used to control what networks information is returned
 * 
 * @see <a
 *      href="http://download.cloud.com/releases/2.2.0/api/user/listNetworks.html"
 *      />
 * @author Adrian Cole
 */
public class ListNetworksOptions extends AccountInDomainOptions {

   public static final ListNetworksOptions NONE = new ListNetworksOptions();

   /**
    * @param isDefault
    *           true if network is default, false otherwise
    */
   public ListNetworksOptions isDefault(boolean isDefault) {
      this.queryParameters.replaceValues("isdefault", ImmutableSet.of(isDefault + ""));
      return this;
   }

   /**
    * @param isShared
    *           true if network is shared, false otherwise
    */
   public ListNetworksOptions isShared(boolean isShared) {
      this.queryParameters.replaceValues("isshared", ImmutableSet.of(isShared + ""));
      return this;
   }

   /**
    * @param isSystem
    *           true if network is system, false otherwise
    */
   public ListNetworksOptions isSystem(boolean isSystem) {
      this.queryParameters.replaceValues("issystem", ImmutableSet.of(isSystem + ""));
      return this;
   }

   /**
    * @param type
    *           the type of the network
    */
   public ListNetworksOptions type(GuestIPType type) {
      this.queryParameters.replaceValues("type", ImmutableSet.of(type.toString()));
      return this;
   }

   /**
    * @param id
    *           list networks by id
    */
   public ListNetworksOptions id(String id) {
      this.queryParameters.replaceValues("id", ImmutableSet.of(id + ""));
      return this;
   }

   /**
    * @param zoneId
    *           the Zone ID of the network
    */
   public ListNetworksOptions zoneId(String zoneId) {
      this.queryParameters.replaceValues("zoneid", ImmutableSet.of(zoneId + ""));
      return this;

   }

   /**
    * @param projectId
    *           the project ID of the network
    */
   public ListNetworksOptions projectId(String projectId) {
      this.queryParameters.replaceValues("projectid", ImmutableSet.of(projectId + ""));
      return this;

   }

   /**
    * @param trafficType
    *           type of the traffic
    */
   public ListNetworksOptions trafficType(TrafficType trafficType) {
      this.queryParameters.replaceValues("traffictype", ImmutableSet.of(trafficType.toString()));
      return this;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public ListNetworksOptions accountInDomain(String account, String domain) {
      return ListNetworksOptions.class.cast(super.accountInDomain(account, domain));
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public ListNetworksOptions domainId(String domainId) {
      return ListNetworksOptions.class.cast(super.domainId(domainId));
   }

   public static class Builder {
      /**
       * @see ListNetworksOptions#isDefault
       */
      public static ListNetworksOptions isDefault(boolean isDefault) {
         ListNetworksOptions options = new ListNetworksOptions();
         return options.isDefault(isDefault);
      }

      /**
       * @see ListNetworksOptions#isShared
       */
      public static ListNetworksOptions isShared(boolean isShared) {
         ListNetworksOptions options = new ListNetworksOptions();
         return options.isShared(isShared);
      }

      /**
       * @see ListNetworksOptions#isSystem
       */
      public static ListNetworksOptions isSystem(boolean isSystem) {
         ListNetworksOptions options = new ListNetworksOptions();
         return options.isSystem(isSystem);
      }

      /**
       * @see ListNetworksOptions#type
       */
      public static ListNetworksOptions type(GuestIPType type) {
         ListNetworksOptions options = new ListNetworksOptions();
         return options.type(type);
      }

      /**
       * @see ListNetworksOptions#id
       */
      public static ListNetworksOptions id(String id) {
         ListNetworksOptions options = new ListNetworksOptions();
         return options.id(id);
      }

      /**
       * @see ListNetworksOptions#zoneId
       */
      public static ListNetworksOptions zoneId(String id) {
         ListNetworksOptions options = new ListNetworksOptions();
         return options.zoneId(id);
      }

      /**
       * @see ListNetworksOptions#projectId(String)
       */
      public static ListNetworksOptions projectId(String id) {
         ListNetworksOptions options = new ListNetworksOptions();
         return options.projectId(id);
      }

      /**
       * @see ListNetworksOptions#trafficType
       */
      public static ListNetworksOptions trafficType(TrafficType trafficType) {
         ListNetworksOptions options = new ListNetworksOptions();
         return options.trafficType(trafficType);
      }

      /**
       * @see ListNetworksOptions#accountInDomain
       */
      public static ListNetworksOptions accountInDomain(String account, String domain) {
         ListNetworksOptions options = new ListNetworksOptions();
         return options.accountInDomain(account, domain);
      }

      /**
       * @see ListNetworksOptions#domainId
       */
      public static ListNetworksOptions domainId(String domainId) {
         ListNetworksOptions options = new ListNetworksOptions();
         return options.domainId(domainId);
      }
      
      public static ListNetworksOptions name(String name) {
          ListNetworksOptions options = new ListNetworksOptions();
          return options.domainId(name);
       }
      
      public static ListNetworksOptions cidr(String cidr) {
          ListNetworksOptions options = new ListNetworksOptions();
          return options.domainId(cidr);
       }
      
      public static ListNetworksOptions vlanId(String vlanid) {
          ListNetworksOptions options = new ListNetworksOptions();
          return options.vlanId(vlanid);
       }
      
      public static ListNetworksOptions page(long page) {
          ListNetworksOptions options = new ListNetworksOptions();
          return options.page(page);
       }
      
      public static ListNetworksOptions pageSize(long pageSize) {
          ListNetworksOptions options = new ListNetworksOptions();
          return options.pageSize(pageSize);
       }
   }
   
   @Beta
   public ListNetworksOptions name(String name) {
       this.queryParameters.replaceValues("name", ImmutableSet.of(name));
       return this;
    }
   
   @Beta
   public ListNetworksOptions cidr(String cidr) {
       this.queryParameters.replaceValues("cidr", ImmutableSet.of(cidr));
       return this;
    }

   @Beta
   public ListNetworksOptions vlanId(String vlanid) {
       this.queryParameters.replaceValues("vlanid", ImmutableSet.of(vlanid));
       return this;
    }
   
   /**
    * @param page
    */
   public ListNetworksOptions page(long page) {
      this.queryParameters.replaceValues("page", ImmutableSet.of(page + ""));
      return this;
   }

   /**
    * @param pageSize the page size
    */
   public ListNetworksOptions pageSize(long pageSize) {
      this.queryParameters.replaceValues("pagesize", ImmutableSet.of(pageSize + ""));
      return this;
   }
}
