package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.many2manyBi.Batch;

public class A4_FindBatchByTrainerName {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Trainer  name  to find Batch");
		String trainerName = sc.nextLine();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select b from Batch b where b.trainner= ?1");
		q.setParameter(1, trainerName);

		try {

			List<Batch> b = q.getResultList();

			for (Batch bt : b) {
				System.out.println(bt);
			}

		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}

	}

}
