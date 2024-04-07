package org.jspider.hibernateDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindAllEmployee {
	public static void main(String[] args) {
		Configuration cgf= new Configuration().configure();
		SessionFactory factory =cgf.buildSessionFactory();
		Session s= factory.openSession();
		Query <Employee> q= s.createQuery("select e from Employee e ");
		List <Employee> emps= q.getResultList();
		if(emps.size()>0) {
			for (Employee e : emps) {
				System.out.println("Verification succefull");
				System.out.println("Employee Id: " +e.getId());
				System.out.println("Employee Name" + e.getName());
				System.out.println("Employee Designation " +e.getDesg());
				System.out.println("Employee salary " + e.getSalary());
				System.out.println("Employee Phone number " + e.getPhone());
				System.out.println("---------------------------------");
			}
		}
		
		else {
			System.err.println("can not find any employee");
		}
		
	}

}

