package org.jspider.hibernateDemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateEmployeeUsingUpdate {
	public static void main(String[] args) {
		Configuration cgf= new Configuration().configure();
		SessionFactory factory =cgf.buildSessionFactory();
		Session s= factory.openSession();
		Employee e=new Employee();
			e.setId(1);
			e.setName("Kumar Niraj kushwaha");
			e.setDesg("Founder & CEO");
			e.setPhone(90756483L);
			e.setSalary(89876293l);
			e.setPassword("mdsoijbhdc");
			s.update(e);
			Transaction tc= s.beginTransaction();
			tc.commit();
		}
	}


