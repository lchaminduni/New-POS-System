package com.example.pos_system.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pos_system.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer>{
    List<Sale> findByUserId(int userId);
} 
