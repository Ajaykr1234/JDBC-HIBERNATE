package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2manyUni.Employee;

public class A91_FindEmpByDeptIdAndLoc {

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter department id ");
		int id = sc.nextInt();
		System.out.println("Enter depatment location ");
		String loc = sc.next();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		String jpql = "select d.emps from Department d where d.id=?1 and d.location=?2";

		Query q = manager.createQuery(jpql);

		q.setParameter(1, id);
		q.setParameter(2, loc);

		List<Employee> emp = q.getResultList();

		if (emp.size() > 0) {

			for (Employee e : emp) {
				System.out.println(e);
			}
		} else {
			System.err.println("Sorry Data Not Found Try Again! ");
		}
	}
}
