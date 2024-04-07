package org.jspdemo;

import java.util.List;

import javax.persistence.*;
public class FindNames {
	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query q=manager.createNamedQuery("findNames");
		List<String> names=q.getResultList();
		for(String name: names) {
			System.out.println(name);
		}
	}
}
