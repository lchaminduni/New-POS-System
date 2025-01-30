package com.example.pos_system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateUserRequestDto {
    private String fullName;
    private String password;
    private String role;
}
