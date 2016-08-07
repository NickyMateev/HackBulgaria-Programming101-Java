package ShopInventory;

import VatTaxCalculator.NotSupportedCountryException;
import VatTaxCalculator.VatTaxCalculator;

public class Product {
	
	private int productId;
	private String productName;
	private int quantity;
	private int countryId;
	
	private double price;
	private double priceAfterTax;
	
	public Product(int productId, String productName, int quantity, int countryId, double price, VatTaxCalculator calculator) throws NotSupportedCountryException {

		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.countryId = countryId;
		this.price = price;
		
		this.priceAfterTax = price + calculator.CalculateTax(price, countryId); 
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getCountryId() {
		return countryId;
	}

	public double getPrice() {
		return price;
	}

	public double getPriceAfterTax() {
		return priceAfterTax;
	}
	
}
