package org.jclouds.cloudstack.response;


public abstract class ListResponse {
    protected Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
