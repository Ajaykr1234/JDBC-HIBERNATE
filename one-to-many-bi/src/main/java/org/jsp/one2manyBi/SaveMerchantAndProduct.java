package org.jsp.one2manyBi;

import java.util.Arrays;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveMerchantAndProduct {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Merchant m = new Merchant();
		System.out.println("Enter Merchant Name :");
		m.setName(sc.next());
		System.out.println("Enter your phone number ");
		m.setPnone(sc.nextLong());
		System.out.println("Enter your Gst Number ");
		m.setGst_number(sc.next());
		System.out.println("Enter your password ");
		m.setPassword(sc.next());

		Product p = new Product();
		System.out.println("Enter product Name");
		p.setName(sc.next());
		System.out.println("Enter product brand");
		p.setBrand(sc.next());
		System.out.println("Enter product catagoery");
		p.setCatogary(sc.next());
		System.out.println("Enter product Decription");
		p.setDecription(sc.next());
		System.out.println("Enter product Cost");
		p.setCost(sc.nextDouble());
		p.setMerchant(m);

		Product p2 = new Product();
		System.out.println("Enter product Name");
		p2.setName(sc.next());
		System.out.println("Enter product brand");
		p2.setBrand(sc.next());
		System.out.println("Enter product catagoery");
		p2.setCatogary(sc.next());
		System.out.println("Enter product Decription");
		p2.setDecription(sc.next());
		System.out.println("Enter product Cost");
		p2.setCost(sc.nextDouble());
		p2.setMerchant(m);

		Product p3 = new Product();
		System.out.println("Enter product Name");
		p3.setName(sc.next());
		System.out.println("Enter product brand");
		p3.setBrand(sc.next());
		System.out.println("Enter product catagoery");
		p3.setCatogary(sc.next());
		System.out.println("Enter product Decription");
		p3.setDecription(sc.next());
		System.out.println("Enter product Cost");
		p3.setCost(sc.nextDouble());
		p3.setMerchant(m);

		m.setProduct(Arrays.asList(p, p2, p3));

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		manager.persist(m);

		transaction.begin();
		transaction.commit();
		sc.close();

	}

}
