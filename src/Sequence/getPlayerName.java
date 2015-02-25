/**
 * 
 */
package Sequence;
import javax.swing.JOptionPane;

/**
 * @author vihar
 * This class implements methods to get player name from the window
 */
public class getPlayerName {
			static String playerName=null;
			//--------------------------------------------------------------------------------------------------------------
			//Get player name from window method
			//--------------------------------------------------------------------------------------------------------------
			public static String PlayerName (String name){
				
				
//				Scanner playerScan1 = new Scanner(System.in);
//				Scanner playerScan2 = new Scanner(System.in);
//				out.print("Enter 1st player's name : ");
//				String player1 = playerScan1.nextLine();

//				out.print("Enter 2nd player's name : ");
//				String player2 = playerScan2.nextLine();
				
				playerName = JOptionPane.showInputDialog(name+" Choose your name :");
				if (playerName==null){//check if no user pressed cancel
					playerName = name;
					JOptionPane.showMessageDialog(null, "You have not chosen any name. System allocated "+name+" as your name");
				}
				else if (playerName.length()==0){ //check if no text was entered and user pressed OK
					playerName = name;
					JOptionPane.showMessageDialog(null, "You left the name field blank. System allocated "+name+" as your name");
				}else{
					JOptionPane.showMessageDialog(null, "You have chosen "+playerName +" as your name. That is a nice name!");
				}//end if
				
				return playerName;
				
			}//end PlayerName
			
}//end getPlayerName



//acceptName = true;
//SwingUtilities.invokeLater(new Runnable() {
//	@Override
//	public void run() {
//		player1 = JOptionPane.showInputDialog(null, "Enter User Name for Player1");
//		acceptName = false;
//	}
//});
//
//int wait1 = 1;
////acceptName = false;
//while (true){
//	if (wait1%10==0){out.println("Waiting for username entry .... ");} 
//	if (wait1%2==0){
//		out.println("Player did not enter name .... ");
//		wait1=1;JOptionPane.getRootFrame().dispose(); 
//		break;} 
//	try {Thread.sleep(1000);} catch (InterruptedException e) {break;};
//	wait1++;
//}//end while loop
//
//acceptName = true;
//out.println("starting second player!");
//SwingUtilities.invokeLater(new Runnable() {
//	@Override
//	public void run() {
//		player2 = JOptionPane.showInputDialog(null, "Enter User Name for Player2");
//		acceptName = false;
//	}
//});
//
//wait1 = 1;acceptName = true;
//while (true){
//	//out.println("starting while loop!");
//	if (wait1%10==0){out.println("Waiting for username entry .... ");} 
//	if (wait1%2==0){
//		out.println("Player did not enter name .... ");
//		wait1=1;JOptionPane.getRootFrame().dispose(); 
//		break;} 
//	try {Thread.sleep(1000);} catch (InterruptedException e) {break;};
//	wait1++;
//	//out.println("one loop complete! "+wait1);
//}//end while loop
//
//
//if (player1==null) player1="player1";
//if (player2==null) player2="player2";
