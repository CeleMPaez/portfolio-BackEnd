package com.portfolio.portfolioBackEnd.Repository;

import com.portfolio.portfolioBackEnd.Entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends JpaRepository <Skills, Long>{
    
}
