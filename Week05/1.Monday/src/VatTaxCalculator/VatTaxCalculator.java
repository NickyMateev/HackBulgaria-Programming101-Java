package VatTaxCalculator;

import java.util.ArrayList;
import java.util.List;

public class VatTaxCalculator {

	private List<CountryVatTax> countryList = new ArrayList<>();	
	private CountryVatTax defaultCountry = null;

	public VatTaxCalculator(List<CountryVatTax> countryList){
		
		if(countryList != null){
			
			for (CountryVatTax country : countryList) {
				this.countryList.add(country);
				
				if(country.isDefault()){
					defaultCountry = country;
				}
			}
		}
	}
	
	public double CalculateTax(double productPrice) throws NoDefaultCountryProvidedException {
	
		if(defaultCountry == null){
			throw new NoDefaultCountryProvidedException("ERROR: No default country was provided in the country list.");
		}
		
		return (productPrice * (1 + defaultCountry.getVATTax())) - productPrice;
	}
	
	public double CalculateTax(double productPrice, int countryId) throws NotSupportedCountryException {
		
		for (CountryVatTax country : countryList) {
			
			if(country.getCountryId() == countryId){
				
				return (productPrice * (1 + country.getVATTax())) - productPrice;
			}
		}
	
		// if the country was not found:
		throw new NotSupportedCountryException("ERROR: The country list does not contain the given country.");
	}
	
}
