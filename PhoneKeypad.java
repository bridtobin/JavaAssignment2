// Created by Brid Delap on 13/11/13.  
// Assignment 1.  Question 1.
// I created the PhoneKeypad class to use with Question 1.


public class PhoneKeypad {
	// The object PhoneKeypad is made of the following arrays.
	int [] numberPad = {1,2,3,4,5,6,7,8,9,0} ;
	String [] characterPad = {"1","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ","0"} ;
	
	PhoneKeypad() {
	} // phoneKeypad constructor

    // This method returns an actual number. The input parameter is a string (which is converted to
	// uppercase as our numbers are stored in uppercase in the character array). The string can be made up of
	// letters, numbers and non-alphanumeric characters.  This method converts the letters to numbers and
	// leaves all other characters intact
   public StringBuilder getActualNumber(String keypadInput) {
    	 // Convert the string to uppercase
    	 keypadInput = keypadInput.toUpperCase() ;
    	 StringBuilder stringOutput = new StringBuilder() ;
    	 int keypadInputLength = keypadInput.length() ;
    	 // use a for loop to loop through string, one character at a time
    	 for(int i = 0; i<keypadInputLength;i++) {
    		 if(Character.isLetter(keypadInput.charAt(i)))  {
    			 // if a character is a letter we call getNumber method
     			 stringOutput.append(getNumber(keypadInput.charAt(i)) );
    		 } // if Character.isLetter
    		 else {
    			 stringOutput.append(keypadInput.charAt(i)) ;
    		 } // else...if(Character
    	 } // for int i=0
     	 return stringOutput ;
     } // method getNumber

    // this method takes a character (which will be an uppercase letter and converts it to
   // a number by comparing its value with the number arrray
	public int getNumber(char charInput) {
		int number = 0 ;
		for(int i = 0; i < characterPad.length; i++) {	
			if(characterPad[i].indexOf(charInput) != -1) {
				number = (numberPad[i])  ;
				break ;
			} // if(characterPad[i]
		} // for(int i=0
		return number ;
	} // getNumber method

} // class phoneKeypad


