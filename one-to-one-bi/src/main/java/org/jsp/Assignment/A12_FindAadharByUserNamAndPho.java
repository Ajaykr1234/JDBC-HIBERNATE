package org.jsp.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2oneBi.AadharCard;

public class A12_FindAadharByUserNamAndPho {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter User name to find Aadhar Card");
		String name = sc.next();
		System.out.println("enter  user phone to find AdharCard ");
		long phone = sc.nextLong();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select u.Card from User u where u.name=?1 and u.phone=?2");
		q.setParameter(1, name);
		q.setParameter(2, phone);

		try {
			AadharCard ac = (AadharCard) q.getSingleResult();
			System.out.println(ac);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}
	}

}
