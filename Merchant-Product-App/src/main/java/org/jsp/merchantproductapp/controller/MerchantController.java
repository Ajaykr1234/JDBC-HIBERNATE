package org.jsp.merchantproductapp.controller;

import java.util.Scanner;

import org.jsp.merchantproductapp.dao.MerchantDao;
import org.jsp.merchantproductapp.dto.Merchant;

public class MerchantController {

	public static void main(String[] args) {

		MerchantDao merchantdao = new MerchantDao();
		
		Scanner sc = new Scanner(System.in);

		System.out.println(
				"01.Save Merchant \n02.Update Merchant \n03.Find Merchant By Id \n04.Verify Merchant By phone and password\n05.Verify Merchant By Email and password");
		System.out.println("Enter your choice ");
		switch (sc.nextInt()) {
		case 1:{

			Merchant merchant = new Merchant();
			System.out.println("Enter Merchant name : ");
			merchant.setName(sc.next());
			System.out.println("Enter Merchant phone : ");
			merchant.setPhone(sc.nextLong());
			System.out.println("Enter Merchant Email : ");
			merchant.setEmail(sc.next());
			System.out.println("Enter Merchant Gst_number : ");
			merchant.setGst_number(sc.next());
			System.out.println("Enter Merchant Password : ");
			merchant.setPassword(sc.next());

			merchant = merchantdao.saveMerchant(merchant);

			System.out.println("Merchant save with id " + merchant.getId());
			break;
		}
		case 2:{
			Merchant merchant = new Merchant();
			System.out.println("Enter Merchant id to update");
			merchant.setId(sc.nextInt());
			System.out.println("Enter Merchant name : ");
			merchant.setName(sc.next());
			System.out.println("Enter Merchant phone : ");
			merchant.setPhone(sc.nextLong());
			System.out.println("Enter Merchant Email : ");
			merchant.setEmail(sc.next());
			System.out.println("Enter Merchant Gst_number : ");
			merchant.setGst_number(sc.next());
			System.out.println("Enter Merchant Password : ");
			merchant.setPassword(sc.next());

			merchant = merchantdao.updateMerchant(merchant);

			if (merchant != null) {
				System.out.println("Merchant update  with id " + merchant.getId());
			} else {
				System.out.println("Invaild id ");
			}

			break;
		}
		case 3:{
			System.out.print("Enter mercahant id to find:- ");
			int merchant_id = sc.nextInt();
			Merchant merchant = merchantdao.findMerchantById(merchant_id);

			if (merchant != null) {
				System.out.println(merchant);
			} else {
				System.err.println("Invaild Id Try Again");
			}
			break;
		}
		case 4:
		{
			System.out.print("Enter the phone of the merchant:- ");
			long phone = sc.nextLong();
			System.out.print("Enter the passowrd of the merchant:- ");
			String password = sc.next();
			Merchant merchant = merchantdao.verifyMerchant(phone, password);
			if (merchant != null) {
				System.out.println(merchant);
			} else {
				System.err.println("Invalid Phone Number or Password");
			}
			break;
			
		}	
		case 5:
		{
			System.out.print("Enter the Email of the merchant:- ");
			String email = sc.next();
			System.out.print("Enter the passowrd of the merchant:- ");
			String password = sc.next();
			Merchant merchant = merchantdao.verifyMerchant(email, password);
			if (merchant != null) {
				System.out.println(merchant);
			} else {
				System.err.println("Invalid Email Id or Password");
			}
			break;
		}
		default:

			System.out.println("Invaild choice Please Try Again");
			break;
		}
		sc.close();
	}

}
