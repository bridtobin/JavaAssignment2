// Created by Brid Delap on 23/11/13.  
// Assignment 2.  Question 3.
//Write a hangman game that randomly generates a word and prompts the user to
//guess one letter at a time, as shown in the sample run. Each letter in the word is
//displayed as an asterisk. When the user makes a correct guess, the actual letter is
//then displayed. When the user finishes a word, display the number of misses and
//asks the user whether to continue to play with another word. Declare an array to
//store words, as follows:

// import the java.util.Random to generate a random number
import java.util.Random ;
import java.util.Scanner ;
public class Q3 {
	public static void main(String[] args) {
		// declare and create an array called words
		String [] words = {"write", "that", "hangman", "program", "display", "thee", "result"} ;
		String playAnotherGame = "Y" ;
		Scanner getInput = new Scanner(System.in) ;

		do {
			playGame(words) ;
			// when game has finished, ask player if they wish to play another game.  Keep asking until
			// they enter a valid response
			do {
				System.out.println("Do you want to guess another word (Enter Y or N):  ") ;
				playAnotherGame = getInput.next() ;
	   			if ( !playAnotherGame.equalsIgnoreCase("y") && !playAnotherGame.equalsIgnoreCase("n")) {
    				System.out.println("ERROR - Please re-enter Y or N: ") ;
    			} // if !playAnotherGame
			}while ( !playAnotherGame.equalsIgnoreCase("y") && !playAnotherGame.equalsIgnoreCase("n")) ;

		}  while (playAnotherGame.equalsIgnoreCase("Y"));
	
		
		
	
    	
	} // main method
		
		public static void playGame(String [] words) {	
			Scanner getInput = new Scanner(System.in) ;

			// generate a random number between 0 and array length using the random class
			Random randomNumber = new Random() ;
			int wordNumber = randomNumber.nextInt(words.length) ;
			// Store the word to variable word - the word stored is the word in the array with index = to random number generated
			String word = words[wordNumber] ;
			// Set up an instance of StringBuilder to hold the * during play - called showProgress
			StringBuilder showProgress = new StringBuilder(word.length()) ;
			// Fill the showProgress variable with *
	    	for(int i = 0; i<word.length(); i++) {
	    		showProgress.append('*') ;
	    	} //for int i 
			// declare variabe to count the number of misses in game
			int countMisses = 0 ;
			// Keep asking for characters until showProgress is the same as word
			do {
				System.out.print("(Guess) Enter a letter in word " + showProgress + " > ") ;
				// Get the first character input.  User only meant to input 1 character
				char guess = getInput.next().charAt(0) ;
				// convert the input to lower case as the words are stored in lower case
				guess = Character.toLowerCase(guess) ;
				// see if the char guess exists in the word. If it does, check that it hasn't already been entered
				// by the user ie check showProgress.  If it doesn't let them know.
				if(word.indexOf(guess)!=-1) {
				
					// check if they have already entered the character
					if (showProgress.indexOf(guess+"")!=-1) {
						System.out.println(guess + " is already in the word ") ;
					} // if (showProgress
					else {
					// replace all occurences of the letter. Loop through the word starting at the
					// first occurrence of the guess letter
					
						for(int i = word.indexOf(guess); i <= word.length()-1; i++) {
							if(word.charAt(i) == guess) {
									showProgress.setCharAt(i, guess);
							} // if word.charAt(i)
						} // for
					} // else if showProgress.indexOf
				} // if word.indexOf
				else {
					countMisses++ ;
					System.out.println(guess + " is not in the word") ;
	
				}// else if word
			} while (!showProgress.toString().equalsIgnoreCase(word)) ;
		
			System.out.println("The word is " + word + ".  You missed " + countMisses + (countMisses==1?" time":" times")) ;
		} // playGame method
		
	
} // class Q3