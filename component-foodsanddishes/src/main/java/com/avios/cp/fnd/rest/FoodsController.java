package com.avios.cp.fnd.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avios.cp.fnd.food.constant.FoodConstants;
import com.avios.cp.fnd.food.entity.Food;
import com.avios.cp.fnd.food.service.FoodsService;
import com.avios.cp.starter.rest.dto.Payload;
import com.avios.cp.starter.rest.dto.RestAPIWrapper;
import com.avios.cp.starter.rest.helper.RestAPIWrapperHelper;

@RestController
@RequestMapping("/api/fnd/foods")
public class FoodsController {

	@Autowired
	private FoodsService foodsService;

	@GetMapping(path = "/foods/foodId/{foodId}")
	public RestAPIWrapper<Food> getFood(@PathVariable("foodId") String foodId) {

		Food food = foodsService.getFoodByFoodId(Long.parseLong(foodId));

		RestAPIWrapper<Food> response = RestAPIWrapperHelper.prepSuccessResponse(food, null);

		return response;
	}

	@PostMapping(path = { "/foods/save", "/foods" })
	public RestAPIWrapper<Food> saveFood(@RequestBody Payload payload) {

		Food food = foodsService.saveFood(payload);

		RestAPIWrapper<Food> response = RestAPIWrapperHelper.prepSuccessResponse(food, null);

		return response;
	}

	@GetMapping(path = "/foods")
	public RestAPIWrapper<List<Food>> getAllFoods(@RequestParam Map<String, String> requestParams) {

		int page = 1;
		int batch = 20;

		if (!CollectionUtils.isEmpty(requestParams)) {

			String pageString = requestParams.get(FoodConstants.Constant.PAGE.value());
			String batchString = requestParams.get(FoodConstants.Constant.BATCH_SIZE.value());

			page = (pageString != null) ? Integer.parseInt(pageString) : page;
			batch = (batchString != null) ? Integer.parseInt(batchString) : batch;
		}

		RestAPIWrapper<List<Food>> foods = foodsService.getAllFoods(page, batch);

		return foods;
	}

	@GetMapping(path = "/foods/foodName/{foodName}")
	public RestAPIWrapper<Food> getFoodByFoodName(@PathVariable("foodName") String foodName) {

		Food food = foodsService.getFoodByFoodName(foodName);

		RestAPIWrapper<Food> response = RestAPIWrapperHelper.prepSuccessResponse(food, null);

		return response;
	}
}
