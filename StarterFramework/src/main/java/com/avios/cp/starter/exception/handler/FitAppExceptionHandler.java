package com.avios.cp.starter.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.avios.cp.starter.exception.FitAppRuntimeException;
import com.avios.cp.starter.rest.dto.RestAPIWrapper;
import com.avios.cp.starter.rest.helper.RestAPIWrapperHelper;

@ControllerAdvice
public class FitAppExceptionHandler extends ResponseEntityExceptionHandler {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public RestAPIWrapper handleErrorResponse(FitAppRuntimeException fitAppRuntimeException, WebRequest webRequest) {

		RestAPIWrapper errorResponse = new RestAPIWrapper();

		errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		errorResponse.setSuccess(false);
		errorResponse.setMessages(RestAPIWrapperHelper.prepMessages(fitAppRuntimeException.getErrorCodes()));

		return errorResponse;
	}
}
