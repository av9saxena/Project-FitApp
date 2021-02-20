package com.avios.cp.fnd.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.avios.cp.fnd.food.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long>, QuerydslPredicateExecutor<Food> {
}
