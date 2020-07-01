package net.atm;

import java.util.ArrayList;

import net.atm.account.Account;
import net.atm.bank.Bank;
import net.atm.transactions.Transaction;
import net.atm.types.AccountType;
import net.atm.user.User;

public class Atm {

	public static void main(String[] args) {
		User u1 = new User("Thaabit", "Jacobs", "passwor", 1234567891);
		u1.addAccount(new Account("Thaabit Savings", AccountType.SavingsAccount));
		u1.addAccount(new Account("Thaabit Deposidt", AccountType.FixedDepositAccount));
		
		ArrayList<User> userList = new ArrayList<>();
		userList.add(u1);
		
		Bank b1 = new Bank("Thaabit Bank", userList);
		
		Transaction tran = new Transaction(b1.getUsers().get(0).getUserAccounts().get(0));
		
		
	}

}
