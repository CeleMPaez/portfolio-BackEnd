package com.portfolio.portfolioBackEnd.DTO;

import javax.validation.constraints.NotBlank;

public class dtoEducation {
    
    @NotBlank
    private String imgInstitucion;
    @NotBlank
    private String institucion;
    @NotBlank
    private String titulo;  
    @NotBlank
    private String tiempo;
    @NotBlank
    private String estado;


    public dtoEducation(){
    
    }

    public dtoEducation (@NotBlank String imgInstitucion,@NotBlank  String institucion, @NotBlank String titulo, @NotBlank String tiempo, @NotBlank String estado){
       this.imgInstitucion = imgInstitucion;
       this.institucion = institucion;
       this.titulo = titulo;
       this.tiempo = tiempo;
       this.estado = estado;
    }

    public String getImgInstitucion() {
        return imgInstitucion;
    }
    
    public void setImgInstitucion(String imgInstitucion) {
        this.imgInstitucion = imgInstitucion;
    }
    
    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String periodo) {
        this.tiempo = periodo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
