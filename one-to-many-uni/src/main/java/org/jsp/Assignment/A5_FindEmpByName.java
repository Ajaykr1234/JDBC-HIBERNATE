package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.one2manyUni.Employee;

public class A5_FindEmpByName {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee name ");
		String name = sc.next();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		String jpql = "select e from Employee e where e.name=?1";

		Query q = manager.createQuery(jpql);

		q.setParameter(1, name);

		List<Employee> emp=q.getResultList();
		
		if(emp.size()>0) {
			for(Employee e : emp) {
				System.out.println(e);
			}
		}else {
			System.err.println("no employee found by this name");
		}
	}


}
