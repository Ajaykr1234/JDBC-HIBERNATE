package org.jspdemo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Update_BY_fetch {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter merchant to update the details ");
		int id = sc.nextInt();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Merchant m1 = manager.find(Merchant.class, id);

		System.out.println("Enter name to update  ");
		m1.setName(sc.next());
		System.out.println("Enter email to update  ");
		m1.setEmail(sc.next());
		System.out.println("Enter pass to update  ");
		m1.setPassword(sc.next());

		EntityTransaction transtion = manager.getTransaction();
		transtion.begin();
		transtion.commit();
		sc.close();

	}

}
