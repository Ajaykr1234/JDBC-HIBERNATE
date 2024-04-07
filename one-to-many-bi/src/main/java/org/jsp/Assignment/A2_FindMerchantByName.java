package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2manyBi.Merchant;

public class A2_FindMerchantByName {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Merchant name to find details");
		String name = sc.next();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select m from Merchant m where m.name=?1");
		q.setParameter(1, name);

		try {

			List<Merchant> mer = q.getResultList();
			for (Merchant m : mer) {
				System.out.println(m);
			}

		} catch (NoResultException e) {
			System.out.println("No Merchant Found BY Name : " + name);
		}
	}

}
