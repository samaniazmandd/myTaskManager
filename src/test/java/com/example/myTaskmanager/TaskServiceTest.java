package com.example.myTaskmanager;


import com.example.myTaskmanager.entity.Task;
import com.example.myTaskmanager.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



@SpringBootTest //full spring context no mock or in memory
public class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    private Task task;


    @BeforeEach
    void setUp() {
        task = new Task();
        task.setTitle("task");
        task.setDescription("Task ");
        task.setStatus("TODO");

        taskService.createTask(task);
    }


    @Test
    void givenATask_whenCreateTask_thenItWillBeSaved() {
        Task task = new Task();
        task.setTitle("task 2");
        task.setDescription("Task 2");
        task.setStatus("TODO");
        taskService.createTask(task);
        assertEquals(2, taskService.getAllTasks().size());


    }

    @Test
    void givenATask_whenDelete_thenTaskIsDeleted() {
        taskService.deleteTask(task.getId());
        assertTrue(taskService.getAllTasks().isEmpty());

    }

    @Test
    void givenAListOfTasks_whenAskingForListOfAllTasks_thenAllTasksAreReturned() {
        Task task = new Task();
        task.setTitle("task 2");
        task.setDescription("Task 2");
        task.setStatus("TODO");
        taskService.createTask(task);

        List<Task> allTasks = taskService.getAllTasks();

        assertEquals(4, allTasks.size());

        assertEquals("task", allTasks.get(0).getTitle());
        assertEquals("task 2", allTasks.get(1).getTitle());



    }
}
