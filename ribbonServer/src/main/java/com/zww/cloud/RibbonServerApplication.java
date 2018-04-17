package com.zww.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by RogueZww on 2018/3/29.
 */
@SpringBootApplication
@EnableEurekaClient
public class RibbonServerApplication {

    public static void main(String[] args) {
        new SpringApplication().run(RibbonServerApplication.class);
    }
}
