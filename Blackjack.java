// Created by Brid Delap on 23/11/13.  
// Assignment 2.  Question 4.
// The Blackjack class is instantiated in Question 4.  The Blackjack class contains methods related to the game of blackjack
// as follows:  
// initialiseHand() which stores a value of 99 in the hands of the player and dealer - this will be used later to see if a 
//     card has yet been placed in an element of an array
// setupGame() shuffles the pack and deals two cards each to dealer and player
// playGame() shows both hands and gives the user to hit or stay. If they select hit, it calls the hit() method.
//      If they decide to stay, it calls the method finishDealersPlay()
// hit() is used to deal a new card. It accepts an array parameter representing the hand of dealer or player
// printhand() is used to print a hand.  It accepts an array parameter representing the hand of dealer or player.
//       It also accepts a boolean parameter to indicate if only one card needs to be printed (in the case of the dealer)
// calculateScore() calculates the score of a hand.  It accepts an array parameter representing the hand of dealer or player.
//         It also accepts a boolean parameter to indicate that we only need to check the first two cards in a deck - we do
//         this to check if a player/dealer has blackjack.
//	       It returns an integer value
// finishDealersPlay() finishes the dealing of cards to player once the player decides to stand
// calculateWinnings() checks which hand has won.  It returns an integer value
// getCardValue() takes the value stored in deck for a card as a parameter and works out its value in blackjack.  
//         It returns an integer.
// finishGame() calls the calculateWinnings method and displays who is the winner based on the value returned from
//          calculateWinnings
// startNewGame() calls the setupGame method. It accepts the stake parameter.  After setup, the cards are checked to see if 
//           the dealer has a blackjack.  If not the playGame() method is called.  It finally calls finishGame passing 
//           it the stake amount

import java.util.Scanner;


public class Blackjack {
	// The variables of the Blackjack class are newDeck which is type DeckOfCards (DeckOfCards class).  The other two
	// are arrays used to hold the hands of the dealer and the player.  
	DeckOfCards newDeck = new DeckOfCards();
	   // this array represents the dealer's hand.  The maximum number of cards that can be in a hand is 11 ie. 4 x 1, 4 x 2 and 3 x 3
    int[] handDealer = new int[11];
     // this array represents the players's hand.  The maximum number of cards that can be in a hand is 11 ie. 4 x 1, 4 x 2 and 3 x 3
    int[] handPlayer = new int[11];
    // The variable to hold the financial balance of the game.  We declare it as static as we want to keep a running total
    // of balance while player continues to play.
    static double balance = 100 ;
  
    // default Blackjack (no argument) Constructor 
      Blackjack () {
    	initialiseHand(handDealer) ;
    	initialiseHand(handPlayer) ;
    	// Check if Blackjack for player i.e. if score = 21.
    }
  
      // Both hands are initialised with a number outside the range of the deck numbers so that later when we want to see 
      // at what index to enter a card, we can check to see if it is the initialisation number.  If we leave it at 0 
      // - the default for an int in an array, there is a problem as this is also an index used to reference a card
      // in deck    
    public void initialiseHand(int hand []) {
		for(int i=0; i<hand.length; i++) {
			hand[i] = 99 ;
		}
	} // initialiseHand method
    
    // Set up the game: perform a shuffle, "deal" 2 cards to both the dealer & player */
	public void setupNewGame() {
		newDeck.shuffle();
		// deal 2 cards to dealer and 2 to player.  The currentIndex in deck is incremented each time we draw.
		handDealer[0] = newDeck.drawCard() ;
		handDealer[1] = newDeck.drawCard() ;
		handPlayer[0] = newDeck.drawCard() ;
		handPlayer[1] = newDeck.drawCard() ;
	
	} // method setupNewGame
	
	// Deal another card to the player or dealer//
	public void hit(int hand[]) {
		newDeck.drawCard() ;
		for(int i=0;i<hand.length;i++) {
			// find the first element in which a card has not been stored
			if(hand[i]==99) {
				hand[i]=newDeck.getCurrentIndex() ;
				break ;
			} // if hand[i] == 99
		} // for int i=0
	} // hit method
	
	// Print the hand supplied as an int array to the console, e.g.:* 7 of Spades, Ace of Hearts, 3 of Diamonds
	// King of Clubs, 10 of Hearts.  I will also include a boolean parameter here which determines if only
	// the first card is shown.  This is the case for the dealer until the very end of the game - the dealer only
	// shows the first card.
	public void printHand(String whichHand, int hand[], boolean printFirstCardOnly) {
		  if(printFirstCardOnly) {
			  
			  System.out.print(whichHand) ;
			  System.out.println(newDeck.ranks[hand[0]%13] + " of " + newDeck.suits[hand[0]/13] + "; X") ; 
  
		  } // if(printFirstCardOnly
		  else {
			  System.out.print(whichHand) ;
				  for(int i=0;i<hand.length;i++) {
				  if(hand[i] != 99) {
					  System.out.print(newDeck.ranks[hand[i]%13] + " of " + newDeck.suits[hand[i]/13] + "; ") ; 
				  }
				  else {
					  break ;
				  } // else... if hand[i] !=99
			  } // for (int i=0
			  System.out.println();
		  } // else...if(printFirstCardOnly
	  } // printHand method
	
	// Expects an int array representing a blackjack hand as a	parameter.	* Returns the score from the 
	// card representation.  The boolean parameter searchForBlackJack is set to true when we only want to look at the first
	// 2 cards of a hand i.e. to see if it is a blackjack.  If it's false it will look through the entire hand
	 public int calculateScore(int hand[], boolean searchForBlackJack) {	  
		  int score = 0 ;
		  int noOfAces = 0 ;
		  int lengthToSearch = 0 ;
		  // searchForBlackJack used when we just want to check for a blackjack i.e. just look at the first 2 cards
		  if(searchForBlackJack) { 
			  lengthToSearch = 2 ;
		  } 
		  else {
			  lengthToSearch = hand.length ;
		  }
		  // get the value of cards except aces.  When we encounter an ace, just count the number of aces then
		  // at the end of the calculation, test the ace with the value of 11.  If it brings the score over 21, change it to 1.  
		  for(int i=0;i<lengthToSearch;i++) {
			  if(hand[i] != 99) {
				  if(hand[i]%13 == 0) {
					  noOfAces++ ;
				  } // if hand[i]%13
				  else {
					  score += getCardValue(hand[i]) ;
				  } // else...if hand[i]%13
			  } // if hand[i] != 99
			  else {
				  break ;
			  } // else... if hand[i] !=99	  
		  } // for int i=0
		  // test the score by adding the value of aces
		  for(int i=0;i<noOfAces;i++) {
			  if(score + 11 > 21 ) {
				  score += 1;
			  } // if score + 11
			  else {
				  score += 11 ;
			  } // else.... if score + 11
		  } // for int i=0
		  return score ;
	  } // calculateScore method

	
	 // Automates the dealer's play after the player stands. Dealer	 draws a new card until he has 17 or greater 
	 public void finishDealersPlay() {
			int score = calculateScore(handDealer,false) ;
			// Because the only cards played are those in the initialiseHand, I will set this variable noOfCards to 2.
			// This will be used to decide if the hand is a blackjack.
			while (score < 17) {
				hit(handDealer) ;
				score = calculateScore(handDealer, false) ;
			} // while score < 17
		} // finishDealersPay method 
	 
	 // Returns 1 if the player has won, -1 if the player has lost and 0 if it's a draw/push (both the player
	 // and the dealer have the same score). A player has won if:
	 // 1. His/her hand is <= 21 and his/her hand has a  higher score than the dealer
	 // 2. His/her hand is <= 21 and the dealers goes bust(i.e., the dealer's score is >21)
	 // 3. The player gets Blackjack (21) with two cards:  any 10 card and an Ace (except if the dealer also
	 //    has a blackjack)
	 //
	 //  Otherwise the dealer has won.
	 
	 public int calculateWinnings() {
		 int returnValue = 0 ;
		 int dealerScore = calculateScore(handDealer,false) ;
		 int playerScore = calculateScore(handPlayer,false) ;
		 // The first if statement is if player's score is under 21 and greater than dealer's score or 
		 // if player's score is less than or equal to 21 and dealer has gone bust (ie score > 21)
		 if ((playerScore <= 21 && playerScore > dealerScore) || (playerScore <=21 && dealerScore > 21)) {
			 returnValue = 1 ;
		 } // if(playerScore <= 21 && playerScore > dealerScore) || (playerScore <=21 && dealerScore > 21)
		 // If the players have an even score, then it is a push unless the player has a black jack, then
		 // that will beat the dealer.  But then if the dealer also has a blackjack, then it's considered
		 // even.
		 else {
			 if(playerScore == dealerScore) {
				 // Check if player has a blackjack by looking at his/her first two cards
				 if(calculateScore(handPlayer,true) == 21) { // this means Ace + 10 card in player's first hand
					 if(calculateScore(handDealer,true) ==21) { // this means they both have a blackjack, therefore push
						 returnValue=0;
					 } // if(calculateScore(handDealter,true==21)
					 else { // this means player has blackjack and dealer doesn't, therefore win for player
						 returnValue = 1;
					 }
				 } // if(calculateScore(handPlayer,true)==21)
				 else { // If the player hasn't a blackjack we have to check if the dealer has
					 if(calculateScore(handDealer,true) == 21) { // this means dealer has playjack and player doesn't, therefore lost
						 returnValue = -1 ;
					 } // if(calculateScore(handDealer,true)==21)
					 
					 else {	 // Neither player or dealer have blackjack but have equal scores, therefore, push
						 returnValue =0;
					 } //else...if(calculateScore(handDealer,true) == 21
				 } // else...if (calculateScore(handPlayer,true)==21
			 } // if(playerScore == dealerScore)
			 else {
				 returnValue = -1 ;
			 } // else .... if(playerScore == dealerScore) 
		 } // else .....if (playerScore <= 21 && playerScore > dealerScore) || (playerScore <=21 && dealerScore > 21)
		 return returnValue ;
	 } // method calculateWinnings
	 
	
	// method to return value of card
		public int getCardValue(int number) {
			int value = 0 ;
			switch (number % 13) {
			case 10:
				value = 10; break;
			case 11:
				value = 10; break;
			case 12:
				value= 10; break;
			default:
				value = (number%13 + 1); break;
			} // switch number % 13
			return value ;
		} // getCardValue method
		
		// method to finish the game
		
		public void finishGame(double stake) {
			// if the player has gone over 21 then the dealer does not have to show his cards at the end.  He only
			// has to show the first card.  We therefore send the parameter 'true' if the players score > 21 and
			// the parameter 'false' if <= 21 to the printHand method.
			printHand("Dealer's hand: ",handDealer, calculateScore(handPlayer,false)>21?true:false);
			printHand("Player's hand: ",handPlayer,false) ;

			switch (calculateWinnings()) {
			case 1:  System.out.println("Player Wins"); balance += stake; break ;
			case 0:  System.out.println("Push"); break ;
			case -1: System.out.println("House Wins"); balance-=stake; break ;
			} // switch
			System.out.printf("Balance is %.2f ",balance) ;

		} // finishGame method
		
		// method to play game
		public void playGame() {
		   	String hitOrStand="" ;
	    	do {
	    		printHand("Dealer's hand: ",handDealer,true) ;
	    		printHand("Player's hand: ",handPlayer,false) ;
	    		System.out.print("Do wish to Hit or Stay.  To Hit press 'h'.  To stand press 's':  " ) ;
	    		// keep asking for 'h' or 's' until valid data entry
	    		do {
	    			Scanner getInput = new Scanner(System.in);
	    			hitOrStand = getInput.next() ;
	    			if ( !hitOrStand.equalsIgnoreCase("s") && !hitOrStand.equalsIgnoreCase("h")) {
	    				System.out.println("ERROR - You must enter s or h ") ;
	    			} // if !hitOrStand
	    		} while (!hitOrStand.equalsIgnoreCase("s") && !hitOrStand.equalsIgnoreCase("h")) ;
	    
	    
	    		if(hitOrStand.equalsIgnoreCase("s")){
	    			finishDealersPlay() ;
	    		} // if hitOrStand
	    		else {
	    			hit(handPlayer) ;
	    		} // else.... if hitOrStand
	    	} while(hitOrStand.equalsIgnoreCase("h") && calculateScore(handPlayer,false) < 21) ;
		} // method playGame
	
		// this method starts a new game.  Tt receives a parameter of stake which is the stake for each game
		public void startNewGame(double stake) {
			setupNewGame();
			// If the player has a blackjack after setting up the game, then we don't go ahead with the
			// normal playing of the game, we go straight to finishGame()
			if(calculateScore(handPlayer,true)!=21) {
				playGame();
			} // if calculateScore
			    finishGame(stake);
		} // startNewGame method

} // Blackjack class
