package PrintingMessages;

public class PrintThread extends Thread {
	
	private String message;
	
	public PrintThread(String message) {
		this.message = message;
	}

	public void run(){
		System.out.format("%s: %s%n", Thread.currentThread().getName(), message);
	}
	
}
