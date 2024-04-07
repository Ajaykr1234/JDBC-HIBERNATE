package org.jsp.Assignment;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2oneBi.User;

public class A6_FindUserByAadharNoAndDOB {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter  AadharNumber to find user ");
		long number = sc.nextLong();
		System.out.println("Enter date of Birth formate YYYY-MM-DD");
		LocalDate dob = LocalDate.parse(sc.next());

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select a.user from AadharCard a where a.number=?1 and a.dob=?2");
		q.setParameter(1, number);
		q.setParameter(2, dob);

		try {
			User p = (User) q.getSingleResult();
			System.out.println(p);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}
	}

}
