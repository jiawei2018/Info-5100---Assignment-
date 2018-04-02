package porject_1_jw;
import java.util.*;


class DeckEmptyExecption extends Exception { // An exception type
	int size;
	public DeckEmptyExecption(int size){
		this.size= size;
	}
	
	public String toString() {
		return("Error message : run out of cards   "+size  );
	}
	
	



};

public class Deck extends GroupOfCards {

	final int DeckSize = 52;//a new deck size
	 List<Card> cards = new ArrayList<Card>();  //now we use  arraylist
	//cards = new ArrayList<Card>();
	// A standard Deck of 52 playing card---no jokers
    int shTimes;
    int reShuffleTimes=0; 
    
    
	Deck() {
		
		// make a new card
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				if (j == 0) {
					cards.add(new Card(getNum(i), Suit.SPADES)) ;  
				} else if (j == 1) {
					cards.add(new Card(getNum(i), Suit.HEARTS)) ;
				} else if (j == 2) {
					cards.add(new Card(getNum(i), Suit.CLUBS)) ;
				} else {
					cards.add(new Card(getNum(i), Suit.DIAMONDS)) ;
				}
			} // suit loop
		}//spot loop
	};// EFFECTS: constructs a "newly opened" Deck of card. first the
		// spades from 2-A, then the hearts, then the clubs, then the
		// diamonds. The first Card dealt should be the 2 of Spades.

	void reset() {
		new Deck();
		System.out.println("This is a new deck.");// not sure yet
	};

	// EFFECTS: resets the Deck to the state of a "newly opened" Deck
	// of card:

	void shuffleOnce(int n) {
		if (n <= 0 || n > 51) return;
		//left =n
		List<Card> left = new ArrayList<Card>();
		List<Card> right = new ArrayList<Card>();

		for (int i = 0; i < n; i++) left.add(cards.get(i));
		for (int i = 0; i < 52-n; i++) right.add( cards.get(n+i));            //card[n + i])  ;
		
		// now finish cut cards with n
		int l = 0 , r = 0;
		//int c = 0 ;
		//cards.
		cards.clear();
		//System.out.println(cards.size());
		while(l < left.size() && r < right.size()) {
		   if(cards.size()%2 == 0) {
			   cards.add(right.get(r++));
			   //c++;//= right[r++];
		   }else {
			   cards.add(left.get(l++));
			   //c++;
		   }
		}//while
		while(l<left.size() )  cards.add(left.get(l++));//= left[l++];
		while(r<right.size())  cards.add(right.get(r++));//card[c++] = right[r++];
	};

	// REQUIRES: n is between 0 and 52, inclusive.

	// EFFECTS: cut the Deck into two segments: the first n card,
	// called the "left", and the rest called the "right". Note that
	// either right or left might be empty. Then, rearrange the Deck
	// to be the first Card of the right, then the first Card of the
	// left, the 2nd of right, the 2nd of left, and so on. Once one
	// side is exhausted, fill in the remainder of the Deck with the
	// card remaining in the other side. Finally, make the first
	// Card in this shuffled Deck the next Card to deal. For example,
	// shuffle(26) on a newly-reset() Deck results in: 2-clubs,
	// 2-spades, 3-clubs, 3-spades ... A-diamonds, A-hearts.

	// Note: if shuffle is called on a Deck that has already had some   ---  this
	// card dealt, those card should first be restored to the Deck
	// in the order in which they were dealt, preserving the most
	// recent post-shuffled/post-reset state.

	void shuffle(int times) {//finished
		int ts =0 ,cut=0;
		ts = times;
		shTimes = ts;
		if(ts < 5 )	ts = 5;
		if(times>100) ts = 20;
	    System.out.println("Shuffling the deck");
		for(int i=0 ; i<ts ;i++)  {
		      cut = ((int)(Math.random()*26))+13 ;
		      System.out.println("Deck shuffle at the cut = "+cut);
		      shuffleOnce(cut);
		}//for
	};
	
	
	// REQUIRES: times is the time of using shuffleOnce method to shuffle
	// cards, normally time should be at least 5.

	// EFFECTS: In each time, use Math.random to pick an cut number between
	// 13 - 39, and then call shuffleOnce method with the number;

	Card deal() throws DeckEmptyExecption {//exceptions 
		//nextCard;
		//System.out.println(cardsLeft());
		 if(cardsLeft() == 0) {
			// reset();
			 int cs=cards.size();
			 this.cards = new Deck().cards;
			 shuffle(shTimes);
			 this.reShuffleTimes++;
			 //throw new DeckEmptyExecption(cs);
		 //return null;
		 }
		try {
		Card  nextCard = cards.get(0);//?
			cards.remove(0);
			return nextCard;   
		}finally {
			//inform player?
		}
		 
			//return null;
	};

	
	
	// EFFECTS: returns the next Card to be dealt. If no card 意思是下一张牌是啥,没有就 throw exception
	// remain, throws an instance of DeckEmptyExecption and then
	// reset the deck

	int cardsLeft() {//还剩几张牌
		
		
		return cards.size();
	};
	// EFFECTS: returns the number of card in the Deck that have not
	// been dealt since the last reset/shuffle.

	private Spot getNum(int ins) {// choose the number from two --- ace
		Spot res = null;
		int count = 0;
		for (Spot s : Spot.values()) {
			count = s.ordinal();
			if (count == ins)
				return s;
			count++;
		}
		return null;
		//return res;
	}// my methodsssss

}