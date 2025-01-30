package com.example.pos_system.services;

import java.util.List;
import com.example.pos_system.dto.UpdateUserRequestDto;
import com.example.pos_system.dto.UserDto;
import com.example.pos_system.dto.UserRequestDto;

public interface UserService {
    //Optional<User> findByUsername(String username);

    //boolean validateLogin(LoginRequestDto loginDTO);

    //Optional<User> getLoggedInUser(String username);

    List<UserDto> getAllUsers();

    UserDto getUserById(int id);

    UserDto createUser(UserRequestDto createUserRequest);

    UserDto updateUser(int id, UpdateUserRequestDto updateUserRequest);

    void deleteUser(int id);
}
