package org.jsp.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class J4_Create_DataBase {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		String quey = "create database jdbc_demo1";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "admin");
			st=con.createStatement();
			System.out.println("platform created");
			boolean res = st.execute(quey);
			System.out.println("Database created.........");
			System.out.println(res);

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
