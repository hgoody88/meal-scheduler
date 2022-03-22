package com.scottlogic.practice.mealscheduler.Services;

import com.scottlogic.practice.mealscheduler.Repositories.MealRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MealServiceConfiguration {
    @Bean
    MealService createMealService(MealRepo mealRepo) {
        return new MealService(mealRepo);
    }
}
