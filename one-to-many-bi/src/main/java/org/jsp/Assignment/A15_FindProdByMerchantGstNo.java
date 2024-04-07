package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2manyBi.Product;

public class A15_FindProdByMerchantGstNo {
	


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Merchant Gst_Number to find Product");
		String  gst = sc.next();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select m.product from Merchant m where m.gst_number=?1");
		q.setParameter(1, gst);
		
		

		List<Product> pro = q.getResultList();
		for (Product p : pro) {
			System.out.println(p);
		}

	}


}
