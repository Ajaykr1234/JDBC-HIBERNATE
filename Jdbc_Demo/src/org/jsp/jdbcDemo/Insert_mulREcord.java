package org.jsp.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert_mulREcord {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
//		String quey = "insert into student values (15,23,222,'ayy',76.5)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "admin");
			st = con.createStatement();
			System.out.println("platform created");
//				boolean res = st.execute(quey);
			int res1 = st.executeUpdate("insert into student values (28,23,25825,'t20',76.5)");
			int res2 = st.executeUpdate("insert into student values (21,23,852,'t21',76.5)");
			int res3 = st.executeUpdate("insert into student values (22,23,3210,'t22',76.5)");
			int res4 = st.executeUpdate("insert into student values (23,23,0123,'t23',76.5)");
			System.out.println("Inserting the record Successfully.........");
			System.out.println(res1 + "row inserted....");
			System.out.println(res2 + "row inserted....");
			System.out.println(res3 + "row inserted....");
			System.out.println(res4 + "row inserted....");
			

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		} finally {
			if (con != null) {
				try {
					con.close();
					System.out.println("Connection closed.....");
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (st != null) {
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
