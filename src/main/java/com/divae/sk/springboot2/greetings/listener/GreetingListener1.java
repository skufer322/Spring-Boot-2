package com.divae.sk.springboot2.greetings.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GreetingListener1 {

    @JmsListener(destination = "greetings-topic")
    @SendTo("greeting-response-queue")
    public String onGreeting(final String greeter) {
        log.info("GreetingListener1 received a greeting from {}.", greeter);
        return "GreetingListener1 response";
    }
}
