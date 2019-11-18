package com.divae.sk.springboot2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class OAuth2LoginController {

    @GetMapping("/hello-oauth")
    public String sayHello(Principal principal) {
        return "Hello, " + principal.getName();
    }
}
