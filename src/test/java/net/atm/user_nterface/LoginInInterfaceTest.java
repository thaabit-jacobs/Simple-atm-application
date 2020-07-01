package net.atm.user_nterface;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import net.atm.account.Account;
import net.atm.bank.Bank;
import net.atm.types.AccountType;
import net.atm.user.User;

class LoginInInterfaceTest {

	@Test
	void shouldReturnTheUsersName() {
		System.out.println("Enter name: ");
		String userName = "Thaabit ";
		userName = userName.trim();
		
		assertEquals("Thaabit", userName);
	}
	
	@Test
	void shouldReturnTheUsersPassword() {
		System.out.println("Enter password: ");
		String password = " password";
		password = password.trim();
		
		assertEquals("password", password);
	}
	
	@Test
	void shouldReturnFalseForInalidDetailsEntered() {
		User u1 = new User("Thaabit", "Jacobs", "password", 1234567891);
		u1.addAccount(new Account("Thaabit Savings", AccountType.SavingsAccount));
		
		ArrayList<User> userList = new ArrayList<>();
		userList.add(u1);
		
		Bank b1 = new Bank("Thaabit Bank", userList);
		
		boolean b = false;
		
		for(User u: b1.getUsers()) {
			if(u.getUserName().equals("thaabitjacobs") && u.getPassword().equals("password")) {
				b =  true;
			} else {
				b = false;
			}
		}
		
		assertEquals(true, b == false);
	}
	
	@Test
	void shouldReturnTrueForCorrectUserDetails() {
		User u1 = new User("Thaabit", "Jacobs", "password", 1234567891);
		u1.addAccount(new Account("Thaabit Savings", AccountType.SavingsAccount));
		
		ArrayList<User> userList = new ArrayList<>();
		userList.add(u1);
		
		Bank b1 = new Bank("Thaabit Bank", userList);
		
		boolean b = false;
		
		for(User u: b1.getUsers()) {
			if(u.getUserName().equals("ThaabitJacobs") && u.getPassword().equals("password")) {
				b =  true;
				break;
			} else {
				b = false;
			}
		}
		
		assertEquals(true, b);
	}
}
