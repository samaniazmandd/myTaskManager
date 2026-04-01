package com.example.myTaskmanager.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public class TaskRequestDTO {

    @Schema(description = "Title of the task", example = "Study Spring boot")
    private String title;
    @Schema(description = "Description of the task", example = "Study the notes")
    private String description;
    @Schema(description = "Status of the task", example = "TODO")
    private String status;

    public TaskRequestDTO(){}


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
