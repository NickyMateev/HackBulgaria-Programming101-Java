import java.util.regex.Pattern;

public class UserInputChecker {
	
	private interface Validator{
		
		public boolean validate(String input);
	}
	
	public class PersonNameValidator implements Validator{

		@Override
		public boolean validate(String input) {
			
			String regex = "^[A-Z][a-z]+( [A-Z][a-z]+)$";
			Pattern pattern = Pattern.compile(regex);
			
			return pattern.matcher(input).matches();
		}
	}
	
	public class BulgarianPhoneNumberValidator implements Validator {

		@Override
		public boolean validate(String input) {

			String regexMobile = "^\\d{3}[\\s-]?\\d{3}[\\s-]?\\d{4}$";
			String regexHome = "^\\d{3}[\\s-]?\\d{2}[\\s-]?\\d{2}$"; 
		
			Pattern pattern1 = Pattern.compile(regexMobile);
			Pattern pattern2 = Pattern.compile(regexHome);
		
			return (pattern1.matcher(input).matches() || pattern2.matcher(input).matches());
		}
	}
	
	public class PersonAgeValidator implements Validator {

		@Override
		public boolean validate(String input) {
			
			String regex = "^[1-9]\\d{0,2}$";
			Pattern pattern = Pattern.compile(regex);
			
			return pattern.matcher(input).matches();
		}
	}
	
	public class CreditCardNumberValidator implements Validator {

		@Override
		public boolean validate(String input) {
			
			String regex = "^(\\d{4}[\\s-]?){3}\\d{4}$";
			Pattern pattern = Pattern.compile(regex);
			
			return pattern.matcher(input).matches();
		}
	}
	
	public class IpVersion4Validator implements Validator {

		@Override
		public boolean validate(String input) {
			
			String regex = "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
			Pattern pattern = Pattern.compile(regex);
			
			return pattern.matcher(input).matches();
		}
	}

	public class IpVersion6Validator implements Validator {

		@Override
		public boolean validate(String input) {
			
			String regex = "^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$";
			Pattern pattern = Pattern.compile(regex);
			
			return pattern.matcher(input).matches();
		}
	}
	
	public class MacAdressValidator implements Validator {

		@Override
		public boolean validate(String input) {
			
			String regex = "^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$";
			Pattern pattern = Pattern.compile(regex);
			
			return pattern.matcher(input).matches();
		}
	}	
}
