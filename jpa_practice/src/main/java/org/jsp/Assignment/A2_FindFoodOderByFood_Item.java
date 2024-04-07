package org.jsp.Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.jpa_practice.FoodOrder;

public class A2_FindFoodOderByFood_Item {
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter food_item to find food order");
		String  foodItems = sc.nextLine();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");

		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select f from FoodOrder f where f.Food_item=?1");

		q.setParameter(1, foodItems);

		try {
			List<FoodOrder> item = q.getResultList();
			
			for(FoodOrder food : item) {
				System.out.println(food);
			}

		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}


	}
}
