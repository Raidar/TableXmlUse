package org.raidar.app.common;

import org.apache.log4j.Logger;
import org.raidar.app.utils.AppConfigReader;

import java.util.Properties;

public class AppConfig implements AppConfigInt {

	private static final Logger logger = Logger.getLogger(AppConfigInt.LOGGER);

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
				ThrowHelper.throwBy(errMessage);

				return null;
			}

		} else {
			String errMessage = String.format(errorPropertyKey, key);
			ThrowHelper.throwBy(errMessage);

			return null;
		}
	}

}
