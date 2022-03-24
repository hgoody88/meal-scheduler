package com.scottlogic.practice.mealscheduler.Repositories;

import com.scottlogic.practice.mealscheduler.Models.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MealRepo extends JpaRepository<Meal, Integer> {
}
