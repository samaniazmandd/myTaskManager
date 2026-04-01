package com.example.myTaskmanager.controller;

import com.example.myTaskmanager.dto.request.UserRequestDTO;
import com.example.myTaskmanager.dto.response.UserResponseDTO;
import com.example.myTaskmanager.entity.User;
import com.example.myTaskmanager.mapper.UserMapper;
import com.example.myTaskmanager.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Create a new user")
    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserRequestDTO userRequestDTO) {
        User user = UserMapper.toEntity(userRequestDTO);
        return UserMapper.toDTO(userService.createUser(user));
    }
}
