package com.rest.example.apiclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "api-resource", fallback = GreetingClient.GreetingClientFallback.class)
public interface GreetingClient {

    @GetMapping("/greeting/{username}")
    String greeting(@PathVariable("username") String username);

    @Component
    class GreetingClientFallback implements GreetingClient {

        @Override
        public String greeting(String username) {
            return String.format("Fallback Hello %s!\n", username);
        }
    }
}
