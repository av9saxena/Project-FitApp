package com.avios.cp.starter.logging;

import java.text.MessageFormat;
import java.util.function.Supplier;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author ProMinder
 *
 */
public class Logger extends Log {

	private final String METHOD_ENTRY = "MethodEntry: {0} :: {1} :: {2}";

	private final String METHOD_EXIT = "MethodExit: {0} :: {1} :: {2}";

	private final String ERROR = "Error: {0} :: {1} :: {2}";

	private final String DEBUG = "Debug: {0} :: {1} :: {2}";

	private final String TRACE = "Trace: {0} :: {1} :: {2}";

	private final String INFO = "Info: {0} :: {1} :: {2}";

	private ObjectMapper mapper = new ObjectMapper();

	/**
	 * 
	 * @param logger
	 */
	public Logger(org.slf4j.Logger logger) {
		super(logger);
	}

	/**
	 * 
	 * @param methodName
	 * @param message
	 * @param objects
	 */
	public void logMethodEntry(String methodName, Supplier<String> message, Object... objects) {
		if (isInfoEnabled()) {
			info(MessageFormat.format(METHOD_ENTRY, methodName, message != null ? message.get() : "",
					getToStringValues(objects)));
		}
	}

	/**
	 * 
	 * @param methodName
	 * @param message
	 * @param objects
	 */
	public void logMethodExit(String methodName, Supplier<String> message, Object... objects) {
		if (isInfoEnabled()) {
			info(MessageFormat.format(METHOD_EXIT, methodName, message != null ? message.get() : "", getToStringValues(objects)));
		}
	}

	/**
	 * 
	 * @param methodName
	 * @param message
	 * @param objects
	 */
	public void debug(String methodName, Supplier<String> message, Object... objects) {
		if (isDebugEnabled()) {
			debug(MessageFormat.format(DEBUG, methodName, message != null ? message.get() : "", getToStringValues(objects)));
		}
	}

	/**
	 * 
	 * @param methodName
	 * @param message
	 * @param object
	 */
	public void debugWithJSON(String methodName, Supplier<String> message, Object object) {
		if (isDebugEnabled()) {
			debug(MessageFormat.format(DEBUG, methodName, message != null ? message.get() : "", getJson(object)));
		}
	}

	/**
	 * 
	 * @param methodName
	 * @param message
	 * @param objects
	 */
	public void info(String methodName, Supplier<String> message, Object... objects) {
		if (isInfoEnabled()) {
			info(MessageFormat.format(INFO, methodName, message != null ? message.get() : "", getToStringValues(objects)));
		}
	}

	/**
	 * 
	 * @param methodName
	 * @param message
	 * @param objects
	 */
	public void trace(String methodName, Supplier<String> message, Object... objects) {
		if (isTraceEnabled()) {
			trace(MessageFormat.format(TRACE, methodName, message != null ? message.get() : "", getToStringValues(objects)));
		}
	}

	/**
	 * 
	 * @param methodName
	 * @param message
	 * @param exception
	 */
	public void error(String methodName, Supplier<String> message, Throwable exception) {
		if (isErrorEnabled()) {
			error(MessageFormat.format(ERROR, methodName, message != null ? message.get() : "", getExceptionTrace(exception)));
		}
	}

	private String getToStringValues(Object... objects) {

		StringBuilder st = new StringBuilder("");

		if (objects.length > 0) {

			for (Object obj : objects) {
				st.append(obj.toString() + " :: ");
			}
		}

		return st.toString();
	}

	private String getJson(Object object) {

		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			jsonString = "";
		}
		return jsonString;
	}

	private String getExceptionTrace(Throwable exception) {

		String exceptionString = "";
		if (exception != null) {
			exceptionString = ExceptionUtils.getStackTrace(exception);
		}
		return exceptionString;
	}
}
