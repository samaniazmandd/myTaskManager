package com.example.myTaskmanager.service;


import com.example.myTaskmanager.model.Day;
import com.example.myTaskmanager.model.Task;
import com.example.myTaskmanager.repository.DayRepository;
import com.example.myTaskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DayService {

    @Autowired
    private DayRepository dayRepository;

    @Autowired
    private TaskRepository taskRepository;

    public Day addTasksToDay(Long dayId, Long taskId) {
        Day day = dayRepository.findById(dayId).orElseThrow(() -> new RuntimeException("Day not found"));
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        day.getTasks().add(task);

        return dayRepository.save(day);
    }
}
