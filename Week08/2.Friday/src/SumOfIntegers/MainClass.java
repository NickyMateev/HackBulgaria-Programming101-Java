package SumOfIntegers;

import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) {
		
		int x, y;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("x = ");
		x = scanner.nextInt();
		System.out.print("y = ");
		y = scanner.nextInt();
		scanner.close();
		
		Thread sumThread = new Thread(new SumThread(x, y));
		sumThread.start();
		
	}
}
