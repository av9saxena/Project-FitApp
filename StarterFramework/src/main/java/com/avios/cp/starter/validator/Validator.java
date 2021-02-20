package com.avios.cp.starter.validator;

import java.util.List;
import java.util.Map;

import com.avios.cp.starter.constant.Constant;

public interface Validator {

	List<String> validate(Map<String, Object> targetMap, Map<String, Object> existingDataMap);

	@SuppressWarnings("unchecked")
	default void merge(Map<String, Object> targetMap, Map<String, Object> existingDataMap) {

		for (Map.Entry<String, Object> entry : targetMap.entrySet()) {

			if (!Constant.Fields.PK.value().equals(entry.getKey())) {

				Object value = entry.getValue();

				if (value instanceof Map) {
					merge((Map<String, Object>) value, (Map<String, Object>) existingDataMap.get(entry.getKey()));
				} else {
					existingDataMap.put(entry.getKey(), value);
				}
			}
		}
	}
}
