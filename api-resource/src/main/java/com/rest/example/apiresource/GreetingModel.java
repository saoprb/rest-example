package com.rest.example.apiresource;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GreetingModel {
    private static final String VERSION = "1.0";
    private final String greeting;
}
