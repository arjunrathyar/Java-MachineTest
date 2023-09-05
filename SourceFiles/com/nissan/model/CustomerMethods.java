package com.nissan.model;

public interface CustomerMethods {

	void deposit(long accountNo,double amt);
	void withdraw(long accountNo,double amt);
	void checkBal(long accountNo);
	void deposit(long accountNo,long depositAccountNo,double amt);

}
