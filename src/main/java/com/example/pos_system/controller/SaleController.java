package com.example.pos_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pos_system.dto.DiscountRequestDto;
import com.example.pos_system.dto.SaleRequestDto;
import com.example.pos_system.entity.Sale;
import com.example.pos_system.entity.SaleItem;
import com.example.pos_system.services.SaleService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/sales")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @PostMapping
    public ResponseEntity<Sale> createSale(@RequestBody SaleRequestDto  saleRequest) {

        Sale savedSale = saleService.createSale(saleRequest);
        return ResponseEntity.ok(savedSale);
    }

    /*@PutMapping("/{saleId}/discount")
    public ResponseEntity<Sale> applyDiscount(@PathVariable int saleId, @RequestBody DiscountRequestDto discountRequest) {
        Sale updatedSale = saleService.applyDiscount(saleId, discountRequest.getDiscount());
        return ResponseEntity.ok(updatedSale);
    }*/

    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {
        List<Sale> sales = saleService.getAllSales();
        return ResponseEntity.ok(sales);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Sale>> getSalesByUserId(@PathVariable int userId) {
        List<Sale> sales = saleService.getSalesByUserId(userId);
        return ResponseEntity.ok(sales);
    }

    @GetMapping("/{saleId}/items")
    public ResponseEntity<List<SaleItem>> getSaleItems(@PathVariable int saleId) {
        List<SaleItem> saleItems = saleService.getSaleItems(saleId);
        return ResponseEntity.ok(saleItems);
    }
}
