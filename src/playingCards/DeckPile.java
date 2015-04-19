/**
 * 
 */
package playingCards;

import java.util.ArrayList;

/**
 * @author vihar
 *
 */


public class DeckPile
{
	private static int cardSequenceNumber = 0;
	private static int cardsInDeck = 54;

	public static int getCardsInDeck()
	{
		return cardsInDeck;
	}


	//deck constructor
	public ArrayList<Card> createDeck(int numOfDeck)
	{
		if (numOfDeck < 11) return createClosedCardPile(numOfDeck);
		else {System.out.println("Can not create more then 10 decks");return null;}
	}


	private ArrayList<Card> createClosedCardPile(int numberOfDeck)
	{

		String [] suite = {"Spades","Clubs","Hearts","Diamonds"};
		String [] cardName = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
		int [] cardValue = {10,2,3,4,5,6,7,8,9,10,10,10,10}; 
		int deckNumber = 0;
		//	    Card card[] = new Card[numberOfDeck*cardsInDeck];
		ArrayList<Card> deck = new ArrayList<Card>(numberOfDeck*cardsInDeck);

		for (int i = 0; i < numberOfDeck; i++)
		{
			deckNumber = i+1;
//			System.out.println(i+" "+deckNumber);
			for (int j = 0; j < suite.length; j++)
			{
				for (int k = 0; k < cardName.length; k++)
				{
					deck.add(new Card(suite[j], cardName[k], cardValue[k], ++cardSequenceNumber , deckNumber));
//					System.out.println("Card Created "+suite[j]+" "+ cardName[k]+" "+ cardValue[k]+" "+ cardSequenceNumber +" "+ deckNumber);

				}//loop to create 13 cards

			}//loop to create 4 suites

		}//loop to create multiple decks

		for (int i = 0; i < numberOfDeck; i++)
		{
			deck.add(new Card("Joker", "Joker", 0, ++cardSequenceNumber , deckNumber));
//			System.out.println("Card Created "+"Joker"+" "+ "Joker"+" "+ 0+" "+ cardSequenceNumber +" "+ deckNumber);
			deck.add(new Card("Joker", "Joker", 0, ++cardSequenceNumber , deckNumber));
//			System.out.println("Card Created "+"Joker"+" "+ "Joker"+" "+ 0+" "+ cardSequenceNumber +" "+ deckNumber);
		}//loop to create multiple decks

		//add jokers
		return deck;

	}// end deck creation method

}//end class
