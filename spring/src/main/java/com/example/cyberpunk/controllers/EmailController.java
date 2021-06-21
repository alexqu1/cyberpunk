package com.example.cyberpunk.controllers;

import com.example.cyberpunk.models.EmailModel;
import com.example.cyberpunk.services.EmailService;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/guardarEmail")

public class EmailController {


    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }


    @PostMapping
    public EmailModel GuardarEmail(@RequestBody String newEmail) {
        return emailService.GuardarEmail(newEmail);
    }


}






