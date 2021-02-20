package com.avios.cp.fnd.food.validator;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.avios.cp.fnd.food.constant.ErrorCodes;
import com.avios.cp.fnd.food.constant.FoodConstants;
import com.avios.cp.starter.validator.Validator;

@Component
@Qualifier("EXISTING_FOOD_VALIDATOR")
public class ExistingFoodValidator implements Validator {

	@Override
	public List<String> validate(Map<String, Object> targetMap, Map<String, Object> existingDataMap) {

		List<String> errorCodes = new LinkedList<>();

		Long pk = (Long) targetMap.get(FoodConstants.Fields.PK.value());
		String foodName = (String) targetMap.get(FoodConstants.Fields.FOOD_NAME.value());
		String existingFoodName = (String) existingDataMap.get(FoodConstants.Fields.FOOD_NAME.value());

		if (!StringUtils.isEmpty(foodName) && !foodName.equals(existingFoodName) && pk == null) {
			errorCodes.add(ErrorCodes.ERR_FND_FOODS_0004);
		}

		merge(targetMap, existingDataMap);

		return CollectionUtils.isEmpty(errorCodes) ? null : errorCodes;
	}
}
