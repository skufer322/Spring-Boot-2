package com.divae.sk.springboot2.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @GetMapping("mail/{name}")
    public String getPersonalizedEmail(@PathVariable final String name) {
        mailService.sendEmailFrom(name);
        return "An email has been sent from " + name + " to stefan.kufer@diva-e.com.";
    }
}
