package com.project1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String URL = "jdbc:postgresql://database-1.caam8pcxddhn.us-west-1.rds.amazonaws.com/postgres";
	private static final String USERNAME = System.getenv("DB_USER");
	private static final String PASSWORD = System.getenv("DB_PASSWORD");
	
	private static Connection conn;
	
	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
