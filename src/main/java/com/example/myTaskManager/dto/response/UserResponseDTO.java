package com.example.myTaskManager.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {

    @Schema(description = "ID of the user", example = "2")
    private Long id;
    @Schema(description = "Username of the user ", example = "saraThijhuis")
    private String username;
    @Schema(description = "Email of the user ", example = "sara_thijhuis@icloud.com")
    private String email;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
