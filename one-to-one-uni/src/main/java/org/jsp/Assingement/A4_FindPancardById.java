package org.jsp.Assingement;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2oneUni.PanCard;


public class A4_FindPancardById {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter your PanCard id number ");
		int id = sc.nextInt();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select c from PanCard c where c.id=?1");
		q.setParameter(1, id);

		try {
			PanCard p = (PanCard) q.getSingleResult();
			System.out.println(p);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}
	}

}
