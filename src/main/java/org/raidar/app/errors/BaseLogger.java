package org.raidar.app.errors;

import org.apache.log4j.Logger;
import org.raidar.app.common.AppConfigInt;
import org.raidar.app.common.AppException;

public class Thrower {

	private static final Logger logger = Logger.getLogger(AppConfigInt.LOGGER);

	private static final String textDefault = "Ошибка приложения.";

	private static String getMessage (String message) {
		return (message != null) ? message : textDefault;
	}

	private static String getMessage (Throwable thrown) {
		String message = (thrown != null) ? thrown.getMessage() : null;

		return getMessage(message);
	}

	public static void newBy (String message) {
		String msg = getMessage(message);
		logger.error(msg);

		throw new AppException(msg);
	}

	public static void newBy (String message, Throwable thrown, String details) {
		String msg = getMessage(message);
		logger.error(msg);

		if (details != null) {
			logger.error(details);
		}

		throw new AppException(msg, thrown);
	}

	@SuppressWarnings("unused")
	public static void newBy (String message, Throwable thrown) {
		newBy(message, thrown, getMessage(thrown));
	}

}
