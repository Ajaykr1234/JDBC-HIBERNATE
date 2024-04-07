package org.jsp.CacheConcept;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchPerson {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");

		EntityManager manager1 = factory.createEntityManager();
		EntityManager manager2 = factory.createEntityManager();

		System.out.println(manager1.find(Person.class, 3));
		System.out.println(manager2.find(Person.class, 5));
		System.out.println(manager1.find(Person.class, 3));
		System.out.println(manager2.find(Person.class, 3));
		System.out.println(manager1.find(Person.class, 3));
	}

}
