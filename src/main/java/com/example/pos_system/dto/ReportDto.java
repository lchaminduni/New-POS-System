package com.example.pos_system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReportDto {
    private int id;
    private String reportType;
    private String details;
    private String generatedAt;
}
