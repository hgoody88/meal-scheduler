package com.scottlogic.practice.mealscheduler.Services;

import com.scottlogic.practice.mealscheduler.Models.Meal;
import com.scottlogic.practice.mealscheduler.Repositories.MealRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    private final MealRepo mealRepo;
    private final Logger logger = LoggerFactory.getLogger(MealService.class);

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
