package org.jsp.jdbcDemo.Assignment;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FectsAllName {
	public static void main(String[] args) {
		String query = "select name from student";
		Connection con = null;
		Statement st = null;
		ResultSet res = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","admin");
			st = con.createStatement();
			res = st.executeQuery(query);
			while((res.next())) {
				System.out.println("Student name  "+res.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
			if(res!=null) {
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

}

