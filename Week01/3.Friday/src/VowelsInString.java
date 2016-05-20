
public class VowelsInString {

	public static boolean isVowel(char c){
		return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U' || c == 'y' || c == 'Y';
	}
	
	public static int countVowels(String str){
		
		int count = 0;
		for (int i = 0; i < str.length(); i++){
			if(isVowel(str.charAt(i)))
				count++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {

		System.out.println(countVowels("Java"));
		System.out.println(countVowels("Theistareykjarbunga"));
		System.out.println(countVowels("grrrrgh!"));
		System.out.println(countVowels("Github is the second best thing that happend to programmers, after the keyboard!"));
		System.out.println(countVowels("A nice day to code!"));
	}

}
