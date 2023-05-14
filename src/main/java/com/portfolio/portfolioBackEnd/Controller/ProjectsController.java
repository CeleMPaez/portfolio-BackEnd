package com.portfolio.portfolioBackEnd.Controller;

import com.portfolio.portfolioBackEnd.DTO.Mensaje;
import com.portfolio.portfolioBackEnd.Entity.Projects;
import com.portfolio.portfolioBackEnd.DTO.dtoProjects;
import com.portfolio.portfolioBackEnd.Service.ProjectsService;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/API/version 1")
@CrossOrigin(origins = "*")
public class ProjectsController {
    @Autowired
    private ProjectsService projectsS;

    @PreAuthorize("hasRole('USER')")
        @GetMapping("/projects")
            public ResponseEntity<List<Projects>> list(){
                List<Projects> list = projectsS.verProjects();
                return new ResponseEntity(list, HttpStatus.OK);
            }

    @PreAuthorize("hasRole('USER')")
        @GetMapping("/projects/{id}")
            public ResponseEntity<Projects> getById(@PathVariable("id") Long id){
                if(!projectsS.existsProjects(id))
                    return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
                Projects proy = projectsS.buscarProjects(id);
                return new ResponseEntity(proy, HttpStatus.OK);
            }
    
    @PreAuthorize("hasRole('USER')")
        @PostMapping("/projects")
        public ResponseEntity<?> create(@RequestBody dtoProjects proyect){
            Projects projectNuevo = new Projects( proyect.getImgProyecto(), proyect.getNomProyecto(), proyect.getUrlProyecto() );
            projectsS.crearProjects(projectNuevo);
            return new ResponseEntity(new Mensaje("Proyecto Item creado."), HttpStatus.OK);
        }

     @PreAuthorize("hasRole('USER')")
        @DeleteMapping("/projects/{id}")
        public ResponseEntity<?> delete(@PathVariable("id")Long id){
            if(!projectsS.existsProjects(id))
                return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
            projectsS.borrarProjects(id);
            return new ResponseEntity(new Mensaje("Item Proyecto eliminado."), HttpStatus.OK);
        }

    @PreAuthorize("hasRole('USER')")
        @PutMapping("/projects/{id}")
        public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody dtoProjects proyDto){
            if(!projectsS.existsProjects(id))
                return new ResponseEntity(new Mensaje("No existe el item buscado."), HttpStatus.NOT_FOUND);
            if(StringUtils.isBlank(proyDto.getImgProyecto()))
                return new ResponseEntity(new Mensaje("Ingresar la imagen es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(proyDto.getNomProyecto()))
                return new ResponseEntity(new Mensaje("Ingresar el nompre del proyecto es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(proyDto.getUrlProyecto()))
                return new ResponseEntity(new Mensaje("Ingresar la URL del proyecto es obligatorio."), HttpStatus.BAD_REQUEST);
            

            Projects proyEdit = projectsS.buscarProjects(id);
            proyEdit.setImgProyecto(proyDto.getImgProyecto());
            proyEdit.setNomProyecto(proyDto.getNomProyecto());
            proyEdit.setUrlProyecto(proyDto.getUrlProyecto());
            projectsS.crearProjects(proyEdit);
            return new ResponseEntity(new Mensaje("Item Projects actualizado."), HttpStatus.OK);
        }
}
