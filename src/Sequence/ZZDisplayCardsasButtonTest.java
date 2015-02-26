package Sequence;
import static java.lang.System.out;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;


public class ZZDisplayCardsasButtonTest {
	static JButton[] holdingCardsButton=new JButton[13];
	static JButton testButton=new JButton();
	static int i=0;
	static int[] holdingCardsValue = {41,12,33,45,589,69,7433,348,3459,15670,567811,162,173};
	static int[] holdingButtonValue;
	static boolean toggle;
	static List<Integer> playerHoldings=new ArrayList<Integer>(); 
	
	public static void main(String[] args) {
		
		Scanner scan= new Scanner(System.in);

	    //For string

	    String text= scan.nextLine();

	    System.out.println(text);

	    //for int

	    int num= scan.nextInt();

	    System.out.println(num);
		
		
		Scanner playerScan1 = new Scanner(System.in);
		Scanner playerScan2 = new Scanner(System.in);
		String player1 = playerScan1.toString();
		String player2 = playerScan2.toString();
		//int myint = keyboard.nextInt();
		out.println("*********************"+player1+"******************");
		out.println("*********************"+player2+"******************");
		
		
		JFrame winnerFrame = new JFrame(" We have a winner!!");
		winnerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel playerWins = new JLabel(" has won!!",SwingConstants.CENTER);
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
		
//		
//		playerHoldings.add(42);
//		playerHoldings.add(43);
//		System.out.println(" playerHoldings "+playerHoldings);
//		playerHoldings.remove(0);
//		System.out.println(" playerHoldings "+playerHoldings);
//		
//		JLabel myText = new JLabel("-------   Your current holdings -------",SwingConstants.CENTER);
//		
//		JFrame frame = new JFrame("Cards in your hand");
//		
//		//frame.setLayout(); - Set any layout here, default will be the form layout
//		JPanel panel4 = new JPanel();
//		JPanel panel5 = new JPanel();
//		JPanel panel6 = new JPanel();
//		
//		panel4.add(myText);
//		//JButton[] holdingCardsButton = new JButton[13];
//		//int i;
//		//int buttonVal;
//		System.out.println(" Initialization complete"); 
//		//for (i=0; i<13; i++){
//		for (int cardVAlue : holdingCardsValue ){
//			System.out.println(" Starting Creation of button "+cardVAlue); 
//			holdingCardsButton[i]=new JButton(String.valueOf(cardVAlue));
//			holdingCardsButton[i].setName(String.valueOf(cardVAlue)); 
//			holdingCardsButton[i].setEnabled(false);
//			//holdingButtonValue[cardVAlue] = holdingCardsValue[cardVAlue];
//			System.out.println(" Completed Creation of button "+cardVAlue); 
//			//Add action listener to drawButton
//			System.out.println(" Started Creation of Action listener for Button "+cardVAlue); 
//			holdingCardsButton[i].addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e){
//					System.out.println(((JButton) e.getSource()).getName()+" Click"); 
//					System.out.println(Integer.parseInt(((JButton) e.getSource()).getName())+2); 
//
//					((JButton) e.getSource()).setEnabled(false);
//					
////					for(int i=5;i>0;i--){
////						System.out.println(i+" seconds left!");
////						try {Thread.sleep(1000);} catch (InterruptedException er) {break;};
////					}
////					((JButton) e.getSource()).setEnabled(true);
//
//				}
//			});
//			
//			System.out.println(" Completed Creation of Action listener for Button "+cardVAlue); 
//
//			if(i<5){
//				panel4.add(holdingCardsButton[i]);
//			}// 5 buttons for the first panel
//			else if (i>4 && i<9){
//				panel5.add(holdingCardsButton[i]);
//			}// next 4 buttons for second panel			
//			else if (i>8){
//				panel6.add(holdingCardsButton[i]);
//			}// next 4 buttons for second panel
//			
//			i++;
//			
//
//			
//		}//end for loop
//
//		testButton=new JButton("test");
//		testButton.setName(String.valueOf(9999)); 
//		testButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e){
//				System.out.println(((JButton) e.getSource()).getName()+" Click"); 
//				System.out.println(Integer.parseInt(((JButton) e.getSource()).getName())+2); 
//
////				((JButton) e.getSource()).setEnabled(false);
//				
////				for(int i=12;i>=0;i--){
////					System.out.println(i+" time left!");
////				
////				}
////				
//				for(int i=12;i>=0;i--){
//					//System.out.println(i+" time left!");
//					//try {Thread.sleep(1000);} catch (InterruptedException e2) {break;};
//					holdingCardsButton[i].setEnabled(true);
//				}
//
//			}
//		});
//		panel6.add(testButton);
//		
//		//JLabel myText1 = new JLabel("Cards you are holding are : ");
//		//panel2.add(myText1, BorderLayout.WEST);
//		//panel4.add(myText1);
//		frame.add(panel4);
//		
//		//JLabel myText2 = new JLabel("I'm second label in the window");
//		//panel2.add(myText2, BorderLayout.SOUTH);
//		//panel5.add(myText2, BorderLayout.SOUTH);
//		frame.add(panel5);
//		frame.add(panel6);
//		
//		
//		//not needed in the code
//		frame.setSize(500, 200);
//		frame.setLocationRelativeTo(null);  
//		frame.setLayout(new GridLayout(3,1));
//		frame.pack();
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
////		for(int i=12;i>=0;i--){
////			System.out.println(i+" seconds left!");
////		
////		}
////		
////		for(int i=12;i>=0;i--){
////			System.out.println(i+" seconds left!");
////			try {Thread.sleep(1000);} catch (InterruptedException e) {break;};
////			holdingCardsButton[i].setEnabled(true);
////		}
////		
//		myText.setText("My updated text");
//		myText.paintImmediately(myText.getVisibleRect());
//		
//		for(int i=100;i>0;i--){
//			System.out.println(i+" seconds left!");
//			try {Thread.sleep(1000);} catch (InterruptedException e) {break;};
//		}
//		
//		myText.setText("Program is ending after this");
//		myText.paintImmediately(myText.getVisibleRect());
//		
	}//end main
}//end class