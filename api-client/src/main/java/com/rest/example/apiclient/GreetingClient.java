package com.rest.example.apiclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TimeZone;

@FeignClient(name = "api-resource",
        fallback = GreetingClient.GreetingClientFallback.class,
        configuration = GreetingClientFeignConfig.class)
public interface GreetingClient {

    @GetMapping("/greeting/{username}")
    GreetingModel greeting(@PathVariable("username") String username);

    @Component
    class GreetingClientFallback implements GreetingClient {

        @Override
        public GreetingModel greeting(String username) {
            return new GreetingModel(String.format("Fallback Hello %s!%n", username),
                    LocalDateTime.now(TimeZone.getTimeZone("UTC").toZoneId()),
                    LocalDate.now(TimeZone.getTimeZone("UTC").toZoneId()));
        }
    }
}
