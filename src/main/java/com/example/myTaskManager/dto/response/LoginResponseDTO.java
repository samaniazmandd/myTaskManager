package com.example.myTaskManager.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginResponseDTO {


    @Schema(description = "Token of the user")
    private String token;

    public String getToken() {
        return token;
    }

}
