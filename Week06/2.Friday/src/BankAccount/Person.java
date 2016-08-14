package BankAccount;

import java.util.regex.Pattern;

public class Person {
	
	private String firstName;
	private String lastName;
	private int age;
	
	public Person(String firstName, String lastName, int age) throws InvalidPersonInformationException { 
		
		if(!isValidName(firstName)){
			throw new InvalidPersonInformationException("ERROR: Invalid first name!");
		}
		
		if(!isValidName(lastName)){
			throw new InvalidPersonInformationException("ERROR: Invalid last name!"); 
		}
		
		if(!isValidAge(age)){
			throw new InvalidPersonInformationException("ERROR: Invalid age!");
		}
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public static boolean isValidName(String name){
	
		String regex = "^[A-Z][a-z]*$";
		Pattern pattern = Pattern.compile(regex);
		
		return pattern.matcher(name).matches();
	}
	
	public static boolean isValidAge(int age){
		return age > 16 && age < 150; // we assume that 16 is the minimum age and 150 is the maximum
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

}
