package com.example.pos_system.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {
    private int id;
    private int saleId;
    private String invoiceNumber;
    private BigDecimal total;
    private BigDecimal discount;
    private BigDecimal grossAmount;
}
