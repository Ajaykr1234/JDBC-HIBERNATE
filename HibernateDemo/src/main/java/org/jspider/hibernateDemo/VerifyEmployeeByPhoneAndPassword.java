package org.jspider.hibernateDemo;
import java.util.*;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
public class VerifyEmployeeByPhoneAndPassword {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the Phone Number and Password to verify");
		long phone=sc.nextLong();
		String password=sc.next();
		Configuration cgf= new Configuration().configure();
		SessionFactory factory =cgf.buildSessionFactory();
		Session s= factory.openSession();
		Query <Employee> q=s.createQuery("select e from Employee e where e.phone=?1 and e.password=:ps");
		q.setParameter(1,phone);
		q.setParameter("ps", password);
		try {
			Employee e=q.getSingleResult();
			System.out.println("Verification succefull");
			System.out.println("Employee Id : " +e.getId());
			System.out.println("Employee Name : " + e.getName());
			System.out.println("Employee Designation : " +e.getDesg());
			System.out.println("Employee salary : " + e.getSalary());
			System.out.println("Employee Phone number : " + e.getPhone());
		}
		catch (NoResultException e) {
			System.err.println("Invalid phone number and password");
		}
	}

}
