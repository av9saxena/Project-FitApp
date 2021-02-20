package com.avios.cp.fnd.food.serviceimpl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.avios.cp.fnd.common.util.FNDUtil;
import com.avios.cp.fnd.food.constant.ErrorCodes;
import com.avios.cp.fnd.food.constant.FoodConstants;
import com.avios.cp.fnd.food.dao.FoodDAO;
import com.avios.cp.fnd.food.entity.Food;
import com.avios.cp.fnd.food.service.FoodsService;
import com.avios.cp.starter.exception.FitAppRuntimeException;
import com.avios.cp.starter.rest.dto.Header;
import com.avios.cp.starter.rest.dto.Payload;
import com.avios.cp.starter.rest.dto.RestAPIWrapper;
import com.avios.cp.starter.rest.helper.RestAPIWrapperHelper;
import com.avios.cp.starter.validator.Validator;

@Service
public class FoodsServiceImpl implements FoodsService {

	@Autowired
	private FoodDAO foodDAO;

	@Autowired
	private FNDUtil fndUtil;

	@Autowired
	@Qualifier("EXISTING_FOOD_VALIDATOR")
	private Validator existingFoodValidator;

	@Autowired
	@Qualifier("NEW_FOOD_VALIDATOR")
	private Validator newFoodValidator;

	@Override
	public Food getFoodByFoodId(Long foodId) {

		Food food = foodDAO.getFoodByFoodId(foodId);

		if (food != null) {
			return food;
		} else {
			throw new FitAppRuntimeException(ErrorCodes.ERR_FND_FOODS_0001);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Food saveFood(Payload payload) {

		Food food = null;
		Food existingFood = null;
		List<String> errorCodes = null;

		Long pk = (Long) payload.getPayloadMap().get(FoodConstants.Fields.PK.value());

		if (pk != null) {
			existingFood = foodDAO.getFoodByFoodId(pk);
		} else {
			String foodName = (String) payload.getPayloadMap().get(FoodConstants.Fields.FOOD_NAME.value());
			if (!StringUtils.isBlank(foodName)) {
				existingFood = foodDAO.getFoodByFoodName(foodName.toLowerCase());
			}
		}

		if (existingFood != null) {

			Map<String, Object> existingFoodMap = fndUtil.convertPayload(existingFood, Map.class);
			errorCodes = existingFoodValidator.validate(payload.getPayloadMap(), existingFoodMap);
			food = fndUtil.convertPayload(existingFoodMap, Food.class);

		} else {
			errorCodes = newFoodValidator.validate(payload.getPayloadMap(), null);
			food = fndUtil.convertPayload(payload.getPayloadMap(), Food.class);
			food.setPk(null);
		}

		if (!CollectionUtils.isEmpty(errorCodes)) {
			throw new FitAppRuntimeException(errorCodes);
		}

		food = foodDAO.saveFood(food);

		return food;
	}

	@Override
	@Transactional
	public RestAPIWrapper<List<Food>> getAllFoods(int page, int batch) {

		List<Food> foods = foodDAO.getAllFoods(page, batch);
		long count = foodDAO.getTotalFoodCount();

		Header header = new Header();
		
		header.setCount(batch);
		header.setPage(page);
		header.setTotalCount((int) count);
		
		RestAPIWrapper<List<Food>> response = RestAPIWrapperHelper.prepSuccessResponse(foods, header);
		
		return response;
	}

	@Override
	public Food getFoodByFoodName(String foodName) {
		
		Food food = foodDAO.getFoodByFoodName(foodName.toLowerCase());
		
		if(food == null) {
			throw new FitAppRuntimeException(ErrorCodes.ERR_FND_FOODS_0003);
		}
		
		return food;
	}
}
