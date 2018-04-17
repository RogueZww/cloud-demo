package com.zww.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by RogueZww on 2018/3/29.
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaClientApplication {

    public static void main(String[] args) {
        new SpringApplication().run(EurekaClientApplication.class);
    }
}
