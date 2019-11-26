package com.divae.sk.springboot2.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.support.JmsMessageHeaderAccessor;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class MessageReceiverService {

    @JmsListener(destination = "greetings-queue")
    @SendTo("responses-queue")
    public String onGreeting(final String greeting) {
        log.info("Received greeting: {}", greeting);
        return "Hello back from Spring!";
    }

    @JmsListener(destination = "greetings-object-queue")
    public String onObjectGreeting(final MyMessageObject mmo,
                                 // neben der payload kann man auch noch header setzen/auslesen -> wird hier bsphaft ausgelesen
                                 @Headers Map<String, Object> headers, MessageHeaders messageHeaders, JmsMessageHeaderAccessor jmsMessageHeaderAccessor){
        log.info("Received object: {}", mmo);
        log.info("Headers map: {}", headers);
        log.info("Message headers: {}", messageHeaders);
        log.info("Jms message header accessor: {}", jmsMessageHeaderAccessor);
        return headers.get("jms_replyTo").toString();
    }
}
