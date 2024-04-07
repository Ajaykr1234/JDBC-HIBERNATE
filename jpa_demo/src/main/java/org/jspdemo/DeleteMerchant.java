package org.jspdemo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteMerchant {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id to delete the record from table");
		int id = sc.nextInt();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Merchant m = manager.find(Merchant.class, id);
		EntityTransaction transaction = manager.getTransaction();
		if(m!=null) {
			manager.remove(m);
			transaction.begin();
			transaction.commit();
			sc.close();
			
		}else {
			System.out.println("Enter id is invalid please try again");
		}

	}
}
