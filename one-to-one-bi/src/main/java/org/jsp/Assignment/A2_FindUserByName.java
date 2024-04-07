package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2oneBi.User;

public class A2_FindUserByName {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter name to find user ");
		String name = sc.next();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select u from User u where u.name=?1");
		q.setParameter(1, name);
		
		//List<User> usr = 

		try {
			User p = (User) q.getSingleResult();
			System.out.println(p);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}
	}

}
