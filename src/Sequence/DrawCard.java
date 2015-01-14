package Sequence;
import java.util.List;
import java.util.Random;

import javax.swing.*;

import Sequence.SequenceMain;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

//this class will hold draw method which randomly draws a number from 1-52
public class DrawCard {

	private static int holdingNumber;
	static int cardThrownbyPlayer, tempDrawHold, topOfDiscardPile=1000;
	static int[] drawCurrent=new int[2];
	protected static List<Integer> aph,ph;
	protected static int totalCardstoDrawFrom;
	static boolean drawPause = true, throwPause = true;
	static String pn;
	static int buttonIndex=0,bIndex=0;

	//promise frame, lable, panel and buttons
	static JFrame frame1 = new JFrame();
	static JLabel myText = new JLabel();
	static JButton[] holdingCardsButton=new JButton[52]; //this needs to be updated to 13 later when throwing card works
	static JButton topOfDiscardPileButton=new JButton(),pickFromStackButton=new JButton(),drawButton=new JButton(),drawnCardButton=new JButton() ;
	static JPanel panel = new JPanel(), panel2 = new JPanel(), panel3 = new JPanel(),panel4 = new JPanel(),panel5 = new JPanel(),panel6 = new JPanel();

	//--------------------------------------------------------------------------------------------------------------
	//Draw a new card from the deck
	//--------------------------------------------------------------------------------------------------------------
	public static int[] DrawCard(int Number, List<Integer> allPlayerHoldings, List<Integer> playerHoldings, String playerName) {
		totalCardstoDrawFrom = Number;
		aph= allPlayerHoldings;
		ph=playerHoldings;
		pn=playerName;

		//Figure out the top card on the discard pile
		if (allPlayerHoldings.size()>1){
			//topOfDiscardPile=500; //cardThrownbyPlayer;//playerHoldings.get(playerHoldings.size()-1);
			//topOfDiscardPile++;
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
		System.out.println("Card drawn was "+drawCurrent[0]+" !!!");
		return drawCurrent; // returned either new draw or card thrown by the player
	}//end draw card

	
	//--------------------------------------------------------------------------------------------------------------
	//Create the graphics to play the game
	//--------------------------------------------------------------------------------------------------------------
	public static void createAndShowGUI()  {

		frame1 = new JFrame(pn + " Turn");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		//%%%%%%%%%%%%%%%%%%%%%%%%%%    DISPLAY CARDS HELD BY THE PLAYER  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		panel2 = new JPanel();
		
		//frame1.add(panel2, BorderLayout.EAST);
		myText = new JLabel("-------   Your current holdings -------",SwingConstants.CENTER);
		panel2.add(myText);		

		//Create 3 frames for displaying cards in hand
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		for (int cardVAlue : ph ){
			//System.out.println(" Starting Creation of button "+cardVAlue); 
			throwPause = true;
			holdingCardsButton[buttonIndex]=new JButton(String.valueOf(cardVAlue));
			holdingCardsButton[buttonIndex].setName(String.valueOf(cardVAlue)); 
			//System.out.println(" Completed Creation of button "+cardVAlue); 

			//Add action listener to drawButton
			//System.out.println(" Started Creation of Action listener for Button "+cardVAlue); 
			holdingCardsButton[buttonIndex].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					System.out.println("You selected this card "+Integer.parseInt(((JButton) e.getSource()).getName()));
					topOfDiscardPile = Integer.parseInt(((JButton) e.getSource()).getName());
					drawCurrent[1]=Integer.parseInt(((JButton) e.getSource()).getName());
					executeCardButtonPress ();

//					disableAllButtons ();
//					pickFromStackButton.setEnabled(false);
//					pickFromStackButton.paintImmediately(pickFromStackButton.getVisibleRect());
//					frame1.dispose();
//					drawPause = false;
					
				}
			});

			//System.out.println(" Completed Creation of Action listener for Button "+cardVAlue); 
			//Frame set up for cards to be displayed
			if(buttonIndex<5){
				panel4.add(holdingCardsButton[buttonIndex]);
			}// 5 buttons for the first panel
			else if (buttonIndex>4 && buttonIndex<10){
				panel5.add(holdingCardsButton[buttonIndex]);
			}// next 4 buttons for second panel			
			else if (buttonIndex>9){
				panel6.add(holdingCardsButton[buttonIndex]);
			}// next 4 buttons for second panel
			//holdingCardsButton[buttonIndex].setEnabled(false);
			buttonIndex++;

		}//end for loop

		buttonIndex=0; //reinitialize buttonIndex
		
		//create a button to display selected card
		throwPause = true;
		drawnCardButton=new JButton("XX");//(String.valueOf(1111));
		drawnCardButton.setName("9999");//(String.valueOf(1111));(String.valueOf(1111)); 
		//Add action listener to drawnCardButton
		//System.out.println(" Started Creation of Action listener for Button "+cardVAlue); 
		drawnCardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println("You selected this card"+Integer.parseInt(((JButton) e.getSource()).getName()));
				topOfDiscardPile = Integer.parseInt(((JButton) e.getSource()).getName());
				drawCurrent[1]=Integer.parseInt(((JButton) e.getSource()).getName());
				executeCardButtonPress ();
				
//				disableAllButtons ();
//				pickFromStackButton.setEnabled(false);
//				pickFromStackButton.paintImmediately(pickFromStackButton.getVisibleRect());
//				frame1.dispose();
//				drawPause = false;
				
			}
		});
		drawnCardButton.setEnabled(false);
		
		//for test
//		for(int i=10;i>0;i--){
//			System.out.println(i+" seconds left!");
//			try {Thread.sleep(1000);} catch (InterruptedException e) {break;};
//		}
//		drawnCardButton.setEnabled(true);
		
		
		panel6.add(drawnCardButton);

		//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		//%%%%%%%%%%%%%%%%%%%%%%%%%%    END OF DISPLAY CARDS HELD BY THE PLAYER  %%%%%%%%%%%%%%%%%%%%%%%%%%%
		//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

		panel3 = new JPanel();
		//frame1.add(panel3, BorderLayout.WEST);
		JLabel myText2 = new JLabel("------- What would you like to do?   -------",SwingConstants.CENTER);
		panel3.add(myText2);

		//frame1.setLayout(new BorderLayout() ); 
		panel = new JPanel();
		//frame1.add(panel);

		pickFromStackButton = new JButton(" Pick "+topOfDiscardPile+" from discard pile");
		panel.add(pickFromStackButton);
		//Add action listener to drawButton
		pickFromStackButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent discardPile)
			{
				//*******Execute when button is pressed*************
				drawButton.setEnabled(false);
				drawButton.paintImmediately(drawButton.getVisibleRect());
				pickFromStackButton.setEnabled(false);
				pickFromStackButton.paintImmediately(pickFromStackButton.getVisibleRect());
				
				System.out.println(" Executing code for picking up last card from dicard pile !");  
				tempDrawHold=drawCurrent[0];
				drawCurrent[0]=topOfDiscardPile;
				//topOfDiscardPile=cardThrownbyPlayer;
				aph.add(topOfDiscardPile);
				System.out.println(" "+pn + "You chose to take this Card"+drawCurrent[0]+" !"); 
				
				myText.setText("-------   Please throw a card!!  -------");
				myText.paintImmediately(myText.getVisibleRect());
				
				//enable all card buttons
				drawnCardButton.setText("You Picked "+String.valueOf(drawCurrent[0]));//update place holder with card
				drawnCardButton.setName(String.valueOf(drawCurrent[0]));//update place holder with card
				drawnCardButton.setEnabled(true);
				drawnCardButton.paintImmediately(drawnCardButton.getVisibleRect());
				
				enableAllButtons();
				
				
				drawPause = false;
				
				frame1.dispose();
				
			}//end action performed
		});//end action listener     


		
		drawButton = new JButton(" Draw new card ");
		panel.add(drawButton);
		//Add action listener to drawButton
		drawButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent drawCard)
			{
//				bIndex=0;
//				for (int cardButtons : ph ){
//					holdingCardsButton[bIndex].setEnabled(true);
//					holdingCardsButton[bIndex].repaint();
//					holdingCardsButton[bIndex].paintImmediately(holdingCardsButton[bIndex].getVisibleRect());
//					bIndex++;
//				}//end for loop
				
//				//*******Execute when button is pressed*************
//				//disable draw button and pick from discard button
				drawButton.setEnabled(false);
				drawButton.paintImmediately(drawButton.getVisibleRect());
				pickFromStackButton.setEnabled(false);
				pickFromStackButton.paintImmediately(pickFromStackButton.getVisibleRect());

				
//				//draw a card
				System.out.println(pn + " decided to draw a card !");
				buttonDrawCard(totalCardstoDrawFrom, aph);
				System.out.println("Hi "+pn + "! You drew "+drawCurrent[0]+" from the deck!");
				
				myText.setText("-------   Please throw a card!!  -------");
				myText.paintImmediately(myText.getVisibleRect());
				
//				//enable all card buttons
				drawnCardButton.setText("You Picked "+String.valueOf(drawCurrent[0]));//update place holder with card
				drawnCardButton.setName(String.valueOf(drawCurrent[0]));//update place holder with card
				drawnCardButton.setEnabled(true);
				drawnCardButton.paintImmediately(drawnCardButton.getVisibleRect());
				
				enableAllButtons();
				
//	------------------------------------			bIndex=0;
//				for (int cardButtons : ph ){
//					holdingCardsButton[bIndex].setEnabled(true);
//					//holdingCardsButton[bIndex].repaint();
//					holdingCardsButton[bIndex].paintImmediately(holdingCardsButton[bIndex].getVisibleRect());
//					bIndex++;
//				}//end for loop
//				topOfDiscardPileButton.setEnabled(true);
//				//topOfDiscardPileButton.updateUI();
//
//				//Graphics g = drawString("Hello",100,100);
//				//g.drawString("Hello",100,100);
//				//frame1.paintAll(g);
//
//				System.out.println("Entering throwPause!");
//				
//				for(int i=10;i>0;i--){
//					System.out.println(i+" seconds left!");
//					try {Thread.sleep(10000);} catch (InterruptedException e) {break;};
//				}
//				//wait for button press
//				while(throwPause){
//					try {Thread.sleep(500);} catch (InterruptedException e) {break;};
//				}//end while loop
//------------------------------------
//				// detect which button was pressed
//				// done in the button action listener by adding it to the top of discard pile
//				// update top of discard pile
				// done in the button action listener by adding it to the top of discard pile
//				// remove it from player holding
//				// done in the button action listener by removing it from the player holding
				
//				myText.setText("You threw this card ");
//				myText.paintImmediately(myText.getVisibleRect());
//
//				System.out.println("Frame visible!");
//
//				drawPause = false;//release pause for drawing
//
//				for(int i=20;i>0;i--){
//					System.out.println(i+" seconds left!");
//					try {Thread.sleep(1000);} catch (InterruptedException e) {break;};
//				}
//				
//				frame1.dispose();
			}//actions performed

		});     


		//panel for text -------   Your current holdings are   -------
		frame1.add(panel2); 

		// panels for cards held
		frame1.add(panel4);
		frame1.add(panel5);
		frame1.add(panel6);

		//panel for text ------- What would you like to do?   -------
		frame1.add(panel3);

		//selection buttons
		frame1.getContentPane().add(panel);
		frame1.setSize(500, 200);
		frame1.setLocationRelativeTo(null);  
		frame1.setLayout(new GridLayout(6,1));
		frame1.pack();
		frame1.setVisible(true);
		
		disableAllButtons ();
		
	}//end createAndShowGUI
	
	
	//--------------------------------------------------------------------------------------------------------------
	//this method disables all card buttons for the cards
	//--------------------------------------------------------------------------------------------------------------

	public static void disableAllButtons (){

		bIndex=0;
		for (int cardButtons : ph ){
			holdingCardsButton[bIndex].setEnabled(false);
			bIndex++;
		}//end for loop
		topOfDiscardPileButton.setEnabled(false);

	}//disable buttons

	
	//--------------------------------------------------------------------------------------------------------------
	//this method is executed for the button click
	//--------------------------------------------------------------------------------------------------------------

		public static void executeCardButtonPress (){
			
			disableAllButtons ();
			pickFromStackButton.setEnabled(false);
			pickFromStackButton.paintImmediately(pickFromStackButton.getVisibleRect());
			frame1.dispose();
			drawPause = false;

		}//enable buttons
	
	
	//--------------------------------------------------------------------------------------------------------------
	//this method enables all card buttons for the cards
	//--------------------------------------------------------------------------------------------------------------

	public static void enableAllButtons (){

		bIndex=0;
		for (int cardButtons : ph ){
			holdingCardsButton[bIndex].setEnabled(true);
			holdingCardsButton[bIndex].repaint();
			holdingCardsButton[bIndex].paintImmediately(holdingCardsButton[bIndex].getVisibleRect());
			bIndex++;
		}//end for loop
		topOfDiscardPileButton.setEnabled(true);
		topOfDiscardPileButton.updateUI();

	}//enable buttons

	
	//--------------------------------------------------------------------------------------------------------------
	//After click of button draw a card and add it to the all player's holding
	//--------------------------------------------------------------------------------------------------------------

	public static int[] buttonDrawCard(int totaltoDrawFrom, List<Integer> playerHoldings) {
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
			drawCurrent[0] = randomNumber.nextInt(totaltoDrawFrom)+1;
			holdingNumber = playerHoldings.size();
			for (int i = 0; i < holdingNumber; i++) {
				tempHolder = playerHoldings.get(i);
				if ((drawCurrent[0] == tempHolder) || (drawCurrent[0] == 0)) {
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

		playerHoldings.add(drawCurrent[0]); //update all player holding
		//playerHoldings=PlayerHolding.sortPlayerHolding(playerHoldings);
		return drawCurrent; //update for initial distribution
	}//end buttonDrawCard

}//end class
