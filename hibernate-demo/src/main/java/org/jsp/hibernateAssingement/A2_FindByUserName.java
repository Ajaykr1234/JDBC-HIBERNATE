package org.jsp.hibernateAssingement;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jsp.hibernatedemo.User;

public class A2_FindByUserName {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user name to find ");
		String name = sc.next();
		
		String hquery = "select u from User u where u.name=?1";
		
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		
		Query<User> q = s.createQuery(hquery);
		q.setParameter(1, name);
		List<User> users = q.getResultList();
		if(users.size()>0) {
		   for(User u : users) {
			   System.out.println("User id "+u.getId());
				System.out.println("User name "+u.getName());
				System.out.println("User Phone "+u.getPhone());
				System.out.println("User Email "+u.getEmail());
				System.out.println("=========================");
		   }
		}else {
			System.out.println("No user found by name "+name);
		}
	}

}
