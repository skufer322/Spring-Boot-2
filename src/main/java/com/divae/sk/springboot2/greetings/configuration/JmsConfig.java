package com.divae.sk.springboot2.greetings.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.destination.DestinationResolver;

import javax.jms.IllegalStateException;

@Configuration
public class JmsConfig {

    @Bean
    public DestinationResolver destinationResolver(){
        return (session, destinationName, pubSubDomain) -> {
            if (session == null){
                throw new IllegalStateException("session is null!");
            }
            if (destinationName.contains("queue")){
                return session.createQueue(destinationName);
            } else if (destinationName.endsWith("topic")){
                return session.createTopic(destinationName);
            }
            throw new RuntimeException("Invalid destination: " + destinationName);
        };
    }
}
