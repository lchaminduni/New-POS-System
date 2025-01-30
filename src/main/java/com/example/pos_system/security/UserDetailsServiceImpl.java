package com.example.pos_system.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.pos_system.entity.User;
import com.example.pos_system.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    
    @Autowired
    private UserRepository userRepository; // Replace with your repository interface

    @Override
    //@Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username).orElse(null);

        if (user==null) {
            throw new UsernameNotFoundException("User is not found");
        } else {
            return org.springframework.security.core.userdetails.User.builder()
            .username(user.getUsername())
            .password(user.getPassword())
            .authorities(user.getRole().name())
            .build();
        }
    }
}
