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

import com.google.common.annotations.Beta;
import com.google.common.collect.ImmutableSet;

/**
 * Options used to control what virtual machines information is returned
 * 
 * @see <a href=
 *      "http://download.cloud.com/releases/2.2.0/api/user/listVirtualMachines.html"
 *      />
 * @author Adrian Cole
 */
public class ListVirtualMachinesOptions extends AccountInDomainOptions {

   public static final ListVirtualMachinesOptions NONE = new ListVirtualMachinesOptions();

   /**
    * @param id
    *           the ID of the virtual machine
    */
   public ListVirtualMachinesOptions id(String id) {
      this.queryParameters.replaceValues("id", ImmutableSet.of(id + ""));
      return this;
   }

   /**
    * @param name
    *           the virtual machine name
    */
   public ListVirtualMachinesOptions name(String name) {
      this.queryParameters.replaceValues("name", ImmutableSet.of(name));
      return this;
   }

   /**
    * @param state
    *           state of the virtual machine
    */
   public ListVirtualMachinesOptions state(String state) {
      this.queryParameters.replaceValues("state", ImmutableSet.of(state));
      return this;
   }

   /**
    * @param groupId
    *           list virtual machines by groupId.
    */
   public ListVirtualMachinesOptions groupId(String groupId) {
      this.queryParameters.replaceValues("groupid", ImmutableSet.of(groupId));
      return this;

   }

   /**
    * @param hostId
    *           list virtual machines by hostId.
    */
   public ListVirtualMachinesOptions hostId(String hostId) {
      this.queryParameters.replaceValues("hostid", ImmutableSet.of(hostId + ""));
      return this;

   }
   
   /**
    * @param hostId or lastHostId
    *           list virtual machines by hostId.
    */
   public ListVirtualMachinesOptions currentHostId(String currentHostId) {
      this.queryParameters.replaceValues("currenthostid", ImmutableSet.of(currentHostId));
      return this;

   }

   /**
    * @param networkId
    *           list virtual machines by networkId.
    */
   public ListVirtualMachinesOptions networkId(String networkId) {
      this.queryParameters.replaceValues("networkid", ImmutableSet.of(networkId + ""));
      return this;

   }

   /**
    * @param podId
    *           list virtual machines by podId.
    */
   public ListVirtualMachinesOptions podId(String podId) {
      this.queryParameters.replaceValues("podid", ImmutableSet.of(podId + ""));
      return this;

   }

   /**
    * @param projectId
    *           list virtual machines by projectId.
    */
   public ListVirtualMachinesOptions projectId(String projectId) {
      this.queryParameters.replaceValues("projectid", ImmutableSet.of(projectId + ""));
      return this;

   }

   /**
    * @param zoneId
    *           list virtual machines by zoneId.
    */
   public ListVirtualMachinesOptions zoneId(String zoneId) {
      this.queryParameters.replaceValues("zoneid", ImmutableSet.of(zoneId + ""));
      return this;

   }

   /**
    * @param usesVirtualNetwork
    *           list by network type; true if need to list vms using Virtual
    *           Network, false otherwise
    */
   public ListVirtualMachinesOptions usesVirtualNetwork(boolean usesVirtualNetwork) {
      this.queryParameters.replaceValues("forvirtualnetwork", ImmutableSet.of(usesVirtualNetwork + ""));
      return this;
   }
   
   public ListVirtualMachinesOptions tags(Map<String, String> tagMap) {
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
   
   public ListVirtualMachinesOptions affinityGroupId(String affinityGroupId) {
       this.queryParameters.replaceValues("affinitygroupid", ImmutableSet.of(affinityGroupId));
       return this;
    }
   
   public ListVirtualMachinesOptions details(String details) {
       this.queryParameters.replaceValues("details", ImmutableSet.of(details));
       return this;
    }
   
   public ListVirtualMachinesOptions forVirtualNetwork(boolean forVirtualNetwork) {
       this.queryParameters.replaceValues("forvirtualnetwork", ImmutableSet.of(forVirtualNetwork + ""));
       return this;
    }
   
   public ListVirtualMachinesOptions hypervisor(String hypervisor) {
       this.queryParameters.replaceValues("hypervisor", ImmutableSet.of(hypervisor));
       return this;
    }
   
   public ListVirtualMachinesOptions isoId(String isoId) {
       this.queryParameters.replaceValues("isoid", ImmutableSet.of(isoId));
       return this;
    }
   
   public ListVirtualMachinesOptions isRecursive(boolean isRecursive) {
       this.queryParameters.replaceValues("isrecursive", ImmutableSet.of(isRecursive + ""));
       return this;
    }
   
   public ListVirtualMachinesOptions keyword(String keyword) {
       this.queryParameters.replaceValues("keyword", ImmutableSet.of(keyword));
       return this;
    }
   
   public ListVirtualMachinesOptions storageId(String storageId) {
       this.queryParameters.replaceValues("storageid", ImmutableSet.of(storageId));
       return this;
    }
   
   public ListVirtualMachinesOptions templateId(String templateId) {
       this.queryParameters.replaceValues("templateid", ImmutableSet.of(templateId));
       return this;
    }
   
   public ListVirtualMachinesOptions vpcId(String vpcId) {
       this.queryParameters.replaceValues("vpcid", ImmutableSet.of(vpcId));
       return this;
    }

   public static class Builder {

      /**
       * @see ListVirtualMachinesOptions#accountInDomain
       */
      public static ListVirtualMachinesOptions accountInDomain(String account, String domain) {
         ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
         return options.accountInDomain(account, domain);
      }

      /**
       * @see ListVirtualMachinesOptions#domainId
       */
      public static ListVirtualMachinesOptions domainId(String id) {
         ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
         return options.domainId(id);
      }

      /**
       * @see ListVirtualMachinesOptions#id
       */
      public static ListVirtualMachinesOptions id(String id) {
         ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
         return options.id(id);
      }

      /**
       * @see ListVirtualMachinesOptions#name
       */
      public static ListVirtualMachinesOptions name(String name) {
         ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
         return options.name(name);
      }

      /**
       * @see ListVirtualMachinesOptions#state
       */
      public static ListVirtualMachinesOptions state(String state) {
         ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
         return options.state(state);
      }

      /**
       * @see ListVirtualMachinesOptions#groupId
       */
      public static ListVirtualMachinesOptions groupId(String id) {
         ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
         return options.groupId(id);
      }

      /**
       * @see ListVirtualMachinesOptions#hostId
       */
      public static ListVirtualMachinesOptions hostId(String id) {
         ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
         return options.hostId(id);
      }
      
      public static ListVirtualMachinesOptions currentHostId(String currentHostId) {
         ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
         return options.currentHostId(currentHostId);
      }

      /**
       * @see ListVirtualMachinesOptions#networkId
       */
      public static ListVirtualMachinesOptions networkId(String id) {
         ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
         return options.networkId(id);
      }

      /**
       * @see ListVirtualMachinesOptions#podId
       */
      public static ListVirtualMachinesOptions podId(String id) {
         ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
         return options.podId(id);
      }

      /**
       * @see ListVirtualMachinesOptions#projectId(String)
       */
      public static ListVirtualMachinesOptions projectId(String id) {
         ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
         return options.projectId(id);
      }

      /**
       * @see ListVirtualMachinesOptions#zoneId
       */
      public static ListVirtualMachinesOptions zoneId(String id) {
         ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
         return options.zoneId(id);
      }

      /**
       * @see ListVirtualMachinesOptions#usesVirtualNetwork
       */
      public static ListVirtualMachinesOptions usesVirtualNetwork(boolean usesVirtualNetwork) {
          ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
          return options.usesVirtualNetwork(usesVirtualNetwork);
       }
      
      public static ListVirtualMachinesOptions nameOrIp(String nameorip) {
          ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
          return options.nameOrIp(nameorip);
       }
      
      public static ListVirtualMachinesOptions guestOsId(String guestosid) {
          ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
          return options.guestOsId(guestosid);
       }
      
      public static ListVirtualMachinesOptions page(long page) {
          ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
          return options.page(page);
       }
      
      public static ListVirtualMachinesOptions pageSize(long pageSize) {
          ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
          return options.pageSize(pageSize);
       }
      
      public static ListVirtualMachinesOptions tags(Map<String, String> tagMap) {
          ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
          return options.tags(tagMap);
       }
      
      public static ListVirtualMachinesOptions affinityGroupId(String affinityGroupId) {
          ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
          return options.affinityGroupId(affinityGroupId);
       }
      
      public static ListVirtualMachinesOptions details(String details) {
          ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
          return options.details(details);
       }
      
      public static ListVirtualMachinesOptions forVirtualNetwork(boolean forVirtualNetwork) {
          ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
          return options.forVirtualNetwork(forVirtualNetwork);
       }
      
      public static ListVirtualMachinesOptions hypervisor(String hypervisor) {
          ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
          return options.hypervisor(hypervisor);
       }
      
      public static ListVirtualMachinesOptions isoId(String isoId) {
          ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
          return options.isoId(isoId);
       }
      
      public static ListVirtualMachinesOptions isRecursive(boolean isRecursive) {
          ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
          return options.isRecursive(isRecursive);
       }
      
      public static ListVirtualMachinesOptions keyword(String keyword) {
          ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
          return options.keyword(keyword);
       }
      
      public static ListVirtualMachinesOptions storageId(String storageId) {
          ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
          return options.storageId(storageId);
       }
      
      public static ListVirtualMachinesOptions templateId(String templateId) {
          ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
          return options.templateId(templateId);
       }
      
      public static ListVirtualMachinesOptions vpcId(String vpcId) {
          ListVirtualMachinesOptions options = new ListVirtualMachinesOptions();
          return options.vpcId(vpcId);
       }
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public ListVirtualMachinesOptions accountInDomain(String account, String domain) {
      return ListVirtualMachinesOptions.class.cast(super.accountInDomain(account, domain));
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public ListVirtualMachinesOptions domainId(String domainId) {
      return ListVirtualMachinesOptions.class.cast(super.domainId(domainId));
   }
   
   @Beta
   public ListVirtualMachinesOptions nameOrIp(String nameorip) {
       this.queryParameters.replaceValues("nameorip", ImmutableSet.of(nameorip));
       return this;
    }
   
   @Beta
   public ListVirtualMachinesOptions guestOsId(String guestosid) {
       this.queryParameters.replaceValues("guestosid", ImmutableSet.of(guestosid));
       return this;
    }
   
   /**
    * @param page
    */
   public ListVirtualMachinesOptions page(long page) {
      this.queryParameters.replaceValues("page", ImmutableSet.of(page + ""));
      return this;
   }

   /**
    * @param pageSize the page size
    */
   public ListVirtualMachinesOptions pageSize(long pageSize) {
      this.queryParameters.replaceValues("pagesize", ImmutableSet.of(pageSize + ""));
      return this;
   }
}
