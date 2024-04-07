package org.jsp.CacheConcept;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class DeletePersonBYID {
	
	
	public static void main(String[] args) {
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		
		EntityManager manager =  factory.createEntityManager();
		
		EntityTransaction transaction =  manager.getTransaction();
		
		Person p = manager.find(Person.class, 1);
		if (p != null) {
			manager.remove(p);
			transaction.begin();
			transaction.commit();
		}

	}

	

}