import java.util.Objects;

public class HackNumbers {

	public static String intToBinary(int n){
	
		if(n == 0)
			return "0";
		
		StringBuilder sb = new StringBuilder();
		while(n != 0){
			sb.append(n % 2);
			n /= 2;
		}
		
		sb.reverse();
		return sb.toString();
	}
	
	public static int countOnes(String str){
		
		int count = 0;
		for (int i = 0; i < str.length(); i++)
			if(str.charAt(i) == '1')
				count++;
		
		return count;
	}
	
	public static String reverseMe(String argument) {

		StringBuilder sb = new StringBuilder();
		for (int i = argument.length() - 1; i >= 0; i--)
			sb.append(argument.charAt(i));

		return sb.toString();
	}
	
	public static boolean isPalindrome(String argument) {

		return Objects.equals(argument, reverseMe(argument));
	}
	
	public static boolean isHack(int n){
		
		String binaryNum = intToBinary(n);
		return isPalindrome(binaryNum) && (countOnes(binaryNum) % 2 == 1);
	}
	
	public static int nextHack(int n){
		
		while(!isHack(n + 1))
			n++;
		return n + 1;
	}
	
	public static void main(String[] args) {

		System.out.println(isHack(1));
		System.out.println(nextHack(0));
		System.out.println("---------------");
		System.out.println(isHack(21));
		System.out.println(nextHack(10));
		System.out.println("---------------");
		System.out.println(isHack(8191));
		System.out.println(nextHack(8031));
		
	}

}
