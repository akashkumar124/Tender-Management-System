package com.masai.bean;

public class TenderDao {
	
	private int vid;
	private int tid;
	private String vname;
	private String vemail;
	private int startingprice;
	private int biddingPrice;
	
	
	public TenderDao(int vId2, int tId2, String vname2, String vemail2, String tsp, String vbp) {
		// TODO Auto-generated constructor stub
	}


	public TenderDao(int vid, int tid, String vname, String email, int startingprice, int biddingPrice) {
		super();
		this.vid = vid;
		this.tid = tid;
		this.vname = vname;
		this.vname = vname;
		this.startingprice = startingprice;
		this.biddingPrice = biddingPrice;
	}


	public TenderDao() {
		// TODO Auto-generated constructor stub
	}


	public int getVid() {
		return vid;
	}


	public void setVid(int vid) {
		this.vid = vid;
	}


	public int getTid() {
		return tid;
	}


	public void setTid(int tid) {
		this.tid = tid;
	}


	public String getVname() {
		return vname;
	}


	public void setVname(String vname) {
		this.vname = vname;
	}


	public String getTname() {
		return vname;
	}


	public void setTname(String tname) {
		this.vname = tname;
	}


	public int getStartingprice() {
		return startingprice;
	}


	public void setStartingprice(int startingprice) {
		this.startingprice = startingprice;
	}


	public int getBiddingPrice() {
		return biddingPrice;
	}


	public void setBiddingPrice(int biddingPrice) {
		this.biddingPrice = biddingPrice;
	}


	@Override
	public String toString() {
		return "TenderDao [vid=" + vid + ", tid=" + tid + ", vname=" + vname + ", tname=" + vname + ", startingprice="
				+ startingprice + ", biddingPrice=" + biddingPrice + "]";
	}
	
	
	

}
