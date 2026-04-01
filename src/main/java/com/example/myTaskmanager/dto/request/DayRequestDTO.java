package com.example.myTaskmanager.dto.request;

import java.time.LocalDate;
import java.util.List;

public class DayRequestDTO {
    private LocalDate date;


    public DayRequestDTO() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


}
