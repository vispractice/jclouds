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
package org.jclouds.cloudstack.domain;

import static com.google.common.base.Preconditions.checkNotNull;

import java.beans.ConstructorProperties;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

/**
 * Class IsolationMethod
 *
 * @author liwei
 */
public class IsolationMethod {

   public static Builder<?> builder() {
      return new ConcreteBuilder();
   }

   public Builder<?> toBuilder() {
      return new ConcreteBuilder().fromSshKeyPair(this);
   }

   public abstract static class Builder<T extends Builder<T>> {
      protected abstract T self();

      protected String name;

      /**
       * @see IsolationMethod#getName()
       */
      public T name(String name) {
         this.name = name;
         return self();
      }

      public IsolationMethod build() {
         return new IsolationMethod(name);
      }

      public T fromSshKeyPair(IsolationMethod in) {
         return this
               .name(in.getName());
      }
   }

   private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
      @Override
      protected ConcreteBuilder self() {
         return this;
      }
   }

   private final String name;

   @ConstructorProperties({"name"})
   protected IsolationMethod(String name) {
      this.name = checkNotNull(name, "name");
   }

   public String getName() {
      return this.name;
   }

   @Override
   public int hashCode() {
      return Objects.hashCode(name);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;
      IsolationMethod that = IsolationMethod.class.cast(obj);
      return Objects.equal(this.name, that.name);
   }

   protected ToStringHelper string() {
      return Objects.toStringHelper(this).add("name", name);
   }

   @Override
   public String toString() {
      return string().toString();
   }

}
