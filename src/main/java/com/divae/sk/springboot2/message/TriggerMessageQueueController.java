package com.divae.sk.springboot2.message;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TriggerMessageQueueController {

    private final MessageSenderService messageSenderService;

    @GetMapping("/trigger/{greeter}")
    public String triggerGreeting(@PathVariable final String greeter){
        messageSenderService.sendTextGreeting(greeter);

        return "The greeting has been sent. Take a look at your message logs.";
    }

    @GetMapping("/trigger/object/{messageInfo}")
    public String triggerObjectGreeting(@PathVariable final String messageInfo){
        messageSenderService.sendObjectAndSetHeaders(messageInfo);

        return "An object and some JMS headers have been created. Look at your logs for more info!";
    }
}
