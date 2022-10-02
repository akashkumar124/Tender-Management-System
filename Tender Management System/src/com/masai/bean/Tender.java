package com.masai.bean;

public class Tender {
	
	
	private int tId;
	private String tName;
	private int startingPrice;
	
	
	public Tender() {
		// TODO Auto-generated constructor stub
	}


	public Tender(int tId, String tName, int startingPrice) {
		super();
		this.tId = tId;
		this.tName = tName;
		this.startingPrice = startingPrice;
	}


	public int gettId() {
		return tId;
	}


	public void settId(int tId) {
		this.tId = tId;
	}


	public String gettName() {
		return tName;
	}


	public void settName(String tName) {
		this.tName = tName;
	}


	public int getStartingPrice() {
		return startingPrice;
	}


	public void setStartingPrice(int startingPrice) {
		this.startingPrice = startingPrice;
	}


	@Override
	public String toString() {
		return "Tender [tId=" + tId + ", tName=" + tName + ", startingPrice=" + startingPrice + "]";
	}
	
	
	

}
