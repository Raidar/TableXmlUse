package org.raidar.app.db;

import java.sql.SQLException;
import java.sql.Statement;

public class DataHandler {

	private static int STATEMENT_QUERY_TIMEOUT = 30; // (sec)

	public static Statement newStatement () throws SQLException {
		return DataConnector.getConnection().createStatement();
	}
}
