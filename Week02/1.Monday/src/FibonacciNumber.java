
public class FibonacciNumber {

	public static int fibonacci(int n){
		
		if(n == 1)
			return 1;
		
		if(n == 2)
			return 1;
		
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	public static long fibNumber(int n){
		
		if(n < 1)
			return 0;
		
		StringBuilder sb = new StringBuilder();
		int i = 1;
		while(i <= n){
			
			sb.append(fibonacci(i));
			i++;
		}
		
		return Long.parseLong(sb.toString());
	}
	
	public static void main(String[] args) {

		
		System.out.println(fibNumber(3));  // 112
		System.out.println(fibNumber(10)); // 11235813213455
	}

}
