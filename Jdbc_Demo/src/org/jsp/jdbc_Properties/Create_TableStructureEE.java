package org.jsp.jdbc_Properties;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_TableStructureEE {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		String quey = "create table studenttt(id int not null,age int not null,phono bigint(20) not null unique, name varchar(45) not null,perc decimal not null, primary key(id))";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "admin");
			st=con.createStatement();
			System.out.println("platform created");
			boolean res = st.execute(quey);
			System.out.println("table created.........");
			System.out.println(res);
			
			
			// Drop the existing 'student' table if it exists
//			String dropTableQuery = "DROP TABLE IF EXISTS student";
//			st.execute(dropTableQuery);
//			st.execute(quey);
//			System.out.println("Table 'student' (with a new structure) created.");


		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		} finally {
			if(con!=null) {
				try {
					con.close();
					System.out.println("Connection closed.....");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if(st!=null) {
				try {
					st.close();
					System.out.println("Statemrnt closed........");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}

	}

}
}

