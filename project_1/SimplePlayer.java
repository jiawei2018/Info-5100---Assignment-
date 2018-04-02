package porject_1_jw;

import java.util.Scanner;

public class SimplePlayer extends Player {//means a computer player
	
	  int exposedToMe = 0 ; // use this as a see?
	
	SimplePlayer(int bankroll, int minimum) {
		super(bankroll, minimum);
		// TODO Auto-generated constructor stub
	}

	GroupOfCards  playCards;
	//   Hand hand; super class

  
	
 


	@Override
	public int bet() {//assume always bet minimum
    	if(isBroke()) {
    		//System.out.println("not enough money.");
    		return -1; 
    	}
    	//System.out.println("Simple player banlance is : "+bankroll+"$");
    	int bet = minimum;
    	bankroll = bankroll - bet;
    	//System.out.println("player bet $"+bet);
    	return bet;
	}

	/*If the total includes an ace counted as 11, the total is called “soft”,
	otherwise it is called “hard”.<- means ace count 1 or no ace
	*/
	@Override
	public boolean draw(Card dealer) {//this is second card of dealer
		//2 science soft or hard
		int thisex = dealer.getSpot().getValue();
	    isDraw = false;
	    boolean input = false;
		if(!hand.getHandValue().isSoft()) {//if hard?    means ace  == 11;
					if(hand.getHandValue().getcount() <= 11) {
						 return true;
					}else if(hand.getHandValue().getcount() == 12){
						if(thisex == 4 ||thisex == 5 || thisex == 6) {
							return false;
						}else
							return true;
					}else if(hand.getHandValue().getcount() >= 13 && hand.getHandValue().getcount() <= 16){
						if(thisex >= 2 && thisex <= 6) {
							return false;
						}else
							return true;
					}else if(hand.getHandValue().getcount() >= 17)  
						return false;
		}else {
			/*• If the player’s hand totals 17 or less, he always hits.
			• If the player’s hand totals 18, he stands if the dealer shows a 2, 7, or 8, otherwise he hits.
			• If the player’s hand totals 19 or greater, he always stands.*/
			
			if(hand.getHandValue().getcount() <= 17) {
				return true;
				
			}else if(hand.getHandValue().getcount() == 18 ) {
				if(thisex == 2 ||thisex == 7 || thisex == 8) {//judge if need the forth card
					return false;
				}else
					input = true;
			}else if(hand.getHandValue().getcount() > 18) {
				return false;
			}
			
		}//big if
		//isDraw = input;		
		// TODO Auto-generated method stub
		return input;
	}// Dealer's "up card"
    // EFFECTS: returns true if the player wishes to be dealt another
    // card, false otherwise.

	@Override
	public void expose(Card c) { 
		// TODO Auto-generated method stub
		//exposed to me ..
		//System.out.println("Expose:the card is :"+c);
		//System.out.println(c);
		//exposedToMe = c.getSpot().getValue();
	}   // EFFECTS: allows the player to "see" the newly-exposedToMe card c.
    // For example, each card that is dealt "face up" is expose()d.
    // Likewise, if the dealer must show his "hole card", it is also
    // expose()d.  Note: not all cards dealt are expose()d---if the
    // player goes over 21 or is dealt a natural 21, the dealer need
    // not expose his hole card.
	

	@Override
	public void shuffled() {//?????? what is  this means?
		//for simple player this means nothing 
		isReshuffled = true;
		//System.out.println("");
	}   // EFFECTS: tells the player that the deck has been re-shuffled.

	@Override
	public void cleanInTrick() {
		this.hand.discardAll();
		this.exposedToMe = 0;
		
	}

	@Override
	public void cleanToNewRound() {
		cleanInTrick();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getCard(Card c,int times) {
		// TODO Auto-generated method stub
		this.hand.cards.add(c);
	}
	
	
}