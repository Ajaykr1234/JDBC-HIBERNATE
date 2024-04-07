package org.jsp.Assingement;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2oneUni.PanCard;

public class A6_FindPanCardByNumberAndDob {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your pancard number ");

		String number = sc.next();

		System.out.println("Enter your date of birth ");

		LocalDate date = LocalDate.parse(sc.next());

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select c from PanCard c where .number=?1 and c.dob=?2");
		q.setParameter(1, number);
		q.setParameter(2, date);

		try {
			PanCard card = (PanCard) q.getSingleResult();
			System.out.println(card);
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}

	}

}
