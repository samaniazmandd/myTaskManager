package com.example.myTaskmanager.dto.response;

import java.time.LocalDate;
import java.util.List;

public class DayResponseDTO {

    private Long id;
    private LocalDate date;
    private List<Long> taskIds;

    public DayResponseDTO() {
    }

    public DayResponseDTO(Long id, LocalDate date, List<Long> taskIds) {
        this.id = id;
        this.date = date;
        this.taskIds = taskIds;
    }


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
