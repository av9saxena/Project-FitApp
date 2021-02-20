package com.avios.cp.fnd.food.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avios.cp.fnd.food.dao.FoodDAO;
import com.avios.cp.fnd.food.entity.Food;
import com.avios.cp.fnd.food.entity.QFood;
import com.avios.cp.fnd.food.repository.FoodRepository;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service
public class FoodDAOImpl implements FoodDAO {

	@Autowired
	private FoodRepository foodRepository;

	@Override
	@Transactional
	public Food getFoodByFoodId(Long foodId) {

		Food food = null;

		QFood qFood = QFood.food;
		BooleanExpression booleanExpression = qFood.pk.eq(foodId);

		Optional<Food> foodOpt = foodRepository.findOne(booleanExpression);

		if (foodOpt.isPresent()) {
			food = foodOpt.get();
		}

		return food;
	}

	@Override
	@Transactional
	public Food saveFood(Food food) {

		food = foodRepository.save(food);

		return food;
	}

	@Override
	@Transactional
	public List<Food> getAllFoods(int page, int batch) {

		Pageable currPageConfig = PageRequest.of(page, batch);

		Page<Food> currPage = foodRepository.findAll(currPageConfig);

		return !currPage.isEmpty() ? currPage.getContent() : null;
	}

	@Override
	public Food getFoodByFoodName(String foodName) {

		Food food = null;

		QFood qFood = QFood.food;
		BooleanExpression booleanExpression = qFood.foodName.eq(foodName);

		Optional<Food> foodOpt = foodRepository.findOne(booleanExpression);

		if (foodOpt.isPresent()) {
			food = foodOpt.get();
		}

		return food;
	}

	@Override
	@Transactional
	public long getTotalFoodCount() {

		long totalCount = foodRepository.count();

		return totalCount;
	}
}
