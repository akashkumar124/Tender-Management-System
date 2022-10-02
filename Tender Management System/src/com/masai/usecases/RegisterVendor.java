package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Vender;
import com.masai.dao.VendorDao;
import com.masai.dao.VendorDaoImpl;

public class RegisterVendor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		VendorDao vd = new VendorDaoImpl();
		
		System.out.println("Enter Vendor Name");
		String vName= sc.next();
		
		System.out.println("Enter Vendor Email");
		String vEmail= sc.next();
		
		System.out.println("Assign a Password To Vendor");
		String vPassword= sc.next();
		

		
		
		Vender vendor = new Vender();
		
		vendor.setvName(vName);
		vendor.setvEmail(vEmail);
		vendor.setvPassword(vPassword);
		
		String result =vd.registerVendor(vendor);
		
		System.out.println(result);

	}

}
