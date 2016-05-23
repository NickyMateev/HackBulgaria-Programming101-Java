
public class LucasSeries {

	public static int nthLucas(int n){
	
		if(n == 0)
			return 2;
		
		if(n == 1)
			return 1;
		
		return nthLucas(n - 1) + nthLucas(n - 2);
	}
	
	public static void main(String[] args) {

		System.out.println(nthLucas(4));	// 7
		System.out.println(nthLucas(8));	// 47
		System.out.println(nthLucas(10));	// 123
	}

}
