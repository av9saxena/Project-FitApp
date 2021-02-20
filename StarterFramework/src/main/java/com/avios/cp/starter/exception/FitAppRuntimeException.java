package com.avios.cp.starter.exception;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;

public class FitAppRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<String> errorCodes;

	private Throwable exception;

	private String stackTraceString;

	public FitAppRuntimeException(String errorCode) {
		this.errorCodes = Arrays.asList(errorCode);
	}

	public FitAppRuntimeException(Throwable exception) {
		this.exception = exception;
		this.stackTraceString = ExceptionUtils.getStackTrace(exception);
	}

	public FitAppRuntimeException(List<String> errorCodes) {
		this.errorCodes = errorCodes;
	}

	public FitAppRuntimeException(List<String> errorCodes, Throwable exception) {
		this.errorCodes = errorCodes;
		this.exception = exception;
		this.stackTraceString = ExceptionUtils.getStackTrace(exception);
	}

	public List<String> getErrorCodes() {
		return errorCodes;
	}

	public Throwable getException() {
		return exception;
	}

	public String getStackTraceString() {
		return stackTraceString;
	}
}
