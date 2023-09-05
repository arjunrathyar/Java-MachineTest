package com.nissan.model;

public interface AdminMethods {

	void addCustomer(long accountNo, String customerName, String accountType, double balance, double minimum_Balance,
			long mobileNumber, String emailId, int atmPin, String panNo);

	void deleteCustomer(long accountNo);

	void displayCustomer(long accountNo);

	void updateCustomer(long accountNo, long mobileNumber, String emailId);

	void displayCustomers();

}
