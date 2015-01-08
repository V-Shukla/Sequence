package Sequence;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class DisplayCardsasButtonTest {
	static JButton[] holdingCardsButton=new JButton[13];
	static int i=0;
	static int[] holdingCardsValue = {41,12,33,45,589,69,7433,348,3459,15670,567811,162,173};
	static int[] holdingButtonValue;
	static boolean toggle;
	
	public static void main(String[] args) {
		
		JLabel myText = new JLabel("-------   Your current holdings -------",SwingConstants.CENTER);
		
		JFrame frame = new JFrame("Cards in your hand");
		
		//frame.setLayout(); - Set any layout here, default will be the form layout
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		
		panel4.add(myText);
		//JButton[] holdingCardsButton = new JButton[13];
		//int i;
		//int buttonVal;
		System.out.println(" Initialization complete"); 
		//for (i=0; i<13; i++){
		for (int cardVAlue : holdingCardsValue ){
			System.out.println(" Starting Creation of button "+cardVAlue); 
			holdingCardsButton[i]=new JButton(String.valueOf(cardVAlue));
			holdingCardsButton[i].setName(String.valueOf(cardVAlue)); 
			//holdingButtonValue[cardVAlue] = holdingCardsValue[cardVAlue];
			System.out.println(" Completed Creation of button "+cardVAlue); 
			//Add action listener to drawButton
			System.out.println(" Started Creation of Action listener for Button "+cardVAlue); 
			holdingCardsButton[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					System.out.println(((JButton) e.getSource()).getName()+" Click"); 
					System.out.println(Integer.parseInt(((JButton) e.getSource()).getName())+2); 
					((JButton) e.getSource()).setEnabled(false);
//					for(int i=5;i>0;i--){
//						System.out.println(i+" seconds left!");
//						try {Thread.sleep(1000);} catch (InterruptedException er) {break;};
//					}
//					((JButton) e.getSource()).setEnabled(true);
				}
			});
			
			System.out.println(" Completed Creation of Action listener for Button "+cardVAlue); 

			if(i<5){
				panel4.add(holdingCardsButton[i]);
			}// 5 buttons for the first panel
			else if (i>4 && i<9){
				panel5.add(holdingCardsButton[i]);
			}// next 4 buttons for second panel			
			else if (i>8){
				panel6.add(holdingCardsButton[i]);
			}// next 4 buttons for second panel
			
			i++;
			

			
		}//end for loop

		
		
		
		//JLabel myText1 = new JLabel("Cards you are holding are : ");
		//panel2.add(myText1, BorderLayout.WEST);
		//panel4.add(myText1);
		frame.add(panel4);
		
		//JLabel myText2 = new JLabel("I'm second label in the window");
		//panel2.add(myText2, BorderLayout.SOUTH);
		//panel5.add(myText2, BorderLayout.SOUTH);
		frame.add(panel5);
		frame.add(panel6);
		
		
		//not needed in the code
		frame.setSize(500, 200);
		frame.setLocationRelativeTo(null);  
		frame.setLayout(new GridLayout(3,1));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for(int i=12;i>=0;i--){
			System.out.println(i+" seconds left!");
		
		}
		for(int i=12;i>=0;i--){
			System.out.println(i+" seconds left!");
			try {Thread.sleep(1000);} catch (InterruptedException e) {break;};
			holdingCardsButton[i].setEnabled(true);
		}
		
		myText.setText("My updated text");
		myText.paintImmediately(myText.getVisibleRect());
		
	}//end mail
}//end class