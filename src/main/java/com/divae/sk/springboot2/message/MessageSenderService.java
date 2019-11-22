package com.divae.sk.springboot2.message;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageSenderService {

    private final JmsTemplate jmsTemplate;

    void sendGreeting(final String greeter){
        jmsTemplate.send("greetings-topic",
                session -> session.createTextMessage("Hello to Spring from " + greeter + "!"));
    }

    @JmsListener(destination = "responses-queue")
    public void receiveResponse(final String response){
        log.info("An answer to your greeting has been received: {}", response);
    }
}
