package com.example.myTaskmanager.controller;


import com.example.myTaskmanager.model.Day;
import com.example.myTaskmanager.service.DayService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/days")
public class DayController {

    @Autowired
    private DayService dayService;

    @DeleteMapping("/{dayId}/{taskId}")
    public Day addTaskToDay(@PathVariable Long dayId, @PathVariable Long taskId) {
        return dayService.addTasksToDay(dayId, taskId);
    }


}
