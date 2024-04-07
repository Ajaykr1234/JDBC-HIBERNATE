package org.jsp.Assingement;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class A2_FindPersonByName {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your name ");
		String name = sc.next();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery("select p from Person p where p.name=?1");
		q.setParameter(1, name);
		
		List<String> nameall = q.getResultList();
		
		for(String n : nameall) {
			System.out.println();
		}
	}

}
