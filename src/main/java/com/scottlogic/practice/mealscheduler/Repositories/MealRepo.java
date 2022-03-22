package com.scottlogic.practice.mealscheduler.Repositories;


import com.scottlogic.practice.mealscheduler.Models.Meal;

import java.util.List;

public interface MealRepo {
    public List<Meal> findAll();
}
