package com.betul.mailapp.controller;

import com.betul.mailapp.model.Mail;
import com.betul.mailapp.model.MailCreateRequest;
import com.betul.mailapp.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/mails")
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody MailCreateRequest mailCreateRequest) {
        mailService.create(mailCreateRequest);
    }

    @GetMapping
    public List<Mail> getAll() {
        return mailService.getAll();
    }

}
