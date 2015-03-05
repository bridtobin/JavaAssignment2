// Created by Brid Delap on 23/11/13.  
// Assignment 2.  Question 4.
// The DeckOfCards class is instantiated by the Blackjack class for Q4. It has 4 variables - an array to hold all the cards;
// an array to hold the four suits; an array to hold the face value of each card in a suit; currentIndex which holds the current card
// or the card on the top of the deck
// Its default constructor initialises a deck of cards with 52 cards. 
// It has two methods - drawCard and Shuffle
public class DeckOfCards {
    // this array represents the deck of cards
	int[] deck = new int[52];
    String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9","10", "Jack", "Queen", "King"};
    int currentIndex = 0;
    
    // Constructor DeckOfCards - Initialises deck of cards
    DeckOfCards() {
  	   currentIndex = 0 ;
       for (int i = 0; i < deck.length; i++) {
          deck[i] = i;
        } // for (int i = 0  
     } // Deck of Cards constructor
   
    // draw the top card from the deck and increment currentIndex to point at the next card.
    int drawCard() {
    	int drawCard = deck[currentIndex] ;
     	currentIndex ++ ;
       	return drawCard ;
    }
    
    void shuffle() {
 	   // Shuffle the cards
 	    for (int i = 0; i < deck.length; i++) {
 	      // Generate an index randomly
 	      int index = (int)(Math.random() * deck.length);
 	      int temp = deck[i];
 	      deck[i] = deck[index]; 
 	      deck[index] = temp;
 	    }	  
   } // method shuffle
    
    int getCurrentIndex() {
    	return currentIndex ;
    } // method getCurrentIndex
      
    
 
} // class DeckOfCards

