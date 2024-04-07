package org.jsp.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2manyUni.Department;

public class A3_FindDeptByLoc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Department Location ");
		String deptloc = sc.next();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		String jpql = "select d from Department d where d.location=?1";

		Query q = manager.createQuery(jpql);

		q.setParameter(1, deptloc);

		try {
			Department dept = (Department) q.getSingleResult();
			System.out.println(dept);
		} catch (NoResultException e) {
			System.err.println("such department Location is not Exites");
		}

	}

}
