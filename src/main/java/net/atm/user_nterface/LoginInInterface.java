package net.atm.user_nterface;

import java.util.ArrayList;
import java.util.Scanner;

import net.atm.bank.Bank;
import net.atm.user.User;

public class LoginInInterface {
	
	private Scanner sc;
	
	private Bank bank;
	
	public LoginInInterface(Bank bank, Scanner sc) {
		
		this.sc = sc;
		
		this.bank = bank;
		
	}
	
	public String[] getUserDetails() {
		System.out.println("Enter username: ");
		String userName = sc.nextLine();
		userName = userName.trim();
		
		System.out.println("Enter password: ");
		String password = sc.nextLine();
		password = password.trim();
		
		return new String[] {userName, password};
	}
	
	public boolean authenticateUserDetails() {
		for(User u: bank.getUsers()) {
			if(u.getUserName().equals(getUserDetails()[0]) && u.getUserName().equals(getUserDetails()[1])) {
				return true;
			}
		}
		
		System.out.println("Incorrect username or password");
		
		return false;
	}
	
}
