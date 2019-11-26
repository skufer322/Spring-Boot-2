package com.divae.sk.springboot2.configuration;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@Configuration
public class JmsConfig {

    @Bean(name = "queueJmsTemplate")
    public JmsTemplate queueJmsTemplate(ConnectionFactory connectionFactory) {
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
        jmsTemplate.setDefaultDestinationName("greeting-queue");
        return jmsTemplate;
    }

    @Bean(name = "topicJmsTemplate")
    public JmsTemplate topicJmsTemplate(ConnectionFactory connectionFactory) {
        JmsTemplate topicJmsTemplate = new JmsTemplate(connectionFactory);
        topicJmsTemplate.setPubSubDomain(true);
        topicJmsTemplate.setDefaultDestinationName("greeting-topic");
        return topicJmsTemplate;
    }

    @Bean
    public JmsListenerContainerFactory<?> queueContainerFactory(DefaultJmsListenerContainerFactoryConfigurer configurer,
                                                                ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();

        configurer.configure(containerFactory, connectionFactory);
        return containerFactory;
    }

    @Bean
    public JmsListenerContainerFactory<?> topicContainerFactory(DefaultJmsListenerContainerFactoryConfigurer configurer,
                                                                ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();

        configurer.configure(containerFactory, connectionFactory);
        containerFactory.setPubSubDomain(true);
        return containerFactory;
    }
}
