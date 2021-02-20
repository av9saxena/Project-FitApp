package com.avios.cp.fnd.food.service;

import java.util.List;

import com.avios.cp.fnd.food.entity.Food;
import com.avios.cp.starter.rest.dto.Payload;
import com.avios.cp.starter.rest.dto.RestAPIWrapper;

public interface FoodsService {

	Food getFoodByFoodId(Long foodId);

	Food saveFood(Payload payload);

	RestAPIWrapper<List<Food>> getAllFoods(int page, int batch);

	Food getFoodByFoodName(String foodName);
}
