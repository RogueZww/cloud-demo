package com.zww.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by RogueZww on 2018/4/19.
 */
@SpringBootApplication
public class MessageApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MessageApplication.class).web(true).run(args);
    }

}
