package com.example.pos_system.services;

import java.math.BigDecimal;
import java.util.List;

import com.example.pos_system.dto.SaleRequestDto;
import com.example.pos_system.entity.Sale;
import com.example.pos_system.entity.SaleItem;


public interface SaleService {
    Sale createSale(SaleRequestDto saleRequest);

    //Sale applyDiscount(int saleId, BigDecimal discount);

    List<Sale> getAllSales();

    List<Sale> getSalesByUserId(int userId);

    List<SaleItem> getSaleItems(int saleId);
}
