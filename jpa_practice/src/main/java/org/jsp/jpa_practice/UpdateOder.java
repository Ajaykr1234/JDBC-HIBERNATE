package org.jsp.jpa_practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateOder {
	
	public static void main(String[] args) {
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");

		EntityManager manager = factory.createEntityManager();

		EntityTransaction transaction = manager.getTransaction();

		
		FoodOrder update =manager.find(FoodOrder.class, 1);
		
		update.setFood_item("PannerItemes");
		update.setCost(200.25);
		
		manager.persist(update);
		
		transaction.begin();
		transaction.commit();
		
	
	}

}
