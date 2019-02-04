package org.raidar.app;

import org.apache.log4j.Logger;
import org.raidar.app.common.AppConfig;
import org.raidar.app.common.AppConfigInt;
import org.raidar.app.common.OperationType;
import org.raidar.app.db.DataConnector;

/**
 * Using JDBC + XML.
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

		/* Avoid JVM bug:
			ERROR: JDWP Unable to get JNI 1.2 environment, jvm->GetEnv() return code = -2
			JDWP exit error AGENT_ERROR_NO_JNI_ENV(183):  [util.c:840]
		   See also:
		   https://bugs.java.com/bugdatabase/view_bug.do?bug_id=6476706
		   https://stackoverflow.com/questions/2225737/error-jdwp-unable-to-get-jni-1-2-environment
		*/
		System.exit(0);
	}
}
