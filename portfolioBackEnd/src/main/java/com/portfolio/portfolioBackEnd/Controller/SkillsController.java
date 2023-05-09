package com.portfolio.portfolioBackEnd.Controller;

import com.portfolio.portfolioBackEnd.DTO.Mensaje;
import com.portfolio.portfolioBackEnd.Entity.Skills;
import com.portfolio.portfolioBackEnd.DTO.dtoSkills;
import com.portfolio.portfolioBackEnd.Service.SkillsService;

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
public class SkillsController {
    
    @Autowired
    private SkillsService skillsS;

    @PreAuthorize("hasRole('USER')")
        @GetMapping("/skills")
            public ResponseEntity<List<Skills>> list(){
                List<Skills> list = skillsS.verSkills();
                return new ResponseEntity(list, HttpStatus.OK);
            }

    @PreAuthorize("hasRole('USER')")
        @GetMapping("/skills/{id}")
            public ResponseEntity<Skills> getById(@PathVariable("id") Long id){
                if(!skillsS.existsSkill(id))
                    return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
                Skills sk = skillsS.buscarSkill(id);
                return new ResponseEntity(sk, HttpStatus.OK);
            }
    
    @PreAuthorize("hasRole('USER')")
        @PostMapping("/skills")
        public ResponseEntity<?> create(@RequestBody dtoSkills sk){
            Skills skNuevo = new Skills( sk.getNombreSkill(), sk.getPorcentajeSkill() );
            skillsS.crearSkill(skNuevo);
            return new ResponseEntity(new Mensaje("Skill Item creado."), HttpStatus.OK);
        }

   @PreAuthorize("hasRole('USER')")
        @DeleteMapping("/skills/{id}")
        public ResponseEntity<?> delete(@PathVariable("id")Long id){
            if(!skillsS.existsSkill(id))
                return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
            skillsS.borrarSkill(id);
            return new ResponseEntity(new Mensaje("Item Skill eliminado."), HttpStatus.OK);
        }

    @PreAuthorize("hasRole('USER')")
        @PutMapping("/skills/{id}")
        public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody dtoSkills DtoSk){
            if(!skillsS.existsSkill(id))
                return new ResponseEntity(new Mensaje("No existe el item buscado."), HttpStatus.NOT_FOUND);
            if(StringUtils.isBlank(DtoSk.getNombreSkill()))
                return new ResponseEntity(new Mensaje("Ingresar el Nombre del Skill es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(DtoSk.getPorcentajeSkill()))
                return new ResponseEntity(new Mensaje("Ingresar el Porcentaje del Skill es obligatorio."), HttpStatus.BAD_REQUEST);
           

            Skills skEdit = skillsS.buscarSkill(id);
            skEdit.setNombreSkill(DtoSk.getNombreSkill());
            skEdit.setPorcentajeSkill(DtoSk.getPorcentajeSkill());
            skillsS.crearSkill(skEdit);
            return new ResponseEntity(new Mensaje("Item Skill actualizado."), HttpStatus.OK);
        }
}
