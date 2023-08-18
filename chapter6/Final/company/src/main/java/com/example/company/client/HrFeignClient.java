//package com.example.company.client;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@FeignClient("hr")
//public interface HrFeignClient {
//    @RequestMapping(
//            method= RequestMethod.GET,
//            value="/hr/{service}",
//            consumes="application/json")
//    Map<String, String> getService(@PathVariable("service") String service);
//}
