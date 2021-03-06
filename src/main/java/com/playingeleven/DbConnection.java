package com.playingeleven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import logger.Logger;

public class DbConnection {
private static final Logger log=Logger.getInstance(); 

	public static Connection getConnection() throws SQLException {

		 Connection connection = null;
		 try {
		 String server = "cslh2009";
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 String url = "jdbc:oracle:thin:@" + server + ":1521:XE";
		 connection = DriverManager.getConnection(url, "system", "asdf12fdsa");
		 log.getInput(connection);
		 } catch (ClassNotFoundException e) {
		 throw new RuntimeException("Driver class not found");
		 } catch (SQLException e) {

		 throw new RuntimeException("invalid DB credentials" + e.getMessage());
		 }
		 return connection;


	}
	public static Jdbi getJdbi() {
		Jdbi jdbi = null;
		try {
			Connection connection = getConnection();
			jdbi = Jdbi.create(connection);
			jdbi.installPlugin(new SqlObjectPlugin());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return jdbi;
	}
}
