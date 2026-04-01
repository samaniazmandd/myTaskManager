package com.example.myTaskmanager.mapper;

import com.example.myTaskmanager.dto.request.UserRequestDTO;
import com.example.myTaskmanager.dto.response.UserResponseDTO;
import com.example.myTaskmanager.entity.User;

public class UserMapper {

    public static UserResponseDTO toDTO(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setUsername(user.getUsername());
        userResponseDTO.setEmail(user.getEmail());
        return userResponseDTO;
    }

    public static User toEntity(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setUsername(userRequestDTO.getUsername());
        user.setEmail(userRequestDTO.getEmail());
        return user;
    }
}
