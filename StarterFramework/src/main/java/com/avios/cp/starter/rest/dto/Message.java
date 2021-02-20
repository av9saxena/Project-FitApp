package com.avios.cp.starter.rest.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("ErrorCode")
	private String errorCode;
	
	@JsonProperty("ErrorDescription")
	private String errorDesc;
	
	public Message(String errorCode, String errorDesc) {
		this.errorCode = errorCode;
		this.errorDesc = errorDesc;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}
}
