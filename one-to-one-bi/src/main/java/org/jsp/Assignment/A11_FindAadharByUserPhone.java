package org.jsp.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2oneBi.AadharCard;

public class A11_FindAadharByUserPhone {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter  user phone to find AdharCard ");
		long phone = sc.nextLong();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select u.Card from User u where u.phone=?1"); 
		q.setParameter(1, phone);

		try {
			AadharCard ac = (AadharCard) q.getSingleResult();
			System.out.println(ac);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}
	}

}
