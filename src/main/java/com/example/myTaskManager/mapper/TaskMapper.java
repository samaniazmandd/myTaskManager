package com.example.myTaskManager.mapper;

import com.example.myTaskManager.dto.request.TaskRequestDTO;
import com.example.myTaskManager.dto.response.TaskResponseDTO;
import com.example.myTaskManager.entity.Task;

public class TaskMapper {

    public static TaskResponseDTO toDTO(Task task) {
        TaskResponseDTO taskResponseDTO = new TaskResponseDTO();
        taskResponseDTO.setId(task.getId());
        taskResponseDTO.setTitle(task.getTitle());
        taskResponseDTO.setDescription(task.getDescription());
        taskResponseDTO.setStatus(task.getStatus());

        return taskResponseDTO;
    }


    public static Task toEntity(TaskRequestDTO taskRequestDTO) {
        Task task = new Task();
        task.setTitle(taskRequestDTO.getTitle());
        task.setDescription(taskRequestDTO.getDescription());
        task.setStatus(taskRequestDTO.getStatus());
        return task;
    }

}
