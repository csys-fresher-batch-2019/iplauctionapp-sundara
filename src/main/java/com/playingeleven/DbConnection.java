package com.playingeleven;

import java.sql.Connection;
import java.sql.DriverManager;

import logger.Logger;

public class DbConnection {
	private static final Logger log=Logger.getInstance(); 

	public static Connection getConnection() throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
				"asdf12fdsa");
		//log.getInput(connection);
		return connection;
	}
}
