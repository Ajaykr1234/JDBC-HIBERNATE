package org.jsp.product.controller;

import java.util.Scanner;

import org.jsp.product.dao.ProductImp;
import org.jsp.product.dto.ProductDetails;
//import org.jsp.userapp.dto.User;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductImp pi = new ProductImp();
		
		while(true) {
			System.out.println("01.insert the product");
			int op = sc.nextInt();
			switch (op) {
			case 1:
				System.out.println("How many users wants to create ?");
				int num = sc.nextInt();
				while (num > 0) {
					
					ProductDetails u = new ProductDetails(1, "nkn", "njbj", "jknk", "bnbj",123, "jbjjhj");
					pi.saveProduct();
//				String message = dao.saveUser(id, name, phone, email, password);
//					System.out.println(message);
					num--;
				}
				pi.saveProduct();
				break;

			default:
				break;
			}
		}
	}

}
