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
	    
	    for (int k = 0; k < numberOfDeck; k++)
        {
		    for (int i = 0; i < suite.length; i++)
	        {
		    	for (int j = 0; j < cardName.length; j++)
			    {
			    	card.add(new Card(suite[i], cardName[j], cardValue[j], ++cardSequenceNumber , ++k));
			    }//loop to create 13 cards
		        
	        }//loop to create 4 suites
	        
        }//loop to create multiple decks
	    
	    //add jokers
	    
		return card;
	    
    }// end deck creation method
	
	//create a method to use above method
	
}//end class
