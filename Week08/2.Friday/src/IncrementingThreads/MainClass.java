package IncrementingThreads;

public class MainClass {

	private static int counter = 1;
	private static int incrementTimes = 1000000;
	
	// synchronized is a must, otherwise we'd experience thread interference or memory consistency errors
	static synchronized void increment(){
		counter++;
	}
	
	static class IncThread1 implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < incrementTimes; i++) {
				increment();
			}
		}
	}

	static class IncThread2 implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < incrementTimes; i++) {
				increment();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(new IncThread1());
		Thread thread2 = new Thread(new IncThread2());

		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
		
		System.out.println(counter);
	}
}
