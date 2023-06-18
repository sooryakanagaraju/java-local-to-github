package com.dal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;sss



public class MyDbConnection {
	 private static Connection con;
	 private MyDbConnection(){

	 }
	
	public static synchronized  Connection getMyConnection() {

		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "Ayroosas@123");
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) {
		System.out.println(getMyConnection());
	}

}