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
package org.jclouds.cloudstack.features;

import java.util.Set;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jclouds.Fallbacks.EmptySetOnNotFoundOr404;
import org.jclouds.cloudstack.domain.AsyncCreateResponse;
import org.jclouds.cloudstack.domain.ResourceTag;
import org.jclouds.cloudstack.filters.AuthenticationFilter;
import org.jclouds.cloudstack.options.CreateResourceTagsOptions;
import org.jclouds.cloudstack.options.DeleteResourceTagsOptions;
import org.jclouds.cloudstack.options.ListResourceTagsOptions;
import org.jclouds.javax.annotation.Nullable;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.QueryParams;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.SelectJson;
import org.jclouds.rest.annotations.Unwrap;

/**
 * Provides synchronous access to cloudstack via their REST API.
 * <p/>
 * 
 * @see <a href="http://cloudstack.apache.org/docs/api/apidocs-4.3/TOC_User.html" />
 * @author gaozheng
 */
@RequestFilters(AuthenticationFilter.class)
@QueryParams(keys = "response", values = "json")
public interface ResourceTagsApi {
    /**
     * List resource tag(s)
     * 
     * @param options
     *           if present, how to constrain the list.
     * @return security groups matching query, or empty set, if no security
     *         groups are found
     */
    @Named("listTags")
    @GET
    @QueryParams(keys = { "command", "listAll" }, values = { "listTags", "true" })
    @SelectJson("tag")
    @Consumes(MediaType.APPLICATION_JSON)
    @Fallback(EmptySetOnNotFoundOr404.class)
    Set<ResourceTag> listTags(ListResourceTagsOptions... options);
    
    /**
     * Creates resource tag(s)
     * @param resourceIds 
     *           list of resources to create the tags for
     * @param resourceType 
     *           type of the resource
     * @param tags 
     *           Map of tags (key/value pairs)
     * @param customer
     *           identifies client specific tag. When the value is not null, the tag can't be used by cloudStack code internally
     * @return
     */
    @Named("createTags")
    @GET
    @QueryParams(keys = "command", values = "createTags")
    @Unwrap
    @Consumes(MediaType.APPLICATION_JSON)
    AsyncCreateResponse createTags(CreateResourceTagsOptions options);
    
    
    /**
     * Deleting resource tag(s)
     * @param resourceIds Delete tags for resource id(s)
     * @param resourceType Delete tag by resource type
     * @param tags Delete tags matching key/value pairs
     * @return
     */
    @Named("deleteTags")
    @GET
    @QueryParams(keys = "command", values = "deleteTags")
    @Unwrap
    @Consumes(MediaType.APPLICATION_JSON)
    AsyncCreateResponse deleteTags(DeleteResourceTagsOptions options);
}

