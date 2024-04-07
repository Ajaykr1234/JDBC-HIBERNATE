package org.jspdemo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class VerifyMerchantBYPhoneAndPass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the your phone ");
		long phone = sc.nextLong();
		
		System.out.println("Enter your password");
		String pass = sc.next();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
	   Query q = manager.createQuery("select m from Merchant m where m.password=?1 and  m.phone=?2 ");
		q.setParameter(1, pass);
		q.setParameter(2, phone  );
		
		try {
			Merchant m = (Merchant) q.getSingleResult();
			System.out.println(m);
			System.out.println("verify merchant");
		} catch (NoResultException e) {
			// TODO: handle exception
			System.out.println("invaild pass and phone ");
		}

	}

}
