package org.jsp.hibernate1demo1;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveEmployeeBYUserinpute {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employee e = new Employee();
		System.out.println("Enter your name : ");
		String name = sc.nextLine();
		System.out.println("Enter your phone number  ");
		long phone = sc.nextLong();
		System.out.println("Enter your email  : ");
		String email = sc.nextLine();
		sc.next();
		System.out.println("Enter your password : ");
		String password = sc.next();
		
		
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		Transaction t = s.beginTransaction();
		int id =(Integer)s.save(e);
		t.commit();
		System.out.println(id);
		sc.close();
	}

}
