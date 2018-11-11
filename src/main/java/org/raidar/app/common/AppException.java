package org.raidar.app.common;

public class AppException extends RuntimeException {

	@SuppressWarnings("unused")
	public AppException () {
		super();
	}

	public AppException (String message) {
		super(message);
	}

	@SuppressWarnings("unused")
	public AppException (String message, Throwable thrown) {
		super(message, thrown);
	}
}
