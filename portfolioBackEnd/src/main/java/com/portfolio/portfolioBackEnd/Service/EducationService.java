package com.portfolio.portfolioBackEnd.Service;

import com.portfolio.portfolioBackEnd.Entity.Education;
import com.portfolio.portfolioBackEnd.Repository.EducationRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService {
    @Autowired
    public EducationRepository educationR;

   
    public List<Education> verEducation(){
      return educationR.findAll();
    }

   
    public void crearEducation(Education edu){
      educationR.save(edu);
    }
   
   
    public void borrarEducation (Long id){
      educationR.deleteById(id);
    } 
 
   
    public Education buscarEducation(Long id){
      return educationR.findById(id).orElse(null);
    }
    
    
    public void editarEducation (Long id, Education edu){
         educationR.findById(id).map( editEdu -> {
         editEdu.setImgInstitucion(edu.getImgInstitucion());
         editEdu.setInstitucion(edu.getInstitucion());
         editEdu.setTitulo(edu.getTitulo());
         editEdu.setTiempo(edu.getTiempo());
         editEdu.setEstado(edu.getEstado());

         return educationR.save(editEdu);
      });
    }

    public Boolean existsEducation(Long id){
    try {
        educationR.findById(id);
        return true;
        } catch(Exception e){
         return false;
         }
        }
}
