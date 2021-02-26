package com.avios.cp.starter.logging.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avios.cp.starter.logging.LoggingManager;
import com.avios.cp.starter.rest.dto.RestAPIWrapper;
import com.avios.cp.starter.rest.helper.RestAPIWrapperHelper;

/**
 * 
 * @author ProMinder
 *
 */
@RestController
@RequestMapping("/api/logging")
public class LoggingController {

	@Autowired
	private LoggingManager loggingManager;

	@PostMapping(path = "/{loggerName}/{logLevel}")
	public RestAPIWrapper<String> updateLogLevel(@PathVariable("loggerName") String loggerName,
			@PathVariable("logLevel") String logLevel) {

		LogLevel newlogLevel = loggingManager.setLogLevel(loggerName, logLevel);

		RestAPIWrapper<String> response = RestAPIWrapperHelper.prepSuccessResponse(newlogLevel.toString(), null);

		return response;
	}
}
