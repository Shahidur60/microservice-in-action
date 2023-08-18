package com.optimagrowth.company.service.client;


import com.optimagrowth.company.model.Hr;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("hr-service")
public interface HrFeignClient {
    @RequestMapping(
            method= RequestMethod.GET,
            value="/v1/hr/{hrId}",
            consumes="application/json")
    Hr getHr(@PathVariable("hrId") String hrId);
}
