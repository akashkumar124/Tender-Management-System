package com.masai.application;

import java.util.Scanner;

import com.masai.usecases.AdminLogin;
import com.masai.usecases.AssigningTender;
import com.masai.usecases.FillTendor;
import com.masai.usecases.GetAllTenderDetails;
import com.masai.usecases.GetAllVendorDetails;
import com.masai.usecases.GetallApplyTender;
import com.masai.usecases.GetallMyBidHisUse;
import com.masai.usecases.RegisterTender;
import com.masai.usecases.RegisterVendor;
import com.masai.usecases.VendorBidSelectedHis;
import com.masai.usecases.VendorLogin;

public class Tenderr_Management_System {
	
	public static void adminPortal() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter 1 to Register new Vendor");
	    System.out.println("Enter 2 to View all the vendors");
	    System.out.println("Enter 3 to Create new tenders");
	    System.out.println("Enter 4 to View All the Tenders.");
	    System.out.println("Enter 5 to View All the Bids of a tender");
	    System.out.println("Enter 6 to Assign tender to a vendor");
		System.out.println("Enter 7 to Exit");
		
		
		int choice = sc.nextInt();
		
       switch(choice) {
		
		case 1:
			new RegisterVendor().main(null);
			Tenderr_Management_System.adminPortal();
			break;
		
		case 2:
			new GetAllVendorDetails().main(null);
			Tenderr_Management_System.adminPortal();
			break;
			
		case 3:
			new RegisterTender().main(null);
			Tenderr_Management_System.adminPortal();
			break;
		
		case 4:
			new GetAllTenderDetails().main(null);
			Tenderr_Management_System.adminPortal();
			break;
		case 5:
			new GetallApplyTender().main(null);
			Tenderr_Management_System.adminPortal();
			break;
		case 6:
			new AssigningTender().main(null);
			Tenderr_Management_System.adminPortal();
			break;
		case 7:
			System.out.println("Exit from choices..");
			Tenderr_Management_System.exit();
		}
		
		
		
	}
	
    public static void vendorPortal() {
    	
       Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter 1 to View all the current Tenders");
	    System.out.println("Enter 2 to Place a Bid against a Tender");
	    System.out.println("Enter 3 to View status of a Bid(Whether Selected or Not)");
	    System.out.println("Enter 4 to View his own Bid History");
	    System.out.println("Enter 5 to Exit");
	    
	    int choice = sc.nextInt();
		
	       switch(choice) {
			
			case 1:
				new GetAllTenderDetails().main(null);
				Tenderr_Management_System.adminPortal();
				break;
			
			case 2:
				new FillTendor().main(null);
				Tenderr_Management_System.adminPortal();
				break;
				
			case 3:
				new VendorBidSelectedHis().main(null);
				Tenderr_Management_System.adminPortal();
				break;
			
			case 4:
				new GetallMyBidHisUse().main(null);
				Tenderr_Management_System.adminPortal();
				break;
			
			case 5:
				System.out.println("Exit from choices..");
				Tenderr_Management_System.exit();
				
			}
    	
		
	}
    
    public static void exit() {
    	System.out.println("Thanks for choosing us...........");
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome To the Tender Management System");
		
		System.out.println("For Admin enter 1 or vendor enter 2");
		
		int ch=sc.nextInt();
		
		if(ch==1) {
			
			if(new AdminLogin().main(null))
				Tenderr_Management_System.adminPortal();
			
				
			
			
		}else if(ch==2) {
			if(new VendorLogin().main(null))
				Tenderr_Management_System.vendorPortal();
		}
		
		

	}

}
