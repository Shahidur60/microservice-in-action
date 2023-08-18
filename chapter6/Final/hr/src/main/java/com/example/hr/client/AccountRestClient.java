package com.example.hr.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class AccountRestClient {

    @Autowired
    private RestTemplate restTemplate;

    public Map<String, String> getService(String service){

        return restTemplate.getForEntity("http://account/accounts/"+service, Map.class).getBody();
    }
}
