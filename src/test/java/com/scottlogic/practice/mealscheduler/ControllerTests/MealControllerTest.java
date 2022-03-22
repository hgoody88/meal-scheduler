package com.scottlogic.practice.mealscheduler.ControllerTests;

import com.scottlogic.practice.mealscheduler.Controllers.MealController;
import com.scottlogic.practice.mealscheduler.Models.Meal;
import com.scottlogic.practice.mealscheduler.Repositories.MealRepo;
import com.scottlogic.practice.mealscheduler.Services.MealService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MealControllerTest {

    @MockBean
    MealRepo mealRepo;

    @Autowired
    MealService mealService;

    @Autowired
    MealController mealController;

    private final List<Meal> testMeals = List.of(
            new Meal(UUID.randomUUID(),
                    "Curry",
                    LocalDateTime.of(2022, 2, 2, 12, 32),
                    "User Two"),
            new Meal(UUID.randomUUID(),
                    "Pasta",
                    LocalDateTime.of(2022, 1, 1, 10, 30),
                    "User One"));


    @Test
    public void GetAllMeals_ShouldReturnListOfMeals() {
        when(mealRepo.findAll()).thenReturn(testMeals);

        //Act
        var result = mealController.GetAllMeals();

        //Assert
        assertEquals(result, testMeals);
    }
}
