package com.portfolio.portfolioBackEnd.Util;

import com.portfolio.portfolioBackEnd.Security.Entity.Rol;
import com.portfolio.portfolioBackEnd.Security.Enums.RolName;
import com.portfolio.portfolioBackEnd.Security.Service.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
        
@Component
public class CreateRoles implements CommandLineRunner {
    
    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
         Rol rolAdmin = new Rol(RolName.ROLE_ADMIN);
        Rol rolUser = new Rol(RolName.ROLE_USER);
        rolService.save(rolAdmin);
        rolService.save(rolUser);
        
    }
}
