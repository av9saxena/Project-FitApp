package com.avios.cp.fnd.dish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.avios.cp.fnd.dish.entity.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long>, QuerydslPredicateExecutor<Dish> {

}