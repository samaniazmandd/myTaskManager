package com.example.myTaskmanager;


import com.example.myTaskmanager.model.Task;
import com.example.myTaskmanager.repository.TaskRepository;
import com.example.myTaskmanager.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

@SpringBootTest
public class TaskServiceTestWithMockRepo {

    private TaskRepository taskRepository;
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        //mock repository because I don't want to use the real db for my tests
        taskRepository = Mockito.mock(TaskRepository.class);
        taskService = new TaskService(taskRepository);

    }

    @Test
    void givenNewTask_whenCreateTask_thenTaskIsSaved() {
        //given
        Task task = new Task();
        task.setTitle("test task");
        task.setDescription("task for testing");
        task.setStatus("TODO");
        when(taskRepository.save(task)).thenReturn(task);
        //when
        Task newTask = taskService.createTask(task);


        //then
        assertEquals("test task", newTask.getTitle());
    }

    @Test
    void givenMultipleTasks_whenGettingAllTasks_thenReturnAllTasks() {
        //given
        Task task1 = new Task();
        task1.setTitle("task1");
        Task task2 = new Task();
        task2.setTitle("task2");

        when(taskRepository.findAll()).thenReturn(Arrays.asList(task1, task2));
        //when
        List<Task> allTasks = taskService.getAllTasks();


        //then
        assertEquals(2, allTasks.size());
    }

}
