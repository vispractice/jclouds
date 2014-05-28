package org.jclouds.cloudstack.response;

import java.util.Set;

import org.jclouds.cloudstack.domain.Volume;


public class ListVolumesResponse extends ListResponse {
    protected Set<Volume> volume;

    public Set<Volume> getVolume() {
        return volume;
    }

    public void setVolume(Set<Volume> volume) {
        this.volume = volume;
    }

}
