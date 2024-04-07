package org.jsp.many2one_uni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveQuestionAndAnswer {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		QuestionData data = new QuestionData();
		System.out.println("Enter Author name : ");
		data.setPostedBy(sc.next());
		System.out.println("Enter Question ");
		sc.next();
		data.setQuestion(sc.nextLine());
		

		System.out.println("How Many Answer you want to be added");
		int num = sc.nextInt();
		
		AnswerData adata = new AnswerData();
		for (int i = 1; i <= num; i++) {

			System.out.println("Enter your name ");
			adata.setAnswerBy(sc.next());
			System.out.println("Enter your Answer");
			sc.next();
			adata.setAnswer(sc.nextLine());
			adata.setQuestion(data);
		}

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(adata);
		transaction.begin();
		transaction.commit();
		sc.close();
	}

}
