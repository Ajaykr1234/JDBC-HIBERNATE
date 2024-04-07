package org.jsp.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2oneBi.AadharCard;

public class A7_FindAdharById {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter id number to find AdharCard ");
		int id = sc.nextInt();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select a from AadharCard a where  a.id=?1");
		q.setParameter(1, id);

		try {
			AadharCard ac = (AadharCard) q.getSingleResult();
			System.out.println(ac);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}
	}

}
