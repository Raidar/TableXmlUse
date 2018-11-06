package org.raidar.app;

import org.apache.log4j.Logger;
import org.raidar.app.common.AppConfigInt;
import org.raidar.app.db.DataConnector;

/**
 * Hello world!
 *
 */
public class JdbcXmlApp {

	private static final Logger logger = Logger.getLogger(AppConfigInt.LOGGER);

	public static void main (String[] args) {

		if (args.length > 0) {
			logger.info("args:");
			for (int i = 0; i < args.length; i++) {
				logger.info(String.format("arg %d = %s", i, args[i]));
			}
		}

		DataConnector.loadDriver();

		//DataConnector.getConnection();
	}
}
