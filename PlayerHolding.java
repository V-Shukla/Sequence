package Sequence;
import static java.lang.System.out;
import java.util.List;

/**
 * @author vihar
 *
 */
public class PlayerHolding {
	//            public static int totalCard = 52;
	//            public static int draw;
	//public static int tempHolding;

	public static List<Integer> Player_Holding (int draw, List<Integer> playerHoldings){
		//final String printValues = "Draw is %d, i is %d, player%dHoldings[%d] is %d\n";
		int holdingNumber;

		//draw = Draw.DrawCard(totalCard, playerHoldings);
		playerHoldings.add(draw);
		holdingNumber = playerHoldings.size();
		out.println("Player drew "+draw+" in draw number "+holdingNumber);

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
					//i=0;
					//i++; //if current draw is more then current value move on
				}                                                                             
				else {
					//error msg print
				}
			}//end j loop

		}//end i for loop

		//out.printf(printValues,draw,i,1,i,playerHoldings.get(i));

		return playerHoldings;
	}//end method

}//end class
