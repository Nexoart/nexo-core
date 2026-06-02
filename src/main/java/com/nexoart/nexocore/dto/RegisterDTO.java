package com.nexoart.nexocore.dto;

public class RegisterDTO {

    private String name;
    private String email;
    private String password;
    private boolean isArtista;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isArtista() {
        return isArtista;
    }

    public void setArtista(boolean artista) {
        isArtista = artista;
    }
}