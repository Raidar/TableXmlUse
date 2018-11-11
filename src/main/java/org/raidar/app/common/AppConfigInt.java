package org.raidar.app.common;

public interface AppConfigInt {
	// Config.
	String appConfigFileName = "appConfig.xml";
	String appConfigFullName = "/" + appConfigFileName;
	String errorAppConfig = "Error loading config file '%s'";

	String APP_PROPERTY_KEY = "APP_PROPERTY_EMPTY";
	String errorPropertyKey = "Config file or property key is bad (key = '%s')";

	// Logger.
	String LOGGER = "AppLogger";

	// Class.
	String UTILITY_CLASS_ERROR = "Utility class";

	// Database.
	String DRIVER_CLASS_NAME = "DRIVER_CLASS_NAME";
	String APP_DATABASE_TYPE = "APP_DATABASE_TYPE";
	String APP_DATABASE_NAME = "APP_DATABASE_NAME";

	// Application.
	String APP_CONSOLE_HELP = "APP_CONSOLE_HELP";
}
