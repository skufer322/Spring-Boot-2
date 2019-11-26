package com.divae.sk.springboot2.greeting;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GreetingService {

    @Qualifier("queueJmsTemplate")
    private final JmsTemplate queueJmsTemplate;
    @Qualifier("topicJmsTemplate")
    private final JmsTemplate topicJmsTemplate;

    void triggerGreetingQueue() {
        queueJmsTemplate.send("greeting-queue", session ->
                session.createTextMessage("Hello Queue!"));
    }

    void triggerGreetingTopic() {
        topicJmsTemplate.send("greeting-topic", session ->
                session.createTextMessage("Hello Topic!"));
    }
}
