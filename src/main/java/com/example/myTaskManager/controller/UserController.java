package com.example.myTaskManager.controller;

import com.example.myTaskManager.dto.request.UserRequestDTO;
import com.example.myTaskManager.dto.response.UserResponseDTO;
import com.example.myTaskManager.entity.User;
import com.example.myTaskManager.mapper.UserMapper;
import com.example.myTaskManager.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Create a new user")
    @PostMapping
    public UserResponseDTO createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        User user = UserMapper.toEntity(userRequestDTO);
        return UserMapper.toDTO(userService.createUser(user));
    }

    @Operation(summary = "View all users")
    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers().stream().map(UserMapper::toDTO).toList();
    }


    @Operation(summary = "Delete a user")
    @DeleteMapping({"/id"})
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);

    }
}
