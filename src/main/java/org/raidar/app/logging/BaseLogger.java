package org.raidar.app.logging;

import org.apache.log4j.Logger;
import org.raidar.app.common.AppConfigInt;

public class BaseLogger {

	private static final Logger logger = Logger.getLogger(AppConfigInt.LOGGER);

	private static final String textDefault = "Ошибка приложения.";

	private static String getMessage (String message) {
		return (message != null) ? message : textDefault;
	}

	private static String getMessage (Throwable thrown) {
		String message = (thrown != null) ? thrown.getMessage() : null;

		return getMessage(message);
	}

	public static void error (String message) {
		logger.error(getMessage(message));
	}

	public static void error (String message, Throwable thrown, String details) {
		logger.error(getMessage(message));

		if (details != null) {
			logger.error(details);
		}
	}

	@SuppressWarnings("unused")
	public static void error (String message, Throwable thrown) {
		error(message, thrown, getMessage(thrown));
	}

}
