import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class OneHundredSMS {

	private static HashMap<Integer, Character> map = new HashMap<Integer, Character>();

	private static void fillOutMap() {

		map.put(0, ' ');
		map.put(2, 'a');
		map.put(22, 'b');
		map.put(222, 'c');
		map.put(3, 'd');
		map.put(33, 'e');
		map.put(333, 'f');
		map.put(4, 'g');
		map.put(44, 'h');
		map.put(444, 'i');
		map.put(5, 'j');
		map.put(55, 'k');
		map.put(555, 'l');
		map.put(6, 'm');
		map.put(66, 'n');
		map.put(666, 'o');
		map.put(7, 'p');
		map.put(77, 'q');
		map.put(777, 'r');
		map.put(7777, 's');
		map.put(8, 't');
		map.put(88, 'u');
		map.put(888, 'v');
		map.put(9, 'w');
		map.put(99, 'x');
		map.put(999, 'y');
		map.put(9999, 'z');

	}

	private static void enterCommand(StringBuilder result, StringBuilder curInput, boolean capitalize) {

		if (capitalize)
			result.append(Character.toUpperCase(map.get(Integer.parseInt(curInput.toString()))));
		else
			result.append(map.get(Integer.parseInt(curInput.toString())));

		curInput.setLength(0); // emptying the StringBuilder so it's ready for
								// the next command
	}

	public static String numbersToMessage(int[] pressedSequence) {

		StringBuilder result = new StringBuilder();
		StringBuilder curInput = new StringBuilder();

		boolean capitalize = false;

		int c; // we'll use this for saving the digit after each iteration
		for (int i = 0; i < pressedSequence.length; i++) {

			c = pressedSequence[i];

			if (c == 1) {
				capitalize = true;
				continue;
			}

			if (c == -1)
				continue;

			curInput.append(c);
			if (curInput.length() == 4) // if the user enters "aaaa" that's
										// equal to => "a"
				curInput.setLength(1);

			if (i != pressedSequence.length - 1) {

				if (c != pressedSequence[i + 1]) {
					enterCommand(result, curInput, capitalize);
					capitalize = false;
				}

			} else {

				enterCommand(result, curInput, capitalize);
				capitalize = false;
			}
		}

		return result.toString();
	}
	
	public static int[] messageToNumbers(String message){
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		char c; // we'll assign each character of the string to this on each iteration
		int num = 0;
		for (int i = 0; i < message.length(); i++) {
			
			c = message.charAt(i);
			
			if(c >= 65 && c <= 90)
				list.add(1);
				
			c = Character.toLowerCase(c); // just in case it's an upper case letter
			for (Entry<Integer, Character> set : map.entrySet()) {
					
				if(set.getValue().equals(c)){
					num = set.getKey();
					break;					}
			}
			
			if(list.size() != 0 && (list.get(list.size() - 1) == num % 10)) // this will take care of the special breaking number "-1"
				list.add(-1);
			
			if(num == 0)
				list.add(0);
			
			while(num != 0){
				list.add(num % 10);
				num /= 10;
			}
		}
		
		int[] result = new int[list.size()];
		for (int i = 0; i < result.length; i++)
			result[i] = list.get(i);
		
		return result;
	}
	
	private static void printArr(int[] arr){
		
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			if(i != arr.length - 1)
				System.out.print(arr[i] + ", ");
			else
				System.out.print(arr[i]);
		}
		System.out.println("]");
	}

	public static void main(String[] args) {

		fillOutMap();
		System.out.println(numbersToMessage(new int[] { 1, 5, 2, 8, 8, 8, 2 })); // Result:
																					// Java
		System.out.println(numbersToMessage(new int[] { 2, -1, 2, 2, -1, 2, 2, 2 })); // Result:
																						// abc
		System.out.println(numbersToMessage(new int[] { 2, 2, 2, 2 })); // Result:a

		// Result: Ivo e Panda
		System.out.println(
				numbersToMessage(new int[] { 1, 4, 4, 4, 8, 8, 8, 6, 6, 6, 0, 3, 3, 0, 1, 7, 7, 7, 7, 2, 6, 6, 3, 2 }));

		System.out.println("----------------------------------------------------------------------------");
		int[] arr1 = messageToNumbers("abc");
		printArr(arr1);
		
		int[] arr2 = messageToNumbers("a");
		printArr(arr2);
		
		int[] arr3 = messageToNumbers("Ivo e Panda");
		printArr(arr3);
		
		int[] arr4 = messageToNumbers("aabbcc");
		printArr(arr4);
	}
}