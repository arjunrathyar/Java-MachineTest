package com.nissan.lib;

import java.util.ArrayList;

import com.nissan.model.AdminMethods;
import com.nissan.model.CustomerPojo;

public class AdminMethodHandler implements AdminMethods {

	static ArrayList<CustomerPojo> customerList = new ArrayList<>();

	@Override
	public void addCustomer(long accountNo, String customerName, String accountType, double balance,
			double minimum_Balance, long mobileNumber, String emailId, int atmPin, String panNo) {
		CustomerPojo customer = new CustomerPojo(accountNo, customerName, accountType, balance, minimum_Balance,
				mobileNumber, emailId, atmPin, panNo);
		customerList.add(customer);
	}

	@Override
	public void deleteCustomer(long accountNo) {
		// TODO Auto-generated method stub
			for (CustomerPojo a : customerList) {
				if (a.getAccountNo()==accountNo) {
					customerList.remove(customerList.indexOf(a));
					return;
				}
			}
	}

	@Override
	public void displayCustomer(long accountNo) {
		// TODO Auto-generated method stub
		for (CustomerPojo a : customerList) {
			if (a.getAccountNo()==accountNo) {
				System.out.println("Customer Name             :" + a.getCustomerName() +
						"\nAccount No             :" + a.getAccountNo() +
						"\nAccount Type           :" + a.getAccountType() +
						"\nAccount Balance        :" + a.getBalance() +
						"\nAccount Minimum Balance:" + a.getMinimum_Balance()+
						"\nCustomer E-Mail Id     :" + a.getEmailId()+
						"\nCustomer Mobile No     :" + a.getMobileNumber()
			);
				return;
			}
			
		}

	}

	@Override
	public void displayCustomers() {
		// TODO Auto-generated method stub
		for (CustomerPojo a : customerList) {
			System.out.println("Customer Name             :" + a.getCustomerName() +
								"\nAccount No             :" + a.getAccountNo() +
								"\nAccount Type           :" + a.getAccountType() +
								"\nAccount Balance        :" + a.getBalance() +
								"\nAccount Minimum Balance:" + a.getMinimum_Balance()+
								"\nCustomer E-Mail Id     :" + a.getEmailId()+
								"\nCustomer Mobile No     :" + a.getMobileNumber()
					);
		}
	}

	@Override
	public void updateCustomer(long accountNo, long mobileNumber, String emailId) {
		// TODO Auto-generated method stub
		int flag = 0;
		for (CustomerPojo a : customerList) {
			if (a.getAccountNo() == accountNo) {
				a.setMobileNumber(mobileNumber);
				a.setEmailId(emailId);
				flag =1;
				return;
			}
		}
		if(flag==0) {
			System.out.println("Account number not found..!!");
		}

	}

}
