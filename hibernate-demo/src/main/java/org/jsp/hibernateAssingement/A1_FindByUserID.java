package org.jsp.hibernateAssingement;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jsp.hibernatedemo.User;

public class A1_FindByUserID {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user id ");
		int id = sc.nextInt();
		String hquery = "select u from User u where u.id=?1";
		Session s= new Configuration().configure().buildSessionFactory().openSession();
		
		Query<User > q = s.createQuery(hquery);
		q.setParameter(1, id);
		
		try {
			User u = q.getSingleResult();
			System.out.println("User id "+u.getId());
			System.out.println("User name "+u.getName());
			System.out.println("User Phone "+u.getPhone());
			System.out.println("User Email "+u.getEmail());
			System.out.println("=========================");
			
		} catch (NoResultException e) {
			System.out.println("There is no record found in user table by id "+id);
		}
		
	}

}
