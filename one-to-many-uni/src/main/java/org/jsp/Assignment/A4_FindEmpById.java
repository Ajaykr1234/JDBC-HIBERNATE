package org.jsp.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2manyUni.Employee;

public class A4_FindEmpById {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee id ");
		int id = sc.nextInt();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		String jpql = "select e from Employee e where e.id=?1";

		Query q = manager.createQuery(jpql);

		q.setParameter(1, id);

		try {
			Employee emp = (Employee) q.getSingleResult();
			System.out.println(emp);
		} catch (NoResultException e) {
			System.err.println("such department id is not Exites");
		}

	}

}
