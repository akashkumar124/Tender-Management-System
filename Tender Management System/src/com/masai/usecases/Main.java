package com.masai.usecases;

import java.util.Scanner;


import com.masai.bean.Tender;
import com.masai.bean.Vender;

import com.masai.dao.TenderDao;
import com.masai.dao.TenderDaoImpl;
import com.masai.exceptions.TenderException;
import com.masai.exceptions.VendorException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc = new Scanner(System.in);
		TenderDao td = new TenderDaoImpl();
		
		
		// for vendor
		
//		System.out.println("Enter Vendor Name");
//		String vName= sc.next();
//		
//		System.out.println("Enter Vendor Email");
//		String vEmail= sc.next();
//		
//		System.out.println("Assign a Password To Vendor");
//		String vPassword= sc.next();
//		
////		TenderDao td = new TenderDaoImpl();
//		
//		
//		Vender vendor = new Vender();
//		
//		vendor.setvName(vName);
//		vendor.setvEmail(vEmail);
//		vendor.setvPassword(vPassword);
//		
//		String result =td.registerVendor(vendor);
//		
//		System.out.println(result);
		
		
//		//for tender inserstion
		
//		System.out.println("Enter Tendor Name");
//		String tName= sc.next();
//		
//		System.out.println("Tendor Starting Price");
//		int tSPrice= sc.nextInt();
//		
//		Tender tender = new Tender();
//		
//		tender.settName(tName);
//		tender.setStartingPrice(tSPrice);
//		
//		
//		String result= td.registerTender(tender);
//		System.out.println(result);
		
		
		
//		// for getting vendor data with id
//		
//		System.out.println("Enter Vendor id:");
//		int vid= sc.nextInt();
//		
//
//		
//		try {
//		Vender ved= td.getVendorById(vid);
//		
//			System.out.println(ved);
//		
//		}catch (VendorException ve) {
//			System.out.println(ve.getMessage());
//		}
		
		
		
//		// for getting Tendor data with id
//		
//		System.out.println("Enter Vendor id:");
//		int tid= sc.nextInt();
//		
//
//		
//		try {
//		Tender ted= td.getTenderById(tid);
//		
//			System.out.println(ted);
//		
//		}catch (TenderException te) {
//			System.out.println(te.getMessage());
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
