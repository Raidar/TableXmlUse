package org.raidar.app.common;

import org.apache.log4j.Logger;

public class ThrowHelper {

	private static final Logger logger = Logger.getLogger(AppConfigInt.LOGGER);

	private static final String textDefault = "Ошибка приложения.";
	private static final String textCaption = "Ошибка приложения:\r\n";
	private static final String textDetails = "\r\nПодробности:\r\n";

	private static String getMessage (String message) {
		return (message != null) ? message : textDefault;
	}

	private static String getMessage (Throwable thrown) {
		String message = (thrown != null) ? thrown.getMessage() : null;

		return getMessage(message);
	}

	@SuppressWarnings("unused")
	private static String getWideMessage (Throwable thrown) {
		if (thrown == null) {
			return null;
		}

		String message = thrown.getMessage();
		if (message == null) {
			if (thrown.getCause() == null) {
				message = thrown.toString();
			} else {
				message = thrown.getCause().getMessage();
			}
		}

		String details = "";
		if ((thrown.getStackTrace() != null) && (thrown.getStackTrace().length > 1)) {
			details = textDetails + thrown.getStackTrace()[0];
		}

		return textCaption + message + details;
	}

	public static void throwBy (String message) {
		String msg = getMessage(message);
		logger.error(msg);

		throw new AppException(msg);
	}

	private static void throwBy (String message, Throwable thrown, String details) {
		String msg = getMessage(message);
		logger.error(msg);

		if (details != null) {
			logger.error(details);
		}

		throw new AppException(msg, thrown);
	}

	@SuppressWarnings("unused")
	public static void throwBy (String message, Throwable thrown) {
		throwBy(message, thrown, getMessage(thrown));
	}

	public static void throwWide (String message, Throwable thrown) {
		throwBy(message, thrown, getWideMessage(thrown));
	}

}
