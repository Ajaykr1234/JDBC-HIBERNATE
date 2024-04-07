package org.jsp.Assignment;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2oneBi.AadharCard;

public class A9_FindAadharByNoAndDOB {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter  number to find AdharCard ");
		long number = sc.nextLong();

		System.out.println("Enter DOB by formate YYYY-MM-DD");

		LocalDate DOB = LocalDate.parse(sc.next());

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select a from AadharCard a where  a.number=?1 and a.dob=?2");
		q.setParameter(1, number);
		q.setParameter(2, DOB);

		try {
			AadharCard ac = (AadharCard) q.getSingleResult();
			System.out.println(ac);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}
	}

}
