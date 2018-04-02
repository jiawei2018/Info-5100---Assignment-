package porject_1_jw;

import java.util.ArrayList;
import java.util.List;

public class GroupOfCards {
    List<Card> cards = new ArrayList<Card>();// no need to make it private,and we need to maike it this way 
    GroupOfCards(){};
      void addCard(Card c){
    	cards.add(c);
    };
    // EFFECTS: adds the card "c" to those presently held.

    void discardAll(){
    	cards.clear();
    	
    };
    // EFFECTS: discards any cards presently held , restoring the state
    // of the cards to empty.

    int getCurrentSize(){//º∏’≈≈∆
    	int len = cards.size();
    	return len;
    }
    // EFFECTS: return the length of cards;
    

    void display(){
    	System.out.println("All cards : ");
    	for(int i = 0; i<cards.size();i++) {
    		System.out.println(cards.get(i)); 
    	}
    }//end method
    //EFFECTS: display every card in cards;

    Card deleteCard(){
    	Card res = cards.get(0);
    	cards.remove(0);
    	return res;
    };
    // EFFECTS: delete the top card from the group of cards and return the
    // deleted card value;


}