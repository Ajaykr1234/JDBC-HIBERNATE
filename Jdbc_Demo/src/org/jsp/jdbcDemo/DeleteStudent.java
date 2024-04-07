package org.jsp.jdbcDemo;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteStudent {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		String quey = "Delete from student where id=15";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "admin");
			st = con.createStatement();
			System.out.println("platform created");
//			boolean res = st.execute(quey);
			int res = st.executeUpdate(quey);
			System.out.println("Updating  the record Successfully.........");
			System.out.println(res+"row deleted");

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
