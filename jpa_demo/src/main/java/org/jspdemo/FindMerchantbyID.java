package org.jspdemo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindMerchantbyID {

	public static void main(String[] args) {
		Merchant m = new Merchant();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter merchant id :");
		int id = sc.nextInt();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Merchant m1 = manager.find(Merchant.class, id);
		
		if(m1!=null) {
			System.out.println(m1.getName());
		}else {
			System.out.println("Invaild id ");
		}

	}

}
