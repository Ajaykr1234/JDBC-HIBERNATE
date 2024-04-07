package org.jsp.jdbcDemo.Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FindStudentBy_PhonoNumber {
	public static void main(String[] args) {
		String query = "select * from student where phono=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet res = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student MObile number");
		long mob  = sc.nextLong();		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","admin");
			pst = con.prepareStatement(query);
			pst.setLong(1,mob);
			res = pst.executeQuery();
			if(res.next()) {
				System.out.println("Student id  = "+res.getInt("id"));
				System.out.println("Student name = :"+res.getString("name"));
				System.out.println("Student mobile number = "+res.getLong("phono"));
				System.out.println("Student percentage = "+res.getDouble("perc"));
				System.out.println("Student age  = "+res.getInt("age"));
				System.out.println("=====================================");
			}else {
				System.err.println("Invalid mobile  number ");
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
