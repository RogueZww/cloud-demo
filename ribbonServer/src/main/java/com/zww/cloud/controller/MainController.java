package com.zww.cloud.controller;

import com.zww.cloud.dto.AlUser;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Created by RogueZww on 2018/3/29.
 */
@RestController
public class MainController {

    private static final long SLEEP = 2000l;
    @Value("${userId:ccc}")
    private String userId;
    private AtomicInteger integer = new AtomicInteger(0);
    @Autowired
    private DiscoveryClient discoveryClient;

    private Logger logger = LogManager.getLogger(MainController.class);

    @GetMapping("/index")
    public String index() throws InterruptedException {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
//        logger.info(instance.getHost() + "\n" + instance.getServiceId() + "\n" + instance.getMetadata() + "\n" +
//                instance.getPort() + "\n" + instance.getUri());
        Thread.sleep(SLEEP);
        integer.getAndIncrement();
        logger.info(integer.get());
        if (integer.get() % 2 == 0) {
            throw new RuntimeException("this is evenNumber");
        }
        return String.valueOf(instance.getPort());
    }

    @GetMapping("/retry")
    public String retry() throws InterruptedException {
        int delay = new Random().nextInt(3000);
        logger.info("let's rock and roll");
//        logger.info(2000);
        Thread.sleep(1250);
        return "retry";
    }

//    @GetMapping({"/optional/{id}", "/optional"})
//    public String optional(@PathVariable Optional<String> id) {
//        if (id.isPresent()) {
//            String ids = id.get();
//            return ids;
//        } else {
//            return "novalue";
//        }
//    }

    @GetMapping("/optional/userid")
    public String optional2(@RequestParam Optional<String> userIds) {
        if (userIds.isPresent()) {
            return userIds.get();
        } else {
            return userId;
        }
    }

    @GetMapping("/test/resolver")
    public String resolver(AlUser alUser) {
        if (alUser != null) {
            return alUser.toString();
        }
        throw new RuntimeException("coco");
    }

}
