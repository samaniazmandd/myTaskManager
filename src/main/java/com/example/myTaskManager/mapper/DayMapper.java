package com.example.myTaskManager.mapper;

import com.example.myTaskManager.dto.request.DayRequestDTO;
import com.example.myTaskManager.dto.response.DayResponseDTO;
import com.example.myTaskManager.entity.Day;
import com.example.myTaskManager.entity.Task;

import java.util.stream.Collectors;

public class DayMapper {

    public static DayResponseDTO toDTO(Day day) {
        DayResponseDTO dayResponseDTO = new DayResponseDTO();
        dayResponseDTO.setId(day.getId());
        dayResponseDTO.setDate(day.getDate());
        dayResponseDTO.setTaskIds(day.getTasks().stream().map(Task::getId).collect(Collectors.toList()));

        return dayResponseDTO;
    }

    public static Day toEntity(DayRequestDTO dayRequestDTO) {
        Day day = new Day();
        day.setDate(dayRequestDTO.getDate());
        return day;
    }

}
