package org.jsp.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Save_Student {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		String quey = "insert into student values (15,23,222,'ayy',76.5)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "admin");
			st=con.createStatement();
			System.out.println("platform created");
//			boolean res = st.execute(quey);
			int res = st.executeUpdate(quey);
			System.out.println("Inserting the record Successfully.........");
			System.out.println(res+"row inserted....");

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
