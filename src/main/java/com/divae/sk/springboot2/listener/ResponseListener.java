package com.divae.sk.springboot2.listener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ResponseListener {

    void listenToGreetingResponseQueue(final String response) {
        log.info("Received the following response: {}.", response);
    }
}
