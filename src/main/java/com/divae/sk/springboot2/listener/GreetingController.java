package com.divae.sk.springboot2.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingsService greetingListenerService;

    @GetMapping("/greeting/{greeter}")
    public String getGreetingFromGreeter(@PathVariable final String greeter){
        greetingListenerService.processGreeting(greeter);
        return "The greeting has been delivered!";
    }
}
