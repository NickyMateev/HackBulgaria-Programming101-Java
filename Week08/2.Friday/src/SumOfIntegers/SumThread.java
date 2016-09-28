package SumOfIntegers;

public class SumThread implements Runnable {
	
	private int x;
	private int y;
	
	public SumThread(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void run() {
		System.out.println("x + y = " + (x + y));
	}
}
