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
import java.net.URI;

import org.jclouds.javax.annotation.Nullable;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

/**
 * Class NIC
 *
 * @author Adrian Cole
 */
public class NIC {

   public static Builder<?> builder() {
      return new ConcreteBuilder();
   }

   public Builder<?> toBuilder() {
      return new ConcreteBuilder().fromNIC(this);
   }

   public abstract static class Builder<T extends Builder<T>> {
      protected abstract T self();

      protected String id;
      protected URI broadcastURI;
      protected String gateway;
      protected String IPAddress;
      protected boolean isDefault;
      protected URI isolationURI;
      protected String netmask;
      protected String macAddress;
      protected String networkId;
      protected TrafficType trafficType;
      protected GuestIPType guestIPType;
      protected String IP6Address;
      protected String IP6Cidr;
      protected String IP6Gateway;
      protected String networkName;
      protected String secondaryIP;

      /**
       * @see NIC#getId()
       */
      public T id(String id) {
         this.id = id;
         return self();
      }

      /**
       * @see NIC#getBroadcastURI()
       */
      public T broadcastURI(URI broadcastURI) {
         this.broadcastURI = broadcastURI;
         return self();
      }

      /**
       * @see NIC#getGateway()
       */
      public T gateway(String gateway) {
         this.gateway = gateway;
         return self();
      }

      /**
       * @see NIC#getIPAddress()
       */
      public T IPAddress(String IPAddress) {
         this.IPAddress = IPAddress;
         return self();
      }

      /**
       * @see NIC#isDefault()
       */
      public T isDefault(boolean isDefault) {
         this.isDefault = isDefault;
         return self();
      }

      /**
       * @see NIC#getIsolationURI()
       */
      public T isolationURI(URI isolationURI) {
         this.isolationURI = isolationURI;
         return self();
      }

      /**
       * @see NIC#getNetmask()
       */
      public T netmask(String netmask) {
         this.netmask = netmask;
         return self();
      }

      /**
       * @see NIC#getMacAddress()
       */
      public T macAddress(String macAddress) {
         this.macAddress = macAddress;
         return self();
      }

      /**
       * @see NIC#getNetworkId()
       */
      public T networkId(String networkId) {
         this.networkId = networkId;
         return self();
      }

      /**
       * @see NIC#getTrafficType()
       */
      public T trafficType(TrafficType trafficType) {
         this.trafficType = trafficType;
         return self();
      }

      /**
       * @see NIC#getGuestIPType()
       */
      public T guestIPType(GuestIPType guestIPType) {
         this.guestIPType = guestIPType;
         return self();
      }
      
      public T IP6Address(String IP6Address) {
          this.IP6Address = IP6Address;
          return self();
       }
      
      public T IP6Cidr(String IP6Cidr) {
          this.IP6Cidr = IP6Cidr;
          return self();
       }
      
      public T IP6Gateway(String IP6Gateway) {
          this.IP6Gateway = IP6Gateway;
          return self();
       }
      
      public T networkName(String networkName) {
          this.networkName = networkName;
          return self();
       }
      
      public T secondaryIP(String secondaryIP) {
          this.secondaryIP = secondaryIP;
          return self();
       }
       
      public NIC build() {
         return new NIC(id, broadcastURI, gateway, IPAddress, isDefault, isolationURI, netmask, macAddress, networkId, 
                 trafficType, guestIPType, IP6Address, IP6Cidr, IP6Gateway, networkName, secondaryIP);
      }

      public T fromNIC(NIC in) {
         return this
               .id(in.getId())
               .broadcastURI(in.getBroadcastURI())
               .gateway(in.getGateway())
               .IPAddress(in.getIPAddress())
               .isDefault(in.isDefault())
               .isolationURI(in.getIsolationURI())
               .netmask(in.getNetmask())
               .macAddress(in.getMacAddress())
               .networkId(in.getNetworkId())
               .trafficType(in.getTrafficType())
               .guestIPType(in.getGuestIPType())
               .IP6Address(in.getIP6Address())
               .IP6Cidr(in.getIP6Cidr())
               .IP6Gateway(in.getIP6Gateway())
               .networkName(in.getNetworkName())
               .secondaryIP(in.getSecondaryIP());
         
      }
   }

   private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
      @Override
      protected ConcreteBuilder self() {
         return this;
      }
   }

   private final String id;
   private final URI broadcastURI;
   private final String gateway;
   private final String IPAddress;
   private final boolean isDefault;
   private final URI isolationURI;
   private final String netmask;
   private final String macAddress;
   private final String networkId;
   private final TrafficType trafficType;
   private final GuestIPType guestIPType;
   private final String IP6Address;
   private final String IP6Cidr;
   private final String IP6Gateway;
   private final String networkName;
   private final String secondaryIP;

   @ConstructorProperties({
         "id", "broadcasturi", "gateway", "ipaddress", "isdefault", "isolationuri", "netmask", "macaddress", "networkid", "traffictype", "type",
         "ip6address", "ip6cidr", "ip6gateway", "networkname", "secondaryip"
   })
   protected NIC(String id, @Nullable URI broadcastURI, @Nullable String gateway, @Nullable String IPAddress, boolean isDefault,
                 @Nullable URI isolationURI, @Nullable String netmask, @Nullable String macAddress, @Nullable String networkId,
                 @Nullable TrafficType trafficType, @Nullable GuestIPType guestIPType, @Nullable String IP6Address, @Nullable String IP6Cidr, 
                 @Nullable String IP6Gateway, @Nullable String networkName, @Nullable String secondaryIP) {
      this.id = checkNotNull(id, "id");
      this.broadcastURI = broadcastURI;
      this.gateway = gateway;
      this.IPAddress = IPAddress;
      this.isDefault = isDefault;
      this.isolationURI = isolationURI;
      this.netmask = netmask;
      this.macAddress = macAddress;
      this.networkId = networkId;
      this.trafficType = trafficType;
      this.guestIPType = guestIPType;
      this.IP6Address = IP6Address;
      this.IP6Gateway = IP6Gateway;
      this.IP6Cidr = IP6Cidr;
      this.networkName = networkName;
      this.secondaryIP = secondaryIP;
   }

   /**
    * the ID of the nic
    */
   public String getId() {
      return this.id;
   }

   /**
    * the broadcast uri of the nic
    */
   @Nullable
   public URI getBroadcastURI() {
      return this.broadcastURI;
   }

   /**
    * the gateway of the nic
    */
   @Nullable
   public String getGateway() {
      return this.gateway;
   }

   /**
    * the ip address of the nic
    */
   @Nullable
   public String getIPAddress() {
      return this.IPAddress;
   }

   /**
    * true if nic is default, false otherwise
    */
   public boolean isDefault() {
      return this.isDefault;
   }

   /**
    * the isolation uri of the nic
    */
   @Nullable
   public URI getIsolationURI() {
      return this.isolationURI;
   }

   /**
    * the netmask of the nic
    */
   @Nullable
   public String getNetmask() {
      return this.netmask;
   }

   /**
    * the MAC Address of the NIC
    */
   @Nullable
   public String getMacAddress() {
      return this.macAddress;
   }

   /**
    * the ID of the corresponding network
    */
   @Nullable
   public String getNetworkId() {
      return this.networkId;
   }

   /**
    * the traffic type of the nic
    */
   @Nullable
   public TrafficType getTrafficType() {
      return this.trafficType;
   }

   /**
    * the type of the nic
    */
   @Nullable
   public GuestIPType getGuestIPType() {
      return this.guestIPType;
   }
   
    @Nullable
    public String getIP6Address() {
        return IP6Address;
    }

    @Nullable
    public String getIP6Cidr() {
        return IP6Cidr;
    }

    @Nullable
    public String getIP6Gateway() {
        return IP6Gateway;
    }

    @Nullable
    public String getNetworkName() {
        return networkName;
    }

    @Nullable
    public String getSecondaryIP() {
        return secondaryIP;
    }

    @Override
   public int hashCode() {
      return Objects.hashCode(id, broadcastURI, gateway, IPAddress, isDefault, isolationURI, netmask, macAddress, networkId, trafficType, 
              guestIPType, IP6Address, IP6Cidr, IP6Gateway, networkName, secondaryIP);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;
      NIC that = NIC.class.cast(obj);
      return Objects.equal(this.id, that.id)
            && Objects.equal(this.broadcastURI, that.broadcastURI)
            && Objects.equal(this.gateway, that.gateway)
            && Objects.equal(this.IPAddress, that.IPAddress)
            && Objects.equal(this.isDefault, that.isDefault)
            && Objects.equal(this.isolationURI, that.isolationURI)
            && Objects.equal(this.netmask, that.netmask)
            && Objects.equal(this.macAddress, that.macAddress)
            && Objects.equal(this.networkId, that.networkId)
            && Objects.equal(this.trafficType, that.trafficType)
            && Objects.equal(this.guestIPType, that.guestIPType)
            && Objects.equal(this.IP6Address, that.IP6Address)
            && Objects.equal(this.IP6Cidr, that.IP6Cidr)
            && Objects.equal(this.IP6Gateway, that.IP6Gateway)
            && Objects.equal(this.networkName, that.networkName)
            && Objects.equal(this.secondaryIP, that.secondaryIP);
   }

   protected ToStringHelper string() {
      return Objects.toStringHelper(this)
            .add("id", id).add("broadcastURI", broadcastURI).add("gateway", gateway).add("IPAddress", IPAddress)
            .add("isDefault", isDefault).add("isolationURI", isolationURI).add("netmask", netmask).add("macAddress", macAddress)
            .add("networkId", networkId).add("trafficType", trafficType).add("guestIPType", guestIPType).add("IP6Address", IP6Address)
            .add("IP6Cidr", IP6Cidr).add("IP6Gateway", IP6Gateway).add("networkName", networkName).add("secondaryIP", secondaryIP);
   }

   @Override
   public String toString() {
      return string().toString();
   }

}
