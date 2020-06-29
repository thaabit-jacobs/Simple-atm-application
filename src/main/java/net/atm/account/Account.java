package net.atm.account;

import java.time.LocalDate;
import java.util.ArrayList;

import net.atm.transactions.Transaction;
import net.atm.types.AccountType;

public class Account {
	
	private String accountName;
	
	private AccountType type;
	
	private int accountNum;
	
	private LocalDate dateCreated;
	
	private double availibleBalance;
	
	private ArrayList<Transaction> tranactions;
	
	public Account(String accountName, AccountType type) {
		
		this.accountName = accountName;
		
		this.type = type;
		
		this.accountNum = new AccountSupport().generateAccountNum();
		
		this.dateCreated = LocalDate.now();
		
		this.tranactions = new ArrayList<>();
	}
	
	public String getAccountName() {
		return accountName;
	}
	
	public AccountType getAccountType() {
		return type;
	}
	
	public int getAccountNumber() {
		return accountNum;
	}
	
	public LocalDate getLocalDate() {
		return dateCreated;
	}
	
	public ArrayList<Transaction> getTransactions(){
		return tranactions;
	}
	
	public void setAmount(double amount) {
		this.availibleBalance = amount;
	}
	
	public String toString() {
		return "Name: "  + accountName + "\n" + "Account type: " + type.toString()+ "\n" + "Account num: " + accountNum + "\n" + "Balance: " + availibleBalance + "\n" + "Transactions: " + tranactions.toString() + "\n" +  "Date created: " + dateCreated + "\n" + "Description: " + type.getDescription() ; 
	}
	
}

/*
Account:
TypeofAccount 
String name
double availibleBalance
ArrayListTansanction transactions
 */
