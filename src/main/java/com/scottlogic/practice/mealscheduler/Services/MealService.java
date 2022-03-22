package com.scottlogic.practice.mealscheduler.Services;

import com.scottlogic.practice.mealscheduler.Models.Meal;
import com.scottlogic.practice.mealscheduler.Repositories.MealRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    private final MealRepo mealRepo;

    @Autowired
    public MealService(MealRepo mealRepo) {
        this.mealRepo = mealRepo;
    }

    public List<Meal> GetAllMeals() {
        return mealRepo.findAll();
    }

    public Meal CreateMeal(Meal meal) {
        return mealRepo.save(meal);
    }
}
