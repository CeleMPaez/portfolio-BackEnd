package com.portfolio.portfolioBackEnd.Service;

import com.portfolio.portfolioBackEnd.Entity.Skills;
import com.portfolio.portfolioBackEnd.Repository.SkillsRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillsService {
    
    @Autowired
    public SkillsRepository skillsR;

    
    public List<Skills> verSkills (){
      return skillsR.findAll();
    }

  
    public void crearSkill (Skills sk){
      skillsR.save(sk);
    }
   
    
    public void borrarSkill (Long id){
      skillsR.deleteById(id);
    } 
 
   
    public Skills buscarSkill(Long id){
      return skillsR.findById(id).orElse(null);
    }
    
   
    public void editarSkill (Long id, Skills sk){
         skillsR.findById(id).map( editSk -> {
         editSk.setNombreSkill(sk.getNombreSkill());
         editSk.setPorcentajeSkill(sk.getPorcentajeSkill());

         return skillsR.save(editSk);
      });
    }

        
            public Boolean existsSkill(Long id){
                try {
                  skillsR.findById(id);
                   return true;
                 } catch(Exception e){
                    return false;
                 }
           }
}
