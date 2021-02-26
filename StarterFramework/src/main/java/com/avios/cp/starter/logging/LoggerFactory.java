package com.avios.cp.starter.logging;

public class LoggerFactory {

	public static Logger getLogger(Class<?> clazz) {
		return getLogger(clazz);
	}

	public static Logger getLogger(String loggerName) {
		return new Logger(org.slf4j.LoggerFactory.getLogger(loggerName));
	}
}
