package org.jsp.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2manyBi.Merchant;

public class A4_VerifyMerchantByPhoneAndPass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Merchant phone ");
		long phone = sc.nextLong();

		System.out.println("Enter Merchant Password ");
		String password = sc.next();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select m from Merchant m where m.pnone=?1 and m.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);

		try {

			Merchant m = (Merchant) q.getSingleResult();
			System.out.println(m);

		} catch (NoResultException e) {
			System.out.println("No Merchant Found BY Phone and Password: " + phone);
		}
	}

}
