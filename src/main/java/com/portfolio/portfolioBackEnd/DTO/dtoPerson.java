package com.portfolio.portfolioBackEnd.DTO;

import javax.validation.constraints.NotBlank;

public class dtoPerson {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String imgPerfil;
    @NotBlank
    private String titulo;
    @NotBlank
    private String descripcion;
    
    public dtoPerson() {
    
    }
    
    public dtoPerson(@NotBlank String nombre, @NotBlank String email, @NotBlank String password, @NotBlank String imgPerfil, @NotBlank String titulo, @NotBlank String descripcion) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.imgPerfil = imgPerfil;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    
    public String getImgPerfil() {
        return imgPerfil;
    }
    
    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
