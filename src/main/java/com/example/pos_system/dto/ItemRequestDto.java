package com.example.pos_system.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.pos_system.entity.Item.Unit;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ItemRequestDto {
    private String name;
    private Long categoryId; // Foreign key reference
    private BigDecimal price;
    private Integer stock;
    private Unit unit; // Should match the Enum values
    private LocalDate expiryDate;

    //@Column(name = "category_id")
    //private Long categoryId;  
}
