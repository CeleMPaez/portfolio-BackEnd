package com.portfolio.portfolioBackEnd.DTO;

import javax.validation.constraints.NotBlank;

public class dtoProjects {
    
    @NotBlank
    private String imgProyecto;
    @NotBlank
    private String nomProyecto;
    @NotBlank
    private String urlProyecto;  
   


    public dtoProjects(){
    
    }

    public dtoProjects( @NotBlank String imgProyecto,  @NotBlank String nomProyecto,  @NotBlank String urlProyecto){
       this.imgProyecto = imgProyecto;
       this.nomProyecto = nomProyecto;
       this.urlProyecto = urlProyecto;
    }

    public String getImgProyecto() {
        return imgProyecto;
    }

    public void setImgProyecto(String imgProyecto) {
        this.imgProyecto = imgProyecto;
    }

    public String getNomProyecto() {
        return nomProyecto;
    }

    public void setNomProyecto(String nomProyecto) {
        this.nomProyecto = nomProyecto;
    }

    public String getUrlProyecto() {
        return urlProyecto;
    }

    public void setUrlProyecto(String urlProyecto) {
        this.urlProyecto = urlProyecto;
    }
}
