package BankAccount;

public class NonExistingBankAccountException extends Exception {

	public NonExistingBankAccountException(String message) {
		super(message);
	}
}
