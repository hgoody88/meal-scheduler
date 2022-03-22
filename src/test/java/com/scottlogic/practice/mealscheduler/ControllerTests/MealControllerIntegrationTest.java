package com.scottlogic.practice.mealscheduler.ControllerTests;

import com.scottlogic.practice.mealscheduler.Controllers.MealControllerConfiguration;
import com.scottlogic.practice.mealscheduler.Models.Meal;
import com.scottlogic.practice.mealscheduler.Repositories.MealRepo;
import com.scottlogic.practice.mealscheduler.Services.MealServiceConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureWebMvc
@WebMvcTest
@ContextConfiguration(classes = {MealServiceConfiguration.class, MealControllerConfiguration.class})
public class MealControllerIntegrationTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    MealRepo mealRepo;


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
    public void GetAllMeals_Integration() throws Exception {
        when(mealRepo.findAll()).thenReturn(testMeals);

        //Act
        final var result = mvc.perform(MockMvcRequestBuilders.get("/meals"))
                .andExpect(status().isOk()).andReturn();


        final var contentsString = result.getResponse().getContentAsString();

        //Assert
        for (final var m : testMeals) {
            assertTrue(contentsString.contains(m.getName()));
        }

    }
}
