package com.example.myTaskmanager.controller;

import com.example.myTaskmanager.dto.request.TaskRequestDTO;
import com.example.myTaskmanager.dto.response.TaskResponseDTO;
import com.example.myTaskmanager.entity.Task;
import com.example.myTaskmanager.mapper.TaskMapper;
import com.example.myTaskmanager.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@RestController
@RequestMapping("/tasks")

public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @Operation(summary = "Create a new task")
    @PostMapping
    public TaskResponseDTO createTask(@RequestBody TaskRequestDTO taskRequestDTO) {
        Task task = TaskMapper.toEntity(taskRequestDTO);
        return TaskMapper.toDTO(taskService.createTask(task));
    }


    @Operation(summary = "View all the tasks")
    @GetMapping
    public List<TaskResponseDTO> getAllTasks() {
        return taskService.getAllTasks().stream().map(TaskMapper::toDTO).toList();
    }


    @Operation(summary = "Delete a task")
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @Operation(summary = "Delete all tasks")
    @DeleteMapping
    public void deleteAllTasks() {
        taskService.deleteAllTasks();
    }

    @Operation(summary = "Edit a task")
    @PutMapping("/{id}")
    public TaskResponseDTO editTask(@PathVariable Long id, @RequestBody TaskRequestDTO updatedtask) {
        return TaskMapper.toDTO(taskService.editTask(id, updatedtask));
    }

}
