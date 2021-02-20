package com.avios.cp.starter.entity;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author ProMinder
 *
 */
public class Entity {

	private Map<String, Object> newObject;

	private Map<String, Object> oldObject;

	private boolean isError = false;

	private Set<String> errorCodes;

	public Entity(Map<String, Object> newObject, Map<String, Object> oldObject) {
		this.oldObject = oldObject;
		this.newObject = newObject;
	}

	public Map<String, Object> getNewObject() {
		return newObject;
	}

	public Map<String, Object> getOldObject() {
		return oldObject;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public Set<String> getErrorCodes() {
		return errorCodes;
	}

	public void addErrorCode(String errorCode) {
		if (this.errorCodes == null) {
			errorCodes = new HashSet<>();
		}

		errorCodes.add(errorCode);
	}
}
