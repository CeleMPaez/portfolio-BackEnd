package com.portfolio.portfolioBackEnd.DTO;

import javax.validation.constraints.NotBlank;

public class dtoSkills {
    
    @NotBlank
    private String nombreSkill;
    @NotBlank
    private String porcentajeSkill;
  
    public dtoSkills(){
    
    }

    public dtoSkills ( @NotBlank String nombreSkill,  @NotBlank String porcentajeSkill){
       this.nombreSkill = nombreSkill;
       this.porcentajeSkill = porcentajeSkill;
    }

    public String getNombreSkill() {
        return nombreSkill;
    }

    public void setNombreSkill(String nombreSkill) {
        this.nombreSkill = nombreSkill;
    }

    public String getPorcentajeSkill() {
        return porcentajeSkill;
    }

    public void setPorcentajeSkill(String porcentajeSkill) {
        this.porcentajeSkill = porcentajeSkill;
    }
}
