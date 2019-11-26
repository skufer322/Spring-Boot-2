package com.divae.sk.springboot2.greetings.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ResponseListener {

    @JmsListener(destination = "greeting-response-queue")
    public void acknowledgeGreetingListener1Response(final String response) {
        log.info("GreetingListener1 responded with '{}'.", response);
    }

    @JmsListener(destination = "greeting-response-queue-2")
    public void acknowledgeGreetingListener2Response(final String response) {
        log.info("GreetingListener2 responded with '{}'.", response);
    }
}
