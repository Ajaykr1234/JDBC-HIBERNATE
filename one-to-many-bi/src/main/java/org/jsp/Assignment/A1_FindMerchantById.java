package org.jsp.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2manyBi.Merchant;

public class A1_FindMerchantById {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Merchant id to find details");
		int id = sc.nextInt();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select m from Merchant m where m.id=?1");
		q.setParameter(1, id);

		try {

			Merchant m = (Merchant) q.getSingleResult();
			System.out.println(m);

		} catch (NoResultException e) {
			System.out.println("No Merchant Found BY ID : " + id);
		}
	}

}
