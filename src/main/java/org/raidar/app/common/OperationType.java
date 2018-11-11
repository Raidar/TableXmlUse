package org.raidar.app.common;

public enum OperationType {

	HELP,
	INIT,
	LOAD,
	SAVE;

	public static OperationType getValue(String strCode) {

		for (OperationType value : OperationType.values()) {
			if (value.name().equals(strCode.toUpperCase())) {
				return value;
			}
		}

		return null;
	}

}
