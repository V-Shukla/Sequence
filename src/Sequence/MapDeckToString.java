/**
 * 
 */
package Sequence;
import static java.lang.System.out;

import java.util.*;
/**
 * @author vihar
 *
 */
public class MapDeckToString {
	public static HashMap<Integer, String> intDeckToString = new HashMap<Integer, String>();
	public final static int maxCardinDeck = 52;
	/**
	 * @param args
	 */
	MapDeckToString () {
		// TODO Auto-generated method stub
				
				String allocateString;
		      // Create a hash map
		      
		      
		      // Put elements to the map
		      
		      for (int i=0; i<=maxCardinDeck; i++){
		    	  
		    	  int suiteLength = maxCardinDeck/4;
		    	  
		    	  //define numbers of the cards in string
		    	  if (i==0){allocateString = "Joker";}
		    	  else if (i%suiteLength==1){allocateString = "Ace of ";}
		    	  else if (i%suiteLength==11){allocateString = "Jack of ";}
		    	  else if (i%suiteLength==12){allocateString = "Queen of ";}
		    	  else if (i%suiteLength==0){allocateString = "King of ";}
		    	  else {allocateString = (i%suiteLength)+" of ";}
		    	  
		    	  //define suites of the cards
		    	  if (i==0){allocateString = "Joker";}
		    	  else if (i<= suiteLength){allocateString += "Spades";}
		    	  else if (i<= (2*suiteLength) && i>suiteLength){intDeckToString.put(i, allocateString += "Hearts");}
		    	  else if (i<= (3*suiteLength) && i>(2*suiteLength)){intDeckToString.put(i, allocateString += "Clubs");}
		    	  else if (i<= maxCardinDeck && i>(3*suiteLength)){intDeckToString.put(i, allocateString += "Diamonds");}
		    	  else {System.out.println("ERROR : Cards can not exceed 52");}
		    	  
		    	  intDeckToString.put(i, allocateString);
		    	  
		      }//end for loop
		      
//		      for (int i=0; i<=maxCardinDeck; i++){System.out.println("i is = " +i+" hashvalue of i = "+intDeckToString.get(i));}//end for loop
		      for (int i=0; i<=maxCardinDeck; i++){System.out.println("i is = " +i+" hashvalue of i = "+StringReturnFromIntCard (i));}//end for loop

	}//end main method
	
		//--------------------------------------------------------------------------------------------------------------
		//return String for the integer value of the card
		//--------------------------------------------------------------------------------------------------------------
		public static String StringReturnFromIntCard (int intCardValue){
			return intDeckToString.get(intCardValue);
		}//end PlayerTurn
	
	
}//end class
