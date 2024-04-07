package org.jsp.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Delete_recored {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id number to delete");
		int id = sc.nextInt();

		String query = "delete from student where id=(?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "admin");
			pst = con.prepareStatement(query);

			pst.setInt(1, id);
			int res = pst.executeUpdate();
			System.out.println(res+" record deleted.....");

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
			if (pst != null) {
				try {
					pst.close();
					System.out.println("Statemrnt closed........");
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}

		}

	}
}
