package com.example.pos_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pos_system.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

    Optional<Category> findById(Long categoryId);
    Optional<Category> findByName(String name);
} 