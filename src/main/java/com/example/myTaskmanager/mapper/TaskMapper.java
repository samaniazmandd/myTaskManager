package com.example.myTaskmanager.mapper;

import com.example.myTaskmanager.dto.request.TaskRequestDTO;
import com.example.myTaskmanager.dto.response.TaskResponseDTO;
import com.example.myTaskmanager.entity.Task;

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
