package com.scottlogic.practice.mealscheduler.Models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Meal {
    private UUID Id;
    private String Name;
    private LocalDateTime Time;
    private String User;

    public Meal(UUID id, String name, LocalDateTime time, String user) {
        Id = id;
        Name = name;
        Time = time;
        User = user;
    }
}
