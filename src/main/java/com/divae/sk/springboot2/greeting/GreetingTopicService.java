package com.divae.sk.springboot2.greeting;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GreetingTopicService {

//    @Qualifier("topicJmsTemplate")
    private final JmsTemplate topicJmsTemplate;

    public GreetingTopicService(@Qualifier("topicJmsTemplate") JmsTemplate topicJmsTemplate){
        this.topicJmsTemplate = topicJmsTemplate;
    }

    void triggerGreetingTopic() {
        log.info("destination: {}", topicJmsTemplate.getDefaultDestinationName());
        topicJmsTemplate.send("greeting-topic", session ->
                session.createTextMessage("Hello Topic!"));
    }
}
