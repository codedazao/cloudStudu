package com.borrow.config;


import feign.Retryer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFeignClientConfiguration {
    @Bean
    public Retryer feginRetryer(){
        return new Retryer.Default(0,0,0);
    }
}
