package com.rest.example.apiclient;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class GreetingModel {
    private static final String VERSION = "1.0";
    private final String greeting;
    private final LocalDateTime timestamp;
    private final LocalDate dateToday;
}
