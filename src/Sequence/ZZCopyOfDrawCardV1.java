package Sequence;
import java.util.List;
import java.util.Random;

import javax.swing.*;

import Sequence.SequenceMain;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//this class will hold draw method which randomly draws a number from 1-52
public class ZZCopyOfDrawCardV1 {

	private static int holdingNumber;
	static int cardThrownbyPlayer, tempDrawHold, drawCurrent,topOfDiscardPile=500;
	protected static List<Integer> aph,ph;
	protected static int totalCardstoDrawFrom;
	static boolean drawPause = true;
	static String pn;

	public static int DrawCard(int Number, List<Integer> allPlayerHoldings, List<Integer> playerHoldings, String playerName) {
		totalCardstoDrawFrom = Number;
		aph= allPlayerHoldings;
		ph=playerHoldings;
		pn=playerName;
		
		//Figure out the top card on the discard pile
		if (allPlayerHoldings.size()>1){
		//topOfDiscardPile=500; //cardThrownbyPlayer;//playerHoldings.get(playerHoldings.size()-1);
		topOfDiscardPile++;
		}else{
			//topOfDiscardPile=1000;
			System.out.println("You are not allowed to pick a discarded card yet!!");
		}
	
		//create window for player to choose either to pick or draw
		//Buttons in GUI will carry out appropriate actions
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});

		//wait for response from player's button
		while(drawPause){
			try {Thread.sleep(500);} catch (InterruptedException e) {break;};
		}//end while loop
		drawPause=true;
		System.out.println("Card drawn was "+drawCurrent+" !!!");
		return drawCurrent; // returned either new draw or card thrown by the player
	}//end draw card

	public static void createAndShowGUI()  {

		final JFrame frame1 = new JFrame(pn + " Turn");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel2 = new JPanel();
		frame1.add(panel2, BorderLayout.EAST);
		JLabel myText = new JLabel("Your current holdings are "+ph+".",SwingConstants.CENTER);
		panel2.add(myText);		

		JPanel panel3 = new JPanel();
		frame1.add(panel3, BorderLayout.WEST);
		JLabel myText2 = new JLabel("What would you like to do?",SwingConstants.CENTER);
		panel3.add(myText2);

		frame1.setLayout(new BorderLayout() ); 
		JPanel panel = new JPanel();
		frame1.add(panel);

		JButton drawButton = new JButton(" Draw new card ");
		panel.add(drawButton);
		//Add action listener to drawButton
		drawButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				//Execute when button is pressed
				System.out.println(pn + " decided to draw a card !");
				buttonDrawCard(totalCardstoDrawFrom, aph);
				drawPause = false;
				frame1.dispose();
			}
		});     

		JButton pickFromStackButton = new JButton(" Pick from stack ");
		panel.add(pickFromStackButton);
		//Add action listener to drawButton
		pickFromStackButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				//Execute when button is pressed
				System.out.println(" Executing code for picking up last card from dicard pile !");  
				tempDrawHold=drawCurrent;
				
				drawCurrent=topOfDiscardPile;
				//topOfDiscardPile=cardThrownbyPlayer;
				aph.add(topOfDiscardPile);
				System.out.println(" "+pn + "You chose to take this Card"+drawCurrent+" !");  
				drawPause = false;
				frame1.dispose();
			}
		});     



		frame1.getContentPane().add(panel2,SwingConstants.LEFT);
		frame1.getContentPane().add(panel3,SwingConstants.LEFT);
		frame1.getContentPane().add(panel);
		frame1.setSize(500, 200);
		frame1.setLocationRelativeTo(null);  
		frame1.setLayout(new GridLayout(3,1));
		frame1.pack();
		frame1.setVisible(true);
	}//end createAndShowGUI

	//after click of button draw a card and add it to the all player's holding
	public static int buttonDrawCard(int totaltoDrawFrom, List<Integer> playerHoldings) {
		int tempHolder;
		Random randomNumber = new Random();
		boolean numberExists = false;
		
//		if (playerHoldings.size()>1){
//		//topOfDiscardPile=500; //cardThrownbyPlayer;//playerHoldings.get(playerHoldings.size()-1);
//		topOfDiscardPile++;
//		}else{
//			//topOfDiscardPile=1000;
//		}
		
		System.out.println("topOfDiscardPile "+topOfDiscardPile);
		
		label: do {
			drawCurrent = randomNumber.nextInt(totaltoDrawFrom)+1;
			holdingNumber = playerHoldings.size();
			for (int i = 0; i < holdingNumber; i++) {
				tempHolder = playerHoldings.get(i);
				if ((drawCurrent == tempHolder) || (drawCurrent == 0)) {
					numberExists = true;
					break;
				}// end if for compare
				else {
					numberExists = false;
				}
			}// end for loop

			if (numberExists == true) continue label;// restart if the number matches any from
			break label;

		} while (true); //end of do loop

		//System.out.println("playerHoldings = "+playerHoldings+"draw = "+draw);
		
		playerHoldings.add(drawCurrent); //update all player holding
		//playerHoldings=PlayerHolding.sortPlayerHolding(playerHoldings);
		return drawCurrent; //update for initial distribution
	}//end buttonDrawCard

}//end class