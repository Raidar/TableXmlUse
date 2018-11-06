package org.raidar.app.common;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

public class AppException extends RuntimeException {

	@SuppressWarnings("unused")
	public AppException () {
		super();
	}

	public AppException (String message) {
		super(message);
	}

	public AppException (String message, Throwable thrown) {
		super(message, thrown);
	}
}
