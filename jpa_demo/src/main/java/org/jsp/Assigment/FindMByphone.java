package org.jsp.Assigment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jspdemo.Merchant;

public class FindMByphone {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your phone number ");
		
		long phone = sc.nextLong();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery("select m from Merchant m where m.phone=?1");
		
		q.setParameter(1, phone);
		
		try {
			Merchant m = (Merchant) q.getSingleResult();
			System.out.println(m);
		} catch (NoResultException e) {
			System.err.println("Phone is not exixting in data base try again"+e.getMessage());
//			e.getMessage();
		}
	}

}
