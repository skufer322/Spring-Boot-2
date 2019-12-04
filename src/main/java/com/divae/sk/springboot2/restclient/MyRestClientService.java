package com.divae.sk.springboot2.restclient;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;

@RestController
public class MyRestClientService {

    private final RestTemplate restTemplate;

    public MyRestClientService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public String getRemoteInfo(){
        return "returned: " + Objects.requireNonNull(restTemplate.getForObject("https://biking.michael-simons.eu/api/system/info", Map.class)).get("spring-boot.version");
    }
}
