package org.jsp.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class J2_EstablishConnection {

	public static void main(String[] args) {

		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Class Loaded and Register");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "admin");
			System.out.println("connection has been stablished");
		} catch (ClassNotFoundException e) {
			System.out.println("class not found ");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Invalid creadentials1");
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("Invalid creadentials");
					e.printStackTrace();
				}
			}
		}
	}

}
