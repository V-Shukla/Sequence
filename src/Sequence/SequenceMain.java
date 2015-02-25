package Sequence;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import static java.lang.System.out;

/**
 * @author vihar
 *
 */
public class SequenceMain {

	public static List<Integer> player1Holdings = new ArrayList<Integer>();
	public static List<Integer> player2Holdings = new ArrayList<Integer>();
	public static List<Integer> player3Holdings = new ArrayList<Integer>();
	public static final int totalCard = 30;//52;
	public static int numberOfPlayers = 2; 
	public static int cardsLeft4Drawing=totalCard;
	public static int drawnCard[]=new int[2];
	private static boolean winner=false,acceptName=false;
	public static List<Integer> allPlayerHoldings = new ArrayList<Integer>();
	public static String player1 = null, player2 = null, player3 = "player3 ";

	public static void main(String[] args) {


		String playerOne = getPlayerName.PlayerName("Player1");
		final String player1 = playerOne;
//		while (player1 == null) {}
		
		String playerTwo = getPlayerName.PlayerName("Player2");
//		while (playerTwo == null) {}
		final String player2 = playerTwo;
		

		
		out.println("player1 "+player1);
		out.println("player2 "+player2);
		
		int finalIteration = totalCard/numberOfPlayers;
		//use for setting up initial cards
		for (int i = 1; i < 14; i++) {
			out.println("inside for loop "+player2);
			
			out.println("********************* "+player1+" ******************");
			player1Holdings=SequenceMain.PlayerInitialSetup(player1, player1Holdings);
			if (winner == true) {break;}
			
			out.println("inside for loop after player2 "+player2);
			out.println("********************* "+player2+" ******************");
			player2Holdings=SequenceMain.PlayerInitialSetup(player2,player2Holdings);
			//out.println("--------------------------------------------------");			 
			if (winner == true) {break;}

			if ((cardsLeft4Drawing==0)){  //||(winner == false && i == finalIteration)) {
				break;
			}//end if for no one wins after all iterations or no cards are left for drawing
		}// end for loop
		
		out.println("--------------------------------------------------");
		out.println("--------------- Initial 13 cards distributed ---------------");
		out.println("--------------------------------------------------");
		
		
		//use for player turns -13+1 for initial card distribution
		if (winner == false) {
		for (int i = 1; i < finalIteration-12; i++) {
			out.println("--------------------------------------------------");
			out.println("--------------- Iteration "+(i)+" ----------------------");
			out.println("--------------------------------------------------");
			out.println("*********************"+player1+"******************");

			player1Holdings=PlayerTurn(player1,player1Holdings);
			if (winner == true) {break;}

			out.println("*********************"+player2+"******************");

			player2Holdings=PlayerTurn(player2,player2Holdings);
			//out.println("--------------------------------------------------");			 
			if (winner == true) {break;}

			if ((cardsLeft4Drawing==0)){  //||(winner == false && i == finalIteration)) {
				break;
			}//end if for no one wins after all iterations or no cards are left for drawing
		}// end for loop
		}//end of winner if statement

		if (winner == false) {
			out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			out.println("!!!!!!!!!!!!!!!!!!!Noone wins!!!!!!!!!!!!!!!!!!!!!!!!!!");
			out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}//end if for no one wins after all iterations redundancy

	}// end main method

	
	//--------------------------------------------------------------------------------------------------------------
	//player turn method to execute turn of each player
	//--------------------------------------------------------------------------------------------------------------
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
			WinnerDisplay (playerName);
			out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			out.println("!!!!!!!!!!!!!!!!!!! "+playerName+" wins!!!!!!!!!!!!!!!!!!!!!!!!!");
			out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		return playerHoldings;
	}//end PlayerTurn
	
	//--------------------------------------------------------------------------------------------------------------
	//Initial card distribution method
	//--------------------------------------------------------------------------------------------------------------
	public static List<Integer> PlayerInitialSetup(String playerName, List<Integer> playerHoldings){
		out.println("inside initialSetup method "+player2);
		//draw and add the card to allPlayerHolding
		drawnCard = DrawCard.buttonDrawCard(totalCard, allPlayerHoldings); 
		out.println("drawnCard[0] "+drawnCard[0]);
		out.println("drawnCard[1] "+drawnCard[1]);
		out.println("after drawncard "+player2);
		out.println("p3 "+player3);
		player2="player2";
		cardsLeft4Drawing--;
		out.println("allPlayerHoldings" + allPlayerHoldings+"cardsLeft4Drawing"+cardsLeft4Drawing);
		
		//add the draw to current player
		playerHoldings = (PlayerHolding.Player_Initial_Holding(drawnCard, playerHoldings));
		out.println("playerHoldings" + playerHoldings);
		out.println("after updating playerholding "+player2);
		winner = (CheckWinning.checkForWinner(playerHoldings));
		if (winner == true) {
			WinnerDisplay (playerName);
			out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			out.println("!!!!!!!!!!!!!!!!!!! "+playerName+" wins!!!!!!!!!!!!!!!!!!!!!!!!!");
			out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}//end if statement
		
		out.println("ending initialSetup method "+player2);

		return playerHoldings;
	}//end PlayerTurn
	
		//--------------------------------------------------------------------------------------------------------------
		//Winner Display method
		//--------------------------------------------------------------------------------------------------------------
		public static void WinnerDisplay (String playerName){
			
			JFrame winnerFrame = new JFrame(" We have a winner!!");
			winnerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JLabel playerWins = new JLabel(playerName+" has won!!",SwingConstants.CENTER);
			JLabel gameEnds = new JLabel("Game ends here!!",SwingConstants.CENTER);
			JLabel playAnotherone = new JLabel("Try playing another one!!",SwingConstants.CENTER);
			
			winnerFrame.add(playerWins);
			winnerFrame.add(gameEnds);
			winnerFrame.add(playAnotherone);

			//winnerFrame.getContentPane().add(panel);
			winnerFrame.setSize(500, 200);
			winnerFrame.setLocationRelativeTo(null);  
			winnerFrame.setLayout(new GridLayout(3,1));
			//winnerFrame.pack();
			winnerFrame.setVisible(true);
			
		}//end Winner Display
	
}// end class