package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2manyBi.Merchant;
import org.jsp.one2manyBi.Product;

public class A14_FindProdByMerchantIDAndPass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Merchant id ");
		int id = sc.nextInt();

		System.out.println("Enter Merchant Password ");
		String password = sc.next();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select m.product from Merchant m where m.id=?1 and m.password=?2");
		q.setParameter(1, id);
		q.setParameter(2, password);

		List<Product> pro = q.getResultList();
		for (Product p : pro) {
			System.out.println(p);
		}

	}

}
