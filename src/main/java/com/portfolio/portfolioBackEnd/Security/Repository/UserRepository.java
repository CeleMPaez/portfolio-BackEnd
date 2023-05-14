package com.portfolio.portfolioBackEnd.Security.Repository;

import com.portfolio.portfolioBackEnd.Security.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername (String username);
    boolean existsByEmail (String email);
}
