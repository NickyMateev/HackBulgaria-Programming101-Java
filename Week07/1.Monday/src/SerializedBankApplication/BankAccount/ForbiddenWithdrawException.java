package SerializedBankApplication.BankAccount;

public class ForbiddenWithdrawException extends Exception {

	public ForbiddenWithdrawException(String message) {
		super(message);
	}
}
