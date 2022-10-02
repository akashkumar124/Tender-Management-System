package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Vender;
import com.masai.dao.VendorDao;
import com.masai.dao.VendorDaoImpl;
import com.masai.exceptions.VendorException;

public class GetVendorById {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		VendorDao vd = new VendorDaoImpl();
		
		System.out.println("Enter Vendor id:");
		int vid= sc.nextInt();
		

		
		try {
		Vender ved= vd.getVendorById(vid);
		
			System.out.println(ved);
		
		}catch (VendorException ve) {
			System.out.println(ve.getMessage());
		}

	}

}
