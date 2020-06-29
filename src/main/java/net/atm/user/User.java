package net.atm.user;

import java.time.LocalDate;
import java.util.ArrayList;

import net.atm.account.Account;

public class User {
	
	private String firstName;
	
	private String lastName;
	
	private String password;
	
	private int cellNo;
	
	private LocalDate dateCreated;
	
	private ArrayList<Account> userAccounts;
	
	public User(String firstName, String lastName, String password, int cellNo) {
		
		this.firstName = firstName;
		
		this.lastName = lastName;
		
		this.password = password;
		
		this.cellNo = cellNo;
		
		this.dateCreated = LocalDate.now();
		
		this.userAccounts = new ArrayList<>();
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getCellNo() {
		return cellNo;
	}
	
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	
	public ArrayList<Account> getUserAccounts(){
		return userAccounts;
	}
	
	public String changeCellNo(int amount) {
		String s = new Integer(amount).toString();
		if(s.length() < 10 || s.length() > 10)
			return "Invalid cell phone number";
		
		this.cellNo = amount;
		return "Cell number successfully changed";
	}
	
	public String changePassword(String password) {
		if(password.length() < 4 || password.length() > 8)
			return "Invalid password";
		
		this.password = password;
		return "Password successfully changed";
	}
	
	public String addAccount(Account account) {
		this.userAccounts.add(account);
		return "Account successfully added";
	}
	
	public String toString() {
		return "Name: " + this.firstName + this.lastName + "\n" + "Cell no: " + this.cellNo + "\n" +  "Date created: " + this.dateCreated.toString() + "\n" + "Accounts: " + this.userAccounts.toString();
	}
}