package com.divae.sk.springboot2.message.configuration;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import java.util.List;

@Configuration
@EnableJms
public class MessageSecurityConfig {

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory(){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("vm://localhost?broker.persistent=false");
        factory.setTrustedPackages(List.of("com.divae.sk.springboot2.message"));
        return factory;
    }
}
