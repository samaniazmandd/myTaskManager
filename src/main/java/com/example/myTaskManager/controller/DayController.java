package com.example.myTaskManager.controller;

import com.example.myTaskManager.dto.request.DayRequestDTO;
import com.example.myTaskManager.dto.response.DayResponseDTO;
import com.example.myTaskManager.entity.Day;
import com.example.myTaskManager.mapper.DayMapper;
import com.example.myTaskManager.service.DayService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/days")
public class DayController {

    private final DayService dayService;

    public DayController(DayService dayService) {
        this.dayService = dayService;
    }

    @Operation(summary = "Add a task to a day")
    @PostMapping("/{day-id}/tasks/{task-id}")
    public DayResponseDTO addTaskToDay(@PathVariable("day-id") Long dayId, @PathVariable("task-id") Long taskId) {
        return DayMapper.toDTO(dayService.addTasksToDay(dayId, taskId));
    }

    @Operation(summary = "Delete a task from a day")
    @DeleteMapping("/{day-id}/tasks/{task-id}")
    public DayResponseDTO deleteTaskFromDay(@PathVariable("day-id") Long dayId, @PathVariable("task-id") Long taskId) {
        return DayMapper.toDTO(dayService.deleteTasksFromDay(dayId, taskId));
    }


    @PostMapping
    public DayResponseDTO createDay(@Valid @RequestBody DayRequestDTO dayRequestDTO) {
        Day day = DayMapper.toEntity(dayRequestDTO);
        return DayMapper.toDTO(dayService.createDay(day));
    }
}
