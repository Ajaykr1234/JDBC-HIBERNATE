package org.jsp.hibernatedemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateUserEmpbyid {
	public static void main(String[] args) {
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id to update the record");
		int id = sc.nextInt();
		User e = s.get(User.class, id);
		if(e!=null) {
			System.out.println("Enter name to update ");
			String name = sc.next();
			e.setName(name);
			System.out.println("Enter password to update ");
			String pass = sc.next();
			e.setPassword(pass);
			Transaction t = s.beginTransaction();
			t.commit();
		}else {
			System.out.println("Invalid password");
		}
	}

}
