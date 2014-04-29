package com.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ORMDcon {
	private static Connection conn;

	public static Connection getConnection() {
		if (conn == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
			String url = "jdbc:mysql://localhost/BankSystem";
			String user = "root";
			String password = "123456";

			try {
				conn = (Connection) DriverManager.getConnection(url, user,
						password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Accounts DB connects successfully.");
		}

		return conn;
	}
}
