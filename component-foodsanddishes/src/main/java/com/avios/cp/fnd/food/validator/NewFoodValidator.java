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
@Qualifier("NEW_FOOD_VALIDATOR")
public class NewFoodValidator implements Validator {

	@Override
	public List<String> validate(Map<String, Object> targetMap, Map<String, Object> existingDataMap) {

		List<String> errorList = new LinkedList<>();
		
		String foodName = (String) targetMap.get(FoodConstants.Fields.FOOD_NAME.value());
		
		if(StringUtils.isBlank(foodName)) {
			errorList.add(ErrorCodes.ERR_FND_FOODS_0002);
		} else {
			targetMap.put(FoodConstants.Fields.FOOD_NAME.value(), foodName.toLowerCase());
		}
		
		return CollectionUtils.isEmpty(errorList)?null:errorList;
	}
}
