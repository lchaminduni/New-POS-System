package com.example.pos_system.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pos_system.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByUsername(String username);
}
