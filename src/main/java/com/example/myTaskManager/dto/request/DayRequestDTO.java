package com.example.myTaskManager.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
public class DayRequestDTO {
    @Schema(description = "Date of the day", example = "20-02-2026")
    @NotBlank(message = "Date is required")
    private LocalDate date;


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


}
