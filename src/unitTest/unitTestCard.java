package unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import playingCards.Card;

public class unitTestCard
{
	//+++++++++++++ positive test cases +++++++++++++++++++++++++++++++++
	@Test //2 of diamonds card creation
	public void test1() {positiveTest("Diamonds", "2", 2, 1, 1);}
	
	@Test // 4 of clubs card creation
	public void test2() {positiveTest("Clubs", "4", 4, 2, 1);}
	
	@Test // King of Spades card creation
	public void test3() {positiveTest("Spades", "King", 13, 3, 1);}
	
	@Test //Queen of Hearts card creation
	public void test4() {positiveTest("Hearts", "Queen", 12, 4, 2);}
	
	//+++++++++++++ positive test cases end +++++++++++++++++++++++++++++++++
	
	//------------- negative test cases -------------------------------------
	
	@Test //3 of diamonds with wrong spelling
	public void test5() {negativeTest("diamonds", "3", 3, 5, 1);}
	
	@Test // 5 of clubs wrong card name
	public void test6() {negativeTest("Clubs", "Face", 5, 6, 1);}
	
	@Test // Jack of Spades wrong card value
	public void test7() {negativeTest("Spades", "Jack", 14, 7, 1);}
	
	@Test //Ace of Hearts wrong card value
	public void test8() {negativeTest("Hearts", "Ace", 0, 8, 2);}
	
	@Test //6 of diamonds wrong card value
	public void test9() {negativeTest("Diamonds", "6", -3, 9, 3);}
	
	@Test // 7 of clubs wrong cardSequenceNumber
	public void test10() {negativeTest("Clubs", "7", 7, 0, 4);}
	
	@Test // 8 of Spades wrong cardSequenceNumber
	public void test11() {negativeTest("Spades", "8", 8, -5, 5);}
	
	@Test //9 of Hearts wrong deck number
	public void test12() {negativeTest("Hearts", "9", 9, 12, 0);}
	
	@Test //10 of Hearts wrong deck number 
	public void test13() {negativeTest("Hearts", "10", 10, 12, -8);}
	
	@Test // 8 of Spades card multiple arguments failure 
	public void test14() {negativeTest("spades", "1 0", 15, -5, 5);}
	
	//------------- negative test cases end ---------------------------------

	//positive test common method
	public void positiveTest(String suite, String cardName, int cardValue, int cardSequenceNumber, int deckNumber) {
		Card card = new Card (suite, cardName, cardValue, cardSequenceNumber, deckNumber);
		assertEquals(suite, card.getSuite());
		assertEquals(cardName, card.getCardName());
		assertEquals(cardValue, card.getCardValue());
		assertEquals(cardSequenceNumber, card.getCardSequenceNumber());
		assertEquals(deckNumber, card.getDeckNumber());
		System.out.println(card);
	}
	
	public void negativeTest(String suite, String cardName, int cardValue, int cardSequenceNumber, int deckNumber) {
		Card card = new Card (suite, cardName, cardValue, cardSequenceNumber, deckNumber);
		assertEquals(null, card.getSuite());
		assertEquals(null, card.getCardName());
		assertEquals(0, card.getCardValue());
		assertEquals(0, card.getCardSequenceNumber());
		assertEquals(0, card.getDeckNumber());
		System.out.println("~~~~~~~~ Failed test case ~~~~~~~~~~~~~~");
		System.out.println(card);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

}//end of unitTestCard
