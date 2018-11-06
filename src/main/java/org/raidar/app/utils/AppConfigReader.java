package org.raidar.app.utils;

import org.apache.log4j.Logger;
import org.raidar.app.common.AppConfigInt;
import org.raidar.app.common.ThrowHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfigReader {

	private static final Logger logger = Logger.getLogger(AppConfigInt.LOGGER);

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
			//throw new IOException("Dbg error"); // DEBUG only: ThrowHelper.
			return props;

		} catch (IOException e) {
			ThrowHelper.throwWide(String.format(AppConfigInt.errorAppConfig, name), e);

			return null;
		}
	}
}
