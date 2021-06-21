package com.example.cyberpunk.models;

import com.example.cyberpunk.entities.Personaje;

public class PersonajeModel {

    private Long id;
    private String Titulo;
    private String Bio;
    private String Img;


    /* from convierte de modelo a entidad*/
    public static PersonajeModel from(Personaje personaje) {
        PersonajeModel personajeModel = new PersonajeModel();


        personajeModel.setId(personaje.getId());
        personajeModel.setTitulo(personaje.getTitulo());
        personajeModel.setBio(personaje.getBio());
        personajeModel.setImg(personaje.getImg());
//        personajeModel.setImg(personaje.getImg().substring(22));
      /*  personajeModel.setRuta(personaje.getRuta()); */
        return personajeModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getBio() {
        return Bio;
    }

    public void setBio(String Bio) {
        this.Bio = Bio;
    }


    public String getImg() {
        return Img;
    }

    public void setImg(String Img) {
        this.Img = Img;
    }



}



/*image:base64,tpoye:qweqwe, fjghsdfgjkhsdfgjklsdhfgkljdfghsdfjklhkl substring java8*/







