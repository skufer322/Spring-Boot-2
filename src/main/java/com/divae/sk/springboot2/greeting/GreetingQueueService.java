package com.divae.sk.springboot2.greeting;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class GreetingQueueService {

    private final JmsTemplate queJmsTemplate;

    public GreetingQueueService(@Qualifier("queueJmsTemplate") JmsTemplate queJmsTemplate) {
        this.queJmsTemplate = queJmsTemplate;
    }

    void triggerGreetingQueue() {
        queJmsTemplate.send("greeting-queue", session ->
                session.createTextMessage("Hello Queue!"));
    }
}
