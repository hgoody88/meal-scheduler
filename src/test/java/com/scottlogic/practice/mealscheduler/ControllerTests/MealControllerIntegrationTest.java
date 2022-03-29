package com.scottlogic.practice.mealscheduler.ControllerTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.scottlogic.practice.mealscheduler.Models.Meal;
import com.scottlogic.practice.mealscheduler.Repositories.MealRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@TestPropertySource("classpath:application-test.yml")
public class MealControllerIntegrationTest {

    @Autowired
    MealRepo mealRepo;

    @Autowired
    MockMvc mvc;

    private final List<Meal> testMeals = List.of(
            new Meal(1,
                    "Curry",
                    LocalDateTime.of(2022, 2, 2, 12, 32),
                    "User Two"),
            new Meal(2,
                    "Pasta",
                    LocalDateTime.of(2022, 1, 1, 10, 30),
                    "User One"));

    public String ObjectToJsonString(Object obj) throws JsonProcessingException {
        //This module needs to be registered in order to json parse LocalDateTime
        ObjectMapper objectMapper =
                new ObjectMapper().registerModule(new JavaTimeModule())
                        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        return objectMapper.writeValueAsString(obj);
    }

    @BeforeEach
    private void setUp(){
        mealRepo.deleteAll();
    }

    @Test
    public void GetAllMeals_Integration() throws Exception {
        mealRepo.saveAll(testMeals);

        //Act
        final var result = mvc.perform(MockMvcRequestBuilders.get("/meals"))
                .andExpect(status().isOk()).andReturn();


        final var contentsString = result.getResponse().getContentAsString();

        //Assert
        for (final var m : testMeals) {
            assertTrue(contentsString.contains(m.getName()));
        }

    }

    @Test
    public void PostNewMeal_Integration() throws Exception {
        var meal = testMeals.get(0);
        //repo will get another object, deserialised from json. we must not assume ref-equality with 'meal' above

        // Declared outside try catch as felt too heavyweight to have the whole test inside
        // the try block
        String jsonMeal = "";
        try {
            jsonMeal = ObjectToJsonString(meal);
        } catch (JsonProcessingException e) {
            fail("Json not parsed correctly... how have you done this... " + e.getMessage());
        }

        //Act
        final var result = mvc.perform(MockMvcRequestBuilders
                        .post("/meals")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonMeal))
                .andExpect(status().isOk()).andReturn();

        final var contentsString = result.getResponse().getContentAsString();

        //Assert
        assertEquals(contentsString, ObjectToJsonString(meal));
    }
}
