package org.jsp.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchesNth_Record {
	
	public static void main(String[] args) {
		String query = "select * from student";
		Connection con = null;
		Statement st = null;
		ResultSet res = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","admin");
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			res = st.executeQuery(query);
			if((res.absolute(5))) {
				System.out.println("Student id : "+res.getInt("id"));
				System.out.println("Student name : "+res.getString("name"));
				System.out.println("Student Percentage  "+res.getDouble("perc"));
				System.out.println("===============================================");
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
