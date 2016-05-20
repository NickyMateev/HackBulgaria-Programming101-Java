
public class CreditCardValidation {

	public static boolean is_credit_card_valid(String number){
		
		if(number.length() % 2 == 0)
			return false;
		
		int sum = 0;
		for (int i = number.length() - 1; i >= 0; i--) {
			
			if(i % 2 == 0)
				sum += (number.charAt(i) - 48);	// 48 is '0' in ASCII
			else
				sum += 2 * (number.charAt(i) - 48);
		}
		
		return ((sum % 10) == 0);
	}
	
	public static void main(String[] args) {

		System.out.println(is_credit_card_valid("79927398715"));	// valid
		System.out.println(is_credit_card_valid("79927398713"));	// invalid
	}

}
