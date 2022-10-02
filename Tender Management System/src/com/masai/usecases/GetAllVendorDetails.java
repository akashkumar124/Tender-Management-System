package com.masai.usecases;

import java.util.List;
import java.util.Set;

import com.masai.bean.Vender;
import com.masai.dao.VendorDao;
import com.masai.dao.VendorDaoImpl;
import com.masai.exceptions.VendorException;


public class GetAllVendorDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VendorDao vd = new VendorDaoImpl();
		
		try {
			
			Set<Vender> vendors= vd.getAllVendorDetails();
			
			vendors.forEach(s ->{
				
				System.out.println("Vendor Id :"+s.getvId());
				System.out.println("Vendor Name :"+s.getvName());
				System.out.println("Vendor Email:"+s.getvEmail());
				System.out.println("Vendor Password :"+s.getvPassword());
				
				System.out.println("=======================");
			});
			
			
			
			
			}catch(VendorException ve) {
				System.out.println(ve.getMessage());
			}

	}

}
