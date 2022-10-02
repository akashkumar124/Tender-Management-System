package com.masai.usecases;

import java.util.Scanner;


import com.masai.bean.Vender;

import com.masai.dao.VendorDao;
import com.masai.dao.VendorDaoImpl;

import com.masai.exceptions.VendorException;

public class VendorLogin {

	public static boolean main(String[] args) {
		// TODO Auto-generated method stub
       Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Username:");
		String uname = sc.next();
		
		System.out.println("Enter Password:");
		String pass = sc.next();
		
		VendorDao dao = new VendorDaoImpl();
		
		try {
			Vender vender= dao.loginVendor(uname, pass);
		
	 		System.out.println("Welcome Vender :"+vender.getvName());
	 		
	 		return true;
	 	
	 	
		}catch (VendorException e) {
			System.out.println(e.getMessage());
		}
		return false;

	}

}
