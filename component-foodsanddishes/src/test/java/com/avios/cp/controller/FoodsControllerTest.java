package com.avios.cp.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.avios.cp.base.BaseTC;
import com.avios.cp.fnd.food.entity.Food;
import com.avios.cp.starter.rest.dto.RestAPIWrapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FoodsControllerTest extends BaseTC {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void test1() {

		Food food = new Food();

		food.setFoodName("Egg");
		food.setFoodShortDesc("Protein packed eggs");
		food.setFoodLargeDesc("Fresh chicken eggs");
		food.setNutr_carbs("30");
		food.setNutr_fats("10");
		food.setNutr_protein("50");
		food.setNutr_others("896");
		food.setEstimatedCalories("78945");

		HttpEntity<Food> foodEntity = new HttpEntity<>(food);

		ResponseEntity<RestAPIWrapper<Food>> response = testRestTemplate.exchange("/api/fnd/foods/foods/save", HttpMethod.POST,
				foodEntity, new ParameterizedTypeReference<RestAPIWrapper<Food>>() {
				});

		assertNotNull(response);
		assertNotNull(response.getBody());

		RestAPIWrapper<Food> foodSaved = response.getBody();

		assertNotNull(foodSaved.getData());
		assertNotNull(foodSaved.getData().getPk());

		response = testRestTemplate.exchange("/api/fnd/foods/foods/foodId/1", HttpMethod.GET, null,
				new ParameterizedTypeReference<RestAPIWrapper<Food>>() {
				});

		assertNotNull(response);
		assertNotNull(response.getBody());

		RestAPIWrapper<Food> foodFetched = response.getBody();

		Long expected = 1L;

		assertNotNull(foodFetched.getData());
		assertEquals(expected, foodFetched.getData().getPk());
	}

	@Test
	public void test2() {

		ResponseEntity<RestAPIWrapper<Food>> response = testRestTemplate.exchange("/api/fnd/foods/foods/foodName/Egg",
				HttpMethod.GET, null, new ParameterizedTypeReference<RestAPIWrapper<Food>>() {
				});

		assertNotNull(response);
		assertNotNull(response.getBody());

		RestAPIWrapper<Food> foodFetched = response.getBody();

		Long expected = 1L;

		assertNotNull(foodFetched.getData());
		assertEquals(expected, foodFetched.getData().getPk());
	}
}
