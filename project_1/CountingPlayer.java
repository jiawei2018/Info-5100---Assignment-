package porject_1_jw;

import java.util.Scanner;

public class CountingPlayer extends Player {//means a human

    int memoryCard;
    private  int count ;
    int reShuffleTimes;

    CountingPlayer(int bankroll, int minimum){
        super(bankroll, minimum);
        memoryCard = 0;
    }

    @Override
    public int bet() {
    	if(isBroke()) {
    		//System.out.println("not enough money.");
    		return -1; 
    	}
    	 int bets ;	
    	if(count >= 2 && bankroll >= 2*minimum) {
    		bets = minimum*2;
    	}else
    	 bets = minimum;
    	//System.out.println("Simple player banlance is : "+bankroll+"$");
    	bankroll = bankroll - bets;
    	//System.out.println("player bet $"+bet);
    	return bets;
        
    }

    @Override
    public boolean draw(Card dealer) {
		//2 science soft or hard
		int thisex = dealer.getSpot().getValue();
	  //  isDraw = false;
		//System.out.println(count+"<<--<<--");
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
    	
    }
    
    
    public void resetCount() {
    	count = 0;
    }

    @Override
    public void expose(Card c) {

    	exposedToMe = c.getSpot().getValue();
    	
    	if(exposedToMe >= 10) {
    		count--;
    	}else if(exposedToMe <=6  &&  exposedToMe > 1){
    		count++;
    	}
    	
    }

    @Override
    public void shuffled() {
    	this.resetCount();//that hoe this work
    }
    
    void checkingShuffled(int newTimes) {
    	 if(newTimes > this.reShuffleTimes) {
    		 this.resetCount();
    		 this.reShuffleTimes = newTimes;
    	 }else
    		return;
    		 //this.reShuffleTimes = newTimes;
    }
    @Override
    void resetExposed(){//as much we can all 
    	 
    }

	@Override
	public void cleanInTrick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cleanToNewRound() {
		// TODO Auto-generated method stub
    	this.exposedToMe = 0;
    	this.hand.discardAll();
    	//this.resetCount();
    	//count =0;
	}

	@Override
	public void getCard(Card c,int times) {
		this.hand.cards.add(c);
		
		checkingShuffled(times);
		// TODO Auto-generated method stub
		
	}
    
    
}