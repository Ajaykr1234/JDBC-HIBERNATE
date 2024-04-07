package org.jsp.jdbcDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesClass_WritePropertesStore {
	public static void main(String[] args) {
		Properties p = new Properties();
		p.setProperty("DriverClass","com.mysql.cj.jdbc.Driver");
		p.setProperty("url", "jdbc:mysql://localhost 3306/jdbc_demmo");
		p.setProperty("user", "root");
		p.setProperty("password","admin");
	    FileOutputStream fis = null;
	    try {
	    	fis = new FileOutputStream("C:\\Users\\ajayk_dqm1o31\\Desktop\\Advance java by satish sir\\Jdbc_Demo\\lib\\jdbc.properties");
			p.store(fis, "Adding the properties");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
