package VatTaxCalculator;

public final class CountryVatTax {
	
	private final int countryId;
	private final double VATTax;
	private final boolean IsDefault;
	
	public CountryVatTax(int countryId, double VATTax, boolean IsDefault){
		
		this.countryId = countryId;
		this.VATTax = VATTax; 
		this.IsDefault = IsDefault;
	}
	
	public int getCountryId(){
		return countryId;
	}
	
	public double getVATTax(){
		return VATTax;
	}
	
	public boolean isDefault(){
		return IsDefault;
	}
}
