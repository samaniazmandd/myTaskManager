package com.example.myTaskManager.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    @Schema(description = "Username of the user", example = "saraTijhuis")
    @NotBlank(message = "Username is required")
    private String username;


    @Schema(description = "Email of the user", example = "sara_thijhuis@gamil.com")
    @Email
    @NotBlank(message = "Email is required")
    private String email;

    @Schema(description = "password of the user", example = "12345")
    @NotBlank(message = "Username is required")
    @Size(min = 5, message = "Password must be at least 5 characters")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }


}
