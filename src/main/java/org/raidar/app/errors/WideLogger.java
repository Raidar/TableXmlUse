package org.raidar.app.errors;

public class WideThrower extends Thrower {

	private static final String textCaption = "Ошибка приложения:\r\n";
	private static final String textDetails = "\r\nПодробности:\r\n";

	private static String getMessage (Throwable thrown) {
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
		StackTraceElement[] trace = thrown.getStackTrace();
		if ((trace != null) && (trace.length > 1)) {
			details = textDetails + trace[0];
		}

		return textCaption + message + details;
	}

	public static void newBy (String message, Throwable thrown) {
		Thrower.newBy(message, thrown, getMessage(thrown));
	}

}
