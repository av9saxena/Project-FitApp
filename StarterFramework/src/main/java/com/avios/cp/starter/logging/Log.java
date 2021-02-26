package com.avios.cp.starter.logging;

import java.util.function.Supplier;

import org.slf4j.ext.XLogger;

/**
 * 
 * @author ProMinder
 *
 */
public class Log extends XLogger {

	/**
	 * 
	 * @param logger
	 */
	public Log(org.slf4j.Logger logger) {
		super(logger);
	}

	/**
	 * 
	 * @param message
	 */
	public void error(Supplier<String> message) {
		if (isErrorEnabled()) {
			error(message.get());
		}
	}

	/**
	 * 
	 * @param message
	 */
	public void warn(Supplier<String> message) {
		if (isWarnEnabled()) {
			warn(message.get());
		}
	}

	/**
	 * 
	 * @param message
	 */
	public void info(Supplier<String> message) {
		if (isInfoEnabled()) {
			info(message.get());
		}
	}

	/**
	 * 
	 * @param message
	 */
	public void debug(Supplier<String> message) {
		if (isDebugEnabled()) {
			debug(message.get());
		}
	}

	/**
	 * 
	 * @param message
	 */
	public void trace(Supplier<String> message) {
		if (isTraceEnabled()) {
			trace(message.get());
		}
	}
}
