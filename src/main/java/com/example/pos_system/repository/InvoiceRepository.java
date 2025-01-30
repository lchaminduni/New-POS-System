package com.example.pos_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pos_system.entity.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{
    Optional<Invoice> findByInvoiceNumber(String invoiceNumber);
}
