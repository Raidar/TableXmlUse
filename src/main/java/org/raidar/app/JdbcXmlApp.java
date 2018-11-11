package org.raidar.app;

import org.apache.log4j.Logger;
import org.raidar.app.common.AppConfig;
import org.raidar.app.common.AppConfigInt;
import org.raidar.app.common.OperationType;
import org.raidar.app.db.DataConnector;

/**
 * Hello world!
 *
 */
public class JdbcXmlApp {

	private static final Logger logger = Logger.getLogger(AppConfigInt.LOGGER);

	private static final String APP_ARG_EMPTY = "No arguments";
	private static final String APP_ARG_LIST = "Arguments:";
	private static final String APP_ARG_ITEM = "[%d] = %s";

	public static void logArgs (String[] args) {

		if (!(args.length > 0)) {
			logger.info(APP_ARG_EMPTY);

			return;
		}

		logger.info(APP_ARG_LIST);
		for (int i = 0; i < args.length; i++) {
			logger.info(String.format(APP_ARG_ITEM, i, args[i]));
		}
	}

	public static OperationType getOperationType (String value) {
		OperationType type = OperationType.getValue(value);
		return (type != null) ? type : OperationType.HELP;
	}

	public static void main (String[] args) {
		logArgs(args);

		boolean isArgs = (args.length > 0);
		OperationType type = (isArgs) ? getOperationType(args[0]) : OperationType.HELP;

		if (type == OperationType.HELP) {
			System.out.println(AppConfig.getProperty(AppConfigInt.APP_CONSOLE_HELP));

			return;
		}

		try {
			DataConnector.loadDriver();

			//DataConnector.getConnection();

			// TODO: switch + action.

		} finally {
			DataConnector.closeConnection();
		}
	}
}
