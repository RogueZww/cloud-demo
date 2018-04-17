package com.zww.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zww.cloud.client.apfClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * Created by RogueZww on 2018/3/29.
 */
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private apfClient apfClient;

    @GetMapping("/ribbon1")
    @HystrixCommand(fallbackMethod = "ribbon1Fallback")
    public String ribbon1() {
        String forObject = restTemplate.getForObject("http://ribbonServer/index", String.class);
        return forObject;
    }

    @GetMapping("/client1")
    public String client1() {
        return apfClient.getToken();
    }

    @GetMapping("/client2")
    public String client2() {
        return apfClient.index();
    }

    @GetMapping("/client3")
    public String client3() {
        return apfClient.retry();
    }

    private String ribbon1Fallback(Throwable e) {
        if (e instanceof RuntimeException) {
            return e.getMessage();
        }
        return "this is fall back";
    }

    @GetMapping("/zuul1")
    public String zuul1() {
        return "zuul";
    }

    @GetMapping("/zuul2")
    public String zuul2() {
        boolean b = new Random().nextBoolean();
        if (b) {
            throw new RuntimeException("consumer exception!");
        }
        return "zuul";
    }

    @GetMapping("/optional/userid")
    public String optional2() {
        return apfClient.optional2();
    }

    @GetMapping("/parameter")
    public String parameter(@RequestParam(required = false) String parameter) {
        return parameter == null ? "" : parameter;
    }

}
