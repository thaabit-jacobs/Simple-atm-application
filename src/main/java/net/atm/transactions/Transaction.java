package net.atm.transactions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Formatter;

import net.atm.account.Account;
import net.atm.types.AccountType;

public class Transaction {
	
	private Account account;
	
	private TransactionType type;
	
	private LocalDate date;
	
	private boolean transactionSuccess;
	
	private double transactionAmount;
	
	public Transaction(Account account) {
		
		this.account = account;
		
	}
	
	public String balanceEnquiry() {
		Formatter f = new Formatter();
		date = LocalDate.now();
		
		this.type = TransactionType.BalanceEnquiry;
		transactionSuccess = true;
		transactionAmount = account.getAvailibleBalance();
		
		String balance = f.format("Current Balance: R%.2f", account.getAvailibleBalance()).toString();
		
		f.close();
		
		account.addTransactions(this);
		
		return balance;
	}
	
	public String deposit(double amount) {
		Formatter f = new Formatter();
		date = LocalDate.now();
		
		this.type = TransactionType.Deposit;
		transactionAmount = amount;
		
		if(amount <= 0) {
			String invalidMsg = f.format("Amount: R%.2f invalid amount", amount).toString();
			
			transactionSuccess = false;
			
			f.close();
			
			account.addTransactions(this);
			
			return invalidMsg;
		}
		
		account.changeAmount(amount);
		
		String deposittedMsg = f.format("Amount: R%.2f deposited", amount).toString();
		
		transactionSuccess = true;
		
		f.close();
		
		account.addTransactions(this);
		
		return deposittedMsg;
	}
	
	public String withdrawal(double amount) {
		Formatter f = new Formatter();
		date = LocalDate.now();
		
		this.type = TransactionType.Withdrawal;
		transactionAmount = amount;
		
		if(amount <= 0 || amount > account.getAvailibleBalance()) {
			String invalidMsg = f.format("Amount: R%.2f invalid amount", amount).toString();
			
			transactionSuccess = false;
			
			f.close();
			
			account.addTransactions(this);
			
			return invalidMsg;
		}
		
		account.changeAmount(-amount);
		
		String withdrawalMsg = f.format("Amount: R%.2f withdrawn", amount).toString();
		
		transactionSuccess = true;
		
		f.close();
		
		account.addTransactions(this);
		
		return withdrawalMsg;
	}
	
	public String receipt() {
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		Formatter f = new Formatter();

		String receipt = f.format("Transaction type: %s \nTransanction amount: R%.2f \nTransanction sucess: %b \nDate: %s", type.toString(), transactionAmount, transactionSuccess, formatter.format(date)).toString();
		
		f.close();
		
		return receipt;
	}

	public static void main(String[] args){
		System.out.println(LocalDate.now());
	}
}
