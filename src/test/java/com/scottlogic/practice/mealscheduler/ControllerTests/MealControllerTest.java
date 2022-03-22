package com.scottlogic.practice.mealscheduler.ControllerTests;

import com.scottlogic.practice.mealscheduler.Controllers.MealController;
import com.scottlogic.practice.mealscheduler.Models.Meal;
import com.scottlogic.practice.mealscheduler.Repositories.MealRepo;
import com.scottlogic.practice.mealscheduler.Services.MealService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(controllers = MealController.class)
public class MealControllerTest {
    @Mock
    private MealRepo mealRepo;

    @InjectMocks
    private MealService mealService;

    @Test
    public void GetAllMeals_ShouldReturnListOfMeals() throws Exception {
        //Arrange
        MealController mealController = new MealController(mealService);

        var meals = new ArrayList<Meal>();
        meals.add(new Meal(
                UUID.randomUUID(),
                "Curry",
                LocalDateTime.of(2022, 2, 2, 12, 32),
                "User Two"));
        meals.add(new Meal(
                UUID.randomUUID(),
                "Pasta",
                LocalDateTime.of(2022, 1, 1, 10, 30),
                "User One"));

        when(mealRepo.findAll()).thenReturn(meals);

        //Act
        var result = mealController.GetAllMeals();

        //Assert
        assertEquals(result, meals);
    }
}
