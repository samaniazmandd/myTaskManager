package com.example.myTaskmanager.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Day {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;

    //owner of the relation because of @JoinTable
    @ManyToMany
    @JoinTable(
            name = "day_tasks",
            joinColumns = @JoinColumn(name = "day_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )

    private List<Task> tasks;


    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
