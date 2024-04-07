package org.jsp.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveUser {
	public static void main(String[] args) {
		User u = new User();
		u.setName("Ajay");
		u.setPhone(54658788L);
		u.setEmail("ajay@123");
		u.setPassword("ajay123");
		
		Configuration cfg = new Configuration().configure();
		SessionFactory  factory= cfg.buildSessionFactory();
		Session s = factory.openSession();
		Transaction t = s.beginTransaction();
		int id =(Integer)s.save(u);
		t.commit();
		System.out.println(id);
	}

}
