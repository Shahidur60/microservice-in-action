package com.example.account.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AccountDiscoveryClient {

    @Autowired
    private DiscoveryClient discoveryClient;

    public Map<String, String> getAccount(String service) {
        List<ServiceInstance> instances = discoveryClient.getInstances("organization-service");

        if (instances.size()==0) return null;

        Map<String, String> map = new HashMap<>();
        map.put("first",instances.get(0).getInstanceId().toString());
        map.put("second",instances.get(0).getInstanceId().toString());

        return map;
    }
}
