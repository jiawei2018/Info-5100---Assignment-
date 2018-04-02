package porject_1_jw;

public class Dealer extends Player {
	//int dealerFund = 10000;//dealer's start fund ,why == bankroll
	private int exposedToMe = 0 ;
	private boolean playerBusted;




	Dealer(int bankroll, int minimum) {
		super(bankroll, minimum);//?
		// TODO Auto-generated constructor stub
	}
	
	public void setPlayerBusted(boolean ifPlayerBusted) {
		this.playerBusted = ifPlayerBusted;
	}

	@Override
	public int bet() {//dealer dont bet
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean draw(Card dealer) {//dealer do draw
		// this can be very complex
		// add if on;ly happend  when player not busted
		//always hit if smaller than player
		//System.out.println("==============="+otherCount);
		boolean input = false;
		if(!playerBusted) {
			if(hand.getHandValue().getcount()<= 17  ||  (hand.getHandValue().getcount() < otherCount) ) {
				input = true;
				//return true;
			}
		}
		this.isDraw = input;
		return false;
	}// Player's current hand
	// EFFECTS: returns true if the player wishes to be dealt another
	// card, false otherwise. For dealer The dealer must
	// hit until he either reaches a total greater than or equal to 17
	// (hard or soft), or busts.
	

	@Override
	public void expose(Card c) {
		//exposedToMe = c.getSpot().getValue();
		 
	}// EFFECTS: allows the player to "see" the newly-exposed card c.
	// For example, each card that is dealt "face up" is expose()d.
	// Likewise, if the dealer must show his "hole card", it is also
	// expose()d. Note: not all cards dealt are expose()d---if the
	// player goes over 21 or is dealt a natural 21, the dealer need
	// not expose his hole card.
	
	
	

	@Override
	public void shuffled() {
		isReshuffled = true;//dealer dont care??
		// EFFECTS: tells the player that the deck has been re-shuffled.		
	}

	@Override
	public void cleanInTrick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cleanToNewRound() {
		// TODO Auto-generated method stub
		this.hand.discardAll();
		this.otherCount = 0;
 
	}

	@Override
	public void getCard(Card c,int times) {
		this.hand.cards.add(c);
		// TODO Auto-generated method stub
		
	}
}