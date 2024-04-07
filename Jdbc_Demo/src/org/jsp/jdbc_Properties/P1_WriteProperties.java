package org.jsp.jdbc_Properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class P1_WriteProperties {
	public static void main(String[] args) {
		Properties p = new Properties();
		p.setProperty("DriverClass","com.mysql.cj.jdbc.Driver");
		p.setProperty("url", "jdbc:mysql://localhost:3306/jdbc_demo");
		p.setProperty("user", "root");
		p.setProperty("password","admin");
		p.setProperty("query", "create table user (id not null unique, name not null,email varchar(20) not null,phone bigint(12) not null,primary key(id))");
	    FileOutputStream fis = null;
	    try {
	    	fis = new FileOutputStream("C:\\Users\\ajayk_dqm1o31\\Desktop\\Advance java by satish sir\\Jdbc_Demo\\jdbc.properties");
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
