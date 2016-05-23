
public class LongestIncreasingSubsequence {

	public static int maxIncreasingConsecutive(int[] items){
		
		int cur = 1, max = 1;
		
		for (int i = 0; i < items.length - 1; i++) {
			
			if(items[i] <= items[i + 1]){
				
				cur++;
				
				if(cur > max)
					max = cur;
				
			} else
				cur = 1;
		}
		
		return max;
	}
	
	public static void main(String[] args) {

		System.out.println(maxIncreasingConsecutive(new int[] {1, 2, 3, 3, 3, 3, 4, 3, 3})); // 7
		System.out.println(maxIncreasingConsecutive(new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5})); // 11
			
	}

}
