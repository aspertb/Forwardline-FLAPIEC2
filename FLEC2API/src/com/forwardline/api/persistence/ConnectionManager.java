package com.forwardline.api.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static String host;
	private static String port;
	private static String db;
	private static String userName;
	private static String password;

	private static ConnectionManager cm;
	private Connection connection;

	static {
		host = "aaof84atcb0bk1.c3jldtex5t6b.us-west-2.rds.amazonaws.com";
		port = "3306";
		userName = "fladmin";
		password = "!#FlFiN16app%$";
		db = "flapimysqldb";
	}

	private ConnectionManager() throws Exception {
		loadConnection();
	}

	public static ConnectionManager getInstance() throws Exception {
		if (cm == null)
			cm = new ConnectionManager();
		return cm;
	}

	private void loadConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://" + host + ":" + port + "/" + db + "?user=" + userName + "&password=" + password;
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
			ConnectionManager cm = ConnectionManager.getInstance();
			Connection conn = cm.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
