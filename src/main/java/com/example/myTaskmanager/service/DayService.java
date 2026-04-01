package com.example.myTaskmanager.service;


import com.example.myTaskmanager.entity.Day;
import com.example.myTaskmanager.entity.Task;
import com.example.myTaskmanager.repository.DayRepository;
import com.example.myTaskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class DayService {


    private final DayRepository dayRepository;
    private final TaskRepository taskRepository;

    public DayService(DayRepository dayRepository, TaskRepository taskRepository) {
        this.dayRepository = dayRepository;
        this.taskRepository = taskRepository;
    }

    public Day addTasksToDay(Long dayId, Long taskId) {
        Day day = dayRepository.findById(dayId).orElseThrow(() -> new RuntimeException("Day not found"));
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        day.getTasks().add(task);

        return dayRepository.save(day);
    }

    public Day createDay(Day day) {
        return dayRepository.save(day);
    }
}
