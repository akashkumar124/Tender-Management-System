package com.masai.usecases;

import java.util.Scanner;

import com.masai.bean.Tender;
import com.masai.dao.TenderDao;
import com.masai.dao.TenderDaoImpl;
import com.masai.exceptions.TenderException;

public class GetTenderByID {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		TenderDao td = new TenderDaoImpl();
		
		System.out.println("Enter Vendor id:");
		int tid= sc.nextInt();
		

		
		try {
		Tender ted= td.getTenderById(tid);
		
			System.out.println(ted);
		
		}catch (TenderException te) {
			System.out.println(te.getMessage());
		}

	}

}
