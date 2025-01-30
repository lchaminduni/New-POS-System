package com.example.pos_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pos_system.entity.Report;

public interface ReportRepository extends JpaRepository<Report, Integer>{
    
}
