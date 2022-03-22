package com.scottlogic.practice.mealscheduler.Controllers;

import com.scottlogic.practice.mealscheduler.Services.MealService;
import org.springframework.context.annotation.Bean;

public class MealControllerConfiguration {
    @Bean
    MealController createMealController(MealService mealService) {
        return new MealController(mealService);
    }
}
