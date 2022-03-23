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
public class Meal {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private int Id;

    @Getter
    @Setter
    private String Name;

    @Getter
    @Setter
    private LocalDateTime Time;

    @Getter
    @Setter
    private String User;
}
