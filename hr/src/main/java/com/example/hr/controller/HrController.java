package com.example.hr.controller;

import com.example.hr.client.AccountRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value="company/callHr")
public class HrController {

    @Autowired
    AccountRestClient accountRestClient;

    @RequestMapping(value="/hr/{service}",method = RequestMethod.GET)
	public Map<String, String> getLicensesWithClient(@PathVariable("service") String service) {

		return accountRestClient.getAccount(service);
	}

//	HrFeignClient hrFeignClient;
//
//	@RequestMapping(value="/feign/{service}",method = RequestMethod.GET)
//	public HashMap<String, String> getLicensesWithClient(@PathVariable("service") String service) {
//
//		return hrFeignClient.getHr(service);
//	}
}
