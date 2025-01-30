package com.example.pos_system.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import com.example.pos_system.entity.Sale;
import com.example.pos_system.entity.SaleItem;
import com.example.pos_system.repository.SaleItemRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SaleRequestDto {
    private int userId;
    private BigDecimal discount;
    private List<SaleItemRequestDto> saleItems;
}
