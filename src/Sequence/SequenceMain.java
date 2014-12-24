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
	public static int totalCard = 53;
	public static int draw;
	private static boolean winner;
	public static boolean pause=true;
	public static List<Integer> allPlayerHoldings = new ArrayList<Integer>();

	public static void main(String[] args) {
		String player1 = "Player 1";
		String player2 = "Player 2";
		
		for (int i = 0; i < totalCard; i++) {
			out.println("--------------------------------------------------");
			out.println("--------------- Iteration "+(i+1)+" ----------------------");
			out.println("--------------------------------------------------");
			out.println("*********************"+player1+"******************");
			
			player1Holdings=SequenceMain.PlayerTurn(player1,player1Holdings);
			if (winner == true) {break;}
			
			out.println("*********************"+player2+"******************");

			player2Holdings=SequenceMain.PlayerTurn(player2,player2Holdings);
			//out.println("--------------------------------------------------");			 
			if (winner == true) {break;}

			if (winner == false && i == 25) {
				out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				out.println("!!!!!!!!!!!!!!!!!!!Noone wins!!!!!!!!!!!!!!!!!!!!!!!!!!");
				out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				break;
			}//end if for no one wins
		}// end for loop
	}// end main method

//player turn method to execute turn of each player
	public static List<Integer> PlayerTurn (String playerName, List<Integer> playerHoldings){
		
		//draw and add the card to allPlayerHolding
		draw = DrawCard.DrawCard(totalCard, allPlayerHoldings, playerHoldings,playerName);
		out.println("allPlayerHoldings" + allPlayerHoldings);
		
		//add the draw to current player
		playerHoldings = (PlayerHolding.Player_Holding(draw, playerHoldings));
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