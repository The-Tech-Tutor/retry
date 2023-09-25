package com.example.retry;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("sample")
public interface SampleClient {
    @RequestMapping(method = RequestMethod.GET, value = "/sample")
    ResponseEntity<Object> getSampleDataByIds(@RequestParam("ids") List<Long> ids);
}