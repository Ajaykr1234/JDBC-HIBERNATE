package org.jsp.userapp.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.jsp.userapp.dao.UserDao;
import org.jsp.userapp.dto.User;

public class UserController {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		UserDao dao = new UserDao();
 		boolean flag = true;
		while (flag) {
			System.out.println("1.Save User");
			System.out.println("2.Update User");
			System.out.println("3.Verify User by email and password");
			System.out.println("4.Verify User by phone and password");
			System.out.println("5.Find user By Id");
			System.out.println("6.delete User By Id");
			System.out.println("7.Find all users ");
			System.out.println("8.Exit");
			switch (sc.nextInt()) {
			case 1: {
				System.out.println("How many users wants to create ?");
				int num = sc.nextInt();
				while (num > 0) {
					System.out.println("Enter the user id");
					int id = sc.nextInt();
					System.out.println("Enter the user Name");
					String name = sc.next();
					System.out.println("Enter the user PhoneNumber");
					long phone = sc.nextLong();
					System.out.println("Enter the user Email id");
					String email = sc.next();
					System.out.println("Enter the user Password");
					String password = sc.next();
					User u = new User(id, name, email, phone, password);
					String message = dao.saveUser(u);
//				String message = dao.saveUser(id, name, phone, email, password);
					System.out.println(message);
					num--;
				}
				break;
			}
			case 2: {
				System.out.println("Enter the use id,name,phone,email and password to update user");
				int id = sc.nextInt();
				String name = sc.next();
				long phone = sc.nextLong();
				String email = sc.next();
				String password = sc.next();
				User u = new User(id, name, email, phone, password);
				String message = dao.updateUser(u);
				System.out.println(message);
				break;
			}

			case 3: {
				System.out.println("Enter the phone Number and password to verify user");
				long phone = sc.nextLong();
				String password = sc.next();
				User u = dao.verifyUser(phone, password);
				if (u != null) {
					System.out.println("User Verified Succesfully");
					System.out.println("User Id:" + u.getId());
					System.out.println("User Name:" + u.getName());
					System.out.println("Email Id:" + u.getEmail());
					System.out.println("Phone Number:" + u.getPhone());
				} else {
					System.err.println("Invalid Phone Number or Password");
				}
				break;
			}
			case 4: {
				System.out.println("Enter the Email Id and password to verify user");
				String email = sc.next();
				String password = sc.next();
				User u = dao.verifyUser(email, password);
				if (u != null) {
					System.out.println("User Verified Succesfully");
					System.out.println("User Id:" + u.getId());
					System.out.println("User Name:" + u.getName());
					System.out.println("Email Id:" + u.getEmail());
					System.out.println("Phone Number:" + u.getPhone());
				} else {
					System.err.println("Invalid Email Id or Password");
				}
				break;
			}
			case 5: {
				System.out.println("Enter the User id to find the user");
				int id = sc.nextInt();
				User u = dao.findUserById(id);
				if (u != null) {
					System.out.println("User Found");
					System.out.println("User Id:" + u.getId());
					System.out.println("User Name:" + u.getName());
					System.out.println("Email Id:" + u.getEmail());
					System.out.println("Phone Number:" + u.getPhone());
				} else {
					System.err.println("Invalid Id");
				}
				break;
			}
			case 6: {
				System.out.println("Enter the User id to delete the record");
				int id = sc.nextInt();
				boolean deleted = dao.deleteUser(id);
				if (deleted) {
					System.out.println("User deleted");
				} else {
					System.err.println("cannot delete user");
				}
				break;
			}
			case 7: {
				List<User> users = dao.findAll();
				if (users.size() > 0) {
					for (User u : users) {
						System.out.println("User Found");
						System.out.println("User Id:" + u.getId());
						System.out.println("User Name:" + u.getName());
						System.out.println("Email Id:" + u.getEmail());
						System.out.println("Phone Number:" + u.getPhone());
						System.out.println("==================================");
					}
				}
				 else {
					System.out.println("user not present in database ");
				}
			}
				break;

			case 8: {
				flag = false;
				try {
					System.out.println(dao.exit());
					sc.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			}
		}

	}
}
