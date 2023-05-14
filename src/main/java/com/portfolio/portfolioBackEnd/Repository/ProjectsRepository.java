package com.portfolio.portfolioBackEnd.Repository;

import com.portfolio.portfolioBackEnd.Entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepository extends JpaRepository <Projects, Long>{
    
}
