package porject_1_jw;

import java.util.ArrayList;
import java.util.List;

public class Hand extends GroupOfCards{//we have the list<card>
//input Card  hc[]
	// where is the input? how?
	//Card[] hCard= new Card[2];
	/*   List<Card> cards;// from super
	    GroupOfCards(){};*/
	boolean bj = false;//is blackjack
	
	//soft or hard
	
	//boolean isSoft = false;
	boolean busted = false;//judge if busted
	
	
	
    class HandValue {
      private  int  count;    // Value of hand
      private  boolean soft;     // true if hand value is a soft count// means that contains a ace;== soft hand
       
        int getcount() {
        	return count;
        }
        boolean isSoft() {
        	return soft;//true == soft have ace ; false == hard;
        }
        void setSoft(boolean isSoft) {
        	this.soft = isSoft;
        }
        void setCount(int count) {
        	this.count = count;
        }
    };
    // OVERVIEW: A blackjack hand of zero or more cards

    private HandValue curValue;//?

    Hand(){
    	//new cards;
    	List<Card> cards =new ArrayList<Card>();
    	cards.clear();
    	//new Hand();
    };
    // EFFECTS: establishes an empty blackjack hand.
    void discardAll(){
    	cards.clear();
    	busted = false;
    	bj = false;
    };

    HandValue getHandValue(){//test   here 
    	
    	HandValue  hv = new HandValue ();
    	int len = cards.size();//here is the input
    	int handValue = 0;    	
    	boolean isSoft = false;
    	int ace ;
        for( Card c:cards) {
        	//System.out.println(handValue+"<<<");
        	if(c.getSpot() !=  Spot.ACE) {
        		handValue += c.getSpot().getValue();//                c.getSpotVal(c.getSpot());
        	}else {//we have a ace
        		// here we choose the value of ace
        		if(handValue+11 > 21 ) { //ace togo 1
        			 ace = 1;
        			isSoft = true;
        		}else {
        			 ace = 11;//means hard
        		}
        		handValue += ace;
        	}
        	
        }
       // System.out.println("handv->>"+String.valueOf(handValue));
        if(handValue >21) busted = true;  
	      //  System.out.println(handValue);
	       // System.out.println(isSoft);
    	hv.setCount(handValue); //= handValue;
    	hv.setSoft(isSoft);
    	return hv;
    };
    // EFFECTS: returns the present value of the blackjack hand.  The
    // count field is the highest blackjack total possible without
    // going over 21.  The soft field should be true if and only if at
    // least one ACE is present, and its value is counted as 11 rather
    // than 1.  If the hand is over 21, any value over 21 may be returned.
    //
    // Note: you are not allowed to change any member variables inside
    // handValue.  It is required because Players only get const Hands
    // passed to them, and therefore can only call methods like addCard,
    // to change the hand.
    
    
    
    boolean   isBJ(){
    	if(cards.size() == 2) { 
    		if(cards.get(0).getSpot().getValue() == 10   ) {
    			    if(cards.get(1).getSpot().getValue() == 1) { 
    				 return true ;
    			    }
    		} else if(cards.get(0).getSpot().getValue() == 1) {
    				 if(cards.get(1).getSpot().getValue() == 10 )  
    				 return true; 
    		}
    		}//else
    	return false;
    }//if
      //mehtod
    	

}