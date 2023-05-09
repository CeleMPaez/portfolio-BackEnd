package com.portfolio.portfolioBackEnd.Controller;

import com.portfolio.portfolioBackEnd.DTO.Mensaje;
import com.portfolio.portfolioBackEnd.Entity.Education;
import com.portfolio.portfolioBackEnd.DTO.dtoEducation;
import com.portfolio.portfolioBackEnd.Service.EducationService;

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
public class EducationController {
    
    @Autowired
    private EducationService educationS;
    
    @PreAuthorize("hasRole('USER')")
        @GetMapping("/education") 
            public ResponseEntity<List<Education>> list(){
                List<Education> list = educationS.verEducation();
                return new ResponseEntity(list, HttpStatus.OK);
            }
    
    @PreAuthorize("hasRole('USER')")
        @GetMapping("/education/{id}")
            public ResponseEntity<Education> getById(@PathVariable("id") Long id){
                if(!educationS.existsEducation(id))
                    return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
                Education educ = educationS.buscarEducation(id);
                return new ResponseEntity(educ, HttpStatus.OK);
            }
    
    @PreAuthorize("hasRole('USER')")
        @PostMapping("/education")
        public ResponseEntity<?> create(@RequestBody dtoEducation edu){
            Education newEdu = new Education( edu.getImgInstitucion(), edu.getInstitucion(), edu.getTitulo(), edu.getTiempo(), edu.getEstado() );
            educationS.crearEducation(newEdu);
            return new ResponseEntity(new Mensaje("Education Item Creado."), HttpStatus.OK);
        }
        
    @PreAuthorize("hasRole('USER')")
        @DeleteMapping("/education/{id}")
        public ResponseEntity<?> delete(@PathVariable("id")Long id){
            if(!educationS.existsEducation(id))
                return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
            educationS.borrarEducation(id);
            return new ResponseEntity(new Mensaje("Item Education eliminado."), HttpStatus.OK);
        }
    
    @PreAuthorize("hasRole('USER')")
        @PutMapping("/education/{id}")
        public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody dtoEducation eduDto){
            if(!educationS.existsEducation(id))
                return new ResponseEntity(new Mensaje("No existe el item buscado."), HttpStatus.NOT_FOUND);
            if(StringUtils.isBlank(eduDto.getImgInstitucion()))
                return new ResponseEntity(new Mensaje("Ingresar la Imagen de la Institucion es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(eduDto.getInstitucion()))
                return new ResponseEntity(new Mensaje("Ingresar la Institucion es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(eduDto.getTitulo()))
                return new ResponseEntity(new Mensaje("Ingresar el Titulo es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(eduDto.getTiempo()))
                return new ResponseEntity(new Mensaje("Ingresar el Tiempo es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(eduDto.getEstado()))
                return new ResponseEntity(new Mensaje("Ingresar el Estado  es obligatorio."), HttpStatus.BAD_REQUEST);
            
            Education eduEdit = educationS.buscarEducation(id);
            eduEdit.setImgInstitucion(eduDto.getImgInstitucion());
            eduEdit.setInstitucion(eduDto.getInstitucion());
            eduEdit.setTitulo(eduDto.getTitulo());
            eduEdit.setTiempo(eduDto.getTiempo());
            eduEdit.setEstado(eduDto.getEstado());
            educationS.crearEducation(eduEdit);
            return new ResponseEntity(new Mensaje("Item Education actualizado."), HttpStatus.OK);
        }
}

