package com.example.myTaskManager.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LoginRequestDTO {

    @Email
    @NotBlank(message = "Email is required")
    @Schema(description = "Email of the user", example = "henk_Timmerman@gmail.com")
    private String email;

    @NotBlank(message = "Password is required  (min 5 characters")
    @Schema(description = "Password of the user", example = "abcde")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
