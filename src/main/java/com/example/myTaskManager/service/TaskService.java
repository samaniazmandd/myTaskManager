package com.example.myTaskManager.service;


import com.example.myTaskManager.dto.request.TaskRequestDTO;
import com.example.myTaskManager.entity.Task;
import com.example.myTaskManager.repository.TaskRepository;
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
