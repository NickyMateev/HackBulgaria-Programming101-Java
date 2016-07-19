
public class CorrectExpression {

	public static boolean isCorrectExpression(String expression){
	
		int openning = 0, closing = 0;
		for (int i = 0; i < expression.length(); i++) {
			
			if(expression.charAt(i) == '(')
				openning++;
			if(expression.charAt(i) == ')')
				closing++;
			
			if(closing > openning)
				return false;
		}
		
		return openning == closing; 
	}

	public static void main(String[] args) {

		String exp = "())(()";
		System.out.println(isCorrectExpression(exp)); // false
		
		exp = "(())";
		System.out.println(isCorrectExpression(exp)); // true 

		exp = ")(";
		System.out.println(isCorrectExpression(exp)); // false
	}

}
