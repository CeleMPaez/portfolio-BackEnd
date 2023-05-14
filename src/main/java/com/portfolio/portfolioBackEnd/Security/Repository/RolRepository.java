package com.portfolio.portfolioBackEnd.Security.Repository;

import com.portfolio.portfolioBackEnd.Security.Entity.Rol;
import com.portfolio.portfolioBackEnd.Security.Enums.RolName;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolName(RolName rolName);
}
