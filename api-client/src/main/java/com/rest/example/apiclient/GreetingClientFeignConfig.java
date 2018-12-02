package com.rest.example.apiclient;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;

public class GreetingClientFeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Retryer retryer() {
        return new Retryer.Default();
    }
}
