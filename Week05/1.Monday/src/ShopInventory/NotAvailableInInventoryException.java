package ShopInventory;

public class NotAvailableInInventoryException extends Exception {

	public NotAvailableInInventoryException(String message) {
		super(message);
	}
}
