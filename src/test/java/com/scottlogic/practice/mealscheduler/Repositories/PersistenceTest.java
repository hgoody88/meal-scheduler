package com.scottlogic.practice.mealscheduler.Repositories;

import com.scottlogic.practice.mealscheduler.Models.Meal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;


@DataJpaTest
@TestPropertySource("classpath:application-test.yml")
public class PersistenceTest {

    @Autowired
    MealRepo mealRepo;

    @Test
    void storeData() {
        final int savedId = mealRepo.save(new Meal(0,
                "Pasta123",
                LocalDateTime.of(2022, 1, 1, 10, 30),
                "User One")).getId();

        final var savedMeal = mealRepo.getById(savedId);
        Assertions.assertEquals(savedMeal.getName(), "Pasta123");
    }
}
