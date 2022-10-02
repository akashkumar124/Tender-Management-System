package com.masai.usecases;

import java.util.Scanner;
import java.util.Set;

import com.masai.bean.TenderDao;
import com.masai.dao.VendorDao;
import com.masai.dao.VendorDaoImpl;

public class VendorBidSelectedHis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
       Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the VendorID Name");
		
		int vId= sc.nextInt();

		
		VendorDao dao = new VendorDaoImpl();
		
		try {
		Set<TenderDao> dtos= dao.getAllMyBidHistory(vId);
		
		dtos.forEach(dto -> System.out.println(dto));
		
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
