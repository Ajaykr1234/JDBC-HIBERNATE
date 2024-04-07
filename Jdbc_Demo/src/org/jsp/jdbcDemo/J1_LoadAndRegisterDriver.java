package org.jsp.jdbcDemo;

public class J1_LoadAndRegisterDriver {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class loaded and register");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

}
