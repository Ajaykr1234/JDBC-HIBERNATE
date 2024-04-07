package org.jsp.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class J3_Create_Ststement {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "admin");
			st=con.createStatement();
			System.out.println("platform created");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		} finally {
			if(con!=null) {
				try {
					con.close();
					System.out.println("Connection closed.....");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if(st!=null) {
				try {
					st.close();
					System.out.println("Statemrnt closed........");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}

		}
	}

}
