package net.atm.user_nterface;

import java.util.Scanner;

import net.atm.bank.Bank;
import net.atm.user.User;

public class UserCreationInterface {

	private Scanner sc;
	
	private Bank bank;
	
	public UserCreationInterface(Bank bank, Scanner sc) {
		
		this.bank = bank;
		
		this.sc = sc;
		
	}
	
	public User createUser() {
		System.out.println("Enter firstname: ");
		String firstname = sc.nextLine();
		firstname = firstname.trim();
		
		System.out.println("Enter lastname: ");
		String lastname = sc.nextLine();
		lastname = lastname.trim();
		
		System.out.println("Enter password: ");
		String password = sc.nextLine();
		password = password.trim();
		
		System.out.println("Enter cellphone num: ");
		int cellNo = sc.nextInt();
		
		return new User(firstname, lastname, password, cellNo);
	}
}
