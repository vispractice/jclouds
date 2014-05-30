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

import static org.testng.AssertJUnit.assertNotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.jclouds.cloudstack.domain.AsyncCreateResponse;
import org.jclouds.cloudstack.domain.AsyncJob;
import org.jclouds.cloudstack.domain.ResourceTag;
import org.jclouds.cloudstack.domain.VirtualMachine;
import org.jclouds.cloudstack.internal.BaseCloudStackApiLiveTest;
import org.jclouds.cloudstack.options.CreateResourceTagsOptions;
import org.jclouds.cloudstack.options.DeleteResourceTagsOptions;
import org.jclouds.cloudstack.options.ListResourceTagsOptions;
import org.jclouds.logging.Logger;
import org.testng.annotations.Test;

/**
 * Tests behavior of {@code ResourceTagsApi}
 * 
 * @author gaozheng
 */
@Test(groups = "live", singleThreaded = true, testName = "ResourceTagsApiLiveTest")
public class ResourceTagsApiLiveTest extends BaseCloudStackApiLiveTest {

    @Resource
    Logger logger = Logger.NULL;

    public void testListTags() {
        ResourceTagsApi tagApi = client.getResourceTagsApi();
        Set<ResourceTag> tags = tagApi.listTags(new ListResourceTagsOptions());
        assertNotNull(tags);

        for(ResourceTag tag : tags) {
            assertNotNull(tag);
            System.out.println(tag);
        }
    }
    
    public void testCreateTags(){
        ResourceTagsApi tagApi = client.getResourceTagsApi();
        CreateResourceTagsOptions options = new CreateResourceTagsOptions();
        options.resourceIds("f9e5a1c8-3aec-4509-9f4f-219f8e87ee1c");
        options.resourceType(ResourceTag.Type.UserVm);
        Map<String, String> tags = new HashMap<String, String>();
        tags.put("a", "22");
        options.tags(tags);
        AsyncCreateResponse resp = tagApi.createTags(options);
        
        AsyncJob<ResourceTag> jobWithResult = client.getAsyncJobApi().<ResourceTag>getAsyncJob(resp.getJobId());
        assertNotNull(jobWithResult);
    }

    public void testDeleteTags(){
        ResourceTagsApi tagApi = client.getResourceTagsApi();
        DeleteResourceTagsOptions options = new DeleteResourceTagsOptions();
        options.resourceIds("f9e5a1c8-3aec-4509-9f4f-219f8e87ee1c");
        options.resourceType(ResourceTag.Type.UserVm);
        Map<String, String> tags = new HashMap<String, String>();
        tags.put("a", null);
        options.tags(tags);
        AsyncCreateResponse resp = tagApi.deleteTags(options);
        
        AsyncJob<ResourceTag> jobWithResult = client.getAsyncJobApi().<ResourceTag>getAsyncJob(resp.getJobId());
        assertNotNull(jobWithResult);
    }
}
