import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Objects;

import javax.imageio.ImageIO;

public class Program {

	// Problem 1:
	public static boolean isOdd(int n) {
		return (n % 2) == 1;
	}

	// Problem 2:
	public static boolean isPrime(int n) {

		if (n < 2)
			return false;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

	// Problem 3:
	public static int min(int... array) {

		int index = 0;
		for (int i = 1; i < array.length; i++) {

			if (array[index] > array[i])
				index = i;
		}

		return array[index];
	}

	// Problem 4:
	public static int kthMin(int k, int[] array) {

		if (k < 1)
			throw new ArithmeticException("Error: Invalid parameter given!");

		if (k > array.length)
			throw new ArithmeticException("Error: Not enough elements in the array!");

		Arrays.sort(array);

		return array[k - 1];
	}

	// Problem 5:
	public static double getAverage(int[] array) {

		int sum = 0;
		for (int i : array) {
			sum += i;
		}

		return ((double) sum / array.length);
	}

	// Problem 6:
	public static int factorial(int n) {

		if (n <= 0)
			return 1;

		return n * factorial(n - 1);
	}

	public static int doubleFac(int n) {

		return factorial(factorial(n));
	}

	// Problem 7:
	public static long kthFac(int k, int n) {

		int factorial = 1;
		for (int i = 1; i <= k * n; i++) {
			factorial *= i;
		}

		return factorial;
	}

	// Problem 8:
	public static long getSmallestMultiple(int upperBound) {

		return factorial(upperBound);
	}

	// Problem 9:
	public static long getLargestPalindrome(int N) {

		if (N < 0)
			throw new ArithmeticException("Error: Invalid input - negative integer!");

		while (N >= 0) {

			if (isPalindrome(N))
				return N;

			N--;
		}

		return 1;
	}

	// Problem 10:
	public static int[] histogram(short[][] image) {

		HashMap<Short, Short> map = new HashMap<Short, Short>();
		
		for (int i = 0; i < image.length; i++) {
			
			for (int j = 0; j < image[0].length; j++) {
				
				if(map.containsKey(image[i][j]))
					map.put(image[i][j], (short)(map.get(image[i][j]) + 1));
				else
					map.put(image[i][j], (short)1);
			}
		}
		
		int[] histogram = new int[256];
		for (int i = 0; i < histogram.length; i++) {
			
			if(map.containsKey(i))
				histogram[i] = map.get(i);
		}
		
		return histogram;
	}

	// Problem 11:
	public static long pow(int a, int b) {

		if (b > 0)
			return a * pow(a, b - 1);
		else
			return 1;
	}

	// Problem 12:
	public static int getOddOccurrence(int... array) {

		// key -> number; value -> occurrences
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < array.length; i++) {

			if (map.containsKey(array[i]))
				map.put(array[i], map.get(array[i]) + 1);
			else
				map.put(array[i], 1);
		}

		for (Entry<Integer, Integer> entry : map.entrySet()) {

			if (entry.getValue() % 2 == 1)
				return entry.getKey();
		}

		return -1; // if nothing is found, return -1;
	}

	// Problem 13:
	public static long maximalScalarSum(int[] a, int[] b) {

		Arrays.sort(a);
		Arrays.sort(b);

		int scalarProduct = 0;
		for (int i = 0; i < a.length; i++)
			scalarProduct += a[i] * b[i];

		return scalarProduct;
	}

	// Problem 14:
	public static int maxSpan(int[] numbers) {

		if (numbers.length < 2)
			return 1;

		int left = 0, right = 0;

		for (int i = 0; i < numbers.length; i++) {

			if (numbers[i] == numbers[numbers.length - 1 - i]) {
				left = numbers.length - i;
				break;
			} else if (numbers[numbers.length - 1] == numbers[i]) {
				right = numbers.length - i;
				break;
			}
		}

		return left >= right ? left : right;
	}

	// Problem 15:
	public static boolean canBalance(int[] numbers) {

		if (numbers.length <= 1)
			return false;

		int leftSum = 0, rightSum = 0;
		for (int i = 1; i < numbers.length; i++) {

			for (int j = 0; j < i; j++)
				leftSum += numbers[j];

			for (int k = i; k < numbers.length; k++)
				rightSum += numbers[k];

			if (leftSum == rightSum)
				return true;

			leftSum = 0;
			rightSum = 0;
		}

		return false;
	}

	// Problem 16:
	public static void rescale(String path, int newWidth, int newHeight) {

		BufferedImage curImg = null;
		BufferedImage newImg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

		try {
			curImg = ImageIO.read(new File(path));
		} catch (IOException | IllegalArgumentException ex) {
			ex.printStackTrace();
		}

		double widthRatio = (double) newWidth / curImg.getWidth();
		double heightRatio = (double) newHeight / curImg.getHeight();

		for (int i = 0; i < newImg.getWidth(); i++) {

			for (int j = 0; j < newImg.getHeight(); j++) {

				int getX = (int) Math.round(i / widthRatio);
				int getY = (int) Math.round(j / heightRatio);
				
				if(getX >= curImg.getWidth())
					getX--;
				
				if(getY >= curImg.getHeight())
					getY--;
				
				newImg.setRGB(i, j, curImg.getRGB(getX, getY));
			}
		}

		try {
			ImageIO.write(newImg, "jpg", new File("resized.jpg"));
		} catch (IOException | IllegalArgumentException ex) {
			ex.printStackTrace();
		}
	}

	// Problem 17:
	public static String reverseMe(String argument) {

		StringBuilder sb = new StringBuilder();
		for (int i = argument.length() - 1; i >= 0; i--)
			sb.append(argument.charAt(i));

		return sb.toString();
	}

	// Problem 18:
	public static String reverseEveryChar(String arg) {

		StringBuilder sb = new StringBuilder();
		String[] words = arg.split(" ");

		for (int i = 0; i < words.length; i++) {

			if (i != words.length - 1)
				sb.append(reverseMe(words[i]) + " ");
			else
				sb.append(reverseMe(words[i]));
		}

		return sb.toString();
	}

	// Problem 19:
	public static boolean isPalindrome(String argument) {

		return Objects.equals(argument, reverseMe(argument));
	}

	// Problem 20:
	public static boolean isPalindrome(int argument) {

		String strNumber = Integer.toString(argument);

		for (int i = 0; i < strNumber.length() / 2; i++) {
			if (strNumber.charAt(i) != strNumber.charAt(strNumber.length() - 1 - i))
				return false;
		}

		return true;
	}

	// Problem 21:
	public static String copyEveryChar(String input, int k) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < input.length(); i++)
			for (int j = 0; j < k; j++)
				sb.append(input.charAt(i));

		return sb.toString();
	}

	// Problem 22:
	public static int getPalindromeLength(String input) {

		String[] split = input.split("\\*");
		int length = 0;
		for (int i = 0; i < split[0].length() && i < split[1].length(); i++) {
			if (split[0].charAt(split[0].length() - 1 - i) == split[1].charAt(i))
				length++;
			else
				break;
		}

		return length;
	}

	// Problem 23:
	public static int countOccurrences(String needle, String haystack) {

		int occurrences = 0;
		for (int i = 0, j = 0; i < haystack.length(); i++) {

			if (haystack.charAt(i) == needle.charAt(j)) {
				j++;
				if (j == needle.length()) {
					occurrences++;
					j = 0;
				}
			} else
				j = 0;
		}

		return occurrences;
	}

	// Problem 24:
	public static String decodeURL(String input) {

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("%20", " ");
		map.put("%3A", ":");
		map.put("%3D", "?");
		map.put("%2F", "/");

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {

			if (input.charAt(i) == '%') {

				if (input.length() - i >= 3) {

					String substr = input.substring(i, i + 3);
					if (map.containsKey(substr))
						sb.append(map.get(substr));
					else
						sb.append(substr);

					i += 2;
				} else
					sb.append(input.charAt(i));
			} else
				sb.append(input.charAt(i));
		}

		return sb.toString();
	}

	// Problem 25:
	public static int sumOfNumbers(String input) {

		StringBuilder curNum = new StringBuilder();
		int sum = 0;
		boolean foundNumber = false;

		for (int i = 0; i < input.length(); i++) {

			if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
				foundNumber = true;
				curNum.append(input.charAt(i));

				if (i == input.length() - 1)
					sum += Integer.parseInt(curNum.toString());
			} else if (foundNumber) {
				foundNumber = false;
				sum += Integer.parseInt(curNum.toString());
				curNum.setLength(0); // clearing the curNum, so that it's ready
										// for the next number
			} else
				continue;
		}

		return sum;
	}

	// Problem 26:
	public static char[] manipulateString(String str) {

		str = str.toLowerCase();
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		return arr;
	}

	public static boolean isAnagram(String A, String B) {

		String str1 = A.replaceAll("\\s+", "");
		String str2 = B.replaceAll("\\s+", "");

		if (str1.length() != str2.length())
			return false;

		char[] charArr1 = manipulateString(str1);
		char[] charArr2 = manipulateString(str2);

		for (int i = 0; i < charArr1.length; i++)
			if (charArr1[i] != charArr2[i])
				return false;

		return true;
	}

	// Problem 27:
	public static boolean hasAnagramOf(String A, String B) {

		String str1 = A.replaceAll("\\s+", "");
		String str2 = B.replaceAll("\\s+", "");

		if (str2.length() < str1.length())
			return false;

		char[] charArr1 = manipulateString(str1);
		char[] charArr2 = manipulateString(str2);

		int counter = 0;
		for (int i = 0; i < charArr2.length; i++) {

			if (charArr1[counter] == charArr2[i]) {
				counter++;

				if (counter == charArr1.length)
					return true;
			}
		}

		return false;
	}

	// Problem 28:
	public static void convertToGrayscale(String imgPath) {

		BufferedImage img = null;

		try {
			img = ImageIO.read(new File(imgPath));
		} catch (IOException | IllegalArgumentException e) {
			e.printStackTrace();
		}

		int avg;

		for (int i = 0; i < img.getWidth(); i++) {

			for (int j = 0; j < img.getHeight(); j++) {

				Color color = new Color(img.getRGB(i, j));
				avg = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
				img.setRGB(i, j, new Color(avg, avg, avg).getRGB());
			}
		}

		try {
			File output = new File("greyscale.jpg");
			ImageIO.write(img, "jpg", output);
		} catch (IOException | IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		System.out.println(getOddOccurrence(new int[] { 1, 2, 2, 1, 3, 4, 3, 4, 4, 6, 5, 6, 5 }));
		System.out.println(maximalScalarSum(new int[] { 2, 1, 4 }, new int[] { 1, 2, 5 }));
		System.out.println(maxSpan(new int[] { 1, 4, 2, 1, 4, 4, 4 }));
		System.out.println(canBalance(new int[] { 2, 1, 1, 2, 1 }));
		
		rescale("cover.jpg", 1366, 768);
		
		System.out.println(reverseMe("Hello"));
		System.out.println(reverseEveryChar("What is this"));
		System.out.println(isPalindrome("andna"));
		System.out.println(isPalindrome(1221));
		System.out.println(copyEveryChar("tldr", 3));
		System.out.println(getPalindromeLength("taz*zad"));
		System.out.println(countOccurrences("da", "daaadaadada"));
		System.out.println(decodeURL("kitten%20pic%3Ajpg%2F"));
		System.out.println(sumOfNumbers("12aa99bfw1h"));
		System.out.println(isAnagram("William Shakespeare", "I am a weakish speller"));
		System.out.println(hasAnagramOf("R i a", "Traveling by air can be expensive."));

		convertToGrayscale("cover.jpg");
	}

}
