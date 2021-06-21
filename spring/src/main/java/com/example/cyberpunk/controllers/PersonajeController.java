package com.example.cyberpunk.controllers;


import com.example.cyberpunk.models.EmailModel;
import com.example.cyberpunk.models.ImageModel;
import com.example.cyberpunk.models.PersonajeModel;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;
import com.example.cyberpunk.services.PersonajeService;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/personaje")
public class PersonajeController {

    private final PersonajeService personajeService;

    public PersonajeController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping
    public List<PersonajeModel> getAll() {
        return personajeService.getAll();
    }

    @PostMapping
    public PersonajeModel createUsuario(@RequestBody PersonajeModel newPersonaje) {
        return personajeService.createPersonaje(newPersonaje);

    }

    @GetMapping("/{id}")
    public PersonajeModel getById(@PathVariable Long id) throws NotFoundException {
        return personajeService.getOneById(id);
    }

    @RequestMapping(value = "/{id}/image")
    @ResponseBody
    public byte[] getImage(@PathVariable long id) throws IOException, NotFoundException {
        PersonajeModel personaje = personajeService.getOneById(id);
        Path path = Paths.get("./images/" + personaje.getImg());
        return Files.readAllBytes(path);
    }

    @RequestMapping(value = "/{id}/image/upload")
    @ResponseBody
    public ImageModel saveImage(MultipartHttpServletRequest request, @PathVariable Long id) throws IOException, NotFoundException {
        return personajeService.saveImage(id, request);
    }


}
