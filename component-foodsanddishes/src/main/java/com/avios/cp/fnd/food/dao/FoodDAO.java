package com.avios.cp.fnd.food.dao;

import java.util.List;

import com.avios.cp.fnd.food.entity.Food;

public interface FoodDAO {

	Food getFoodByFoodId(Long foodId);
	
	Food saveFood(Food food);
	
	List<Food> getAllFoods(int page, int batch);
	
	Food getFoodByFoodName(String foodName);
	
	long getTotalFoodCount();
}
