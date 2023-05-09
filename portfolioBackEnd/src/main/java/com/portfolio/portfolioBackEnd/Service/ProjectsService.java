package com.portfolio.portfolioBackEnd.Service;

import com.portfolio.portfolioBackEnd.Entity.Projects;
import com.portfolio.portfolioBackEnd.Repository.ProjectsRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectsService {
    
    @Autowired
    public ProjectsRepository projectsR;

    
    public List<Projects> verProjects(){
      return projectsR.findAll();
    }

    
    public void crearProjects (Projects pro){
      projectsR.save(pro);
    }
   
   
    public void borrarProjects (Long id){
      projectsR.deleteById(id);
    } 
 
   
    public Projects buscarProjects (Long id){
      return projectsR.findById(id).orElse(null);
    }

  
    public void editarProjects (Long id, Projects pro){
         projectsR.findById(id).map( editExpe -> {
         editExpe.setImgProyecto(pro.getImgProyecto());
         editExpe.setNomProyecto(pro.getNomProyecto());
         editExpe.setUrlProyecto(pro.getUrlProyecto());

         return projectsR.save(editExpe);
      });
    }
    
            public Boolean existsProjects(Long id){
                try {
                  projectsR.findById(id);
                  return true;
                 } catch(Exception e){
                    return false;
                 }
            }
}
