package com.portfolio.portfolioBackEnd.Service;

import com.portfolio.portfolioBackEnd.Entity.Person;
import com.portfolio.portfolioBackEnd.Repository.PersonRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    
    @Autowired
    public PersonRepository personR;

    
    public List<Person> verPerson (){
      return personR.findAll();
    }

  
    public void crearPerson (Person p){
      personR.save(p);
    }
   
    
    public void borrarPerson (Long id){
      personR.deleteById(id);
    } 
 
   
    public Person buscarPerson(Long id){
      return personR.findById(id).orElse(null);
    }
    
   
    public void editarSkill (Long id, Person p){
         personR.findById(id).map( editP -> {
         editP.setNombre(p.getNombre());
         editP.setEmail(p.getEmail());
         editP.setPassword(p.getPassword());
         editP.setImgPerfil(p.getImgPerfil());
         editP.setTitulo(p.getTitulo());
         editP.setDescripcion(p.getDescripcion());

         return personR.save(editP);
      });
    }

        
            public Boolean existsPerson(Long id){
                try {
                  personR.findById(id);
                   return true;
                 } catch(Exception e){
                    return false;
                 }
           }
}
