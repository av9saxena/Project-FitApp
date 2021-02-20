package com.avios.cp.fnd.dish.validator;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.avios.cp.starter.validator.Validator;

@Component
@Qualifier("NEW_DISH_VALIDATOR")
public class NewDishValidator implements Validator {

	@Override
	public List<String> validate(Map<String, Object> targetMap, Map<String, Object> existingDataMap) {
		// TODO Auto-generated method stub
		return null;
	}
}
