import java.math.BigInteger;

public class MathFunctions {
	
	@SuppressWarnings("unchecked")
	public static <T extends Number> T sumation(T x, T y){
	
		if(x.getClass() == Byte.class)
			return (T) Byte.valueOf((byte) (x.byteValue() + y.byteValue()));
		else if(x.getClass() == Short.class)
			return (T) Short.valueOf((short) (x.shortValue() + y.shortValue()));
		else if(x.getClass() == Integer.class)
			return (T) Integer.valueOf(x.intValue() + y.intValue());
		else if(x.getClass() == Long.class)
			return (T) Long.valueOf(x.longValue() + y.longValue());
		else if(x.getClass() == Float.class)
			return (T) Float.valueOf(x.floatValue() + y.floatValue());
		else if(x.getClass() == Double.class)
			return (T) Double.valueOf(x.doubleValue() + y.doubleValue());
		else
			return (T) ((BigInteger) x).add((BigInteger) y);
	
	}
		
	@SuppressWarnings("unchecked")
	public static <T extends Number> T subtraction(T x, T y){
	
		if(x.getClass() == Byte.class)
			return (T) Byte.valueOf((byte) (x.byteValue() - y.byteValue()));
		else if(x.getClass() == Short.class)
			return (T) Short.valueOf((short) (x.shortValue() - y.shortValue()));
		else if(x.getClass() == Integer.class)
			return (T) Integer.valueOf(x.intValue() - y.intValue());
		else if(x.getClass() == Long.class)
			return (T) Long.valueOf(x.longValue() - y.longValue());
		else if(x.getClass() == Float.class)
			return (T) Float.valueOf(x.floatValue() - y.floatValue());
		else if(x.getClass() == Double.class)
			return (T) Double.valueOf(x.doubleValue() - y.doubleValue());
		else
			return (T) ((BigInteger) x).subtract((BigInteger) y);
	
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Number> T multiplication(T x, T y){
	
		if(x.getClass() == Byte.class)
			return (T) Byte.valueOf((byte) (x.byteValue() * y.byteValue()));
		else if(x.getClass() == Short.class)
			return (T) Short.valueOf((short) (x.shortValue() * y.shortValue()));
		else if(x.getClass() == Integer.class)
			return (T) Integer.valueOf(x.intValue() * y.intValue());
		else if(x.getClass() == Long.class)
			return (T) Long.valueOf(x.longValue() * y.longValue());
		else if(x.getClass() == Float.class)
			return (T) Float.valueOf(x.floatValue() * y.floatValue());
		else if(x.getClass() == Double.class)
			return (T) Double.valueOf(x.doubleValue() * y.doubleValue());
		else
			return (T) ((BigInteger) x).multiply((BigInteger) y);
	
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Number> T division(T x, T y){
	
		if(x.getClass() == Byte.class)
			return (T) Byte.valueOf((byte) (x.byteValue() / y.byteValue()));
		else if(x.getClass() == Short.class)
			return (T) Short.valueOf((short) (x.shortValue() / y.shortValue()));
		else if(x.getClass() == Integer.class)
			return (T) Integer.valueOf(x.intValue() / y.intValue());
		else if(x.getClass() == Long.class)
			return (T) Long.valueOf(x.longValue() / y.longValue());
		else if(x.getClass() == Float.class)
			return (T) Float.valueOf(x.floatValue() / y.floatValue());
		else if(x.getClass() == Double.class)
			return (T) Double.valueOf(x.doubleValue() / y.doubleValue());
		else
			return (T) ((BigInteger) x).divide((BigInteger) y);
	
	}
		
	@SuppressWarnings("unchecked")
	public static <T extends Number> T power(T x, int exponent){

		if(exponent == 0)
			return (T) new Integer(0); // we'll use Integer, 0 and 0.0 is all the same 
		if(exponent == 1)
			return x;
		else
			return multiplication(x, power(x, exponent - 1));
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Number> T factorial(T x){
		
		if(x.doubleValue() <= 0)
			return (T) new Integer(1);
		else
			return multiplication(x, factorial(subtraction(x, (T) new Integer(1))));
	}
	
}