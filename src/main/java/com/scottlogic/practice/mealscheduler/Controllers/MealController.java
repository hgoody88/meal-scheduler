package com.scottlogic.practice.mealscheduler.Controllers;

import com.scottlogic.practice.mealscheduler.Models.Meal;
import com.scottlogic.practice.mealscheduler.Services.MealService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MealController {

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping(value = "meals")
    public List<Meal> GetAllMeals() {
        return mealService.GetAllMeals();
    }


}
