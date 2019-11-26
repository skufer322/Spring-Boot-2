package com.divae.sk.springboot2.listener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class GreetingListener {

    String onGreeting(final String greeter){
        log.info("Greeting from {} received at {}.", greeter, System.currentTimeMillis());
        return "I received a greeting from " + greeter + ".";
    }
}
