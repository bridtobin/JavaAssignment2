// Created by Brid Delap on 13/11/13.  
// Assignment 2.  Question 2
// This program contains a method sort(String s) to sort a string.  The sort method is called from the
// main method where a user is prompted to enter a string and the sorted string is then displayed.
import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		System.out.println("Enter a string:  ") ;
		Scanner getInput = new Scanner(System.in) ;
		String s = getInput.nextLine() ;
		System.out.println(sort(s)) ;
	}
	public static String sort(String s)   {
		// I will create a char array to hold the value of the string
		char[] charArray = new char[s.length()] ;
		// store values of string to array
		for(int i=0; i < charArray.length; i++) {
			charArray[i] = s.charAt(i) ;
		} // for (int i=0
		// then sort the array using the java.util.Arrays.sort
		java.util.Arrays.sort(charArray);
		// create a StringBuilder object called sortedString with the same length as the charArray
		StringBuilder sortedString = new StringBuilder(charArray.length) ;
		// Append the array to sortedString
		sortedString.append(charArray) ;
		return sortedString.toString() ;

	} // sort method

}
