package com.example.retry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/sample")
public class RetryController {

    @Autowired
    private SampleClient sampleClient;

    @GetMapping
    @Retryable(maxAttempts=10, backoff=@Backoff(delay=1000, maxDelay=5000))
    public ResponseEntity<Object> getSampleDataByIds(@RequestParam("ids") List<Long> ids) {
        return new ResponseEntity(sampleClient.getSampleDataByIds(ids), HttpStatus.OK);
    }
}
