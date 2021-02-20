package com.avios.cp.starter.entity.service;

import java.util.List;
import java.util.function.Function;

import org.apache.commons.collections4.CollectionUtils;

import com.avios.cp.starter.entity.Entity;
import com.avios.cp.starter.exception.FitAppRuntimeException;

public class EntityValidationService {

	public void processValidation(Entity entity, Function<Entity, List<String>> validationFunction) {

		try {

			List<String> errorCodes = validationFunction.apply(entity);
			if (!CollectionUtils.isEmpty(errorCodes)) {
				entity.getErrorCodes().addAll(errorCodes);
				entity.setError(true);
			}
		} catch (Exception e) {
			entity.setError(true);
			throw new FitAppRuntimeException(e);
		}
	}
}
