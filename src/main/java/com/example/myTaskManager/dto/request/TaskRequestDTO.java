package com.example.myTaskManager.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TaskRequestDTO {

    @Schema(description = "Title of the task", example = "Study Spring boot")
    @NotBlank(message = "Title is required")
    private String title;
    @Schema(description = "Description of the task", example = "Study the notes")
    private String description;
    @Schema(description = "Status of the task", example = "TODO")
    @NotBlank(message = "Status is required")
    private String status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
