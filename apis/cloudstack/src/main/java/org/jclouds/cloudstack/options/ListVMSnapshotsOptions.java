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

import org.jclouds.cloudstack.domain.Snapshot;

import com.google.common.collect.ImmutableSet;

/**
 * Options for the Snapshot listVMSnapshots method.
 *
 * @see org.jclouds.cloudstack.features.SnapshotApi#listVMSnapshots
 * @author gaozheng
 */
public class ListVMSnapshotsOptions extends AccountInDomainOptions {

   public static final ListVMSnapshotsOptions NONE = new ListVMSnapshotsOptions(); 

   /**
    * @param id lists snapshot by snapshot ID
    */
   public ListVMSnapshotsOptions vmSnapshotId(String vmSnapshotId) {
      this.queryParameters.replaceValues("vmsnapshotid", ImmutableSet.of(vmSnapshotId));
      return this;
   }

   /**
    * @param isRecursive defaults to false, but if true, lists all snapshots from the parent specified by the domain id till leaves.
    */
   public ListVMSnapshotsOptions isRecursive(boolean isRecursive) {
      this.queryParameters.replaceValues("isrecursive", ImmutableSet.of(isRecursive + ""));
      return this;
   }

   /**
    * @param keyword List by keyword
    */
   public ListVMSnapshotsOptions keyword(String keyword) {
      this.queryParameters.replaceValues("keyword", ImmutableSet.of(keyword + ""));
      return this;
   }

   /**
    * @param name lists snapshot by snapshot name
    */
   public ListVMSnapshotsOptions name(String name) {
      this.queryParameters.replaceValues("name", ImmutableSet.of(name + ""));
      return this;
   }

   /**
    * @param projectId the project to list in
    */
   public ListVMSnapshotsOptions projectId(String projectId) {
      this.queryParameters.replaceValues("projectid", ImmutableSet.of(projectId + ""));
      return this;
   }
   
   /**
    * @param page
    */
   public ListVMSnapshotsOptions page(long page) {
      this.queryParameters.replaceValues("page", ImmutableSet.of(page + ""));
      return this;
   }

   /**
    * @param pageSize the page size
    */
   public ListVMSnapshotsOptions pageSize(long pageSize) {
      this.queryParameters.replaceValues("pagesize", ImmutableSet.of(pageSize + ""));
      return this;
   }
   
   /**
    * 
    * @param state
    */
   public ListVMSnapshotsOptions state(Snapshot.State state) {
      this.queryParameters.replaceValues("state", ImmutableSet.of(state.toString()));
      return this;
   }
   
   /**
    * @param tagMap
    */
   public ListVMSnapshotsOptions tags(Map<String, String> tagMap) {
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
   
   public ListVMSnapshotsOptions virtualMachineId(String virtualMachineId) {
       this.queryParameters.replaceValues("virtualmachineid", ImmutableSet.of(virtualMachineId));
       return this;
    }

   public static class Builder {

      /**
       * @param account lists snapshot belonging to the specified account.
       * @param domainId The domain ID.
       */
      public static ListVMSnapshotsOptions accountInDomain(String account, String domainId) {
         return (ListVMSnapshotsOptions) new ListVMSnapshotsOptions().accountInDomain(account, domainId);
      }

      /**
       * @param domainId the domain ID.
       */
      public static ListVMSnapshotsOptions domainId(String domainId) {
         return (ListVMSnapshotsOptions) new ListVMSnapshotsOptions().domainId(domainId);
      }

      /**
       * @param id lists snapshot by snapshot ID
       */
      public static ListVMSnapshotsOptions vmSnapshotId(String vmSnapshotId) {
         return new ListVMSnapshotsOptions().vmSnapshotId(vmSnapshotId);
      }

      /**
       * @param isRecursive defaults to false, but if true, lists all snapshots from the parent specified by the domain id till leaves.
       */
      public static ListVMSnapshotsOptions isRecursive(boolean isRecursive) {
         return new ListVMSnapshotsOptions().isRecursive(isRecursive);
      }

      /**
       * @param keyword List by keyword
       */
      public static ListVMSnapshotsOptions keyword(String keyword) {
         return new ListVMSnapshotsOptions().keyword(keyword);
      }

      /**
       * @param name lists snapshot by snapshot name
       */
      public static ListVMSnapshotsOptions name(String name) {
         return new ListVMSnapshotsOptions().name(name);
      }

      public static ListVMSnapshotsOptions page(long page) {
         return new ListVMSnapshotsOptions().page(page);
      }

      public static ListVMSnapshotsOptions pageSize(long pageSize) {
         return new ListVMSnapshotsOptions().pageSize(pageSize);
      }

      /**
       * @param projectId the project to list in
       */
      public static ListVMSnapshotsOptions projectId(String projectId) {
         return new ListVMSnapshotsOptions().projectId(projectId);
      }
      
      public static ListVMSnapshotsOptions state(Snapshot.State state) {
          return new ListVMSnapshotsOptions().state(state);
       }
      
      public static ListVMSnapshotsOptions tags(Map<String, String> tagMap) {
          return new ListVMSnapshotsOptions().tags(tagMap);
       }
      
      public static ListVMSnapshotsOptions virtualMachineId(String virtualMachineId) {
          return new ListVMSnapshotsOptions().virtualMachineId(virtualMachineId);
       }
   }

}
