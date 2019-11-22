package com.divae.sk.springboot2.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageReceiverService {

    @JmsListener(destination = "greetings-queue")
    @SendTo("responses-queue")
    public String onGreeting(final String greeting){
      log.info("Received greeting: {}", greeting);
      return "Hello back from Spring!";
    }
}
