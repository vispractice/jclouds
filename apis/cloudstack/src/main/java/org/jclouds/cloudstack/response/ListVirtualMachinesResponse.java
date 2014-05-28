package org.jclouds.cloudstack.response;

import java.util.Set;

import org.jclouds.cloudstack.domain.VirtualMachine;


public class ListVirtualMachinesResponse extends ListResponse {
    protected Set<VirtualMachine> virtualmachine;

    public Set<VirtualMachine> getVirtualmachine() {
        return virtualmachine;
    }

    public void setVirtualmachine(Set<VirtualMachine> virtualmachine) {
        this.virtualmachine = virtualmachine;
    }
}
