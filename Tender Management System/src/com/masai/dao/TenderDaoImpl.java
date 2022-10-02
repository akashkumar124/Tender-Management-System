package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.masai.bean.Tender;
import com.masai.bean.Vender;
import com.masai.exceptions.TenderException;
import com.masai.exceptions.VendorException;
import com.masai.utility.DButil;

public class TenderDaoImpl implements TenderDao {

	
	//for vendor insertion


	@Override
	public String registerTender(Tender tender) {
		// TODO Auto-generated method stub
        String msg = "Not Inserted";
		
		try(Connection conn= DButil.provideConnection()) {
			
			 PreparedStatement ps =  conn.prepareStatement
			   ("insert into tender(name,startingPrice) values(?,?)");
			 
			 ps.setString(1, tender.gettName());
			 ps.setInt(2, tender.getStartingPrice());
			 
			 
			 
			 int x=ps.executeUpdate();
			 
			 if(x>0)
				 msg="Tender Inserted Succesfully !";
			
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			
			msg =e.getMessage();
		}
		
		
		return msg;
	}


	

	@Override
	public Tender getTenderById(int tid) throws TenderException {
		// TODO Auto-generated method stub
     Tender tendor =null;
		
		try(Connection conn= DButil.provideConnection()) {
			
			 PreparedStatement ps =  conn.prepareStatement
			   ("select * from tender where tId=?");
			 
			 ps.setInt(1, tid);
			 
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				
				int v=rs.getInt("tId");
				String n=rs.getString("name");
				int e=rs.getInt("startingPrice");
				
				
				tendor = new Tender(v,n,e);
			}else
				throw new TenderException("Vendor does not exist with vID"+tid);
			 
			 
			
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			new TenderException(e.getMessage());
		}
		
		
		
		return tendor;
	}




	@Override
	public Set<Tender> getAllTenderList() throws TenderException {
		// TODO Auto-generated method stub
		
		Set<Tender> tenders = new LinkedHashSet<>();
		
		try (Connection conn= DButil.provideConnection()){
			
			PreparedStatement ps=	conn.prepareCall("select * from tender");
			
		    ResultSet rs=	ps.executeQuery();
		    
			while(rs.next()) {
			
			
				int v=rs.getInt("tId");
				String n=rs.getString("name");
				int sp=rs.getInt("startingPrice");
					
					
				  Tender tender=new Tender(v, n, sp);	
			      tenders.add(tender);
			
			
			
		    }
				
			} catch (SQLException e) {
				// TODO: handle exception
				throw new TenderException(e.getMessage());
			}
			
			if(tenders.size() == 0)
			     throw new TenderException("No Vendor found..");
		
		return tenders;
	}

	

}
