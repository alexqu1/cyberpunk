package com.example.cyberpunk.services;

import com.example.cyberpunk.models.EmailModel;
import com.example.cyberpunk.models.PersonajeModel;
import org.springframework.stereotype.Service;

public interface EmailService {

    EmailModel GuardarEmail(String newEmail);
}
