package org.jsp.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert_updateDynamic {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		String query = "insert into student values (?,?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "admin");
			pst = con.prepareStatement(query);
			pst.setInt(1, 108);
			pst.setInt(2, 70);
			pst.setLong(3, 1880);
			pst.setString(4, "tytytytyt");
			pst.setInt(5, 70);
			pst.executeUpdate();
			

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
