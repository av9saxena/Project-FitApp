package com.avios.cp.starter.rest.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author ProMinder
 *
 */
public class Payload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private Map<String, Object> payloadMap = new HashMap<>();

	@JsonAnyGetter
	public Map<String, Object> getPayloadMap() {
		return payloadMap;
	}

	@JsonAnySetter
	public void setPayloadMap(String paramKey, Object paramValue) {
		this.payloadMap.put(paramKey, paramValue);
	}
}
