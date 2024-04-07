package org.jsp.hibernatedemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveUserByUserInput {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		User u = new User();
		System.out.println("Enter user name ");
		u.setName(sc.next());
		System.out.println("Enter user phone number");
		u.setPhone(sc.nextLong());
		System.out.println("Enter user Email ");
		u.setEmail(sc.next());
		System.out.println("ENter user password");
		u.setPassword(sc.next());
		
		Configuration cfg = new Configuration().configure();
		SessionFactory  factory= cfg.buildSessionFactory();
		Session s = factory.openSession();
		Transaction t = s.beginTransaction();
		int id =(Integer)s.save(u);
		t.commit();
		System.out.println(id);
		sc.close();
	}

}
