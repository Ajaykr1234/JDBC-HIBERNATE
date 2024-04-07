package org.jsp.Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.jpa_practice.FoodOrder;

public class A1_FindFoodByID {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter food id to find food item");
		int id = sc.nextInt();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");

		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select f from FoodOrder f where f.id=?1");

		q.setParameter(1, id);

		try {

			FoodOrder item = (FoodOrder) q.getSingleResult();
			System.out.println(item);

		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}

	}

}
