package org.jclouds.cloudstack.response;

import java.util.Set;

import org.jclouds.cloudstack.domain.Template;


public class ListTemplatesResponse extends ListResponse {
    protected Set<Template> template;

    public Set<Template> getTemplate() {
        return template;
    }

    public void setTemplate(Set<Template> template) {
        this.template = template;
    }

}
