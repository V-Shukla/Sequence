/**
 * 
 */
package playingCards;

import java.util.ArrayList;

/**
 * @author vihar
 *
 */


public class Deck
{
	private static int cardSequenceNumber = 0;
	private int cardsInDeck = 54;
	
	//deck constructor
	@SuppressWarnings("unused")
    private ArrayList<Card> createClosedCardPile(int numberOfDeck)
    {
	    
	    String [] suite = {"Spades","Clubs","Hearts","Diamonds"};
	    String [] cardName = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
	    int [] cardValue = {10,2,3,4,5,6,7,8,9,10,10,10,10}; 
//	    Card card[] = new Card[numberOfDeck*cardsInDeck];
	    ArrayList<Card> card = new ArrayList<Card>(numberOfDeck*cardsInDeck);
	    
	    for (int i = 0; i < numberOfDeck; i++)
        {
		    for (int j = 0; j < suite.length; j++)
	        {
		    	for (int k = 0; k < cardName.length; k++)
			    {
			    	card.add(new Card(suite[j], cardName[k], cardValue[k], ++cardSequenceNumber , ++i));
			    }//loop to create 13 cards
		        
	        }//loop to create 4 suites
	        
        }//loop to create multiple decks
	    
	    //add jokers
	    
		return card;
	    
    }// end deck creation method
	
	//create a method to use above method
	
}//end class
