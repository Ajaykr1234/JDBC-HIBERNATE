package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2manyBi.Product;

public class A13_FindProdByMerchantPhoneAndPass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Merchant phone ");
		long phone = sc.nextLong();

		System.out.println("Enter Merchant Password ");
		String password = sc.next();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select m.product from Merchant m where m.pnone=?1 and m.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);

		List<Product> pro = q.getResultList();
		for (Product p : pro) {
			System.out.println(p);
		}

	}

}
