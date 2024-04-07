package org.jspdemo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VerifyByEmailandPassword {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Merchant email id ");
		String email=sc.next();
		System.out.println("Enter the Merchant password ");
		String password=sc.next();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q=manager.createNamedQuery("verifyMerchantByEMail");
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			Merchant m= (Merchant) q.getSingleResult();
			System.out.println(m);
		}catch(NoResultException e) {
			System.err.println("Invalid email id or password");
		}

	}
}
