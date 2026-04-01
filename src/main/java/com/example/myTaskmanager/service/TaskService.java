package com.example.myTaskmanager.service;


import com.example.myTaskmanager.dto.request.TaskRequestDTO;
import com.example.myTaskmanager.entity.Task;
import com.example.myTaskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void deleteAllTasks() {
        taskRepository.deleteAll();
    }

    public Task editTask(Long id, TaskRequestDTO updatedTask) {
        Task existedTask = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));

        existedTask.setTitle(updatedTask.getTitle());
        existedTask.setDescription(updatedTask.getDescription());
        existedTask.setStatus(updatedTask.getStatus());
        return taskRepository.save(existedTask);
    }

}
