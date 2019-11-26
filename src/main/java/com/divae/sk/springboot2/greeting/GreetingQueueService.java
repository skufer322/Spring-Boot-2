package com.divae.sk.springboot2.greeting;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class GreetingQueueService {

    private final JmsTemplate queueJmsTemplate;

    public GreetingQueueService(@Qualifier("queueJmsTemplate") JmsTemplate queueJmsTemplate) {
        this.queueJmsTemplate = queueJmsTemplate;
    }

    void triggerGreetingQueue() {
        queueJmsTemplate.send("greeting-queue", session ->
                session.createTextMessage("Hello Queue!"));
    }
}
