package net.atm.bank;

import java.util.ArrayList;

import net.atm.user.User;

public class Bank {

	private String name;
	
	private ArrayList<User> bankUsers;
	
	public Bank(String name, ArrayList<User> bankUsers) {
		
		this.name = name;
		
		this.bankUsers = bankUsers;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<User> getUsers() {
		return bankUsers;
	}
}
