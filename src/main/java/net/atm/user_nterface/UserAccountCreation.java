package net.atm.user_nterface;

import java.util.Scanner;

import net.atm.account.Account;
import net.atm.types.AccountType;

public class UserAccountCreation {
	
	private Scanner sc;
	
	public UserAccountCreation(Scanner sc) {
		
		this.sc = sc;
	}
	
	public Account createAccount() {
		System.out.println("Select the account you would like to create: ");
		System.out.println("<1> Current Savings: ");
		System.out.println("<2> Savings Account: ");
		System.out.println("<3> Recurring Deposit Account: ");
		System.out.println("<4> Fixed Deposit Account: ");
		
		String userInput = sc.nextLine();
		AccountType userAccountType = AccountType.SavingsAccount;
		
		if(userInput.equals("1"))
			userAccountType = AccountType.CurrentAccount;
		
		else if(userInput.equals("2"))
			userAccountType = AccountType.SavingsAccount;
		
		else if(userInput.equals("3"))
			userAccountType = AccountType.RecurringDepositAccount;
		
		else if(userInput.equals("4"))
			userAccountType = AccountType.FixedDepositAccount;
		
		else
			System.out.println("Invalid entry: ");
		
		System.out.println("Enter a name you would like to give your account: ");
		String accountName = sc.nextLine();
		
		return new Account(accountName, userAccountType);
	} 
	
}
