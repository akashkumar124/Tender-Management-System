package com.masai.usecases;

import java.util.Set;

import com.masai.bean.Tender;
import com.masai.bean.Vender;
import com.masai.dao.TenderDao;
import com.masai.dao.TenderDaoImpl;
import com.masai.exceptions.TenderException;
import com.masai.exceptions.VendorException;

public class GetAllTenderDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TenderDao td = new TenderDaoImpl();
		
            try {
			
			Set<Tender> tenders= td.getAllTenderList();
			
			tenders.forEach(s ->{
				
				System.out.println("Tendor Id :"+s.gettId());
				System.out.println("Tendor Name :"+s.gettName());
				System.out.println("Tendor Starting Price:"+s.getStartingPrice());
				
				
				System.out.println("=======================");
			});
			
			
			
			
			}catch(TenderException te) {
				System.out.println(te.getMessage());
			}

			
			

	}

}
