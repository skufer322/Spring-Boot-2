package com.divae.sk.springboot2.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

@Configuration
@RequiredArgsConstructor
public class ListenerConfig implements JmsListenerConfigurer {

    @Override
    public void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {
        // greeting listener
        final MessageListenerAdapter adapter = new MessageListenerAdapter(new GreetingListener());
        adapter.setDefaultListenerMethod("onGreeting");
        adapter.setDefaultResponseQueueName("greeting-response-queue");

        final SimpleJmsListenerEndpoint rv = new SimpleJmsListenerEndpoint();
        rv.setId("greetingsEndpoint");
        rv.setMessageListener(adapter);
        rv.setDestination("greetings-queue");

        registrar.registerEndpoint(rv);

        // response listener
        final MessageListenerAdapter adapter2 = new MessageListenerAdapter(new ResponseListener());
        adapter2.setDefaultListenerMethod("listenToGreetingResponseQueue");

        final SimpleJmsListenerEndpoint rv2 = new SimpleJmsListenerEndpoint();
        rv2.setId("reponseListenerEndpoint");
        rv2.setMessageListener(adapter2);
        rv2.setDestination("greeting-response-queue");

        registrar.registerEndpoint(rv2);
    }
}
