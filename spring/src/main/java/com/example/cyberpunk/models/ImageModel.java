package com.example.cyberpunk.models;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Iterator;


public class ImageModel {

   	public ImageModel(String name, String type, byte[] picByte) {
    this.name = name;
    this.type = type;
    this.picByte = picByte;
}
@Id
private Long id;
private String name;

private String type;
    //image bytes can have large lengths so we specify a value
    //which is more than the default length for picByte column


    private byte[] picByte;

    public ImageModel() {

    }

    public String getName() {
        return name;
    }	public void setName(String name) {
        this.name = name;
    }	public String getType() {
        return type;
    }	public void setType(String type) {
        this.type = type;
    }	public byte[] getPicByte() {
        return picByte;
    }	public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }
}
