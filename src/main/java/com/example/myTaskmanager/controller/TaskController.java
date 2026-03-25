package com.example.myTaskmanager.controller;


import com.example.myTaskmanager.model.Task;
import com.example.myTaskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// api endpoints
@RestController
@RequestMapping("/tasks")

public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }


    @DeleteMapping
    public void deleteAllTasks() {
        taskService.deleteAllTasks();
    }

    @PutMapping("/{id}")
    public Task editTask(@PathVariable Long id, @RequestBody Task updatedtask) {
        return taskService.editTask(id, updatedtask);
    }

}
