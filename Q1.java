// Created by Brid Delap on 13/11/13.  
// Assignment 2.  Question 1
// Write a test program that prompts the user to enter a phone number as a string.
// The input number may contain letters as follows:
// 2 - ABC; 3 - DEF; 4 - GHI; 5 - JKL; 6 - MNO; 7 - PQRS; 8 - TUV; 9 - WXYZ
// The program translates a letter (upper- or
// lower- case) to a digit and leaves all other characters intact.

// I have created PhoneKeypad as a class or an object.  I then create an instance of that 
// object in this program and call the method getActualNumber (which calls the method getNumber)
// Firstly import the java scanner.
import java.util.Scanner;

public class Q1 {
	public static void main(String[] args) {
		// Create an instance of the object PhoneKeypad called keypad
		PhoneKeypad keypad = new PhoneKeypad() ;
		System.out.println("Enter a string: ") ;
		Scanner getInput = new Scanner(System.in);
		// Get the string from the user
	    String keypadInput = getInput.nextLine() ;
	    // Print out the number calling the method getNumber
		System.out.println(keypad.getActualNumber(keypadInput)) ;
		getInput.close();
	} // main method

} // class Q1
