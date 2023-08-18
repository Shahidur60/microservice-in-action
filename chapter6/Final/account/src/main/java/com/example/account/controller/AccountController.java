package com.example.account.controller;

import com.example.account.client.AccountDiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping(value="accounts")
public class AccountController {

    @Autowired
    private DiscoveryClient discoveryClient;

    public Map<String, String> getServices(String service) {
        List<ServiceInstance> instances = discoveryClient.getInstances(service);
        Map<String, String> map = new HashMap<>();

        int i = 0;
        for (ServiceInstance serviceInstance : instances) {
            String instanceId = serviceInstance.getInstanceId();
            String uri = serviceInstance.getUri().toString();
            String serviceDetails = instanceId + " at " +uri;
            map.put("Instant" + i, serviceDetails);
            i++;
        }
        return map;
    }

    @RequestMapping(value="/{service}",method = RequestMethod.GET)
	public Map<String, String> getService(@PathVariable("service") String service) {
		return getServices(service);
	}
}
