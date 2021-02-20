package com.avios.cp.starter.validator;

import java.util.List;
import java.util.Map;

public interface Validator {

	List<String> validate(Map<String, Object> targetMap, Map<String, Object> existingDataMap);

	default void merge(Map<String, Object> targetMap, Map<String, Object> existingDataMap) {

	}
}
