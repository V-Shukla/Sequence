Sequence
========
note: use boolean to avoid creation of buttons every time. Activate buttons when appropriate. 

Player with sequence of four consecutive numbers wins. This is coded in Java. Eventually it will become a card game. 
http://rummy.com/indianrummy.html

#**************** Defects ***************************************
# Resolved - Defect 1 : cards are persisting for both players in the first draw and chains to other -12/22/2014
# Resolved - Defect 2 : if no one wins needs a graceful end to program -12/27/2014
	# Resolved - 2a: fix draw to start from 1 and end including 52 -12/27/2014
	# Resolved - 2b: calculate iteration ends through end of cards to draw -12/27/2014
	# Resolved - 2c: Extra fall back after certain draws based on the deck -12/27/2014
					if ((cardsLeft4Drawing==0))
					if (winner == false)

?????? Code for drawing on client side	?????? 

#**************** Improvement ******************************
# Completed - Feature 1 : add window to middle -12/22/2014
Feature 2 : add playerHoldings and refresh window for updates
Feature 3 : Update the CheckWinning to defect winner for multiple sequence
	   3a : Check for valid sequences for all cards in hand
	   3b : Check for 3/4 cards of the same number
	   3c : Manage multiple decks
# Completed - Feature 4 : Add the current player holding cards in the frame -12/22/2014
# Completed - Feature 5 : Add buttons and messages vertically in the window -12/22/2014
Feature 6 : Add multiple players - up to 10
	   6a : Need to handle multiple Deck
Feature 7 : Test the application - create JUnits
Feature 8 : Message for winner in a frame, message for others
# Completed - Feature 9 : Provide initial cards - 12/30/2014
# In Progress - Feature10 : Feature to pick last card from the discard pile 
Feature11 : Integrate with Server Client  
Feature12 : Convert Cards to String and Integer for user Experience
Feature13 : Accept player names from the windows
Feature14 : Make the code independent of number of players
Feature15 : Manage Discarding a card
# In Progress - Feature16 : Let player choose which card to discard
Feature17 : check for winner after first distribution
Feature18 : Accommodate Use of Jokers		

