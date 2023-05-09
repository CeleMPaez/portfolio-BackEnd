package com.portfolio.portfolioBackEnd.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Education {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imgInstitucion;
    private String institucion;
    private String titulo;  
    private String tiempo;
    private String estado;


    public Education(){
    }

    public Education(String imgInstitucion, String institucion, String titulo, String tiempo, String estado){
       this.imgInstitucion = imgInstitucion;
       this.institucion = institucion;
       this.titulo = titulo;
       this.tiempo = tiempo;
       this.estado = estado;
      
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
