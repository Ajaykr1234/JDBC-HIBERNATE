package org.jsp.hibernatedemo;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindUserBY_ID {
	public static void main(String[] args) {
		String query ="select u from User u where u.id=:id";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User id to find ");
		int id = sc.nextInt();
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Query<User > q = s.createQuery(query);
		q.setParameter("id", id);
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
