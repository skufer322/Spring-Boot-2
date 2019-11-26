package com.divae.sk.springboot2.greetings;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingService greetingService;

    @GetMapping("/greeting/{greeter}")
    public String getGreetingFromGreeter(@PathVariable final String greeter) {
        greetingService.triggerGreetingMessages(greeter);
        return "The greeting messages have been triggered!";
    }
}
