package com.masai.dao;




import java.util.List;
import java.util.Set;

import com.masai.bean.Tender;
import com.masai.bean.Vender;

import com.masai.exceptions.TenderException;
import com.masai.exceptions.VendorException;

public interface TenderDao {

	
	
	
	public String registerTender(Tender tender);
	
	public Set<Tender> getAllTenderList() throws TenderException;
	
	public Tender getTenderById(int tid) throws TenderException;
	
	
}
