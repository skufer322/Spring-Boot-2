package com.divae.sk.springboot2.greetings;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GreetingService {

    private final JmsTemplate jmsTemplate;

    void triggerGreetingMessages(final String greeter) {
        jmsTemplate.send("greetings-topic", session -> session.createTextMessage(greeter));
    }
}
