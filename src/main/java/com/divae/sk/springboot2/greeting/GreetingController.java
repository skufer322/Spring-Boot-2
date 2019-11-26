package com.divae.sk.springboot2.greeting;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingService greetingService;

    @GetMapping("/greeting/queue")
    public String triggerGreetingQueue(){
        greetingService.triggerGreetingQueue();
        return "Greeting queue has been triggered!";
    }

    @GetMapping("/greeting/topic")
    public String triggerGreetingTopic(){
        greetingService.triggerGreetingTopic();
        return "Greeting topic has been triggered!";
    }
}
