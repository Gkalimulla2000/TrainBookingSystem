package com.irctc.trainbookingsystem.dto;

public class UserDto {
	
	private int userId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private long phoneNo;
	private String email;
	private long walletBalance;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getWalletBalance() {
		return walletBalance;
	}
	public void setWalletBalance(long walletBalance) {
		this.walletBalance = walletBalance;
	}
	
}
