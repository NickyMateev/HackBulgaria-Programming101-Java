
public class IncreasingDecreasingSequences {

	public static boolean IsIncreasing(int[] sequence){
		
		for (int i = 0; i < sequence.length - 1; i++)
			if(sequence[i] > sequence[i + 1])
				return false;
		
		return true;
	}
	
	public static boolean IsDecreasing(int[] sequence){
		
		for (int i = 0; i < sequence.length - 1; i++)
			if(sequence[i] < sequence[i + 1])
				return false;
		
		return true;
	}
	
	public static void main(String[] args) {

		System.out.println(IsIncreasing(new int[] {1, 2, 3, 4, 5}));	// true
		System.out.println(IsDecreasing(new int[] {6, 5, 4, 2, 1, 10}));	// false
	}

}
