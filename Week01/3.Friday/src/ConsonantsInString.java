
public class ConsonantsInString {

	public static boolean isVowel(char c){
		return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U' || c == 'y' || c == 'Y';
	}
	
	public  static int countConsonants(String str){
		
		int count = 0;
		char c;
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if(!isVowel(c) && ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)))
				count++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {

		System.out.println(countConsonants("Java"));
		System.out.println(countConsonants("Theistareykjarbunga"));
		System.out.println(countConsonants("grrrrgh!"));
		System.out.println(countConsonants("Github is the second best thing that happend to programmers, after the keyboard!"));
		System.out.println(countConsonants("A nice day to code!"));
	}

}
