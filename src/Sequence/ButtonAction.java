package Sequence;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ButtonAction {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		//frame.setLayout(); - Set any layout here, default will be the form layout
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		JLabel myText1 = new JLabel("I'm first label in the window");
		//panel2.add(myText1, BorderLayout.WEST);
		panel1.add(myText1);
		frame.add(panel1);
		
		JLabel myText2 = new JLabel("I'm second label in the window");
		//panel2.add(myText2, BorderLayout.SOUTH);
		panel2.add(myText2, BorderLayout.SOUTH);
		frame.add(panel2);
		frame.setLayout(new GridLayout(2,1));
		frame.pack();
		frame.setVisible(true);
		
	}//end mail
}//end class