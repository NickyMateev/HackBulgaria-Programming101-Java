package simple;

public class SimpleCalculator {

	public int add(int x, int y) {
		return x + y;
	}

	public int subtract(int x, int y) {
		return x - y;
	}

	public double divide(double x, double y) {
		if (y == 0) {
			throw new IllegalArgumentException("Divisor cannot be 0.");
		}

		return x / y;
	}
}
