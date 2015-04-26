package unitTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import playingCards.Card;
import playingCards.DeckPile;

public class unitTestDeck<completedTestDeck>
{
	public int numOfDeckTested = 2;
	public int cardsInDeck = DeckPile.getCardsInDeck();
	public ArrayList<Card> completedTestDeck = createTestDeck (numOfDeckTested);
	
	@Test public void test1SuiteValidation()
	{	
		for (int i = 0; i < completedTestDeck.size(); i++)
		{assertEquals(true, testSuiteValue(completedTestDeck.get(i).getSuite()));}
	}
	
	@Test public void test2CardNameValidation()
	{	
		for (int i = 0; i < completedTestDeck.size(); i++)
        {assertEquals(true, testCardNameValidation(completedTestDeck.get(i).getCardName()));}
	}
	
	@Test public void test3CardValueValidation()
	{	
		for (int i = 0; i < completedTestDeck.size(); i++)
        {assertEquals(true, testCardValueValidation(completedTestDeck.get(i).getCardValue()));}
	}
	
	@Test public void test4CardSequenceNumber()
	{	
		for (int i = 0; i < completedTestDeck.size(); i++)
        {assertEquals(true, testCardSequenceNumber(completedTestDeck.get(i).getCardSequenceNumber()));}
	}
	@Test public void test5DeckNumber()
	{	
		for (int i = 0; i < numOfDeckTested; i++)
        {System.out.println(i+" "+completedTestDeck.get(i).getDeckNumber());
		assertEquals(true, testDeckNumber(completedTestDeck.get(i).getDeckNumber()));}
	}


	public ArrayList<Card> createTestDeck (int numberOfDeck) {
		DeckPile deckTest = new DeckPile();
		ArrayList<Card> completedDeck = deckTest.createDeck(numberOfDeck);
		return completedDeck;
	}
	
	public boolean testSuiteValue (String SuiteValue) {
		String [] suiteTest = {"Spades","Clubs","Hearts","Diamonds","Joker"};
		for (int i = 0; i < suiteTest.length; i++)
        {if (SuiteValue.equals(suiteTest[i])) return true;}
		return false;
	}
	
	public boolean testCardNameValidation (String cardName) {
		String [] cardNameTest = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King","Joker"};
		for (int i = 0; i < cardNameTest.length; i++)
        {if (cardName.equals(cardNameTest[i])) return true; }
		return false;
	}
	
	public boolean testCardValueValidation (int cardValue) 
	{ 
		if ((cardValue>1 & cardValue < 11) || cardValue == 0 ) return true; 
		return false;
	}
	
	public boolean testCardSequenceNumber (int cardSequenceNumber) 
	{ 
		if ((cardSequenceNumber>0) & (cardSequenceNumber <= (cardsInDeck*numOfDeckTested))) return true; 
		return false;
	}
	
	public boolean testDeckNumber (int deckNumber) 
	{ 
		if ((deckNumber>0) & (deckNumber <= (numOfDeckTested))) return true; 
		return false;
	}

}//end of class
