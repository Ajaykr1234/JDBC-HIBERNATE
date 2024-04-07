package org.jsp.jdbcDemo.Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FindStudentBy_Perc {
	public static void main(String[] args) {
		String query = "select * from student where perc=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet res = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student Percentage ");
		double perc  = sc.nextDouble();		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","admin");
			pst = con.prepareStatement(query);
			pst.setDouble(1,perc);
			res = pst.executeQuery();
			while(res.next()) {
				System.out.println("Student id  = "+res.getInt("id"));
				System.out.println("Student name = :"+res.getString("name"));
				System.out.println("Student mobile number = "+res.getLong("phono"));
				System.out.println("Student percentage = "+res.getDouble("perc"));
				System.out.println("Student age  = "+res.getInt("age"));
				System.out.println("=====================================");
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
			if (pst != null) {
				try {
					pst.close();
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
