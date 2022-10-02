package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.bean.Admin;
import com.masai.bean.Vender;
import com.masai.exceptions.AdminException;
import com.masai.exceptions.VendorException;
import com.masai.utility.DButil;

public class AdminDaoImpl implements AdminDao{

	@Override
	public Admin loginAdmin(String username, String password) throws AdminException {
		// TODO Auto-generated method stub
		Admin admin = null;
		
		try(Connection conn = DButil.provideConnection()) {
			
			
			PreparedStatement ps= conn.prepareStatement("select * from admin where email = ? AND password = ?");			
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
			int v=rs.getInt("aId");
			String n=rs.getString("name");
			String e=rs.getString("email");
			String p=rs.getString("password");
			
			admin = new Admin(v,n,e,p);
				
				
			}else
				throw new AdminException("Invalid Username or password.. ");
			
			
			
			
		} catch (SQLException e) {
			throw new AdminException(e.getMessage());
		}
		return admin;
	}

//	@Override
//	public Admin loginAdmin(String username, String password) throws AdminException {
//		// TODO Auto-generated method stub
//        Admin admin = null;
//		
//		try(Connection conn = DButil.provideConnection()) {
//			
//			
//			PreparedStatement ps= conn.prepareStatement("select * from admin where email = ? AND password = ?");			
//			
//			ps.setString(1, username);
//			ps.setString(2, password);
//			
//			ResultSet rs= ps.executeQuery();
//			
//			if(rs.next()) {
//			int v=rs.getInt("aId");
//			String n=rs.getString("name");
//			String e=rs.getString("email");
//			String p=rs.getString("password");
//			
//			admin = new Admin(v,n,e,p);
//				
//				
//			}else
//				throw new AdminException("Invalid Username or password.. ");
//			
//			
//			
//			
//		} catch (SQLException e) {
//			throw new AdminException(e.getMessage());
//		}
//		return admin;
//	}

}
