package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.many2manyBi.Batch;

public class A5_FindBatchByStudentID {
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student id to find Batch");
		int id = sc.nextInt();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select s.batchs from Student s where s.id = ?1");
		q.setParameter(1, id);

		try {

		  List<Batch> bat = q.getResultList();
		  for(Batch b:bat) {
			  System.out.println(b);
		  }

		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}

	}

}
