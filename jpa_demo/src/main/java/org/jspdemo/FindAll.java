package org.jspdemo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAll {
	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q=manager.createNativeQuery("select * from merchant", Merchant.class);
		List<Merchant> merchants=q.getResultList();
		for(Merchant m:merchants) {
			System.out.println(m);
			System.out.println("-----------------");
		}
	}
}
