package com.example.cyberpunk.services;

import com.example.cyberpunk.models.ImageModel;
import com.example.cyberpunk.models.PersonajeModel;
import javassist.NotFoundException;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.List;

public interface PersonajeService {

     List<PersonajeModel> getAll();

    PersonajeModel createPersonaje(PersonajeModel newPersonaje);

    PersonajeModel getOneById(Long id) throws NotFoundException;

    ImageModel saveImage(Long id, MultipartHttpServletRequest request) throws IOException, NotFoundException;

}
