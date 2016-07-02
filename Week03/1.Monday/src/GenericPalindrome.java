
public class GenericPalindrome {

	public <T> boolean isPalindrome(T data){
		
		String str = data.toString();
		for (int left = 0, right = str.length() - 1; left < str.length() / 2; left++, right--) 
			if(str.charAt(left) != str.charAt(right))
				return false;
		
		return true;
	}
}
