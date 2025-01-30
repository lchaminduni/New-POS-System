package com.example.pos_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pos_system.entity.SaleItem;

public interface SaleItemRepository extends JpaRepository<SaleItem, Integer>{
    List<SaleItem> findBySaleId(int saleId);
}
