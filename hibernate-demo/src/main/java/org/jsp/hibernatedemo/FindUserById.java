package org.jsp.hibernatedemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FindUserById {
	public static void main(String[] args) {
		
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter user id ");
	int id = sc.nextInt();
	Configuration cfg = new Configuration().configure();
	SessionFactory factory = cfg.buildSessionFactory();
	Session s = factory.openSession();
	User u = s.get(User.class, id);
	if(u!=null) {
		System.out.println("User id "+u.getId());
		System.out.println("User name "+u.getName());
		System.out.println("User Phone "+u.getPhone());
		System.out.println("User Email "+u.getEmail());
	}else {
		System.err.println("You have Enter an Invaild id");
	}
	
}
}