package com.scottlogic.practice.mealscheduler.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/*not using @Data class as IntelliJ says it is bad to use it with @Entity*/
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Meal {
    public static Meal copyOf(Meal meal) {
        return new Meal(meal.getId(), meal.getName(), meal.getTime(), meal.getUser());
    }

    @Id
    @GeneratedValue
    private int Id;
    private String Name;
    private LocalDateTime Time;
    private String User;

    //This is needed because we don't want POST requests to supply an id,
    //so we need to be able to work with a meal without an id,
    //beware this could potentially cause issues.
    public Meal(String name, LocalDateTime time, String user) {
        Name = name;
        Time = time;
        User = user;
    }
}
