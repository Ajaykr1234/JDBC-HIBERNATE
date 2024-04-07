package org.jsp.hibernatedemo;

import java.util.Scanner;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FindUserById_load {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee id ");
		int id = sc.nextInt();
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		User u = s.load(User.class, id);
		
		try {
			System.out.println("employee id "+u.getId());
			System.out.println("employee name "+u.getName());
			System.out.println("employee Phone "+u.getPhone());
			System.out.println("employee Email "+u.getEmail());
		} catch (ObjectNotFoundException e) {
			System.out.println("invaild id ");
		}
	}

}
