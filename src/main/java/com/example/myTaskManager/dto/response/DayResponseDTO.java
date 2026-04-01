package com.example.myTaskManager.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class DayResponseDTO {


    @Schema(description = "ID of the day", example = "2")
    private Long id;
    @Schema(description = "Date of the day", example = "20-02-2026")
    private LocalDate date;
    @Schema(description = "IDs of all the tasks ", example = "2, 3, 5")
    private List<Long> taskIds;


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Long> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(List<Long> taskIds) {
        this.taskIds = taskIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
