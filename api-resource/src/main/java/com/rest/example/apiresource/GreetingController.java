package com.rest.example.apiresource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

@Slf4j
@RestController
public class GreetingController {

    @GetMapping("/greeting/{username}")
    public GreetingModel greeting(@PathVariable("username") String username) {

        if (getRandom() % 2 == 0) {
            log.info("GreetingController: Api failure");
            throw new GreetingControllerException("Api failure");
        }

        GreetingModel greetingModel = new GreetingModel(String.format("Hello %s!%n", username),
                LocalDateTime.now(TimeZone.getTimeZone("UTC").toZoneId()),
                LocalDate.now(TimeZone.getTimeZone("UTC").toZoneId()));
        log.info("GreetingController: Return [{}]", greetingModel);
        return greetingModel;
    }

    protected int getRandom() {
        return new Random(new Date().getTime()).nextInt();
    }
}
