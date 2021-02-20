package com.avios.cp.fnd.dish.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avios.cp.fnd.dish.dao.DishDAO;
import com.avios.cp.fnd.dish.entity.Dish;
import com.avios.cp.fnd.dish.entity.QDish;
import com.avios.cp.fnd.dish.repository.DishRepository;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service
public class DishDAOImpl implements DishDAO {

	private DishRepository dishRepository;

	@Override
	@Transactional
	public Dish getDishByDishId(Long dishId) {

		Dish dish = null;

		QDish qDish = QDish.dish;
		BooleanExpression cond = qDish.pk.eq(dishId);

		Optional<Dish> dishOpt = dishRepository.findOne(cond);

		if (dishOpt.isPresent()) {
			dish = dishOpt.get();
		}

		return dish;
	}

	@Override
	@Transactional
	public Dish saveDish(Dish dish) {

		dish = dishRepository.save(dish);

		return dish;
	}

	@Override
	@Transactional
	public List<Dish> getAllDishes(int page, int batchSize) {

		Pageable currPageConfig = PageRequest.of(page, batchSize);

		Page<Dish> currPage = dishRepository.findAll(currPageConfig);

		return !currPage.isEmpty() ? currPage.getContent() : null;
	}

	@Override
	@Transactional
	public Dish getDishByDishName(String dishName) {

		Dish dish = null;

		QDish qDish = QDish.dish;
		BooleanExpression cond = qDish.dishName.eq(dishName);

		Optional<Dish> dishOpt = dishRepository.findOne(cond);

		if (dishOpt.isPresent()) {
			dish = dishOpt.get();
		}

		return dish;
	}

}
