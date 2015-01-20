package Sequence;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class PlayerNameWindow extends JFrame implements ActionListener {
   private static final long serialVersionUID = 1L;

   int randomNumber = new Random().nextInt(10) + 1;
   int numGuesses = 0;
   public static String inputString = null;

   JTextField textField = new JTextField();
   JButton button = new JButton("OK");
   JLabel label = new JLabel("     Enter the player name      ");

   public PlayerNameWindow() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new FlowLayout());
      add(label);
      add(textField);
      add(button, BorderLayout.CENTER);
      
      button.addActionListener(this);
      
		setSize(500, 200);
		setLocationRelativeTo(null);  
		setLayout(new GridLayout(3,1));
		pack();
		setVisible(true);
		
   }

   @Override
   public void actionPerformed(ActionEvent e) {
	  String textFieldText = textField.getText();

      if (Integer.parseInt(textFieldText)==randomNumber) {
         button.setEnabled(false);
         textField.setText(textField.getText() + " Yes!");
         textField.setEnabled(false);
      } else {
         textField.setText("");
         textField.requestFocus();
      }

      numGuesses++;
      String guessWord = 
          (numGuesses == 1) ? " guess" : " guesses";
      label.setText(numGuesses + guessWord);
      
   }
}
