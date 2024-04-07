package org.jsp.Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2manyBi.Product;

public class A11_FilterProdBetweenPriceRange {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your minimum price");
		double min = sc.nextDouble();

		System.out.println("Enter your maximum price");
		double max = sc.nextDouble();

		Product p = new Product();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select m  from Product p where p.cost?1 >= p.cost?2 ");

		q.setParameter(1, min);
		q.setParameter(2, max);

		List<Product> prod = q.getResultList();

		for (Product p1 : prod) {
			System.out.println(p1);
		}

	}

}
