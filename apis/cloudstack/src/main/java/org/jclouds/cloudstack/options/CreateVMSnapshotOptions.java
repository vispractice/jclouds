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
 * Options used to control how a domain is created
 * 
 * @see <a href=
 *      "http://cloudstack.apache.org/docs/api/apidocs-4.3/root_admin/createVMSnapshot.html"
 *      />
 * @author liwei
 */
public class CreateVMSnapshotOptions extends BaseHttpRequestOptions {

   public static final CreateVMSnapshotOptions NONE = new CreateVMSnapshotOptions();

   /**
    * @param description
    *       The discription of the snapshot
    */
   public CreateVMSnapshotOptions description(String description) {
      this.queryParameters.replaceValues("description", ImmutableSet.of(description));
      return this;
   }

   /**
    * @param name
    *       The display name of the snapshot
    */
   public CreateVMSnapshotOptions name(String name) {
      this.queryParameters.replaceValues("name", ImmutableSet.of(name));
      return this;
   }
   
   /**
    * @param quiesceVm
    *       quiesce vm if true
    */
   public CreateVMSnapshotOptions quiesceVm(boolean quiesceVm) {
      this.queryParameters.replaceValues("quiescevm", ImmutableSet.of(quiesceVm+""));
      return this;
   }
   
   /**
    * @param snapshotMemory
    *       snapshot memory if true
    */
   public CreateVMSnapshotOptions snapshotMemory(boolean snapshotMemory) {
      this.queryParameters.replaceValues("snapshotmemory", ImmutableSet.of(snapshotMemory+""));
      return this;
   }

   public static class Builder {

      /**
       * @see CreateVMSnapshotOptions#description
       */
      public static CreateVMSnapshotOptions description(String description) {
         CreateVMSnapshotOptions options = new CreateVMSnapshotOptions();
         return options.description(description);
      }

      /**
       * @see CreateVMSnapshotOptions#quiesceVm
       */
      public static CreateVMSnapshotOptions quiesceVm(boolean quiesceVm) {
         CreateVMSnapshotOptions options = new CreateVMSnapshotOptions();
         return options.quiesceVm(quiesceVm);
      }
      
      /**
       * @see CreateVMSnapshotOptions#name
       */
      public static CreateVMSnapshotOptions name(String name) {
         CreateVMSnapshotOptions options = new CreateVMSnapshotOptions();
         return options.name(name);
      }
      
      /**
       * @see CreateVMSnapshotOptions#snapshotMemory
       */
      public static CreateVMSnapshotOptions snapshotMemory(boolean snapshotMemory) {
         CreateVMSnapshotOptions options = new CreateVMSnapshotOptions();
         return options.snapshotMemory(snapshotMemory);
      }
   }
}
