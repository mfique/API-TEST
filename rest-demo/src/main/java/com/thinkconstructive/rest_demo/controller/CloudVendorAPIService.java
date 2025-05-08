package com.thinkconstructive.rest_demo.controller;

import com.thinkconstructive.rest_demo.model.CloudVendor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorAPIService {

    private final Map<String, CloudVendor> vendorMap = new HashMap<>();

    @GetMapping("/{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable String vendorId) {
        return vendorMap.get(vendorId);
    }

    @PostMapping
    public String createCloudVendorDetail(@RequestBody CloudVendor cloudVendor) {
        vendorMap.put(cloudVendor.getVendorId(), cloudVendor);
        return "Cloud Vendor Created Successfully";
    }

    @PutMapping
    public String updateCloudVendorDetail(@RequestBody CloudVendor cloudVendor) {
        vendorMap.put(cloudVendor.getVendorId(), cloudVendor);
        return "Cloud Vendor Updated Successfully";
    }

    @DeleteMapping("/{vendorId}")
    public String deleteCloudVendorDetail(@PathVariable String vendorId) {
        if (vendorMap.containsKey(vendorId)) {
            vendorMap.remove(vendorId);
            return "Cloud Vendor Deleted Successfully";
        } else {
            return "Cloud Vendor Not Found";
        }
    }
}