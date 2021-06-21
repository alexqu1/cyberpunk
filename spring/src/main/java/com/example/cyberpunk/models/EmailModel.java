package com.example.cyberpunk.models;

import com.example.cyberpunk.entities.Email;


public class EmailModel {

    private Long id;
    private String Email;


    public static EmailModel from(Email email) {
        EmailModel emailModel = new EmailModel();

        emailModel.setId(email.getId());
        emailModel.setEmail(email.getEmail());

        return emailModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }


}
