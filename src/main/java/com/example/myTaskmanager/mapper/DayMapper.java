package com.example.myTaskmanager.mapper;

import com.example.myTaskmanager.dto.request.DayRequestDTO;
import com.example.myTaskmanager.dto.response.DayResponseDTO;
import com.example.myTaskmanager.entity.Day;
import com.example.myTaskmanager.entity.Task;

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
