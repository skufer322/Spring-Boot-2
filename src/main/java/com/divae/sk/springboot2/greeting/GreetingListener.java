package com.divae.sk.springboot2.greeting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GreetingListener {

    @JmsListener(
            destination = "greeting-queue",
            containerFactory = "queueContainerFactory")
    public void greetingListenerQueue(final String message) {
        log.info("greeting QUEUE listener has received an event: {}", message);
    }

    @JmsListener(
            destination = "greeting-topic",
            containerFactory = "topicContainerFactory"
    )
    public void greetingListenerTopic1(final String message) {
        log.info("greeting TOPIC_1 listener has received an event: {}", message);
    }

    @JmsListener(
            destination = "greeting-topic",
            containerFactory = "topicContainerFactory"
    )
    public void greetingListenerTopic2(final String message) {
        log.info("greeting TOPIC_2 listener has received an event: {}", message);
    }
}
