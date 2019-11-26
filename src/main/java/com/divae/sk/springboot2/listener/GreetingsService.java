package com.divae.sk.springboot2.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class GreetingsService {

    private final JmsTemplate jmsTemplate;

    void processGreeting(final String greeter) {
        log.info("Now processing the greeter's {} greeting!", greeter);
        jmsTemplate.send("greetings-queue", session ->
                session.createTextMessage(greeter));
    }
}
