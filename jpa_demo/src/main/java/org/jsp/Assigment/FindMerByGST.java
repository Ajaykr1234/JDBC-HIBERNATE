package org.jsp.Assigment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jspdemo.Merchant;

public class FindMerByGST {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Gst number ");
		String gstname = sc.next();
		
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery("select m from Merchant m where m.gst_number=?1");
		
		q.setParameter(1, gstname);
		
		try {
			Merchant m = (Merchant) q.getSingleResult();
			System.out.println(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
