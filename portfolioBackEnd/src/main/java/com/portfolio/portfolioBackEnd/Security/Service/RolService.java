package com.portfolio.portfolioBackEnd.Security.Service;

import com.portfolio.portfolioBackEnd.Security.Entity.Rol;
import com.portfolio.portfolioBackEnd.Security.Enums.RolName;
import com.portfolio.portfolioBackEnd.Security.Repository.RolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolService {
    
    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolName(RolName rolName){
        return rolRepository.findByRolName(rolName);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
