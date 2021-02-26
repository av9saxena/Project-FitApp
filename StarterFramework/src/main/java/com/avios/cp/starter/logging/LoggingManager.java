package com.avios.cp.starter.logging;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.impl.StaticLoggerBinder;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

/**
 * 
 * @author ProMinder
 *
 */
@Component
public class LoggingManager {

	private static final Map<LogLevel, Level> LOG_LEVELS;

	static {
		Map<LogLevel, Level> logLevels = new HashMap<>();

		logLevels.put(LogLevel.TRACE, Level.TRACE);
		logLevels.put(LogLevel.INFO, Level.INFO);
		logLevels.put(LogLevel.WARN, Level.WARN);
		logLevels.put(LogLevel.DEBUG, Level.DEBUG);
		logLevels.put(LogLevel.ERROR, Level.ERROR);
		logLevels.put(LogLevel.FATAL, Level.ERROR);
		logLevels.put(LogLevel.OFF, Level.OFF);

		LOG_LEVELS = Collections.unmodifiableMap(logLevels);
	}

	/**
	 * Method set the log level as per the input. It also return the previous log level
	 * @param loggerName
	 * @param logLevel
	 * @return
	 */
	public LogLevel setLogLevel(String loggerName, String logLevel) {

		LogLevel currentLogLevel = getCurrLogLevel(loggerName);
		getLogger(loggerName).setLevel(LOG_LEVELS.get(LogLevel.valueOf(logLevel)));
		return currentLogLevel;
	}

	private LogLevel getCurrLogLevel(String loggerName) {

		Level currlevel = getLogger(loggerName).getLevel();

		for (Map.Entry<LogLevel, Level> entry : LOG_LEVELS.entrySet()) {

			if (entry.getValue() == currlevel) {
				return entry.getKey();
			}
		}
		return LogLevel.OFF;
	}

	private Logger getLogger(String loggerName) {
		return (Logger) (StaticLoggerBinder.getSingleton().getLoggerFactory())
				.getLogger(StringUtils.isBlank(loggerName) ? Logger.ROOT_LOGGER_NAME : loggerName);
	}
}
