package com.example.myTaskmanager.repository;

import com.example.myTaskmanager.model.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {
}
