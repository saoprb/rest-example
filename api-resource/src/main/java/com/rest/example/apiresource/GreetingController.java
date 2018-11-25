package com.rest.example.apiresource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
public class GreetingController {

    @GetMapping("/greeting/{username}")
    public GreetingModel greeting(@PathVariable("username") String username) {

        if (getRandom() % 10 == 0) {
            throw new GreetingControllerException("Api failure");
        }

        return new GreetingModel(String.format("Hello %s!%n", username));
    }

    protected int getRandom() {
        return new Random(new Date().getTime()).nextInt();
    }
}
