package com.example.pos_system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SaleItemRequestDto {
    private int itemId;
    private int quantity;
}
