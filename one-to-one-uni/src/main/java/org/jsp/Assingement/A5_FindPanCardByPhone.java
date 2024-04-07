package org.jsp.Assingement;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2oneUni.PanCard;

public class A5_FindPanCardByPhone {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter phone number to find the PanCard");

		String number = sc.next();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select c from PanCard c where c.number=?1");

		q.setParameter(1, number);

		try {
			PanCard p = (PanCard) q.getSingleResult();
			System.out.println(p);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}
	}

}
