package org.jsp.Assigment;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchAllEmail {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery("select m.email from Merchant m");
		
		List<String> emails = q.getResultList();
		

		for (String e : emails) {
			System.out.println(e);
		}
	}

}
