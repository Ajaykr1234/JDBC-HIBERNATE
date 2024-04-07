package org.jsp.EmbeddableConcept;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveUser {
	public static void main(String[] args) {

		UserPrimaryKey pkey = new UserPrimaryKey();
		pkey.setEmail("abc@gmail.com");
		pkey.setPhone(888);

		User user = new User();
		user.setName("abc");
		user.setPassword("abc123");
		user.setPrimarykey(pkey);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		manager.persist(user);
		transaction.begin();
		transaction.commit();
	}

}
