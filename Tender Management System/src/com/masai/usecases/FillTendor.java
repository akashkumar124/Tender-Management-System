package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Vender;

import com.masai.dao.VendorDao;
import com.masai.dao.VendorDaoImpl;

public class FillTendor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the Tendor ID");
		int tId= sc.nextInt();

		System.out.println("Enter the Vendor ID");
		int vId= sc.nextInt();
		
		System.out.println("Enter Your Bid");
		int bidd = sc.nextInt();
		
		//5:25
		
		
//		StudentDao dao = new StudentDaoImpl();
		
		VendorDao vd = new VendorDaoImpl();
		
		try {
		String result = vd.applyTender(tId, vId, bidd);
		
		System.out.println(result);
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}

	}

}
