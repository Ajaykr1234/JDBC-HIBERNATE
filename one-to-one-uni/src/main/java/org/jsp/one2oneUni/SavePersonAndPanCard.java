package org.jsp.one2oneUni;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePersonAndPanCard {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transtion = manager.getTransaction();
		
		
		Person p = new Person();
		
		System.out.println("Enter PanCard holder name ");
		p.setName(sc.next());
		
		System.out.println("Enter Pancard holder phone number");
		p.setPhone(sc.nextLong());
		
		
		PanCard card = new PanCard();
		
		card.setNumber("Pan" + (int) (Math.random() * 100) + 100);
		
		System.out.println("Enter PanCard holder DOB formate YYYY-MM-DD");
		card.setDob(LocalDate.parse(sc.next()));
		
		System.out.println("Enter Pancard HOlder Pincode");
		card.setPinCode(sc.nextInt());
		
		p.setPancard(card); //Assinging the panCard to person
		
		manager.persist(p);
		manager.persist(card);
		
		transtion.begin();
		transtion.commit();
		
		
	}

}
