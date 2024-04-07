package org.jspdemo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPhoneNumber {
	public static void main(String[] args) {
		
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery("select m.phone from Merchant m");
		
		List<Long> phone = q.getResultList();
		
		for (Long ph : phone) {
			System.out.println(ph);
		}
	}
	
	

}
