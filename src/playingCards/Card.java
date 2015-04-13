/**
 * This class represents a single playing card
 * 
 * 
 */
package playingCards;

/**
 * @author vihar
 *
 */
public class Card {
	
	//Static method to create object only if it meets the standards
	
	private static boolean validateArguments(String suite, String cardName, int cardValue, int cardSequenceNumber, int deckNumber)
	{
		
		boolean suiteValidation = false;
		boolean cardNameValidate = false;
		boolean cardValueValidate = false;
		boolean cardSequenceNumberValidate = false;
		boolean deckNumberValidate = false;
		
		//validate suite input
		suiteValidation = false;
		switch (suite) {
		case "Spades":case "Clubs":case "Hearts":case "Diamonds": suiteValidation = true;
			break;
		default:suiteValidation = false;
				System.out.println("You entered wrong suite name! Suite name has not been set.");
				System.out.println("Valid suite names are [Spades] [Clubs] [Hearts] [Diamonds]");
			break;
		}//end switch statement
		
		//validate cardName input
		cardNameValidate =false;
		switch (cardName)
        {
		case "Ace": case "2": case "3":case "4":case "5":case "6": case "7": case "8": 
		case "9": case "10": case "Jack": case "Queen": case "King": case "Joker": 
			cardNameValidate = true;
			break;
		default:cardNameValidate = false;
			System.out.println("You entered wrong Card name! Card name has not been set.");
			System.out.println("Valid suite names are [Ace] [1-10] [Jack] [Queen] [King]");
			break;
		}
		
		//validate cardValue input
		cardValueValidate =false;
		if(cardValue > 0 && cardValue<14) cardValueValidate = true;
		else {cardValueValidate = false;System.out.println("You entered wrong Card Value! Card value must be inbetween 1 to 13");}
		
		//validate cardSequenceNumber input
		cardSequenceNumberValidate =false;
		if(cardSequenceNumber > 0) cardSequenceNumberValidate = true;
		else {cardSequenceNumberValidate =false;System.out.println("You entered wrong cardSequenceNumber!");}
		
		//validate deckNumberValidate input
		deckNumberValidate =false;
		if(deckNumber > 0) deckNumberValidate = true;
		else {deckNumberValidate =false;System.out.println("You entered wrong deckSequenceNumber!");}
				
		 return (suiteValidation && cardNameValidate && cardValueValidate && cardSequenceNumberValidate && deckNumberValidate);

	}
	
	//constructor
	public Card(String suite, String cardName, int cardValue, int cardSequenceNumber, int deckNumber) 
	{
		super();
		if (validateArguments(suite, cardName, cardValue, cardSequenceNumber, deckNumber))
		{
		this.suite = suite;
		this.cardName = cardName;
		this.cardValue = cardValue;
		this.deckNumber = deckNumber;
		this.cardSequenceNumber = cardSequenceNumber;
		} else {
			System.out.println("****************Error********************");
			System.out.println("Card not created due to Invalid input !!");
			System.out.println("******************************************");
		}
	}//end constructor
	
	//variable declarations
	private String suite, cardName;
	private int cardValue, deckNumber, cardSequenceNumber;
	
	//getters and no setters
	public String getSuite() {
		return suite;
	}
	public String getCardName() {
		return cardName;
	}
	public int getCardValue() {
		return cardValue;
	}
	public int getDeckNumber() {
		return deckNumber;
	}
	public int getCardSequenceNumber() {
		return cardSequenceNumber;
	}

	//toString
	@Override
	public String toString() {
		return "Card [suite=" + suite + ", cardName=" + cardName
				+ ", cardValue=" + cardValue + ", deckNumber=" + deckNumber
				+ ", cardSequenceNumber=" + cardSequenceNumber + "]";
	} 
	
	

}
