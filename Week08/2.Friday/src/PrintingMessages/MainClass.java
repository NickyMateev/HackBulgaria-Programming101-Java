package PrintingMessages;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {
		Thread.currentThread().setName("MainThread");

		Thread otherThread = new Thread(new PrintThread("Hello from the other side."), "OtherThread");
		otherThread.start();
		otherThread.join();
	
		System.out.println(Thread.currentThread().getName() + ": Hello from the main thread.");
	}

}
