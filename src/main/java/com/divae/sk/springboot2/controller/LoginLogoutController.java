package com.divae.sk.springboot2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginLogoutController {

    @GetMapping("/anmelden")
    public String redirectToLoginPage(){
        return "anmelden";
    }
}
