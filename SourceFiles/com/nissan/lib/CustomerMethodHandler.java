package com.nissan.lib;

import java.util.ArrayList;
import java.util.Scanner;

import com.nissan.model.CustomerMethods;
import com.nissan.model.CustomerPojo;

public class CustomerMethodHandler implements CustomerMethods {

	static ArrayList<CustomerPojo> customerList = AdminMethodHandler.customerList;

	@SuppressWarnings("resource")
	@Override
	public void deposit(long accountNo, double amt) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		for (CustomerPojo a : customerList) {
			if (a.getAccountNo() == accountNo) {
				if (a.getBalance() > 50000) {
					System.out.println("Enter the PAN no:");
					String pan = in.next();
					if (pan == a.getPanNo()) {
						a.setBalance(amt + a.getBalance());
					}
				} else {
					a.setBalance(amt + a.getBalance());
				}
				return;
			}
		}
		// in.close();
	}

	@SuppressWarnings("resource")
	@Override
	public void withdraw(long accountNo, double amt) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		for (CustomerPojo a : customerList) {
			if (a.getAccountNo() == accountNo) {
				double avlBal = a.getBalance() - a.getMinimum_Balance();
				if (a.getBalance() <= avlBal) {
					System.out.println("Insufficient funds..!!!");
					return;
				} else if (a.getBalance() > 50000) {
					System.out.println("Enter the PAN no:");
					String pan = in.next();
					if (pan == a.getPanNo()) {
						a.setBalance(a.getBalance() - amt);
					}
				} else {
					a.setBalance(a.getBalance() - amt);
				}
				return;
			}
		}
		// in.close();
	}

	@Override
	public void checkBal(long accountNo) {
		// TODO Auto-generated method stub
		for (CustomerPojo a : customerList) {
			if (a.getAccountNo() == accountNo) {
				System.out.println("Name: " + a.getCustomerName());
				System.out.println("Account No: " + a.getAccountNo());
				System.out.println("Account Type: " + a.getAccountType());
				System.out.println("Account Balance: " + a.getBalance());
				System.out.println("Minimum Balance: " + a.getMinimum_Balance());
				return;
			}
		}

	}

	@Override
	public void deposit(long accountNo, long depositAccountNo, double amt) {
		// TODO Auto-generated method stub
		int flag = 0;
		for (CustomerPojo a : customerList) {
			if (a.getAccountNo() == accountNo) {
				double avlBal = a.getBalance() - a.getMinimum_Balance();
				for (CustomerPojo b : customerList) {
					if (b.getAccountNo() == depositAccountNo) {
						flag = 1;
					}
				}

				if (avlBal > a.getMinimum_Balance() && flag==1) {
					withdraw(accountNo, amt);
					deposit(depositAccountNo, amt);
					System.out.println("Transferred Amount Successfully");
				}
				return;
			}
		}
	}

}
