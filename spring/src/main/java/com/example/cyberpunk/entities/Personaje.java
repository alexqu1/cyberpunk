package com.example.cyberpunk.entities;

import javax.persistence.*;

@Entity
@Table(name = "personaje")

public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

@Column(name = "Titulo")
private String Titulo;

@Column(name ="Bio")
private String Bio;

@Column(name ="Img")
private String Img;
/*
@Column(name ="Ruta")
private  String Ruta;*/

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

/*
    public String getRuta() {
        return Ruta;
    }

    public void setRuta(String Ruta) {
        this.Ruta = Ruta;
    } */

}
