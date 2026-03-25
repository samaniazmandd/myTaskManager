package com.example.myTaskmanager;


import com.example.myTaskmanager.model.Task;
import com.example.myTaskmanager.repository.TaskRepository;
import com.example.myTaskmanager.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest // it runs a lightweight test context for JPA repositories using an in-memory db
public class TaskServiceTest {

    @Autowired
    private TaskRepository taskRepository;
    private TaskService taskService;
    private Task task;


    @BeforeEach
    void setUp() {
        taskService = new TaskService(taskRepository);
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

        List<Task> allTasks=taskService.getAllTasks();

        assertEquals(2, allTasks.size());
        assertEquals("task 2",allTasks.get(1).getTitle());
        assertEquals("task",allTasks.get(0).getTitle());

    }
}
