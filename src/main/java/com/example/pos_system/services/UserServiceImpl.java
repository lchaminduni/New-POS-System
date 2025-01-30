package com.example.pos_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.pos_system.dto.UpdateUserRequestDto;
import com.example.pos_system.dto.UserDto;
import com.example.pos_system.dto.UserRequestDto;
import com.example.pos_system.entity.User;
import com.example.pos_system.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapToDTO(user);
    }

    @Override
    public UserDto createUser(UserRequestDto createUserRequest) {
        
    String password = createUserRequest.getPassword();
    
    // Check if password is null or empty
    if (password == null || password.isEmpty()) {
        throw new IllegalArgumentException("Password cannot be null or empty");
    }

    // Print the password before encoding to verify it's coming in correctly
    System.out.println("Received password: " + password);

    // Log the encoded password to check if encoding works
    String encodedPassword = passwordEncoder.encode(password);
    System.out.println("Encoded password: " + encodedPassword);  // This will print the encoded password

    // Proceed with creating the user
    User user = new User();
    user.setFullName(createUserRequest.getFullName());
    user.setUsername(createUserRequest.getUsername());
    user.setPassword(encodedPassword); // Ensure password is encoded
    user.setRole(User.Role.valueOf(createUserRequest.getRole().toUpperCase()));

    User savedUser = userRepository.save(user);

    // Return saved user as DTO
    return mapToDTO(savedUser);
    }

    @Override
    public UserDto updateUser(int id, UpdateUserRequestDto updateUserRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setFullName(updateUserRequest.getFullName());
        user.setPassword(passwordEncoder.encode(updateUserRequest.getPassword())); // Use password encryption
        user.setRole(User.Role.valueOf(updateUserRequest.getRole()));

        User updatedUser = userRepository.save(user);
        return mapToDTO(updatedUser);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    private UserDto mapToDTO(User user) {
        UserDto userDTO = new UserDto();
        userDTO.setId(user.getId());
        userDTO.setFullName(user.getFullName());
        userDTO.setUsername(user.getUsername());
        userDTO.setRole(user.getRole().name());
        return userDTO;
    }
}
