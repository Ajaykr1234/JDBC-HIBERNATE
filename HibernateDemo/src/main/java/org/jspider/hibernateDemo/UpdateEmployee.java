package org.jspider.hibernateDemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateEmployee {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Employee Id ");
		int id= sc.nextInt();
		Configuration cgf= new Configuration().configure();
		SessionFactory factory =cgf.buildSessionFactory();
		Session s= factory.openSession();
		Employee e=s.get(Employee.class, id);
		if(e!=null) {
			e.setName("Kumar Niraj");
			e.setDesg("Founder");
			Transaction tc= s.beginTransaction();
			tc.commit();
		}
	}

}
