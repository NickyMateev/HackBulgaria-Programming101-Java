import java.util.ArrayList;

public class UniqueWords {

	public static int uniqueWordsCount(String[] arr){
	
		ArrayList<String> list = new ArrayList<String>();
		
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(!list.contains(arr[i])){
				list.add(arr[i]);
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {

		System.out.println(uniqueWordsCount(new String[] {"apple", "banana", "apple", "pie"})); // 3
		System.out.println(uniqueWordsCount(new String[] {"java", "java", "java", "android"})); // 2
		System.out.println(uniqueWordsCount(new String[] {"HELLO!", "HELLO!", "HELLO!", "HELLO!"})); // 1
	}

}
