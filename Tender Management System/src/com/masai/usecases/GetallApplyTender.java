package com.masai.usecases;

import java.util.Set;

import com.masai.bean.TenderDao;
import com.masai.bean.Vender;
import com.masai.dao.VendorDao;
import com.masai.dao.VendorDaoImpl;
import com.masai.exceptions.VendorException;

public class GetallApplyTender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
       VendorDao vd = new VendorDaoImpl();
		
		try {
			
			Set<TenderDao> tdDao= vd.getAllApllyintTendors();
			
			tdDao.forEach(s ->{
				
				System.out.println("Vendor Id :"+s.getVid());
				System.out.println("Vendor Name :"+s.getVname());
				System.out.println("Tender Id :"+s.getTid());
//				System.out.println("Tendor Name :"+s.getTname());
				System.out.println("Tender Starting Price:"+s.getStartingprice());
				
				System.out.println("Vendor Bidding Price :"+s.getBiddingPrice());
				
				
				System.out.println("=======================");
			});
			
			
			
			
			}catch(VendorException ve) {
				System.out.println(ve.getMessage());
			}

	}

}
