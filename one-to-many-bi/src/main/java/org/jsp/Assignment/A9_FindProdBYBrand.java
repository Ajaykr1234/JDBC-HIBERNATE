package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2manyBi.Product;

public class A9_FindProdBYBrand {
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Product Brand to find details");
		String brand = sc.next();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select p from Product p where p.brand=?1");
		q.setParameter(1, brand);

		
			
			List<Product> pro = q.getResultList();
			
			for(Product p : pro) {
				System.out.println(p);
			}

		
	}

}
