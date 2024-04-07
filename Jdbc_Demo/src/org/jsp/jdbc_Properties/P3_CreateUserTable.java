 package org.jsp.jdbc_Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class P3_CreateUserTable {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		Properties p = new Properties();
		FileInputStream fin = null;
		String query = p.getProperty("query");

		try {

			fin = new FileInputStream("C:\\Users\\ajayk_dqm1o31\\Desktop\\Advance java by satish sir\\Jdbc_Demo\\jdbc.properties");
			p.load(fin);
			Class.forName(p.getProperty("DriverClass"));
			System.out.println(p.getProperty("query"));
			con = DriverManager.getConnection(p.getProperty("url"),p);
			st = con.createStatement();
			st.execute(p.getProperty("query"));
			System.out.println("table Created");
		} catch (IOException | SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}