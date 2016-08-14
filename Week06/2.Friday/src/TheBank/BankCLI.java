package TheBank;

import java.util.Scanner;

import BankAccount.ForbiddenWithdrawException;
import BankAccount.InsufficientFundsException;
import BankAccount.InvalidPersonInformationException;
import BankAccount.NonExistingBankAccountException;
import BankAccount.Person;

public class BankCLI {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		run(new Bank());
	}

	public static void run(Bank bank) {

		System.out.println("\t\tWelcome to The Bank 1.0!\n");
		System.out.println("Type \"help\" for more information.\n");

		StringBuilder userInput = new StringBuilder();

		while (true) {
			System.out.print("$> "); // this will act the role of a prompt

			userInput.append(scanner.nextLine());

			if (userInput.toString().contains("create_bank_account")) {

				String firstName, lastName;
				int age;
				Person owner;
				double balance, interestRate;
				boolean isComplexInterest;

				while (true) {
					try {
						System.out.print("First name: ");
						firstName = scanner.nextLine();
						System.out.print("Last name: ");
						lastName = scanner.next();
						System.out.print("Age: ");
						age = scanner.nextInt();

						owner = new Person(firstName, lastName, age);
						break;
					} catch (InvalidPersonInformationException e) {
						System.out.println(e.getMessage());
					}
				}

				System.out.print("Starting balance: ");
				balance = scanner.nextDouble();
				System.out.print("Interest rate: ");
				interestRate = scanner.nextDouble();
				System.out.print("Is complex interest: ");
				userInput.setLength(0);
				userInput.append(scanner.nextLine());
				if (userInput.toString().toLowerCase().contains("yes")) {
					isComplexInterest = true;
				} else {
					isComplexInterest = false;
				}

				bank.createBankAccount(owner, balance, interestRate, isComplexInterest);

			} else if (userInput.toString().contains("show_history")) {

				String[] transactions;

				while (true) {
					try {
						System.out.print("Bank account ID: ");
						transactions = bank.showHistory(scanner.nextInt());
						break;
					} catch (NonExistingBankAccountException e) {
						System.out.println(e.getMessage());
					}
				}
				
				for (String transcation : transactions) {
					if(transactions.length > 0){
						System.out.println(transcation);
					}
				}

			} else if (userInput.toString().contains("add_money")) {

				double amount;
				int bankAccountId;
				
				System.out.print("Amount: ");
				amount = scanner.nextDouble();
				System.out.print("Bank account ID: ");
				bankAccountId = scanner.nextInt();
				
				try {
					bank.addMoney(amount, bankAccountId);
				} catch (NonExistingBankAccountException e) {
					System.out.println(e.getMessage());
				}

			} else if (userInput.toString().contains("withdraw_money")) {

				double amount;
				int bankAccountId;
				
				System.out.print("Amount: ");
				amount = scanner.nextDouble();
				System.out.print("Bank account ID: ");
				bankAccountId = scanner.nextInt();
				
				try {
					bank.withdrawMoney(amount, bankAccountId);
				} catch (NonExistingBankAccountException | ForbiddenWithdrawException | InsufficientFundsException e) {
					System.out.println(e.getMessage());
				}
				
			} else if (userInput.toString().contains("transfer_money")) {

				int originBankId, destinationBankId;
				double amount;
				
				System.out.print("Original bank account ID: ");
				originBankId = scanner.nextInt();
				System.out.print("Destination bank account ID: ");
				destinationBankId = scanner.nextInt();
				System.out.print("Amount: ");
				amount = scanner.nextDouble();
				
				try {
					bank.transferMoney(originBankId, destinationBankId, amount);
				} catch (NonExistingBankAccountException | ForbiddenWithdrawException | InsufficientFundsException e) {
					System.out.println(e.getMessage());
				}
				
			} else if (userInput.toString().contains("calculate_amount")) {
				
				int bankAccountId, months;
				
				System.out.print("Bank account ID: ");
				bankAccountId = scanner.nextInt();
				System.out.print("Months: ");
				months = scanner.nextInt();
				
				try {
					bank.calculateAmount(bankAccountId, months);
				} catch (NonExistingBankAccountException e) {
					System.out.println(e.getMessage());
				}

			} else if (userInput.toString().contains("help")) {
				printHelp();
			} else if (userInput.toString().contains("exit")) {
				break;
			} else {
				System.out.println("Invalid command!");
			}

			userInput.setLength(0);
		}

	}

	public static void printHelp() {

		int repeatCount = 20;
		String symbol = "-";
		String border = new String(new char[repeatCount]).replace("\0", symbol);

		System.out.println();
		System.out.println(border);
		System.out.println("create_bank_account - creates a new bank account based on your input");
		System.out.println("show_history - prompts the user for the bank account number and show its history");
		System.out.println("add_money - prompts the user for the amount and the bank account number");
		System.out.println("withdraw_money - prompts the user for the amount and the bank account number");
		System.out.println(
				"transfer_money - prompts the user for the origin and destination bank account numbers and the amount");
		System.out.println(
				"calculate_amount - prompts the user for bank account number and number of months. It should return the amount after the given number of months");
		System.out.println("help - prints help");
		System.out.println("exit - exits the bank application");
		System.out.println(border);
		System.out.println();
	}
}
