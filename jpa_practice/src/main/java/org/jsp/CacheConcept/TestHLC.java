package org.jsp.CacheConcept;

import javax.persistence.EntityManagerFactory;
import javax.persistence.*;

public class TestHLC {

	public static void main(String[] args) {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	Person p = new Person();
	p.setAge(25);
	p.setName("ABC");
	p.setPhone(999);
	manager.persist(p);
	transaction.begin();
	transaction.commit();
	p.setAge(35);
	p.setName("XYZ");
	transaction.begin();
	transaction.commit();
	p.setAge(45);
	p.setName("PQR");
	transaction.begin();
	transaction.commit();
	manager.detach(p);
	p.setAge(47);
	p.setName("LMN");
	transaction.begin();
	transaction.commit();
	}

}
