 package org.jsp.jdbc_Properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class P2_ReadProperties {
	public static void main(String[] args) {
		FileInputStream fin = null;
		Properties p = new Properties();
		try {
			fin = new FileInputStream("C:\\Users\\ajayk_dqm1o31\\Desktop\\Advance java by satish sir\\Jdbc_Demo\\jdbc.properties");
			p.load(fin);
			System.out.println(p.getProperty("user"));
			System.out.println(p.getProperty("password"));
			System.out.println(p.getProperty("query"));
			System.out.println(p.getProperty("url"));

		}  catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				fin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
