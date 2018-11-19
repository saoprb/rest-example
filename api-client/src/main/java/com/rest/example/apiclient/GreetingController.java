package com.rest.example.apiclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private GreetingClient greetingClient;

    @GetMapping("/greeting/{username}")
    public String greeting(@PathVariable("username") String username) {
        return greetingClient.greeting(username);
    }
}
