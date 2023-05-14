package com.portfolio.portfolioBackEnd.Repository;

import com.portfolio.portfolioBackEnd.Entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository <Education, Long> {
    
}
