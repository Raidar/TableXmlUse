package org.raidar.app.common;

import org.raidar.app.logging.BaseLogger;
import org.raidar.app.utils.AppConfigReader;

import java.util.Properties;

public class AppConfig implements AppConfigInt {

	private static Properties properties;

	private static Properties getProperties () {
		if (properties == null) {
			properties = AppConfigReader.getConfig();
		}

		return properties;
	}

	/**
	 * Get property value from config file.
	 *
	 * @param key		property name
	 *
	 * @return			property value
	 */
	public static String getProperty (String key) {

		Properties props = getProperties();

		if (props != null) {
			String property = props.getProperty(key);
			if (property != null) {
				return property;

			} else {
				String errMessage = String.format(props.getProperty(APP_PROPERTY_KEY, errorPropertyKey), key);
				BaseLogger.error(errMessage);

				throw new AppException(errMessage);
			}

		} else {
			String errMessage = String.format(errorPropertyKey, key);
			BaseLogger.error(errMessage);

			throw new AppException(errMessage);
		}
	}

}
