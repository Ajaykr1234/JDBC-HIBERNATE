package org.jspider.hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveEmployee {
	public static void main(String[] args) {
		Employee e= new Employee();
		e.setDesg("CEO");
		e.setName("Niraj Kumar Kushwaha");
		e.setSalary(2500000);
		e.setPhone(99730432110L);
		e.setPassword("niraj@123");
		Configuration cgf= new Configuration().configure();
		SessionFactory factory =cgf.buildSessionFactory();
		Session s= factory.openSession();
		int id=(Integer)s.save(e);
		Transaction t=s.beginTransaction();
		t.commit();
		System.out.println("Employee record has been saved with Id : " + id);
		
	}

}
