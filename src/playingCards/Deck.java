/**
 * 
 */
package playingCards;

/**
 * @author vihar
 *
 */


public class Deck
{
	private static int cardSequenceNumber = 0;
	private int cardsInDeck = 54;
	
	//deck constructor
	private Card[] createSingleDeck()
    {
	    
	    String [] suite = {"Spades","Clubs","Hearts","Diamonds"};
	    String [] cardName = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
	    int [] cardValue = {10,2,3,4,5,6,7,8,9,10,10,10,10}; 
	    Card card[] = new Card[cardsInDeck];
	    
	    for (int i = 0; i < suite.length; i++)
        {
	    	for (int j = 0; j < cardName.length; j++)
		    {
		    	card[cardSequenceNumber]=new Card(suite[i], cardName[j], cardValue[j], ++cardSequenceNumber , 0);
		    }//loop to create 13 cards
	        
        }//loop to create 4 suites
		return card;
	    
    }// end deck creation method
	
	public Deck(int numberOfDeck)
	{
		for (int i = 0; i < numberOfDeck; i++)
        {
			createSingleDeck();
        }
		

	}
	
	

}//end class
