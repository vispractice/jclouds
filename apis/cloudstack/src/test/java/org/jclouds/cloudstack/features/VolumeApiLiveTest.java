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

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertNotSame;
import static org.testng.AssertJUnit.assertNull;
import static org.testng.AssertJUnit.assertTrue;

import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.jclouds.cloudstack.CloudStackApi;
import org.jclouds.cloudstack.domain.AsyncCreateResponse;
import org.jclouds.cloudstack.domain.AsyncJob;
import org.jclouds.cloudstack.domain.DiskOffering;
import org.jclouds.cloudstack.domain.ExtractMode;
import org.jclouds.cloudstack.domain.Snapshot;
import org.jclouds.cloudstack.domain.StorageType;
import org.jclouds.cloudstack.domain.Template;
import org.jclouds.cloudstack.domain.VirtualMachine;
import org.jclouds.cloudstack.domain.Volume;
import org.jclouds.cloudstack.domain.Zone;
import org.jclouds.cloudstack.internal.BaseCloudStackApiLiveTest;
import org.jclouds.cloudstack.options.ExtractISOOptions;
import org.jclouds.cloudstack.options.ExtractVolumeOptions;
import org.jclouds.cloudstack.options.ListVolumesOptions;
import org.jclouds.cloudstack.options.ResizeVolumeOptions;
import org.jclouds.cloudstack.options.UpdateVolumeOptions;
import org.jclouds.cloudstack.options.UploadVolumeOptions;
import org.jclouds.logging.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * Tests behavior of {@code VolumeApi}
 * 
 * @author Vijay Kiran, Alex Heneveld
 */
@Test(groups = "live", singleThreaded = true, testName = "VolumeApiLiveTest")
public class VolumeApiLiveTest extends BaseCloudStackApiLiveTest {

    @Resource
    Logger logger = Logger.NULL;

    protected String prefix = System.getProperty("user.name") + "-"
            + getClass().getSimpleName();

    private String zoneId;

    private String existVmId = null;

    private String downloadVolumeUrl = null;

    @Override
    protected Properties setupProperties() {
        Properties overrides = super.setupProperties();
        existVmId = setIfTestSystemPropertyPresent(overrides, provider
                + ".existVmId");
        downloadVolumeUrl = setIfTestSystemPropertyPresent(overrides, provider
                + ".downloadVolumeUrl");
        return overrides;
    }

    @BeforeMethod(groups = "live")
    public void setZoneId() {
        Set<Zone> zones = client.getZoneApi().listZones();
        assertNotNull(zones);
        assertFalse(zones.isEmpty());
        zoneId = Iterables.get(zones, 0).getId();
    }

    public void testListVolumes() {
        Set<Volume> volumes = client.getVolumeApi().listVolumes();
        assertNotNull(volumes);
        assertFalse(volumes.isEmpty());

        for (Volume volume : volumes) {
            checkVolume(volume);
        }
    }

    public void testListVolumesById() {
        Iterable<String> volumeIds = Iterables.transform(client.getVolumeApi()
                .listVolumes(), new Function<Volume, String>() {
            public String apply(Volume input) {
                return input.getId();
            }
        });
        assertNotNull(volumeIds);
        assertFalse(Iterables.isEmpty(volumeIds));

        for (String id : volumeIds) {
            Set<Volume> found = client.getVolumeApi().listVolumes(
                    ListVolumesOptions.Builder.id(id));
            assertNotNull(found);
            assertEquals(1, found.size());
            Volume volume = Iterables.getOnlyElement(found);
            assertEquals(id, volume.getId());
            checkVolume(volume);
        }
    }

    public void testListVolumesNonexistantId() {
        Set<Volume> found = client.getVolumeApi().listVolumes(
                ListVolumesOptions.Builder.id("foo"));
        assertNotNull(found);
        assertTrue(found.isEmpty());
    }

    public void testGetVolumeById() {
        Iterable<String> volumeIds = Iterables.transform(client.getVolumeApi()
                .listVolumes(), new Function<Volume, String>() {
            public String apply(Volume input) {
                return input.getId();
            }
        });
        assertNotNull(volumeIds);
        assertFalse(Iterables.isEmpty(volumeIds));

        for (String id : volumeIds) {
            Volume found = client.getVolumeApi().getVolume(id);
            assertNotNull(found);
            assertEquals(id, found.getId());
            checkVolume(found);
        }
    }

    public void testGetVolumeNonexistantId() {
        Volume found = client.getVolumeApi().getVolume("foo");
        assertNull(found);
    }

    protected DiskOffering getPreferredDiskOffering() {
        for (DiskOffering candidate : client.getOfferingApi()
                .listDiskOfferings()) {
            // any will do
            return candidate;
        }
        throw new AssertionError("No suitable DiskOffering found.");
    }

    protected Snapshot getPreferredSnapshot() {
        for (Snapshot candidate : client.getSnapshotApi().listSnapshots()) {
            if (candidate.getState() == Snapshot.State.BACKED_UP)
                return candidate;
        }
        throw new AssertionError("No suitable Snapshot found.");
    }

    protected VirtualMachine getPreferredVirtualMachine() {
        for (VirtualMachine candidate : client.getVirtualMachineApi()
                .listVirtualMachines()) {
            // this is a guess::
            if (candidate.getState() == VirtualMachine.State.RUNNING
                    || candidate.getState() == VirtualMachine.State.STOPPED)
                return candidate;
        }
        throw new AssertionError("No suitable VirtualMachine found.");
    }

    protected Volume createPreferredVolumeFromDisk() {
        AsyncCreateResponse job = client.getVolumeApi()
                .createVolumeFromDiskOfferingInZone(prefix + "-jclouds-volume",
                        getPreferredDiskOffering().getId(), zoneId);
        assertTrue(jobComplete.apply(job.getJobId()));
        logger.info("created volume " + job.getId());
        return findVolumeWithId(job.getId());
    }

    public void testCreateVolumeFromDiskofferingInZoneAndDeleteVolume() {
        logger.info("testCreateVolumeFromDiskofferingInZoneAndDeleteVolume");
        Volume volume = createPreferredVolumeFromDisk();
        checkVolume(volume);
        client.getVolumeApi().deleteVolume(volume.getId());
    }

    /** Test requires a custom disk offering to be available */
    public void testCreateVolumeFromCustomDiskOffering() {
        Volume volume = null;
        try {
            volume = createVolumeFromCustomDiskOffering();
        } finally {
            if (volume != null)
                client.getVolumeApi().deleteVolume(volume.getId());
        }
    }
    
    private Volume createVolumeFromCustomDiskOffering(){
        Volume volume = createVolumeFromCustomDiskOffering(StorageType.SHARED);
        return volume;
    }
    
    private Volume createVolumeFromCustomDiskOffering(StorageType storageType){
        int size = 1;
        Volume volume = createVolumeFromCustomDiskOffering(size, storageType);
        assertEquals(volume.getSize(), size * 1024 * 1024 * 1024);
        return volume;
    }

    private Volume createVolumeFromCustomDiskOffering(final int size,
            StorageType storageType) {
        DiskOffering offering = null;
        for (DiskOffering candidate : client.getOfferingApi()
                .listDiskOfferings()) {
            if (candidate.isCustomized()
                    && candidate.getStoragetype().equals(storageType)) {
                offering = candidate;
                break;
            }
        }

        assertNotNull("No custom disk offering found!", offering);

        AsyncCreateResponse job = client.getVolumeApi()
                .createVolumeFromCustomDiskOfferingInZone(
                        prefix + "-jclouds-volume", offering.getId(), zoneId,
                        size);
        assertTrue(jobComplete.apply(job.getJobId()));
        logger.info("created volume " + job.getId());

        Volume volume = findVolumeWithId(job.getId());
        checkVolume(volume);

        return volume;
    }

    private Volume createVolumeFromCustomDiskOffering(final int size) {
        return createVolumeFromCustomDiskOffering(size, StorageType.SHARED);
    }

    public void testResizeDataVolume() {
        final int size = 1;
        final int newSize = 2;
        Volume volume = createVolumeFromCustomDiskOffering(size,
                StorageType.LOCAL);
        assertEquals(volume.getSize(), size * 1024 * 1024 * 1024);
        logger.info("original size: " + volume.getSize());

        assertNotNull(existVmId);
        VirtualMachine vm = client.getVirtualMachineApi().getVirtualMachine(
                existVmId);
        assertNotNull(vm);

        try {
            AsyncCreateResponse attachJob = client.getVolumeApi().attachVolume(
                    volume.getId(), vm.getId());
            assertTrue(jobComplete.apply(attachJob.getJobId()));

            ResizeVolumeOptions options = new ResizeVolumeOptions();
            options.id(volume.getId());
            options.diskOfferingId(volume.getDiskOfferingId());
            options.size(newSize);
            String resizeJobId = client.getVolumeApi().resizeVolume(options);
            assertTrue(jobComplete.apply(resizeJobId));

            Volume newVolume = client.getVolumeApi().getVolume(volume.getId());
            logger.info("new size: " + volume.getSize());
            assertEquals(newVolume.getSize(),
                    (long) newSize * 1024 * 1024 * 1024);
        } finally {
            AsyncCreateResponse detachJob = client.getVolumeApi().detachVolume(
                    volume.getId());
            assertTrue(jobComplete.apply(detachJob.getJobId()));
            client.getVolumeApi().deleteVolume(volume.getId());
        }
    }

    public void testExtractDataVolume() {
        Volume volume = createVolumeFromCustomDiskOffering(StorageType.LOCAL);
        try {
            stopVmAndattachVolume(volume);
            extractVolume(volume);
        } finally {
            AsyncCreateResponse detachJob = client.getVolumeApi().detachVolume(
                    volume.getId());
            assertTrue(jobComplete.apply(detachJob.getJobId()));
            client.getVolumeApi().deleteVolume(volume.getId());
        }
    }

    public void testExtractRootVolume() {
        assertNotNull(existVmId);
        ListVolumesOptions options = new ListVolumesOptions();
        options.virtualMachineId(existVmId);
        options.type(Volume.Type.ROOT);
        Set<Volume> volumes = client.getVolumeApi().listVolumes(options);
        assert volumes != null && volumes.size() == 1;
        Volume volume = volumes.iterator().next();
        extractVolume(volume);
    }

    public void testUploadVolume() {
        assertNotNull(downloadVolumeUrl);
        Volume volume = null;
        try {
            AsyncCreateResponse uploadJobReps = client.getVolumeApi()
                    .uploadVolume(Template.Format.OVA.toString(),
                            prefix + "-jclouds-upload-volume",
                            downloadVolumeUrl, zoneId,
                            new UploadVolumeOptions());
            assertTrue(jobComplete.apply(uploadJobReps.getJobId()));
            AsyncJob<Volume> uploadJob = client.getAsyncJobApi().getAsyncJob(
                    uploadJobReps.getJobId());
            assertNotNull(uploadJob);
            volume = uploadJob.getResult();
            assertNotNull(volume);
        } finally {
            if (volume != null) {
                while (true) {
                    volume = client.getVolumeApi().getVolume(volume.getId());
                    if (volume.getState().equals(Volume.State.UPLOADED)) {
                        client.getVolumeApi().deleteVolume(volume.getId());
                        break;
                    }
                }
            }
        }
    }

    public void testUpdateVolume() {
        Volume volume = null;
        try{
            volume = createVolumeFromCustomDiskOffering();
            UpdateVolumeOptions options = new UpdateVolumeOptions();
            options.id(volume.getId());
            options.displayVolume("false");
            options.state(Volume.State.UPLOADED.toString());
            AsyncCreateResponse jobReps = globalAdminClient.getVolumeApi().updateVolume(options);
            assertTrue(jobComplete.apply(jobReps.getJobId()));
            volume = client.getVolumeApi().getVolume(volume.getId());
            assertEquals(volume.getState(), Volume.State.UPLOADED);
        }finally {
            if (volume != null) {
                client.getVolumeApi().deleteVolume(volume.getId());
            }
        }
    }

    private void stopVmAndattachVolume(Volume volume) {
        assertNotNull(existVmId);
        VirtualMachine vm = client.getVirtualMachineApi().getVirtualMachine(
                existVmId);
        assertNotNull(vm);
        assert vm.getState().equals(VirtualMachine.State.RUNNING)
                || vm.getState().equals(VirtualMachine.State.STOPPED);
        if (vm.getState().equals(VirtualMachine.State.RUNNING)) {
            String jobId = client.getVirtualMachineApi().stopVirtualMachine(
                    vm.getId());
            assertTrue(jobComplete.apply(jobId));
            vm = client.getVirtualMachineApi().getVirtualMachine(existVmId);
        }
        assertEquals(vm.getState(), VirtualMachine.State.STOPPED);

        AsyncCreateResponse attachJob = client.getVolumeApi().attachVolume(
                volume.getId(), vm.getId());
        assertTrue(jobComplete.apply(attachJob.getJobId()));
    }

    private String extractVolume(Volume volume) {
        AsyncCreateResponse extractJobReps = client.getVolumeApi()
                .extractVolume(volume.getId(),
                        ExtractMode.HTTP_DOWNLOAD.toString(),
                        volume.getZoneId(), new ExtractVolumeOptions());
        assertTrue(jobComplete.apply(extractJobReps.getJobId()));
        AsyncJob<Volume> extractJob = client.getAsyncJobApi().getAsyncJob(
                extractJobReps.getJobId());
        assertNotNull(extractJob);
        volume = extractJob.getResult();
        assertNotNull(volume);
        assertNotNull(volume.getUrl());
        return volume.getUrl();
    }

    /** test requires that a VM exist */
    public void testCreateVolumeFromDiskofferingInZoneAndAttachVolumeToVirtualMachineAndDetachAndDelete() {
        logger.info("testCreateVolumeFromDiskofferingInZoneAndAttachVolumeToVirtualMachineAndDetachAndDelete");
        final Volume volume = createPreferredVolumeFromDisk();
        try {

            checkVolume(volume);

            VirtualMachine virtualMachine = getPreferredVirtualMachine();

            logger.info("attaching volume %s to vm %s", volume, virtualMachine);
            AsyncCreateResponse job = client.getVolumeApi().attachVolume(
                    volume.getId(), virtualMachine.getId());
            assertTrue(jobComplete.apply(job.getJobId()));
            Volume attachedVolume = findVolumeWithId(volume.getId());

            checkVolume(attachedVolume);
            assertEquals(virtualMachine.getId(),
                    attachedVolume.getVirtualMachineId());
            assertNotNull(attachedVolume.getAttached());

            logger.info("detaching volume %s from vm %s", volume,
                    virtualMachine);
            job = client.getVolumeApi().detachVolume(volume.getId());
            assertTrue(jobComplete.apply(job.getJobId()));
            Volume detachedVolume = findVolumeWithId(volume.getId());

            checkVolume(detachedVolume);
            assertNull(detachedVolume.getAttached());

        } finally {
            client.getVolumeApi().deleteVolume(volume.getId());
        }
    }

    public void testCreateVolumeFromSnapshotInZoneAndDeleteVolume() {
        logger.info("testCreateVolumeFromSnapshotInZoneAndDeleteVolume (takes ~3m)");
        assertNotNull(getPreferredSnapshot());

        AsyncCreateResponse job = client.getVolumeApi()
                .createVolumeFromSnapshotInZone(prefix + "-jclouds-volume",
                        getPreferredSnapshot().getId(), zoneId);
        assertTrue(jobComplete.apply(job.getJobId()));
        Volume volume = findVolumeWithId(job.getId());

        checkVolume(volume);
        client.getVolumeApi().deleteVolume(volume.getId());
    }

    static void checkVolume(final Volume volume) {
        assertNotNull(volume.getId());
        assertNotNull(volume.getName());
        assertNotSame(Volume.Type.UNRECOGNIZED, volume.getType());
    }

    Volume findVolumeWithId(final String id) {
        return findVolumeWithId(client, id);
    }

    static Volume findVolumeWithId(final CloudStackApi client, final String id) {
        for (Volume v : client.getVolumeApi().listVolumes())
            if (v.getId().equals(id))
                return v;
        throw new NoSuchElementException("no volume with id " + id);
    }

    // //uncomment to force a cleanup of volumes (since test failures can leave
    // messes)
    // public void deleteAllWeUsed() {
    // for (Volume v: client.getVolumeApi().listVolumes()) {
    // if (v.getName().startsWith(prefix)) {
    // logger.warn("found apparent detritus, deleting: %s", v);
    // try {
    // client.getVolumeApi().deleteVolume(v.getId());
    // } catch (Exception e) {
    // logger.warn(e, "failed to delete %s: %s", v, e);
    // }
    // }
    // }
    // }
}
