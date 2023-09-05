package com.nissan.app;

import java.util.Scanner;

import com.nissan.lib.AdminMethodHandler;
import com.nissan.lib.CustomerMethodHandler;
import com.nissan.lib.ValidateMethods;
import com.nissan.model.AdminMethods;
import com.nissan.model.CustomerMethods;

public class Main {

	public static void main(String[] args) {

		ValidateMethods validate = new ValidateMethods();

		int adminOrCustomer = '1';
		int userInp = 0;
		char choice = 'n';
		String sampleNo;

		Scanner in = new Scanner(System.in);

		try {
		
			do {				
				do {
					System.out.println("Are you a customer or admin? (0 for admin and 1 for customer)");
					sampleNo = validate.validateNumeric(in.next());
				} while (sampleNo == null);
				adminOrCustomer = Integer.parseInt(sampleNo);
				
				//adminOrCustomer = Integer.parseInt(in.next());
				if (adminOrCustomer == 0) {
					AdminMethods adminMethod = new AdminMethodHandler();

					System.out.println("\n\nChoose your prefernce from the following List");
					System.out.println("1.Add a New Customer");
					System.out.println("2.Updating a Customer");
					System.out.println("3.Deleting a Customer");
					System.out.println("4.Display all Customers");
					System.out.println("5.Display a particular Customers");
					System.out.println("6.Exit");
					System.out.println("Enter your choice: ");
					
					
					do {
						sampleNo = validate.validateNumeric(in.next());
					} while (sampleNo == null);
					userInp = Integer.parseInt(sampleNo);

					if (userInp == 1) {

						long accountNo = (long) (Math.random() * 1000000000);
						String customerName;

						do {
							System.out.println("Enter Customer Name: ");
							customerName = validate.validateName(in.next());
						} while (customerName == null);

						System.out.println("Enter Account Type: ");
						String accountType = in.next();

					
						sampleNo = null;
						do {
							System.out.println("Enter Balance: ");
							sampleNo = validate.validateNumeric(in.next());
						} while (sampleNo == null);
						double balance = Double.parseDouble(sampleNo);

						System.out.println("Enter Minimum Balance: ");
						double minimum_Balance = Double.parseDouble(in.next());
	
						String mNo;
						do {
							System.out.println("Enter Mobile Number: ");
							mNo = validate.validateMobileNumber(in.next());
						} while (mNo == null);
						long mobileNumber = Long.parseLong(mNo);

						System.out.println("Enter E-Mail ID: ");
						String emailId = in.next();

						int atmPin = (int) (Math.random() * 1000);

						System.out.println("Enter PAN No: ");
						String panNo = in.next();

						adminMethod.addCustomer(accountNo, customerName, accountType, balance, minimum_Balance,
								mobileNumber, emailId, atmPin, panNo);
					}

					else if (userInp == 2) {

						System.out.println("Enter Account No: ");
						long accountNo = Long.parseLong(in.next());
						System.out.println("Enter New Mobile No: ");
						long mobileNumber = Long.parseLong(in.next());
						System.out.println("Enter New E-Mail ID: ");
						String emailId = in.next();

						adminMethod.updateCustomer(accountNo, mobileNumber, emailId);
					}

					else if (userInp == 3) {
						System.out.println("Enter Account No: ");
						long accountNo = Long.parseLong(in.next());
						adminMethod.deleteCustomer(accountNo);
					}

					else if (userInp == 4) {
						adminMethod.displayCustomers();
					}

					else if (userInp == 5) {
						System.out.println("Enter Account No: ");
						long accountNo = Long.parseLong(in.next());
						adminMethod.displayCustomer(accountNo);
					}

					else {
						System.exit(0);
					}

				}

				else if (adminOrCustomer == 1) {
					CustomerMethods customerMethod = new CustomerMethodHandler();
					System.out.println("\n\nChoose your prefernce from the following List");
					System.out.println("1.Deposit Money");
					System.out.println("2.Withdraw Money");
					System.out.println("3.Check Bank Balance");
					System.out.println("4.Transfer Money to Another Account");
					System.out.println("5.Exit");

					userInp = Integer.parseInt(in.next());
					if (userInp == 1) {
						System.out.println("Enter Account No: ");
						long accNo = Long.parseLong(in.next());
						System.out.println("Enter Amount to be Credited: ");
						double amt = Double.parseDouble(in.next());
						customerMethod.deposit(accNo, amt);

					} else if (userInp == 2) {
						System.out.println("Enter Account No: ");
						long accNo = Long.parseLong(in.next());
						System.out.println("Enter Amount to be Debited: ");
						double amt = Double.parseDouble(in.next());
						customerMethod.withdraw(accNo, amt);

					} else if (userInp == 3) {
						System.out.println("Enter Account No: ");
						long accNo = Long.parseLong(in.next());
						customerMethod.checkBal(accNo);

					} else if (userInp == 4) {
						System.out.println("Enter Account No: ");
						long accNo = Long.parseLong(in.next());
						System.out.println("Enter Account No that needs to be deposited: ");
						long depositAccNo = Long.parseLong(in.next());
						System.out.println("Enter Amount: ");
						double amt = Double.parseDouble(in.next());
						customerMethod.deposit(accNo, depositAccNo, amt);
					} else {
						System.exit(0);
					}

				} else
					System.exit(0);
				System.out.println("Do you wish to Continue?");
				choice = in.next().charAt(0);
			} while (choice == 'Y' || choice == 'y');
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		finally {
			in.close();
		}

	}

}
