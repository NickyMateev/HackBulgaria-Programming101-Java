
public class ZeroInsertion {

	public static long zero_insert(int n){
		
		String number = Integer.toString(n);
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < number.length(); i++) {
			
			if(i == 0)
				result.append(number.charAt(0));
			else {
				
				if(number.charAt(i) == number.charAt(i - 1) || (((number.charAt(i - 1) - '0') + (number.charAt(i) - '0')) % 10 == 0))
					result.append('0');
				
				result.append(number.charAt(i));
			}
		}
		
		
		return Long.parseLong(result.toString()); 
	}
	
	public static void main(String[] args) {

		
		System.out.println(zero_insert(116457)); // 10160457 
		System.out.println(zero_insert(55555555)); // 505050505050505
		System.out.println(zero_insert(1));	// 1
		System.out.println(zero_insert(6446)); // 6040406
	}

}