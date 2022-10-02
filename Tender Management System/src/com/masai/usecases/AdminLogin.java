package com.masai.usecases;

import java.util.Scanner;
import com.masai.bean.Admin;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exceptions.AdminException;



public class AdminLogin {

	public static boolean main(String[] args) {
		// TODO Auto-generated method stub
		
       Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Username:");
		String uname = sc.next();
		
		System.out.println("Enter Password:");
		String pass = sc.next();
		
		AdminDao ad = new AdminDaoImpl();
		
		try {
//			Vender vender= dao.loginVendor(uname, pass);
			Admin admin = ad.loginAdmin(uname, pass);
		
	 		System.out.println("Welcome To the Admin Portal :"+admin.getName());
	 		
	 		return true;
	 	
	 	
		}catch (AdminException e) {
			System.out.println(e.getMessage());
		}
		return false;

	}

}
