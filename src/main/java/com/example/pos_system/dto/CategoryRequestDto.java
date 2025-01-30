package com.example.pos_system.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategoryRequestDto {
    private String name;
    private String description;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
