package com.example.pos_system.dto;

import com.example.pos_system.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthResponseDto {
    private String token;
    private String username;
    private Role role;
    private String message;
}
