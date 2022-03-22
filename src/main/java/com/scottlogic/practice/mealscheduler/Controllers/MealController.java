package com.scottlogic.practice.mealscheduler.Controllers;

import com.scottlogic.practice.mealscheduler.Models.Meal;
import com.scottlogic.practice.mealscheduler.Services.MealService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("meals")
public class MealController {

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping
    public List<Meal> GetAllMeals() {
        return mealService.GetAllMeals();
    }

    @PostMapping
    @ResponseBody
    public Meal CreateMeal(@RequestBody Meal meal) {
        return mealService.CreateMeal(meal);
    }

}
