package com.example.myTaskManager.dto.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class TaskResponseDTO {

    @Schema(description = "ID of the task ", example = "2")
    private Long id;
    @Schema(description = "Title of the task ", example = "Make homework")
    private String title;
    @Schema(description = "Description of the task ", example = "Make assignments 2,3 and 4 of page 134")
    private String description;
    @Schema(description = "Status of the task", example = "TODO")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
