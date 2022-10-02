package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.masai.bean.TenderDao;
import com.masai.bean.Vender;
import com.masai.exceptions.TenderException;
import com.masai.exceptions.VendorException;

import com.masai.utility.DButil;

public class VendorDaoImpl implements VendorDao{

	@Override
	public String registerVendor(Vender vendor) {
        String msg = "Not Inserted";
		
		try(Connection conn= DButil.provideConnection()) {
			
			 PreparedStatement ps =  conn.prepareStatement
			   ("insert into vendor(name,email,password) values(?,?,?)");
			 
			 ps.setString(1, vendor.getvName());
			 ps.setString(2, vendor.getvEmail());
			 ps.setString(3, vendor.getvPassword());
			 
			 int x=ps.executeUpdate();
			 
			 if(x>0)
				 msg="Vendor Inserted Succesfully !";
			
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			
			msg =e.getMessage();
		}
		
		
		
		
		
		
		return msg;
	}

	@Override
	public Vender getVendorById(int vid) throws VendorException {
		// TODO Auto-generated method stub
        Vender vendor =null;
		
		try(Connection conn= DButil.provideConnection()) {
			
			 PreparedStatement ps =  conn.prepareStatement
			   ("select * from vendor where vId=?");
			 
			 ps.setInt(1, vid);
			 
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				
				int v=rs.getInt("vId");
				String n=rs.getString("name");
				String e=rs.getString("email");
				String p=rs.getString("password");
				
				vendor = new Vender(v,n,e,p);
			}else
				throw new VendorException("Vendor does not exist with vID"+vid);
			 
			 
			
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			new VendorException(e.getMessage());
		}
		
		
		
		return vendor;
	}

	@Override
	public Vender loginVendor(String username, String password) throws VendorException {
		// TODO Auto-generated method stub
		
		
        Vender vender = null;
		
		try(Connection conn = DButil.provideConnection()) {
			
			
			PreparedStatement ps= conn.prepareStatement("select * from vendor where email = ? AND password = ?");			
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
			int v=rs.getInt("vId");
			String n=rs.getString("name");
			String e=rs.getString("email");
			String p=rs.getString("password");
			
			vender = new Vender(v,n,e,p);
				
				
			}else
				throw new VendorException("Invalid Username or password.. ");
			
			
			
			
		} catch (SQLException e) {
			throw new VendorException(e.getMessage());
		}
		return vender;
	}

	@Override
	public Set<Vender> getAllVendorDetails() throws VendorException {
		// TODO Auto-generated method stub
		Set<Vender> vendors = new LinkedHashSet<>();
		
		try (Connection conn= DButil.provideConnection()){
			
		PreparedStatement ps=	conn.prepareCall("select * from vendor");
		
	    ResultSet rs=	ps.executeQuery();
	    
		while(rs.next()) {
		
		
				int r= rs.getInt("vId");
				String n= rs.getString("name");
				
				String e= rs.getString("email");
				String p= rs.getString("password");
				
				
			  Vender vender=new Vender(r, n, e, p);	
		      vendors.add(vender);
		
		
		
	    }
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new VendorException(e.getMessage());
		}
		
		if(vendors.size() == 0)
		     throw new VendorException("No Vendor found..");
		
		
		
		
		return vendors;
	}

	@Override
	public String applyTender(int tId, int vId, int bidd) throws VendorException, TenderException {
		// TODO Auto-generated method stub
		String message ="Not Resgistered";
		
		
		try(Connection conn= DButil.provideConnection()) {
			
		 	PreparedStatement ps= conn.prepareStatement("select * from vendor where vId =?");
			
		 	
		 	ps.setInt(1, vId);
		 	
		 	ResultSet rs= ps.executeQuery();
			
		 	if(rs.next()) {
		 		
		 		PreparedStatement ps2= conn.prepareStatement("select * from tender where tId=?");
		 		
		 		ps2.setInt(1, tId);

		 		ResultSet rs2= ps2.executeQuery();
		 		
		 		if(rs2.next()) {
		 			

		 			PreparedStatement ps3= conn.prepareStatement("insert into apply_tendors values(?,?,?)");
		 			
		 			
		 			ps3.setInt(1, tId);
		 			ps3.setInt(2, vId);
		 			ps3.setInt(3, bidd);
		 			
		 			int x= ps3.executeUpdate();
		 			
		 			if(x > 0)
		 				message = "Vendor applying the tendor Sucessfully.. ";
		 			else
		 				throw new VendorException("Techical error..");
		 			
		 			
		 			
		 		}
		 		else
		 			throw new TenderException("Invalid Tender...");
		 		
		 		
		 		
		 		
		 	}else
		 		throw new VendorException("Invalid Vendor...");
			
			
			
			
			
			
		} catch (SQLException e) {
			throw new VendorException(e.getMessage());
		}
		
		
		

		
		
		
		return message;
	}

	@Override
	public Set<TenderDao> getAllApllyintTendors() throws VendorException {
		// TODO Auto-generated method stub
		 Set<TenderDao> tdDao = new LinkedHashSet<>();
		 
		 try (Connection conn= DButil.provideConnection()){
				
				PreparedStatement ps=	conn.prepareCall("select v.vID, v.name,v.email, t.startingPrice,t.tId, ap.biddingPrice from  vendor v INNER JOIN tender t INNER JOIN apply_tendors ap ON v.vID = ap.vId AND t.tId = ap.tId ;");
				
			    ResultSet rs=	ps.executeQuery();
			    
				while(rs.next()) {
				
				
						int vId= rs.getInt("vId");
						int tId= rs.getInt("tId");
						String vname= rs.getString("name");
						
						String vemail= rs.getString("email");
						int tsp= rs.getInt("startingPrice");
						int vbp= rs.getInt("biddingPrice");
						
						
//					  Vender vender=new Vender(r, n, e, p);	
					  TenderDao tdDao2 = new TenderDao(vId,tId,vname,vemail,tsp,vbp);
					  
					  tdDao.add(tdDao2);
				      
				
				
				
			    }
					
				} catch (SQLException e) {
					// TODO: handle exception
					throw new VendorException(e.getMessage());
				}
				
				if(tdDao.size() == 0)
				     throw new VendorException("No Data found..");
		
		return tdDao;
	}

	@Override
	public String assignTender(int tId, int vId) throws VendorException, TenderException {
       String message ="Not Resgistered";
		
		
		try(Connection conn= DButil.provideConnection()) {
			
		 	PreparedStatement ps= conn.prepareStatement("select * from vendor where vId =?");
			
		 	
		 	ps.setInt(1, vId);
		 	
		 	ResultSet rs= ps.executeQuery();
			
		 	if(rs.next()) {
		 		
		 		PreparedStatement ps2= conn.prepareStatement("select * from tender where tId=?");
		 		
		 		ps2.setInt(1, tId);

		 		ResultSet rs2= ps2.executeQuery();
		 		
		 		if(rs2.next()) {
		 			

		 			PreparedStatement ps3= conn.prepareStatement("insert into assign_tendors values(?,?)");
		 			
		 			
		 			ps3.setInt(1, tId);
		 			ps3.setInt(2, vId);
		 			
		 			
		 			int x= ps3.executeUpdate();
		 			
		 			if(x > 0)
		 				message = "Tender applying to the Vendor Sucessfully.. ";
		 			else
		 				throw new VendorException("Techical error..");
		 			
		 			
		 			
		 		}
		 		else
		 			throw new TenderException("Invalid Tender...");
		 		
		 		
		 		
		 		
		 	}else
		 		throw new VendorException("Invalid Vendor...");
			
			
			
			
			
			
		} catch (SQLException e) {
			throw new VendorException(e.getMessage());
		}
		
		
		

		
		
		
		return message;
	}

	@Override
	public Set<TenderDao> getAllMyBidHistory(int vid) throws TenderException {
		// TODO Auto-generated method stub
		Set<TenderDao> tdDao = new LinkedHashSet<>();
		 
		 try (Connection conn= DButil.provideConnection()){
				
				PreparedStatement ps=	conn.prepareCall("select v.vID, v.name,v.email, t.startingPrice,t.tId, ap.biddingPrice from  vendor v INNER JOIN tender t INNER JOIN apply_tendors ap ON v.vID = ap.vId AND t.tId = ap.tId AND v.vId = ?;");
				
				ps.setInt(1, vid);
				
			    ResultSet rs=	ps.executeQuery();
			    
				while(rs.next()) {
				
				
						int vId= rs.getInt("vId");
						int tId= rs.getInt("tId");
						String vname= rs.getString("name");
						
						String vemail= rs.getString("email");
						int tsp= rs.getInt("startingPrice");
						int vbp= rs.getInt("biddingPrice");
						
						
//					  Vender vender=new Vender(r, n, e, p);	
					  TenderDao tdDao2 = new TenderDao(vId,tId,vname,vemail,tsp,vbp);
					  
					  tdDao.add(tdDao2);
				      
				
				
				
			    }
					
				} catch (SQLException e) {
					// TODO: handle exception
					throw new TenderException(e.getMessage());
				}
				
				if(tdDao.size() == 0)
				     throw new TenderException("No Data found..");
		
		return tdDao;
	}

	@Override
	public Set<TenderDao> getAllMySelctedBidHistory(int vid) throws TenderException {
		// TODO Auto-generated method stub
		Set<TenderDao> tdDao = new LinkedHashSet<>();
		 
		 try (Connection conn= DButil.provideConnection()){
				
				PreparedStatement ps=	conn.prepareCall("select v.vID, v.name,v.email, t.startingPrice,t.tId, ap.biddingPrice from  vendor v INNER JOIN tender t INNER JOIN apply_tendors ap ON v.vID = ap.vId AND t.tId = ap.tId AND v.vId = ?;");
				
				ps.setInt(1, vid);
				
			    ResultSet rs=	ps.executeQuery();
			    
				while(rs.next()) {
				
				
						int vId= rs.getInt("vId");
						int tId= rs.getInt("tId");
						String vname= rs.getString("name");
						
						String vemail= rs.getString("email");
						int tsp= rs.getInt("startingPrice");
						int vbp= rs.getInt("biddingPrice");
						
						
//					  Vender vender=new Vender(r, n, e, p);	
					  TenderDao tdDao2 = new TenderDao(vId,tId,vname,vemail,tsp,vbp);
					  
					  tdDao.add(tdDao2);
				      
				
				
				
			    }
					
				} catch (SQLException e) {
					// TODO: handle exception
					throw new TenderException(e.getMessage());
				}
				
				if(tdDao.size() == 0)
				     throw new TenderException("No Data found..");
		
		return tdDao;
	}

	
	


	
	

}
