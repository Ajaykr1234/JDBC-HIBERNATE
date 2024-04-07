package org.jsp.one2manyUni;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveDeptAndEmp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Department d = new Department();
		System.out.println("Enter department name ");
		d.setName(sc.next());
		System.out.println("Enter Company Location ");
		d.setLocation(sc.next());

		System.out.println("How many Employee You want to add");
		int number = sc.nextInt();

		List<Employee> emps = new ArrayList<Employee>();
		for (int i = 1; i <= number; i++) {
			Employee e = new Employee();
			System.out.println("Enter " + i + "st Employee  name");
			e.setName(sc.next());
			System.out.println("Enter Employee Desigation ");
			e.setDegs(sc.next());
			System.out.println("Enter Employee Salary ");
			e.setSalary(sc.nextDouble());
			emps.add(e);
			System.out.println("Employee " + i + " Added Successfully");
		}

		d.setEmps(emps);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(d);
		transaction.begin();
		transaction.commit();
		sc.close();
	}

}
