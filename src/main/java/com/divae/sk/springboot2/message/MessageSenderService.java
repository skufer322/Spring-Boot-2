package com.divae.sk.springboot2.message;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageSenderService {

    private final JmsTemplate jmsTemplate;

    // --- String
    void sendTextGreeting(final String greeter){
        jmsTemplate.send("greetings-queue",
                session -> session.createTextMessage("Hello to Spring from " + greeter + "!"));
    }

    @JmsListener(destination = "responses-queue")
    public void receiveResponse(final String response){
        log.info("An answer to your greeting has been received: {}", response);
    }

    // --- Object
    void sendObjectAndSetHeaders(final String messageInfo){
        MyMessageObject mmo = MyMessageObject.builder()
                .id(new Random().nextLong())
                .info(messageInfo)
                .build();
        jmsTemplate.convertAndSend("greetings-object-queue", mmo, m -> {
            m.setJMSCorrelationID(UUID.randomUUID().toString());
            m.setJMSReplyTo(new ActiveMQQueue("header-specified-responses-queue"));
            return m;
        });
    }

    @JmsListener(destination = "header-specified-responses-queue")
    public void receiveHeaderSpecifiedResponse(final String response){
        log.info("Received a header-specified response: {}", response);
    }
}
