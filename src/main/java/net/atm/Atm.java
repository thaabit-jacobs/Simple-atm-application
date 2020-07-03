package net.atm;

import java.util.ArrayList;
import java.util.Scanner;

import net.atm.account.Account;
import net.atm.bank.Bank;
import net.atm.transactions.Transaction;
import net.atm.user.User;

public class Atm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		User u1 = new User("Thaabit", "Jacobs", "passwor", 1234567891);
		
		ArrayList<User> userList = new ArrayList<>();
		userList.add(u1);
		
		Bank b1 = new Bank("Thaabit Bank", userList);
		
		Main:
		while(true) {
			System.out.println("Login into account to perform transactions: ");
			
			System.out.println("Enter name: ");
			String name = sc.nextLine();
			name = name.trim();
			
			System.out.println("Enter password: ");
			String password = sc.nextLine();
			password = password.trim();
			
			for(User u: b1.getUsers())
				if(u.getFirstName().equals(name) && u.getPassword().equals(password)) {
					System.out.println("Login successful");
					
					User user2 = u; 
					
					System.out.println("Which account would you like to perform a trnasactions on: ");
					
					for(Account a: u.getUserAccounts()) {
						System.out.println(a.getAccountName());
						
						if(sc.nextLine().equalsIgnoreCase(a.getAccountName())) {
							Transaction transsaction = new Transaction(a);
							
							Second:
							while(true) {
								System.out.println("What transaction would you like to perform: ");
								System.out.println("<1> Balance enquiry");
								System.out.println("<2> Deposit");
								System.out.println("<3> Withdrawal");
								System.out.println("<4> Cancel");
								
								String userTransa = sc.nextLine();
								
								if(userTransa.equalsIgnoreCase("1")) {
									System.out.println(transsaction.balanceEnquiry());
									
								} else if(userTransa.equalsIgnoreCase("2")) {
									System.out.println("What is the amount you would like to deposit: ");
									String amount = sc.nextLine();
									System.out.println(transsaction.deposit(new Double(amount)));
									
								} else if(userTransa.equalsIgnoreCase("3")) {
									System.out.println("What is the amount you would like to withdraw: ");
									String amount = sc.nextLine();
									System.out.println(transsaction.withdrawal(new Double(amount)));
									
								} else if(userTransa.equalsIgnoreCase("4")) {
									System.out.println("Goodbye");
									break Main;
									
								} else 
									System.out.println("Invalid input");
								
								System.out.println("Would you like a receipt \n y/n: ");
								
								if(sc.nextLine().equalsIgnoreCase("y"))
									System.out.println(transsaction.receipt());
								else if(sc.nextLine().equalsIgnoreCase("n"))
									;
								else
									System.out.println("Invalid input");
								
								System.out.println("Would you to perform another transaction \n y/n: ");
								if(sc.nextLine().equalsIgnoreCase("y"))
									continue Second;
								else if(sc.nextLine().equalsIgnoreCase("n")) {
									System.out.println("Goodbye...");
									break Main;
								}
								else
									System.out.println("Invalid input");
							}

							
						} else {
							System.out.println("Account not found");
						}
					}				
			} 
		}
	}

}
