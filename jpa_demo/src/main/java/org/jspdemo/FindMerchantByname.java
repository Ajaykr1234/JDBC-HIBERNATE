package org.jspdemo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindMerchantByname {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name ");
		String name = sc.next();
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery("select m from Merchant m where m.name=?1");
		q.setParameter(1, name);
		
		 List<Merchant> Merchants= q.getResultList();
		 
		 if(Merchants.size()>0) {
//			 for(Merchant m:Merchants) {
				 System.out.println(Merchants);
//			 }
		 }else {
			 System.out.println("merchant not found");
		 }
		
		
	}

}
