package com.masai.dao;

import java.util.List;
import java.util.Set;

import com.masai.bean.TenderDao;
import com.masai.bean.Vender;

import com.masai.exceptions.TenderException;
import com.masai.exceptions.VendorException;



public interface VendorDao {
	
	public String registerVendor(Vender vendor);
	
	public Vender getVendorById(int vid) throws VendorException;

//	public List<Vender> getAllVendorDetails();
	
	public Set<Vender> getAllVendorDetails()throws VendorException;
	
	public Vender loginVendor(String username, String password)throws VendorException;
	
	public String applyTender(int tId, int vId, int bidd)throws VendorException,TenderException ;
	
	public Set<TenderDao> getAllApllyintTendors()throws VendorException;
	
	public String assignTender(int tId, int vId)throws VendorException,TenderException ;
	
	public Set<TenderDao> getAllMyBidHistory(int vId)throws TenderException;
	
	public Set<TenderDao> getAllMySelctedBidHistory(int vId)throws TenderException;
	
	
	
	

}
