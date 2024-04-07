package org.jsp.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.many2manyBi.Batch;

public class A2_FindBatchBybatch_code {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Batch code to find Batch");
		String batchcode = sc.next();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select b from Batch b where b.batch_code = ?1");
		q.setParameter(1, batchcode);

		try {

			Batch b = (Batch) q.getSingleResult();
			System.out.println(b);

		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}

	}

}
