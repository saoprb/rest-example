package com.rest.example.apiresource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
public class GreetingController {

    @GetMapping("/greeting/{username}")
    public String greeting(@PathVariable("username") String username) {

        int randomInt = new Random(new Date().getTime()).nextInt();

        if (randomInt % 10 == 0) {
            throw new RuntimeException("Api failure");
        }

        return String.format("Hello %s!\n", username);
    }
}
