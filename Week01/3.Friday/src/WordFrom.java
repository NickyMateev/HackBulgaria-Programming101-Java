
public class WordFrom {

	public static boolean is_an_bn(String word) {

		if(word.equals(""))
			return true;
		
		if (word.length() % 2 != 0)
			return false;

		int left = (word.length() / 2) - 1;
		int right = (word.length() / 2);
		
		int iterations = word.length() / 2;
		while(iterations > 0){
			
			if(word.charAt(left) == 'a' && word.charAt(right) == 'b'){
				
				left--;
				right++;
				iterations--;
			}
			else
				return false;	
		}
		
		return true;
	}

	public static void main(String[] args) {

		
		System.out.println(is_an_bn("")); //True
		System.out.println(is_an_bn("hack")); // False
		System.out.println(is_an_bn("aaabb")); // False
		System.out.println(is_an_bn("aaabbb")); // True
		System.out.println(is_an_bn("aabbaabb")); // False
		System.out.println(is_an_bn("bbbaaa")); // False
		System.out.println(is_an_bn("aaaaabbbbb")); // True
	}

}
