package org.jspdemo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Savemerchant {

	public static void main(String[] args) {

		Merchant m = new Merchant();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your name ");
		m.setName(sc.next());

		System.out.println("Enter your gst_number");
		m.setGst_number(sc.next());

		System.out.println("Enter your phone ");
		m.setPhone(sc.nextLong());
		
		System.out.println("Enter your email ");
		m.setEmail(sc.next());

		System.out.println("Enter your Password ");
		m.setPassword(sc.next());
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		manager.persist(m);
		EntityTransaction transaction = manager.getTransaction();
		
		System.out.println("Merchant save with an id "+m.getId());
		transaction.begin();
		transaction.commit();
		sc.close();

	}

}
