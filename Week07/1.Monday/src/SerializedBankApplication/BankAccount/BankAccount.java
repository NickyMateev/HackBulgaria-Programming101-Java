package SerializedBankApplication.BankAccount;

import java.io.Serializable;
import java.util.Date;

public class BankAccount implements Serializable {
	
	private static int idCounter = 1;
	private final static int historyCount = 5;
	private int historyCounter = 0;
	
	private int bankAccountId;
	private Person owner;
	
	private double balance;
	private double interestRate;
	private boolean isComplexInterest; 
	
	private StringBuilder[] accountHistory = new StringBuilder[historyCount];
	
	
	public BankAccount(Person owner, double balance, double interestRate, boolean isComplexInterest) {

		this.bankAccountId = idCounter;
		idCounter++;
		
		this.owner = owner;
		this.balance = balance;
		this.interestRate = interestRate;
		this.isComplexInterest = isComplexInterest;
		
		for (int i = 0; i < historyCount; i++) {
			accountHistory[i] = new StringBuilder();
		}
	}
	
	private void recordTransaction(String message){
		
		if(historyCounter >= historyCount){
			historyCounter = 0;
		}
		
		accountHistory[historyCounter].setLength(0);
		accountHistory[historyCounter].append(message);
		historyCounter++;
	}
	
	public int getBankAccountId() {
		return bankAccountId;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public double getInterestRate(){
		return interestRate;
	}

	public boolean IsComplexInterest(){
		return isComplexInterest;
	}
	
	public void deposit(double amount){
		
		balance += amount;
		
		recordTransaction(String.format("You deposited $%f on %s.\nNew balance: $%f", amount, new Date().toString(), balance));
	}

	public void withdraw(double amount) throws ForbiddenWithdrawException, InsufficientFundsException{
		
		if(interestRate > 0.01){
			throw new ForbiddenWithdrawException("ERROR: Withdraw not allowed with interest over 1%.");
		}
		
		if(amount > balance){
			throw new InsufficientFundsException("ERROR: Not enough money.");
		}
		
		balance -= amount;

		recordTransaction(String.format("You withdrew $%f on %s.\nNew balance: $%f", amount, new Date().toString(), balance));
		
	}

	public void transfer(BankAccount account, double amount) throws ForbiddenWithdrawException, InsufficientFundsException, NonExistingBankAccountException{
		
		if(account == null){
			throw new NonExistingBankAccountException("ERROR: Missing bank account.");
		}
		
		withdraw(amount);
		account.deposit(amount);
		
		recordTransaction(String.format("You transfered $%f to BankAccountID: %d on %s.\nYour new balance: $%f", amount, account.bankAccountId, new Date().toString(), balance));
	}

	public String[] getRecentTransactions(){
		
		String[] transactions = new String[historyCount];
		for (int i = 0; i < historyCount; i++) {
			transactions[i] = accountHistory[i].toString();
		}
		
		return transactions;
	}
	
}
