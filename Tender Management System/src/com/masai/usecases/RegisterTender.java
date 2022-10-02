package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Tender;
import com.masai.dao.TenderDao;
import com.masai.dao.TenderDaoImpl;

public class RegisterTender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		TenderDao td= new TenderDaoImpl();
		
		System.out.println("Enter Tendor Name");
		String tName= sc.next();
		
		System.out.println("Tendor Starting Price");
		int tSPrice= sc.nextInt();
		
		Tender tender = new Tender();
		
		tender.settName(tName);
		tender.setStartingPrice(tSPrice);
		
		
		String result= td.registerTender(tender);
		System.out.println(result);

	}

}
