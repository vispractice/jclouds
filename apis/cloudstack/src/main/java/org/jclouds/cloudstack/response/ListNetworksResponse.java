package org.jclouds.cloudstack.response;

import java.util.Set;

import org.jclouds.cloudstack.domain.Network;


public class ListNetworksResponse extends ListResponse {
    protected Set<Network> network;

    public Set<Network> getNetwork() {
        return network;
    }

    public void setNetwork(Set<Network> network) {
        this.network = network;
    }
}
