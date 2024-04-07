package org.jsp.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsp.one2manyBi.Product;

public class A7_FindProdBYID {
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Product id to find details");
		int id = sc.nextInt();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select p from Product p where p.id=?1");
		q.setParameter(1, id);

		try {

			Product p = (Product) q.getSingleResult();
			System.out.println(p);

		} catch (NoResultException e) {
			System.out.println("No Product Found BY ID : " + id);
		}
	}

}
