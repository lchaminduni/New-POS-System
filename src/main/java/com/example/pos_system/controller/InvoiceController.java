package com.example.pos_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pos_system.dto.InvoiceDto;
import com.example.pos_system.services.InvoiceService;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<InvoiceDto> createInvoice(@RequestBody InvoiceDto invoiceDTO) {
        InvoiceDto createdInvoice = invoiceService.createInvoice(invoiceDTO);
        return ResponseEntity.ok(createdInvoice);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDto> getInvoiceById(@PathVariable int id) {
        InvoiceDto invoice = invoiceService.getInvoiceById(id);
        return ResponseEntity.ok(invoice);
    }

    @GetMapping
    public ResponseEntity<List<InvoiceDto>> getAllInvoices() {
        List<InvoiceDto> invoices = invoiceService.getAllInvoices();
        return ResponseEntity.ok(invoices);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable int id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.noContent().build();
    }
}
