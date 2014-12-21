package Sequence;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonAction {
	public static void createAndShowGUI()  {
		final JFrame frame1 = new JFrame("Player Turn");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame1.add(panel);

		JButton drawButton = new JButton(" Click here to Draw a card ");
		panel.add(drawButton);
		//Add action listener to drawButton
		drawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				//Execute when button is pressed
				System.out.println("Player decided to draw a card !!!!!!!!!!!!");   
				frame1.dispose();
			}
		});     

		JButton pickFromStackButton = new JButton(" Click here pick a card from stack ");
		panel.add(pickFromStackButton);
		//Add action listener to drawButton
		pickFromStackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				//Execute when button is pressed
				System.out.println("This function is not yet available !!!!!!!!!!!!!");   
				frame1.dispose();
			}
		});     

		frame1.getContentPane().add(panel);
		//frame1.getContentPane().add(pickFromStackButton);
		frame1.pack();
		frame1.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}