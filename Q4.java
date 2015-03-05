// Created by Brid Delap on 23/11/13.  Student No 13205278
// Assignment 2.  Question 4.
// This program creates an instance of the Blackjack class called newBlackjackGame. It checks if the player wishes to play 
// another game and asks the user to enter a stake amount
import java.util.Scanner;

public class Q4 {
	public static void main(String[] args) {
		String playAnotherGame = "" ;
		Scanner getInput = new Scanner(System.in) ;
		// playNewGame is played until the player says they do not wish to play another game
		do {
			playNewGame() ;
			// when game has finished, ask playER if they wish to play another game.  Keep asking until
			// they enter a valid response
			do {
				System.out.print("Do you wish to play another game (Y/N):  ") ;
				playAnotherGame = getInput.nextLine() ;
	   			if ( !playAnotherGame.equalsIgnoreCase("y") && !playAnotherGame.equalsIgnoreCase("n")) {
    				System.out.println("ERROR - Please re-enter Y or N: ") ;
    			} // if !playAnotherGame
			}while ( !playAnotherGame.equalsIgnoreCase("y") && !playAnotherGame.equalsIgnoreCase("n")) ;

		}  while (playAnotherGame.equalsIgnoreCase("Y"));
	} // main method

	// playNewGame creates a new instance of the Blackjack class. The player is asked to input their stake for this
	// game and the method startNewGame from the Blackjack class is called.

	public static void playNewGame() {
		Scanner getInput = new Scanner(System.in) ;
		Blackjack newBlackjackGame = new Blackjack() ;
		// Get the stake from the player for each game
		String stringInputStake = "";
		double stake = 0;
		// keep asking for the stake until we get valid input
		do {
			System.out.print("Please enter your stake (Number only between €5 and €25 in increments of €5): ") ;
			stringInputStake = getInput.nextLine() ;
			stake = returnNumber(stringInputStake) ;
			if ((stake < 5 || stake > 25) || (stake % 5 != 0 )) {
				System.out.println("Invalid Input - Please re-enter your stake (Between €5 and €25 in increments of €5): ") ;
   		    }
		} while ((stake < 5 || stake > 25)  || (stake % 5 != 0 )) ;
	    newBlackjackGame.startNewGame(stake) ;
	} // method playNewGame


	
	// This method takes a string input and outputs it as a double.	If no numbers are passed in the string
	// it outputs 0
	public static double returnNumber(String stringInputStake) {
		StringBuilder tempString = new StringBuilder() ;
		tempString.append('0') ;
		for(int i=0; i<stringInputStake.length();i++) {
	 		 if(Character.isDigit(stringInputStake.charAt(i)))  {
	 			 // if char is a number we append it to tempString
	   			 tempString.append(stringInputStake.charAt(i)) ;
	   		 } // if Character.isDigit
	   	
		} // for int i=0
			return (Double.parseDouble(tempString.toString())) ;
	} // returnNumber method	
	
} // class Q6
