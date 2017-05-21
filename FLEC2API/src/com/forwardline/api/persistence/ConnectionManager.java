package com.forwardline.api.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static ConnectionManager cm;
	private Connection connection;

	static {

	}

	public ConnectionManager() throws Exception {
		loadConnection();
	}

	private void loadConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// String url = "jdbc:mysql://" + host + ":" + port + "/" + db + "?user=" + userName + "&password=" + password;
			String url = System.getProperty("JDBC_CONNECTION_STRING"); //This property is set in AWS but not in local tomcat.
			url = (url == null) ? "jdbc:mysql://aaof84atcb0bk1.c3jldtex5t6b.us-west-2.rds.amazonaws.com:3306/flapimysqldb?user=fladmin&password=!#FlFiN16app--$" : url;
			System.out.println(url);
			connection = DriverManager.getConnection(url);
		} catch (Exception e) {
			throw e;
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void close() throws SQLException {
		if (connection != null)
			connection.close();
	}

	public static void main(String args[]) {
		try {
			ConnectionManager cm = new ConnectionManager();
			Connection conn = cm.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
