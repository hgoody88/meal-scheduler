package com.scottlogic.practice.mealscheduler.Repositories;


import com.scottlogic.practice.mealscheduler.Models.Meal;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Just having this as a stub for now, it implements the Meal Repo so will just adapt the MealRepo
 * when it comes to implementing a real db
 * */
@Repository
public class DummyMealRepo implements MealRepo {
    List<Meal> starterMeals = new ArrayList<>(
            List.of(
                new Meal(
                        UUID.randomUUID(),
                        "Pasta",
                        LocalDateTime.of(2022, 1, 1, 10, 30),
                        "User One"
                ),
                new Meal(
                        UUID.randomUUID(),
                        "Curry",
                        LocalDateTime.of(2022, 2, 2, 12, 32),
                        "User Two"
                )
            )
    );
    @Override
    public List<Meal> findAll() {
        return starterMeals;
    }
}
