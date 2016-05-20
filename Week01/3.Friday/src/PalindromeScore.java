import java.util.Objects;

public class PalindromeScore {

	public static String reverseMe(String argument) {

		StringBuilder sb = new StringBuilder();
		for (int i = argument.length() - 1; i >= 0; i--)
			sb.append(argument.charAt(i));

		return sb.toString();
	}
	
	public static boolean isPalindrome(String argument) {

		return Objects.equals(argument, reverseMe(argument));
	}
	
	public static int pScore(int n){
		
		if(isPalindrome(Integer.toString(n)))
			return 1;
		else
			return 1 + pScore(n + Integer.parseInt(reverseMe(Integer.toString(n))));
	}
	
	public static void main(String[] args) {

		System.out.println(pScore(121));
		System.out.println(pScore(48));
		System.out.println(pScore(198));
	}

}
