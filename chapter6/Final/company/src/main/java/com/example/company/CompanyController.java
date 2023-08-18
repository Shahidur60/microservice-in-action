package com.example.company;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value="company")
public class CompanyController {

//	@Autowired
//	HrFeignClient hrFeignClient;

	@Autowired
	private RestTemplate restTemplate;

	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
	private int attempts=1;


//	@RequestMapping(value="/feign/{service}",method = RequestMethod.GET)
//	public Map<String, String> getService(@PathVariable("service") String service) {
//
//		return hrFeignClient.getService(service);
//	}

	@CircuitBreaker(name = "company", fallbackMethod = "buildFallbackCompany")
	@RequestMapping(value="/cb",method = RequestMethod.GET)
	public ResponseEntity<String> getHrService() {
		String response = restTemplate.getForObject("http://hr/hr/calling", String.class);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	private ResponseEntity<String> buildFallbackCompany(Exception e){
		return new ResponseEntity<String>("HR Service is Down", HttpStatus.OK);
	}

	@Bulkhead(name = "company", fallbackMethod = "bulkheadFallbackCompany")
	@RequestMapping(value="/bh",method = RequestMethod.GET)
	public ResponseEntity<String> getHrServiceByBulkhead() {
		String response = restTemplate.getForObject("http://hr/hr/callBulkHead", String.class);
		logger.info(LocalTime.now() + " Call processing finished = " + Thread.currentThread().getName());
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	private ResponseEntity<String> bulkheadFallbackCompany(Exception e){
		return new ResponseEntity<String>("Company Service is full and could not process more calls", HttpStatus.TOO_MANY_REQUESTS);
	}

	@Retry(name = "company", fallbackMethod = "retryFallbackCompany")
	@RequestMapping(value="/retry",method = RequestMethod.GET)
	public ResponseEntity<String> getHrServiceByRetry() {
		logger.info("hr service call attempted:::"+ attempts++);
		String response = restTemplate.getForObject("http://hr/hr/callRetry", String.class);
		logger.info("hr service called");
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	public ResponseEntity<String> retryFallbackCompany(Exception e){
		attempts=1;
		return new ResponseEntity<String>("Hr service is down", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@RateLimiter(name = "company", fallbackMethod = "rateLimiterFallbackCompany")
	@RequestMapping(value="/rateLimit",method = RequestMethod.GET)
	public ResponseEntity<String> getHrServiceByRateLimiter() {
		String response = restTemplate.getForObject("http://hr/hr/calling", String.class);
		logger.info(LocalTime.now() + " Call processing finished = " + Thread.currentThread().getName());
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	public ResponseEntity<String> rateLimiterFallbackCompany(Exception e){
		return new ResponseEntity<String>("Company service does not permit further calls", HttpStatus.TOO_MANY_REQUESTS);
	}


}
