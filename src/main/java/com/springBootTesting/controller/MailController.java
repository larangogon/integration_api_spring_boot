package com.springBootTesting.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBootTesting.services.MailService;

@RestController("/mail")
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @GetMapping("/send-simple-mail")
    void sendMail() {
        mailService.sendSimpleMail();
    }
}
