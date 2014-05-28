package org.jclouds.cloudstack.response;

import java.util.Set;

import org.jclouds.cloudstack.domain.Host;


public class ListHostsResponse extends ListResponse {
    protected Set<Host> host;

    public Set<Host> getHost() {
        return host;
    }

    public void setHost(Set<Host> host) {
        this.host = host;
    }

}
