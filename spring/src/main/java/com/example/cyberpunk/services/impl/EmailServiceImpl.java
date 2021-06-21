package com.example.cyberpunk.services.impl;

import com.example.cyberpunk.entities.Email;
import com.example.cyberpunk.models.EmailModel;
import com.example.cyberpunk.repositories.EmailRepository;
import com.example.cyberpunk.services.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final EmailRepository emailRepository;

    public EmailServiceImpl(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }


    @Override
    public EmailModel GuardarEmail(String newEmail) {

        Email email= new Email();
        email.setEmail(newEmail);

        return EmailModel.from(emailRepository.save(email));
    }
}
