package com.nissan.model;

public class CustomerPojo {

	private long accountNo;
	private String customerName;
	private String accountType;
	private double balance;
	private double minimum_Balance;
	private long mobileNumber;
	private String emailId;
	private int atmPin;
	private String panNo;

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getMinimum_Balance() {
		return minimum_Balance;
	}

	public void setMinimum_Balance(double minimum_Balance) {
		this.minimum_Balance = minimum_Balance;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getAtmPin() {
		return atmPin;
	}

	public void setAtmPin(int atmPin) {
		this.atmPin = atmPin;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public CustomerPojo(long accountNo, String customerName, String accountType, double balance, double minimum_Balance,
			long mobileNumber, String emailId, int atmPin, String panNo) {
		super();
		this.accountNo = accountNo;
		this.customerName = customerName;
		this.accountType = accountType;
		this.balance = balance;
		this.minimum_Balance = minimum_Balance;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.atmPin = atmPin;
		this.panNo = panNo;
	}

}
