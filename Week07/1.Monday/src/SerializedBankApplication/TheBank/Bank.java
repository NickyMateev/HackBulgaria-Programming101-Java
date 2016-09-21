package SerializedBankApplication.TheBank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import SerializedBankApplication.BankAccount.BankAccount;
import SerializedBankApplication.BankAccount.ForbiddenWithdrawException;
import SerializedBankApplication.BankAccount.InsufficientFundsException;
import SerializedBankApplication.BankAccount.NonExistingBankAccountException;
import SerializedBankApplication.BankAccount.Person;

public class Bank implements Serializable {

	private List<BankAccount> accounts = new ArrayList<>();

	public void createBankAccount(Person owner, double balance, double interestRate, boolean isComplexInterest) {

		accounts.add(new BankAccount(owner, balance, interestRate, isComplexInterest));
	}

	public String[] showHistory(int bankAccountId) throws NonExistingBankAccountException {
		for (BankAccount bankAccount : accounts) {
			if (bankAccount.getBankAccountId() == bankAccountId) {
				return bankAccount.getRecentTransactions();
			}
		}

		throw new NonExistingBankAccountException("ERROR: Missing bank account.");
	}

	public void addMoney(double amount, int bankAccountId) throws NonExistingBankAccountException {
		for (BankAccount bankAccount : accounts) {
			if (bankAccount.getBankAccountId() == bankAccountId) {
				bankAccount.deposit(amount);
				return;
			}
		}

		throw new NonExistingBankAccountException("ERROR: Missing bank account.");
	}

	public void withdrawMoney(double amount, int bankAccountId)
			throws NonExistingBankAccountException, ForbiddenWithdrawException, InsufficientFundsException {
		for (BankAccount bankAccount : accounts) {
			if (bankAccount.getBankAccountId() == bankAccountId) {
				bankAccount.withdraw(amount);
				return;
			}
		}

		throw new NonExistingBankAccountException("ERROR: Missing bank account.");
	}

	public void transferMoney(int originBankId, int destinationBankId, double amount)
			throws NonExistingBankAccountException, ForbiddenWithdrawException, InsufficientFundsException {

		BankAccount origin = null, destination = null;

		for (BankAccount bankAccount : accounts) {
			if (bankAccount.getBankAccountId() == originBankId) {
				origin = bankAccount;

				if (destination != null) {
					break;
				}
			} else if (bankAccount.getBankAccountId() == destinationBankId) {
				destination = bankAccount;

				if (origin != null) {
					break;
				}
			}
		}

		if (origin != null && destination != null) {
			origin.transfer(destination, amount);
		} else {
			throw new NonExistingBankAccountException("ERROR: Missing bank account.");
		}
	}
	
	public double calculateAmount(int bankAccountId, int numberOfMonths) throws NonExistingBankAccountException{
		
		for (BankAccount bankAccount : accounts) {
			if(bankAccount.getBankAccountId() == bankAccountId){
				
				double balance = bankAccount.getBalance();
				double interest = bankAccount.getInterestRate();
				
				if(bankAccount.IsComplexInterest()){
					return balance * Math.pow(1 + interest, numberOfMonths);
				} else {
					return balance + ((balance * interest) * numberOfMonths);
				}
			}
		}
		
		throw new NonExistingBankAccountException("ERROR: Missing bank account.");
	}
}
