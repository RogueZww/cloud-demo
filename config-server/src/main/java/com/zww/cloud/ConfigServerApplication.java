package com.zww.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by RogueZww on 2018/4/17.
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigServerApplication {

    public static void main(String[] args) {
        new SpringApplication().run(ConfigServerApplication.class);
    }
}
