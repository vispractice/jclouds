package org.jclouds.cloudstack.options;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.io.BaseEncoding.base64;

import org.jclouds.http.options.BaseHttpRequestOptions;

import com.google.common.collect.ImmutableSet;

/**
 * Options used to control updates to VirtualMachine
 * </p>
 * @author gaozheng
 *
 */
public class UpdateVirtualMachineOptions extends BaseHttpRequestOptions {
    public static final UpdateVirtualMachineOptions NONE = new UpdateVirtualMachineOptions();
    
    public UpdateVirtualMachineOptions id(String id){
        this.queryParameters.replaceValues("id", ImmutableSet.<String>of(id));
        return this;
    }
    
    public UpdateVirtualMachineOptions displayname(String displayname){
        this.queryParameters.replaceValues("displayname", ImmutableSet.<String>of(displayname));
        return this;
    }
    
    public UpdateVirtualMachineOptions displayvm(boolean displayvm){
        this.queryParameters.replaceValues("displayvm", ImmutableSet.<String>of(String.valueOf(displayvm)));
        return this;
    }
    
    public UpdateVirtualMachineOptions haenable(boolean haenable){
        this.queryParameters.replaceValues("haenable", ImmutableSet.<String>of(String.valueOf(haenable)));
        return this;
    }
    
    public UpdateVirtualMachineOptions isdynamicallyscalable(boolean isdynamicallyscalable){
        this.queryParameters.replaceValues("isdynamicallyscalable", ImmutableSet.<String>of(String.valueOf(isdynamicallyscalable)));
        return this;
    }
    
    public UpdateVirtualMachineOptions ostypeid(String ostypeid){
        this.queryParameters.replaceValues("ostypeid", ImmutableSet.<String>of(ostypeid));
        return this;
    }
    
    public UpdateVirtualMachineOptions userData(byte[] unencodedData) {
        int length = checkNotNull(unencodedData, "unencodedData").length;
        checkArgument(length > 0, "userData cannot be empty");
        checkArgument(length <= 2 * 1024, "userData cannot be larger than 2kb");
        this.queryParameters.replaceValues("userdata", ImmutableSet.of(base64().encode(unencodedData)));
        return this;
     }
    
    public static class Builder {
        public static UpdateVirtualMachineOptions id(String id) {
            UpdateVirtualMachineOptions options = new UpdateVirtualMachineOptions();
            return options.id(id);
        }
        
        public static UpdateVirtualMachineOptions displayname(String displayname) {
            UpdateVirtualMachineOptions options = new UpdateVirtualMachineOptions();
            return options.displayname(displayname);
        }
        
        public static UpdateVirtualMachineOptions displayvm(boolean displayvm) {
            UpdateVirtualMachineOptions options = new UpdateVirtualMachineOptions();
            return options.displayvm(displayvm);
        }
        
        public static UpdateVirtualMachineOptions haenable(boolean haenable) {
            UpdateVirtualMachineOptions options = new UpdateVirtualMachineOptions();
            return options.haenable(haenable);
        }
        
        public static UpdateVirtualMachineOptions isdynamicallyscalable(boolean isdynamicallyscalable) {
            UpdateVirtualMachineOptions options = new UpdateVirtualMachineOptions();
            return options.isdynamicallyscalable(isdynamicallyscalable);
        }
        
        public static UpdateVirtualMachineOptions ostypeid(String ostypeid) {
            UpdateVirtualMachineOptions options = new UpdateVirtualMachineOptions();
            return options.ostypeid(ostypeid);
        }
        
        public static UpdateVirtualMachineOptions userData(byte[] unencodedData) {
            UpdateVirtualMachineOptions options = new UpdateVirtualMachineOptions();
            return options.userData(unencodedData);
        }
    }

}
