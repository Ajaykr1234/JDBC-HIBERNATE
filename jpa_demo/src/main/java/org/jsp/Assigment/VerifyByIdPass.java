package org.jsp.Assigment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jspdemo.Merchant;

public class VerifyByIdPass {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your id :");
		int id = sc.nextInt();
		System.out.println("Enter your password :");
		String pass = sc.next();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
	
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery("select m from Merchant m where m.id=?1 and m.password=?2");
		
		q.setParameter(1, id);
		q.setParameter(2, pass);
		
		try {
			Merchant m = (Merchant)q.getSingleResult();
			System.out.println(m);
			
		} catch (NoResultException e) {
			    System.out.println(e.getMessage());
		}
		
		sc.close();
	}

}
