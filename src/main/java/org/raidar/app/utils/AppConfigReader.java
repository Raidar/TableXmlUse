package org.raidar.app.utils;

import org.raidar.app.common.AppConfigInt;
import org.raidar.app.common.AppException;
import org.raidar.app.logging.WideLogger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfigReader {

	private AppConfigReader () {
		throw new IllegalStateException(AppConfigInt.UTILITY_CLASS_ERROR);
	}

	private static String getConfigFileName () {
		return AppConfigInt.appConfigFullName;
	}

	public static Properties getConfig () {

		String name = getConfigFileName();
		InputStream file = AppConfigReader.class.getResourceAsStream(name);
		if (file == null) {
			return null;
		}

		Properties props = new Properties();
		try {
			props.loadFromXML(file);
			//throw new IOException("Dbg error"); // DEBUG only: BaseLogger.

			return props;

		} catch (IOException e) {
			String errMessage = String.format(AppConfigInt.errorAppConfig, name);
			WideLogger.error(errMessage, e);

			throw new AppException(errMessage);
		}
	}
}
