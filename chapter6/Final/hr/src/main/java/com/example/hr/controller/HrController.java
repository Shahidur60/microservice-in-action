package com.example.hr.controller;

import com.example.hr.client.AccountRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value="hr")
public class HrController {

    @Autowired
    AccountRestClient accountRestClient;

    private static final Logger logger = LoggerFactory.getLogger(HrController.class);


    @RequestMapping(value="/{service}",method = RequestMethod.GET)
	public Map<String, String> getService(@PathVariable("service") String service) {

		return accountRestClient.getService(service);
	}

    @RequestMapping(value="/calling",method = RequestMethod.GET)
    public String getHrService() {

        return "Hello From HR";
    }

    @RequestMapping(value="/callBulkHead",method = RequestMethod.GET)
    public String getHrServiceByBulkhead() throws Exception{
        Thread.sleep(4000);
        logger.info("Get Bulkhead Calls");

        return "Bulkhead Return";
    }

    @RequestMapping(value="/callRetry",method = RequestMethod.GET)
    public String getHrServiceByRetry() {
        return "Retry From HR";
    }

    @RequestMapping(value="/rateLimit",method = RequestMethod.GET)
    public String getHrServiceByRateLimiter() {
        logger.info("Calling Done");
        return "rateLimit From HR";
    }

}
