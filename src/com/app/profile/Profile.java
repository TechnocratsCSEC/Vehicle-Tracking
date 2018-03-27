package com.app.profile;

public class Profile {
	private String userName;
	private String fullName;
	private String emailAdd;
	private String categoryName;
	private String subCat;
	private String phoneNo;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String username) {
		this.userName = username;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fname) {
		this.fullName = fname;
	}
	
	public String getPhone() {
		return phoneNo;
	}
	public void setPhone(String phone) {
		this.phoneNo = phone;
	}
	
	public String getEmailAdd() {
		return emailAdd;
	}
	public void setEmailAdd(String email) {
		this.emailAdd = email;
	}


}
