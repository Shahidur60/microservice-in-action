package com.example.company;

import com.example.company.client.HrFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value="company/callHr")
public class CompanyController {

	@Autowired
	HrFeignClient hrFeignClient;

	@RequestMapping(value="/feign/{service}",method = RequestMethod.GET)
	public Map<String, String> getLicensesWithClient(@PathVariable("service") String service) {

		return hrFeignClient.getHr(service);
	}
}
