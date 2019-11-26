package com.divae.sk.springboot2.greeting;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingQueueService greetingQueueService;
    private final GreetingTopicService greetingTopicService;

    @GetMapping("/greeting/queue")
    public String triggerGreetingQueue(){
        greetingQueueService.triggerGreetingQueue();
        return "Greeting queue has been triggered!";
    }

    @GetMapping("/greeting/topic")
    public String triggerGreetingTopic(){
        greetingTopicService.triggerGreetingTopic();
        return "Greeting topic has been triggered!";
    }
}
