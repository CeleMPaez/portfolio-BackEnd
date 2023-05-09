package com.portfolio.portfolioBackEnd.Controller;

import com.portfolio.portfolioBackEnd.DTO.Mensaje;
import com.portfolio.portfolioBackEnd.Entity.Person;
import com.portfolio.portfolioBackEnd.DTO.dtoPerson;
import com.portfolio.portfolioBackEnd.Service.PersonService;

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
public class PersonController {
    
    @Autowired
    private PersonService personS;
    
    @PreAuthorize("hasRole('USER')")
        @GetMapping("/person")
            public ResponseEntity<List<Person>> list(){
                List<Person> list = personS.verPerson();
                return new ResponseEntity(list, HttpStatus.OK);
            }
            
    @PreAuthorize("hasRole('USER')")
        @GetMapping("/person/{id}")
            public ResponseEntity<Person> getById(@PathVariable("id") Long id){
                if(!personS.existsPerson(id))
                    return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
                Person sk = personS.buscarPerson(id);
                return new ResponseEntity(sk, HttpStatus.OK);
            }
            
    @PreAuthorize("hasRole('USER')")
        @PostMapping("/person")
        public ResponseEntity<?> create(@RequestBody dtoPerson p){
            Person personNuevo = new Person( p.getNombre(), p.getEmail(), p.getPassword(), p.getImgPerfil(), p.getTitulo(), p.getDescripcion() );
            personS.crearPerson(personNuevo);
            return new ResponseEntity(new Mensaje("Person Item creado."), HttpStatus.OK);
        }
        
    @PreAuthorize("hasRole('USER')")
        @DeleteMapping("/person/{id}")
        public ResponseEntity<?> delete(@PathVariable("id")Long id){
            if(!personS.existsPerson(id))
                return new ResponseEntity(new Mensaje("No existe el Item buscado."), HttpStatus.NOT_FOUND);
            personS.borrarPerson(id);
            return new ResponseEntity(new Mensaje("Item Person eliminado."), HttpStatus.OK);
        }
        
    @PreAuthorize("hasRole('USER')")
        @PutMapping("/person/{id}")
        public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody dtoPerson DtoP){
            if(!personS.existsPerson(id))
                return new ResponseEntity(new Mensaje("No existe el item buscado."), HttpStatus.NOT_FOUND);
            if(StringUtils.isBlank(DtoP.getNombre()))
                return new ResponseEntity(new Mensaje("Ingresar el Nombre es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(DtoP.getEmail()))
                return new ResponseEntity(new Mensaje("Ingresar el Email es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(DtoP.getPassword()))
                return new ResponseEntity(new Mensaje("Ingresar el Password es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(DtoP.getImgPerfil()))
                return new ResponseEntity(new Mensaje("Ingresar la Imagen de Perfil es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(DtoP.getTitulo()))
                return new ResponseEntity(new Mensaje("Ingresar el Titulo es obligatorio."), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(DtoP.getDescripcion()))
                return new ResponseEntity(new Mensaje("Ingresar la Descripcion es obligatorio."), HttpStatus.BAD_REQUEST);
           

            Person pEdit = personS.buscarPerson(id);
            pEdit.setNombre(DtoP.getNombre());
            pEdit.setEmail (DtoP.getEmail());
            pEdit.setPassword (DtoP.getPassword());
            pEdit.setImgPerfil (DtoP.getImgPerfil());
            pEdit.setTitulo (DtoP.getTitulo());
            pEdit.setDescripcion (DtoP.getDescripcion());
            personS.crearPerson(pEdit);
            return new ResponseEntity(new Mensaje("Item Person actualizado."), HttpStatus.OK);
        }
}
