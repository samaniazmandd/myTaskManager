package com.example.myTaskmanager.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
// name DAY wil give conflicts
@Table(name = "DAY_TABLE")
public class Day {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;

    //owner of the relation because of @JoinTable
    @ManyToMany
    @JoinTable(
            name = "day_tasks",
            joinColumns = @JoinColumn(name = "day_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )

    private List<Task> tasks;
    public Day() {}

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
