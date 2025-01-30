package com.example.pos_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

import com.example.pos_system.dto.LoginRequestDto;
import com.example.pos_system.security.JwtUtils;

@RestController
//@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/auth/login")
    public String login(@RequestBody LoginRequestDto loginRequestDto) {
        
        try {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequestDto.getUsername(), loginRequestDto.getPassword()
            )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtUtils.generateJwtToken(authentication);
        return jwtToken;
    } catch (BadCredentialsException e) {
        // Log or print the exception details
        System.out.println("Bad credentials: " + e.getMessage());
        return "Authentication failed: Invalid username or password.";
    }
        
    }
}
