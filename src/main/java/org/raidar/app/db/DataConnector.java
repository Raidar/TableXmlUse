package org.raidar.app.db;

import org.apache.log4j.Logger;
import org.raidar.app.common.AppConfig;
import org.raidar.app.common.AppConfigInt;
import org.raidar.app.common.AppException;
import org.raidar.app.logging.WideLogger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnector {

	private static final Logger logger = Logger.getLogger(AppConfigInt.LOGGER);

	private static final String errorDriverClass = "Driver class for '%s' is not found";
	private static final String errorConnectionOpen = "Connection for '%s' is not open";
	private static final String errorConnectionClose = "Connection for '%s' is not closed";

	private static Connection connection = null;

	private static String getDriverClassName () {
		return AppConfig.getProperty(AppConfigInt.DRIVER_CLASS_NAME);
	}

	private static String getDatabaseUrl () {
		return AppConfig.getProperty(AppConfigInt.APP_DATABASE_TYPE) +
			   AppConfig.getProperty(AppConfigInt.APP_DATABASE_NAME);
	}

	/**
	 * Get connection to DB.
	 *
	 * @return			connection to DB.
	 */
	public static Connection getConnection () {
		if (connection != null) {
			return connection;
		}

		String url = getDatabaseUrl();
		try {
			logger.info(String.format("Open connection for: %s", url));
			connection = DriverManager.getConnection(url);

			return connection;

		} catch (SQLException e) {
			String errMessage = String.format(errorConnectionOpen, url);
			WideLogger.error(errMessage, e);

			throw new AppException(errMessage);
		}
	}

	/**
	 * Close connection to DB.
	 */
	public static void closeConnection () {
		if (connection == null) {
			return;
		}

		String url = getDatabaseUrl();
		try {
			logger.info(String.format("Close connection for: %s", url));
			connection.close();

		} catch (SQLException e) {
			String errMessage = String.format(errorConnectionClose, url);
			WideLogger.error(errMessage, e);

			throw new AppException(errMessage);
		}
	}

	/**
	 * Loading driver for DB.
	 */
	public static void loadDriver () {

		String className = getDriverClassName();
		try {
			logger.info(String.format("Driver: %s", className));
			Class.forName(className);

		} catch (ClassNotFoundException e) {
			String errMessage = String.format(errorDriverClass, className);
			WideLogger.error(errMessage, e);

			throw new AppException(errMessage);
		}
	}
}
