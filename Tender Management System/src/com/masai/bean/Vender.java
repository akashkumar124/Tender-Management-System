package com.masai.bean;

public class Vender {
	
	
	private int vId;
	private String vName;
	private String vEmail;
	private String vPassword;
	
	
	public Vender() {
		// TODO Auto-generated constructor stub
	}


	public Vender(int vId, String vName, String vEmail, String vPassword) {
		super();
		this.vId = vId;
		this.vName = vName;
		this.vEmail = vEmail;
		this.vPassword = vPassword;
	}


	public int getvId() {
		return vId;
	}


	public void setvId(int vId) {
		this.vId = vId;
	}


	public String getvName() {
		return vName;
	}


	public void setvName(String vName) {
		this.vName = vName;
	}


	public String getvEmail() {
		return vEmail;
	}


	public void setvEmail(String vEmail) {
		this.vEmail = vEmail;
	}


	public String getvPassword() {
		return vPassword;
	}


	public void setvPassword(String vPassword) {
		this.vPassword = vPassword;
	}


	@Override
	public String toString() {
		return "Vender [vId=" + vId + ", vName=" + vName + ", vEmail=" + vEmail + ", vPassword=" + vPassword + "]";
	}
	
	

}
