package com.example.pos_system.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DiscountRequestDto {
    private BigDecimal discount;
}
