package com.avios.cp.fnd.dish.dao;

import java.util.List;

import com.avios.cp.fnd.dish.entity.Dish;

public interface DishDAO {

	Dish getDishByDishId(Long dishId);
	
	Dish saveDish(Dish dish);
	
	List<Dish> getAllDishes(int page, int batchSize);
	
	Dish getDishByDishName(String dishName);
}
