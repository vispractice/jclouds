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
import org.jclouds.cloudstack.domain.NetworkOffering;
import org.jclouds.cloudstack.domain.NetworkOfferingAvailabilityType;
import org.jclouds.cloudstack.domain.TrafficType;
import org.jclouds.http.options.BaseHttpRequestOptions;

import com.google.common.collect.ImmutableSet;

/**
 * Options used to control what network offerings are returned
 * 
 * @see <a href=
 *      "http://download.cloud.com/releases/2.2.0/api_2.2.12/user/listNetworkOfferings.html"
 *      />
 * @author Adrian Cole
 */
public class ListNetworkOfferingsOptions extends BaseHttpRequestOptions {

   public static final ListNetworkOfferingsOptions NONE = new ListNetworkOfferingsOptions();

   /**
    * @param zoneId
    *           list network offerings available for network creation in specific zone
    */
   public ListNetworkOfferingsOptions zoneId(String zoneId) {
      this.queryParameters.replaceValues("zoneid", ImmutableSet.of(zoneId + ""));
      return this;
   }
   
   /**
    * @param id
    *           the ID of the network offering
    */
   public ListNetworkOfferingsOptions id(String id) {
      this.queryParameters.replaceValues("id", ImmutableSet.of(id + ""));
      return this;
   }
   
   /**
    * @param name
    *           the network offering name
    */
   public ListNetworkOfferingsOptions name(String name) {
      this.queryParameters.replaceValues("name", ImmutableSet.of(name));
      return this;
   }

   /**
    * @param displayText
    *           network offerings by display text
    */
   public ListNetworkOfferingsOptions displayText(String displayText) {
      this.queryParameters.replaceValues("displaytext", ImmutableSet.of(displayText));
      return this;
   }

   /**
    * @param availability
    *           the availability of network offering. Default value is Required
    */
   public ListNetworkOfferingsOptions availability(NetworkOfferingAvailabilityType availability) {
      this.queryParameters.replaceValues("availability", ImmutableSet.of(availability.toString()));
      return this;
   }

   /**
    * @param isDefault
    *           true if network offering is default, false otherwise
    */
   public ListNetworkOfferingsOptions isDefault(boolean isDefault) {
      this.queryParameters.replaceValues("isdefault", ImmutableSet.of(isDefault + ""));
      return this;
   }

   /**
    * @param isShared
    *           true if network offering is shared, false otherwise
    */
   public ListNetworkOfferingsOptions isShared(boolean isShared) {
      this.queryParameters.replaceValues("isshared", ImmutableSet.of(isShared + ""));
      return this;
   }

   /**
    * @param specifyVLAN
    *           True if we allow the network supports vlan, false otherwise. If
    *           you create network using this offering, you must specify vlan.
    */
   public ListNetworkOfferingsOptions specifyVLAN(boolean specifyVLAN) {
      this.queryParameters.replaceValues("specifyvlan", ImmutableSet.of(specifyVLAN + ""));
      return this;
   }

   /**
    * @param trafficType
    *           type of the traffic
    */
   public ListNetworkOfferingsOptions trafficType(TrafficType trafficType) {
      this.queryParameters.replaceValues("traffictype", ImmutableSet.of(trafficType.toString()));
      return this;
   }
   
   public ListNetworkOfferingsOptions forVpc(boolean forVpc) {
       this.queryParameters.replaceValues("forvpc", ImmutableSet.of(forVpc + ""));
       return this;
    }
   
   public ListNetworkOfferingsOptions guestIpType(GuestIPType guestIpType) {
       this.queryParameters.replaceValues("guestiptype", ImmutableSet.of(guestIpType.toString()));
       return this;
    }
   
   public ListNetworkOfferingsOptions isTagged(boolean isTagged) {
       this.queryParameters.replaceValues("istagged", ImmutableSet.of(isTagged + ""));
       return this;
    }
   
   public ListNetworkOfferingsOptions keyword(String keyword) {
       this.queryParameters.replaceValues("keyword", ImmutableSet.of(keyword));
       return this;
    }
   
   public ListNetworkOfferingsOptions networkId(String networkId) {
       this.queryParameters.replaceValues("networkid", ImmutableSet.of(networkId));
       return this;
    }

   /**
    * @param page
    */
   public ListNetworkOfferingsOptions page(long page) {
      this.queryParameters.replaceValues("page", ImmutableSet.of(page + ""));
      return this;
   }

   /**
    * @param pageSize the page size
    */
   public ListNetworkOfferingsOptions pageSize(long pageSize) {
      this.queryParameters.replaceValues("pagesize", ImmutableSet.of(pageSize + ""));
      return this;
   }
   
   public ListNetworkOfferingsOptions sourceNatSupported(boolean sourceNatSupported) {
       this.queryParameters.replaceValues("sourcenatsupported", ImmutableSet.of(sourceNatSupported + ""));
       return this;
    }
   
   public ListNetworkOfferingsOptions specifyIpRanges(boolean specifyIpRanges) {
       this.queryParameters.replaceValues("specifyipranges", ImmutableSet.of(specifyIpRanges + ""));
       return this;
    }
   
   public ListNetworkOfferingsOptions state(NetworkOffering.State state) {
       this.queryParameters.replaceValues("state", ImmutableSet.of(state.toString()));
       return this;
    }
   
   public ListNetworkOfferingsOptions supportedServices(String supportedServices) {
       this.queryParameters.replaceValues("supportedservices", ImmutableSet.of(supportedServices));
       return this;
    }
   
   public ListNetworkOfferingsOptions tags(String tags) {
       this.queryParameters.replaceValues("tags", ImmutableSet.of(tags));
       return this;
    }
   
   public static class Builder {
      /**
       * @see ListNetworkOfferingsOptions#specifyVLAN
       */
      public static ListNetworkOfferingsOptions specifyVLAN(boolean specifyVLAN) {
         ListNetworkOfferingsOptions options = new ListNetworkOfferingsOptions();
         return options.specifyVLAN(specifyVLAN);
      }

      /**
       * @see ListNetworkOfferingsOptions#isDefault
       */
      public static ListNetworkOfferingsOptions isDefault(boolean isDefault) {
         ListNetworkOfferingsOptions options = new ListNetworkOfferingsOptions();
         return options.isDefault(isDefault);
      }

      /**
       * @see ListNetworkOfferingsOptions#isShared
       */
      public static ListNetworkOfferingsOptions isShared(boolean isShared) {
         ListNetworkOfferingsOptions options = new ListNetworkOfferingsOptions();
         return options.isShared(isShared);
      }

      /**
       * @see ListNetworkOfferingsOptions#displayText
       */
      public static ListNetworkOfferingsOptions displayText(String displayText) {
         ListNetworkOfferingsOptions options = new ListNetworkOfferingsOptions();
         return options.displayText(displayText);
      }

      /**
       * @see ListNetworkOfferingsOptions#name
       */
      public static ListNetworkOfferingsOptions name(String name) {
         ListNetworkOfferingsOptions options = new ListNetworkOfferingsOptions();
         return options.name(name);
      }

      /**
       * @see ListNetworkOfferingsOptions#availability
       */
      public static ListNetworkOfferingsOptions availability(NetworkOfferingAvailabilityType availability) {
         ListNetworkOfferingsOptions options = new ListNetworkOfferingsOptions();
         return options.availability(availability);
      }

      /**
       * @see ListNetworkOfferingsOptions#id
       */
      public static ListNetworkOfferingsOptions id(String id) {
         ListNetworkOfferingsOptions options = new ListNetworkOfferingsOptions();
         return options.id(id);
      }

      /**
       * @see ListNetworkOfferingsOptions#zoneId
       */
      public static ListNetworkOfferingsOptions zoneId(String zoneId) {
         ListNetworkOfferingsOptions options = new ListNetworkOfferingsOptions();
         return options.zoneId(zoneId);
      }

      /**
       * @see ListNetworkOfferingsOptions#trafficType
       */
      public static ListNetworkOfferingsOptions trafficType(TrafficType trafficType) {
         ListNetworkOfferingsOptions options = new ListNetworkOfferingsOptions();
         return options.trafficType(trafficType);
      }
      
      public static ListNetworkOfferingsOptions forVpc(boolean forVpc) {
          ListNetworkOfferingsOptions options = new ListNetworkOfferingsOptions();
          return options.forVpc(forVpc);
       }
      
      public static ListNetworkOfferingsOptions guestIpType(GuestIPType guestIpType) {
          ListNetworkOfferingsOptions options = new ListNetworkOfferingsOptions();
          return options.guestIpType(guestIpType);
       }
      
      public static ListNetworkOfferingsOptions isTagged(boolean isTagged) {
          ListNetworkOfferingsOptions options = new ListNetworkOfferingsOptions();
          return options.isTagged(isTagged);
       }
      
      public static ListNetworkOfferingsOptions keyword(String keyword) {
          ListNetworkOfferingsOptions options = new ListNetworkOfferingsOptions();
          return options.keyword(keyword);
       }
      
      public static ListNetworkOfferingsOptions networkId(String networkId) {
          ListNetworkOfferingsOptions options = new ListNetworkOfferingsOptions();
          return options.networkId(networkId);
       }
      
      public static ListNetworkOfferingsOptions page(long page) {
          ListNetworkOfferingsOptions options = new ListNetworkOfferingsOptions();
          return options.page(page);
       }
      
      public static ListNetworkOfferingsOptions pageSize(long pageSize) {
          ListNetworkOfferingsOptions options = new ListNetworkOfferingsOptions();
          return options.pageSize(pageSize);
       }
      
      public static ListNetworkOfferingsOptions sourceNatSupported(boolean sourceNatSupported) {
          ListNetworkOfferingsOptions options = new ListNetworkOfferingsOptions();
          return options.sourceNatSupported(sourceNatSupported);
       }
      
      public static ListNetworkOfferingsOptions specifyIpRanges(boolean specifyIpRanges) {
          ListNetworkOfferingsOptions options = new ListNetworkOfferingsOptions();
          return options.specifyIpRanges(specifyIpRanges);
       }
      
      public static ListNetworkOfferingsOptions state(NetworkOffering.State state) {
          ListNetworkOfferingsOptions options = new ListNetworkOfferingsOptions();
          return options.state(state);
       }
      
      public static ListNetworkOfferingsOptions supportedServices(String supportedServices) {
          ListNetworkOfferingsOptions options = new ListNetworkOfferingsOptions();
          return options.supportedServices(supportedServices);
       }
      
      public static ListNetworkOfferingsOptions tags(String tags) {
          ListNetworkOfferingsOptions options = new ListNetworkOfferingsOptions();
          return options.tags(tags);
       }
   }
}
