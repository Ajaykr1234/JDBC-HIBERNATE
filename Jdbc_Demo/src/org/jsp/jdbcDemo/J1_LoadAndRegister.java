package org.jsp.jdbcDemo;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class J1_LoadAndRegister {
	
	public static void main(String[] args) {
		
		try {
			Driver d  = new Driver();
			DriverManager.registerDriver(d);
			System.out.println("Driver class Loaded and register ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
