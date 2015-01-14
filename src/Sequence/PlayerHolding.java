package Sequence;
import static java.lang.System.out;

import java.util.List;

import javax.swing.JButton;

/**
 * @author vihar
 *
 */
public class PlayerHolding {
	public static List<Integer> Player_Holding (int draw[], List<Integer> playerHoldings){
		// add drawn card to the player's hand
		System.out.println("draw[0] "+draw[0]); 
		System.out.println("draw[1] "+draw[1]); 
		playerHoldings.add(draw[0]);
		
		
		//sort the player Holdings 
		playerHoldings=sortPlayerHolding(playerHoldings);
		//System.out.println("Player Holding Sorted "+playerHoldings);
		
		//delete thrown card from player holding
		int index;
		index = playerHoldings.size();
		
		for (int i=0; i<index-1; i++){
				if (playerHoldings.get(i)==draw[1]){
					playerHoldings.remove(i);
					//for multi deck track that you delete only one card
				}//if both are equal delete this element
		}//end i for loop
		
		return playerHoldings;
	}//end method Player_Holding
	
	public static List<Integer> Player_Initial_Holding (int draw[], List<Integer> playerHoldings){
		// add drawn card to the player's hand
		playerHoldings.add(draw[0]);
		//sort the player Holdings 
		playerHoldings=sortPlayerHolding(playerHoldings);
		//System.out.println("Player Holding Sorted "+playerHoldings);
		
		
		return playerHoldings;
	}//end method Player_Holding

	public static List<Integer> sortPlayerHolding (List<Integer> playerHoldings){
		
		int holdingNumber;
		holdingNumber = playerHoldings.size();
		for (int i=0; i<holdingNumber; i++){
			
			int tempHolding;
			for (int j=0; j<holdingNumber; j++){
				if (playerHoldings.get(i)>=playerHoldings.get(j)){
					//do nothing
				}//if both are equal do nothing
				else if (playerHoldings.get(i)<playerHoldings.get(j)) {
					tempHolding = playerHoldings.get(j);
					playerHoldings.set(j,playerHoldings.get(i));
					playerHoldings.set(i,tempHolding);
				}                                                                             
				else {
					
					//error msg print
				}
			}//end j loop

		}//end i for loop
		
		return playerHoldings;
	}
	
}//end class
