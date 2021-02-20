package com.avios.cp.fnd.dish.service;

import java.util.List;

import com.avios.cp.fnd.dish.entity.Dish;
import com.avios.cp.starter.rest.dto.Payload;

public interface DishService {

	Dish getDishByDishId(Long dishId);
	
	Dish saveDish(Payload payload);
	
	List<Dish> getAllDishes(int page, int batchSize);
	
	Dish getDishByDishName(String dishName);
}
