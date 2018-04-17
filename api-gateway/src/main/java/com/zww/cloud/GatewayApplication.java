package com.zww.cloud;

import com.netflix.zuul.FilterProcessor;
import com.zww.cloud.filter.ErrorHandler;
import com.zww.cloud.filter.TokenFilter;
import com.zww.cloud.processor.PostFilterProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created by RogueZww on 2018/4/8.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class GatewayApplication {

    public static void main(String[] args) {
        new SpringApplication().run(GatewayApplication.class);
        FilterProcessor.setProcessor(new PostFilterProcessor());
    }

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

    @Bean
    public ErrorHandler errorHandler() {
        return new ErrorHandler();
    }


}
