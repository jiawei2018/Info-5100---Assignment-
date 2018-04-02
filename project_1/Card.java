package porject_1_jw;


import java.util.Arrays;

public class Card {

    private final String[] SuitNames = {"Spades", "Hearts", "Clubs", "Diamonds"};
    private final String[] SpotNames = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
            "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
    private Spot spot;
    private Suit suit;

    Card(Spot spot, Suit suit){
        this.spot = spot;
        this.suit = suit;
    };

    public Suit getSuit(){
        return suit;
    }

    public Spot getSpot(){
        return spot;
    }
    
/*    public int getSpotVal(Spot spot) {//    TWO1, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN9,
        //JACK, QUEEN11, KING12, ACE 13
    	if(spot.ordinal() ==  1 ) {
    		return 2;
    	}else if(spot.ordinal() ==  2 ) {
    		return 3;
    	}else if(spot.ordinal() ==  3 ) {
    		return 4;
    	}else if(spot.ordinal() ==  4 ) {
    		return 5;
    	}else if(spot.ordinal() ==  5 ) {
    		return 6;
    	}else if(spot.ordinal() ==  6 ) {
    		return 7;
    	}else if(spot.ordinal() ==  7 ) {
    		return 8;
    	}else if(spot.ordinal() ==  8 ) {
    		return 9;
    	}else if(spot.ordinal() ==  9 ) {
    		return 10;
    	}else if(spot.ordinal() ==  10 ) {//J
    		return 10;
    	}else if(spot.ordinal() ==  11 ) {//Q
    		return 10;
    	}else if(spot.ordinal() ==  12 ) {// K
    		return 10;
    	}
    	
    	return 0;
    }//end method
*/    
    public int[] getAce(Spot ace) {//my method
    	int[] res = new int[2];
    	res[0] = 1;
    	res[1] = 11;
    	return res;
    }
   
    
   

    @Override
    public String toString() {
        return SpotNames[spot.ordinal()] + " of " + SuitNames[suit.ordinal()];
    }
}