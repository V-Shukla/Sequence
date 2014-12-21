package Sequence;
/**
 *
 */

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

	/**
	 * @param args
	 */
	 @SuppressWarnings("static-access")
	public static void main(String[] args) {

		 // final String printValues =
		 // "Draw is %d, i is %d, player%dHoldings[%d] is %d\n";
		 PlayerHolding player1 = new PlayerHolding();
		 PlayerHolding player2 = new PlayerHolding();

		 for (int i = 0; i < totalCard; i++) {
			 out.println("--------------------------------------------------");
			 draw = DrawCard.DrawCard(totalCard, allPlayerHoldings);//

			 while(pause){
				 try {Thread.sleep(500);} catch (InterruptedException e) {break;};
			 }//end while pause loop                                                
			 pause=true;

			 out.println("allPlayerHoldings" + allPlayerHoldings);
			 player1Holdings = (player1.Player_Holding(draw, player1Holdings));
			 out.println("player1Holdings" + player1Holdings);
			 winner = (CheckWinning.checkForWinner(player1Holdings));
			 if (winner == true) {
				 out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				 out.println("!!!!!!!!!!!!!!!!!!!Player1 wins!!!!!!!!!!!!!!!!!!!!!!!!!!");
				 out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				 break;
			 }
			 out.println("*********************");
			 draw = DrawCard.DrawCard(totalCard, allPlayerHoldings);

			 while(pause){
				 try {Thread.sleep(500);} catch (InterruptedException e) {break;};
			 }//end while pause loop   
			 pause=true;

			 out.println("allPlayerHoldings" + allPlayerHoldings);
			 player2Holdings = (player2.Player_Holding(draw, player2Holdings));
			 out.println("player2Holdings" + player2Holdings);
			 out.println("--------------------------------------------------");
			 winner = (CheckWinning.checkForWinner(player2Holdings));
			 if (winner == true) {
				 out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				 out.println("!!!!!!!!!!!!!!!!!!!Player2 wins!!!!!!!!!!!!!!!!!!!!!!!!!!");
				 out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				 break;
			 }

			 if (winner == false && i == 25) {
				 out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				 out.println("!!!!!!!!!!!!!!!!!!!Noone wins!!!!!!!!!!!!!!!!!!!!!!!!!!");
				 out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				 break;
			 }//end if for no one wins
		 }// end for loop
	 }// end main method
}// end class