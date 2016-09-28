package PrintingMessages;

public class PrintRunnable implements Runnable {
	
	private String message;
	
	public PrintRunnable(String message) {
		this.message = message;
	}
	
	public void run() {
		System.out.format("%s: %s%n", Thread.currentThread().getName(), message);
	}		
	
}
