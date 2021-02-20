package com.avios.cp.fnd.dish.serviceimpl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.avios.cp.fnd.common.util.FNDUtil;
import com.avios.cp.fnd.dish.constant.DishConstant;
import com.avios.cp.fnd.dish.constant.ErrorCodes;
import com.avios.cp.fnd.dish.dao.DishDAO;
import com.avios.cp.fnd.dish.entity.Dish;
import com.avios.cp.fnd.dish.service.DishService;
import com.avios.cp.starter.exception.FitAppRuntimeException;
import com.avios.cp.starter.rest.dto.Payload;
import com.avios.cp.starter.validator.Validator;

@Service
public class DishServiceImpl implements DishService {

	@Autowired
	private DishDAO dishDAO;

	@Autowired
	@Qualifier("EXISTING_DISH_VALIDATOR")
	private Validator existingDishValidator;

	@Autowired
	@Qualifier("NEW_DISH_VALIDATOR")
	private Validator newDishValidator;

	@Autowired
	private FNDUtil fndUtil;

	@Override
	public Dish getDishByDishId(Long dishId) {

		Dish dish = dishDAO.getDishByDishId(dishId);

		if (dish == null) {
			throw new FitAppRuntimeException(ErrorCodes.ERR_FND_DISHES_0001);
		}

		return dish;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Dish saveDish(Payload payload) {

		Dish dish = null;
		Dish existingDish = null;
		List<String> errorCodes = null;

		Long pk = (Long) payload.getPayloadMap().get(DishConstant.Fields.PK.value());

		if (pk != null) {
			existingDish = dishDAO.getDishByDishId(pk);
		} else {
			String dishName = (String) payload.getPayloadMap().get(DishConstant.Fields.DISH_NAME.value());
			if (!StringUtils.isBlank(dishName)) {
				existingDish = dishDAO.getDishByDishName(dishName.toLowerCase());
			}
		}

		if (existingDish != null) {
			Map<String, Object> existingDataMap = fndUtil.convertPayload(existingDish, Map.class);
			errorCodes = existingDishValidator.validate(payload.getPayloadMap(), existingDataMap);
			dish = fndUtil.convertPayload(existingDataMap, Dish.class);
		} else {
			errorCodes = newDishValidator.validate(payload.getPayloadMap(), null);
			dish = fndUtil.convertPayload(payload.getPayloadMap(), Dish.class);
			dish.setPk(null);
		}

		if (!CollectionUtils.isEmpty(errorCodes)) {
			throw new FitAppRuntimeException(errorCodes);
		}

		dish = dishDAO.saveDish(dish);

		return dish;
	}

	@Override
	public List<Dish> getAllDishes(int page, int batchSize) {

		List<Dish> dishes = dishDAO.getAllDishes(page, batchSize);

		return dishes;
	}

	@Override
	public Dish getDishByDishName(String dishName) {
		
		Dish dish = dishDAO.getDishByDishName(dishName.toLowerCase());

		if (dish == null) {
			throw new FitAppRuntimeException(ErrorCodes.ERR_FND_DISHES_0002);
		}
		
		return dish;
	}

}
