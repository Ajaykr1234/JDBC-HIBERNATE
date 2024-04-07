package org.jsp.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class FectsStudentby_id {
	public static void main(String[] args) {
		String query = "select * from student where id=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet res = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student id ");
		int id = sc.nextInt();		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","admin");
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			res = pst.executeQuery();
			if(res.next()) {
				System.out.println("Student id  = "+res.getInt("id"));
				System.out.println("Student name = :"+res.getString("name"));
				System.out.println("Student mobile number = "+res.getLong("phono"));
				System.out.println("Student percentage = "+res.getDouble("perc"));
				System.out.println("Student age  = "+res.getInt("age"));
			}else {
				System.err.println("Invalid id number plese Enter valid id");
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
