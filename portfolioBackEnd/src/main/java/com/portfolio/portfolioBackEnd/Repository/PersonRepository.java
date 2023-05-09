package com.portfolio.portfolioBackEnd.Repository;

import com.portfolio.portfolioBackEnd.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository <Person, Long>{
    
}
