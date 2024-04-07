package org.jsp.Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2manyUni.Employee;

public class A8_FindEmpByDeptID {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter department id to find all Employee");
		int id = sc.nextInt();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		String jpql = "select d.emps from Department d where d.id=?1";

		Query q = manager.createQuery(jpql);

		q.setParameter(1, id);

		List<Employee> emp = q.getResultList();

		if (emp.size() > 0) {

			for (Employee e : emp) {
				System.out.println(e);
			}
		} else {
			System.out.println("there is no employee in department " + id);
		}
	}

}
