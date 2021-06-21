package com.example.cyberpunk.services.impl;

import com.example.cyberpunk.entities.Personaje;
import com.example.cyberpunk.models.ImageModel;
import com.example.cyberpunk.models.PersonajeModel;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import com.example.cyberpunk.repositories.PersonajeRepository;
import com.example.cyberpunk.services.PersonajeService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


@Service
public class PersonajeServiceImpl implements PersonajeService {

    private final PersonajeRepository personajeRepository;


    public PersonajeServiceImpl(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }


    @Override
    public List<PersonajeModel> getAll() {
        return personajeRepository.findAll().stream().map(PersonajeModel::from).collect(Collectors.toList());
    }

    @Override
    public PersonajeModel createPersonaje(PersonajeModel newPersonaje) {
        Personaje personaje = new Personaje();
        personaje.setTitulo(newPersonaje.getTitulo());
        personaje.setBio(newPersonaje.getBio());

        return PersonajeModel.from(personajeRepository.save(personaje));
    }

    @Override
    public PersonajeModel getOneById(Long id) throws NotFoundException {
        Personaje personaje = personajeRepository.findById(id).get();
        PersonajeModel personajeModel = PersonajeModel.from(personajeRepository.findById(id).get());
        return PersonajeModel.from(personajeRepository.findById(id).orElseThrow(() -> new NotFoundException("No se encontro el personaje")));
    }

    @Override
    public ImageModel saveImage(Long id, MultipartHttpServletRequest request) throws IOException, NotFoundException {
        ImageModel imageModel = new ImageModel();
        Iterator<String> itr = request.getFileNames();
        MultipartFile multipartFile = request.getFile(itr.next());
        String filename = id + "_" + multipartFile.getOriginalFilename();
        byte[] fileContent = multipartFile.getBytes();
        File file = new File("./images/" + filename);
        try {

            OutputStream os = new FileOutputStream(file);
            os.write(fileContent);
            System.out.println("Write bytes to file.");
            printContent(file);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Personaje personaje = personajeRepository.findById(id).orElseThrow(() -> new NotFoundException("No se encontro el personaje"));
        personaje.setImg(filename);
        personajeRepository.save(personaje);

        imageModel.setName(filename);
        imageModel.setPicByte(fileContent);
        return imageModel;
    }

    public static void printContent(File file) throws Exception {
        System.out.println("Print File Content");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }


}
