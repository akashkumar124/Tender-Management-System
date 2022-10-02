package com.masai.dao;

import com.masai.bean.Admin;
import com.masai.bean.Vender;
import com.masai.exceptions.AdminException;
import com.masai.exceptions.VendorException;

public interface AdminDao {

	
	public Admin loginAdmin(String username, String password)throws AdminException;

//	public Admin loginAdmin(String uname, String pass);
}
