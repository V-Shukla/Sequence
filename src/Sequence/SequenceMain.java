package Sequence;
import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;



/**
 * @author vihar
 *
 */
public class SequenceMain {

	public static List<Integer> player1Holdings = new ArrayList<Integer>();
	public static List<Integer> player2Holdings = new ArrayList<Integer>();
	public static List<Integer> player3Holdings = new ArrayList<Integer>();
	public static int totalCard = 52, numberOfPlayers = 2; 
	public static int drawnCard,cardsLeft4Drawing=totalCard;
	private static boolean winner=false;
	public static List<Integer> allPlayerHoldings = new ArrayList<Integer>();

	public static void main(String[] args) {
		String player1 = "Player 1";
		String player2 = "Player 2";
		int finalIteration = totalCard/numberOfPlayers;

		for (int i = 1; i < finalIteration+1; i++) {
			out.println("--------------------------------------------------");
			out.println("--------------- Iteration "+(i)+" ----------------------");
			out.println("--------------------------------------------------");
			out.println("*********************"+player1+"******************");

			player1Holdings=SequenceMain.PlayerTurn(player1,player1Holdings);
			if (winner == true) {break;}

			out.println("*********************"+player2+"******************");

			player2Holdings=SequenceMain.PlayerTurn(player2,player2Holdings);
			//out.println("--------------------------------------------------");			 
			if (winner == true) {break;}

			if ((cardsLeft4Drawing==0)){  //||(winner == false && i == finalIteration)) {
				break;
			}//end if for no one wins after all iterations or no cards are left for drawing
		}// end for loop

		if (winner == false) {
			out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			out.println("!!!!!!!!!!!!!!!!!!!Noone wins!!!!!!!!!!!!!!!!!!!!!!!!!!");
			out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}//end if for no one wins after all iterations redundancy

	}// end main method

	//player turn method to execute turn of each player
	public static List<Integer> PlayerTurn (String playerName, List<Integer> playerHoldings){

		//draw and add the card to allPlayerHolding
		drawnCard = DrawCard.DrawCard(totalCard, allPlayerHoldings, playerHoldings,playerName);
		cardsLeft4Drawing--;
		out.println("allPlayerHoldings" + allPlayerHoldings+"cardsLeft4Drawing"+cardsLeft4Drawing);

		//add the draw to current player
		playerHoldings = (PlayerHolding.Player_Holding(drawnCard, playerHoldings));
		out.println("playerHoldings" + playerHoldings);

		winner = (CheckWinning.checkForWinner(playerHoldings));
		if (winner == true) {
			out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			out.println("!!!!!!!!!!!!!!!!!!! "+playerName+" wins!!!!!!!!!!!!!!!!!!!!!!!!!");
			out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		return playerHoldings;
	}//end PlayerHolding
}// end class