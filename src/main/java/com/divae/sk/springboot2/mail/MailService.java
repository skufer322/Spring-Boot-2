package com.divae.sk.springboot2.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import static java.nio.charset.StandardCharsets.UTF_8;

@Component
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;

    void sendEmailFrom(String name){
        javaMailSender.send(mimeMessage -> {
            final MimeMessageHelper message =
                    new MimeMessageHelper(
                            mimeMessage, true, UTF_8.name()
                    );
            message.setFrom("hallo_von_" + name + "@spring-boot-2-example.de" );
            message.setTo("stefan.kufer@diva-e.com");
            message.setSubject("Teste Spring Mail");
            message.setText("Hallo,\ndies ist eine Test-Nachricht von " + name + "!\nViele Grüße!");
        });
    }
}
