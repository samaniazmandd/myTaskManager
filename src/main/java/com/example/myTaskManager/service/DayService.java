package com.example.myTaskManager.service;


import com.example.myTaskManager.entity.Day;
import com.example.myTaskManager.entity.Task;
import com.example.myTaskManager.repository.DayRepository;
import com.example.myTaskManager.repository.TaskRepository;
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

    public Day deleteTasksFromDay(Long dayId, Long taskId) {
        Day day = dayRepository.findById(dayId).orElseThrow(() -> new RuntimeException("Day not found"));

        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        day.getTasks().remove(task);

      return dayRepository.save(day);
    }

    public Day createDay(Day day) {
        return dayRepository.save(day);
    }
}
