package org.jsp.one2oneBi;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveUserAndAadharCard {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		User user = new User();
		System.out.println("Enter Aadhar card holder name :");
		user.setName(sc.next());
		System.out.println("Enter Adhar holder phone numbr : ");
		user.setPhone(sc.nextLong());

		AadharCard card = new AadharCard();

		card.setNumber((int) (Math.random() * 1000000000) + 1000000000);

		System.out.println("Enter Card Holder DOB  formate YYYY-MM-MM ");
		card.setDob(LocalDate.parse(sc.next()));

		System.out.println("Enter holder City details");
		card.setCirty(sc.next());

		user.setCard(card);
		card.setUser(user);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		manager.persist(user);

		transaction.begin();
		transaction.commit();
		sc.close();

	}

}
