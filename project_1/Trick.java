package porject_1_jw;

import java.util.Scanner;

public class Trick {
    // one player's turn + one dealer's turn. But dealer's turn
    // only happens if the player hasn  busted or the player is
    // not dealt a natural 21 .
	
	

    Player player;// = pl  thinking as simple , counting , human????
    Dealer dealer;// =dealer
    int bet;// all bet in one trick?
    int min;
    int nums; // for the 'type'
    String type;
    Deck deck;
    int wager=0;
    //int pwager = 0;
    boolean playerbroke = false;
    
    
    boolean pbust=false, dbust = false;

    Trick(String type, int bankroll, int minimum){//type means what?
    	this.min = minimum;
    	this.type = type;
    	
    	//this.bet = bet 
    	
    };

    void play() throws DeckEmptyExecption{
    	int bankroll = player.bankroll;
    	//String type = "Trick "+nums+" ";// like "Trick 3" ,,,  now we have this method in driver 
    	 //Trick t= new Trick(type,bankroll,min);
    	 wager();//need to add bankrupt check
    	 if(playerbroke) {
    		 return;
    	 }
    	 
    	 if(deck.cards.size()==0) {
    		 deck.cards =new Deck().cards;
    		 deck.shuffle(7);
    		 
    		 player.shuffled();
    		 dealer.shuffled();
    	 }
    	  
			DealFour();
		  
    	 playerTurn();
    	 dealerTurn();
    	 closeTurn();
    	 //t.showTurn();
    }
    

	// execute the five following steps;

    void wager(){
    	int tmp = player.bet();
    	if(tmp == -1) {
    		//System.out.println("broke");
    		System.out.println("player do not have enough banlkroll for more bet...");
    		wager += 0;
    		this.playerbroke = true;
    		return;
    	}else
    	wager += tmp;
    	System.out.println("player bet $"+tmp);
    };

    void DealFour() throws DeckEmptyExecption{// where is deck from. ok, from dealer............
    	//Card[] cf = new Card[4]
    	
    	for(int i =0 ; i< 2; i++) {//two round 
    		//System.out.println(deck.deal());
    		player.getCard(deck.deal(), deck.reShuffleTimes);//(deck.deal());
    		System.out.println("player dealt "+player.hand.cards.get(i));  //player.expose(player.hand.cards.get(i));
    		dealer.getCard(deck.deal(), deck.reShuffleTimes);//(deck.deal());
    		if(i == 0)
    		    System.out.println("dealer dealt "+dealer.hand.cards.get(0));
    		    player.expose(dealer.hand.cards.get(0));
    	}//loop
    	//player.draw(dealer.hand.cards.get(0));
    };
    //After the wager, the dealer deals a total of four cards:
    // the first face-up to the player, the second face-up to
    // himself, the third face-up to the player, and the fourth
    // face-down to himself.

    void playerTurn() throws DeckEmptyExecption{
    	//Scanner scp = new Scanner(System.in);
    	//System.out.println(player.isDraw+"            .........///");
    	while(player.draw(dealer.hand.cards.get(0))) {//continue draw?
    		//give player card
    		Card a = deck.deal();
			player.getCard(a, deck.reShuffleTimes);
			System.out.println("player dealt "+player.hand.cards.get(player.hand.cards.size()-1));
			//dealer.expose(dealer.hand.cards.get(dealer.hand.getCurrentSize()-1));
    	}//loop
    	System.out.println("Player's total is "+player.hand.getHandValue().getcount());
    };

    
    
    
    
    void dealerTurn() throws DeckEmptyExecption{
    	//dealer will always hit if its value is smaller than player or player doesnt have a BJ
    	if(!player.hand.busted && !player.hand.isBJ()) {
    		dealer.draw(null);
    		System.out.println("dealer's hole card is "+ dealer.hand.cards.get(1));
    		player.expose(dealer.hand.cards.get(1));
	    	while(  dealer.isDraw  ) {
	    	 
	    			if(dealer.hand.busted) {
	    			System.out.println("dealer is bust.");
	    			//dbust = true;
	    			return;
	    			} //dealer.needExposed = true;//no code in dealer class
	    		dealer.otherPlayValue(player.hand.getHandValue().getcount()); //let the dealer know player's value
	    		//dealer.expose(dealer.hand.cards.get(0));//0 is the hole card
	    	
	    	    Card a =  deck.deal();// this need to test
	    		dealer.getCard(a, deck.reShuffleTimes);
	    		player.expose(a);
	    		dealer.draw(null);
	    		System.out.println("dealer dealet "+a);
	    		//player.expose(a);
	    		//dealer.expose(dealer.hand.cards.get(dealer.hand.getCurrentSize()-1));
	    	} //loop
	    	System.out.println("Dealer's total is "+dealer.hand.getHandValue().getcount());
    	}else
    		return;
    		//dealer.setPlayerBusted(true);//did we need this?
    	
    };//dealer's turn

    // dealer's turn only happens if the player hasn¡¯t busted or the player is
    // not dealt a natural 21 .

    void closeTurn(){//here is to print all information of this trick?
    	if(player.hand.isBJ()) {
    		//means play have an  natural 21
    		player.bankroll += wager+wager*3/2; 
    		//dealer.bankroll -= wager*3/2;
    		System.out.println("player has a blackjack");
    		//should be int his bankroll will increase by 15
    	}else if(dealer.hand.busted && !player.hand.busted   ) {//,dealer B  ,and player not so --player wins   
    		player.bankroll += wager+wager;
    		//dealer.bankroll -= wager;//do we need this?
    		System.out.println("dealer busted, player wins");
    	}else if(!dealer.hand.busted && player.hand.busted ) {
    		System.out.println("player busted.");
    		//dealer bankroll++
    	}else if((!dealer.hand.busted && !player.hand.busted ) &&(player.hand.getHandValue().getcount() == dealer.hand.getHandValue().getcount())  ){//tie, or push
    		player.bankroll += wager;
    		System.out.println("there is a Tie....");
    	}else if((!dealer.hand.busted && !player.hand.busted ) &&(player.hand.getHandValue().getcount() > dealer.hand.getHandValue().getcount()) ) {//do nothing
    	    //player wins
    		player.bankroll += wager+wager;
    		System.out.println("player wins");
    	}else if((!dealer.hand.busted && !player.hand.busted ) &&(player.hand.getHandValue().getcount() < dealer.hand.getHandValue().getcount())) {
    		//dealer wins
    		System.out.println("dealer wins");
    	}else {	
    		
    		dealer.bankroll += wager;
    	    System.out.println("dealer wins");
    	}
    	//we need to renew the play and dealer 's hand
    	//Card empty = new Card(null, null);
    	cleaning();
    	
    /*	player.hand.discardAll();
    	player.expose(empty);
    	dealer.hand.discardAll();
    	dealer.otherPlayValue(0);*/
    	//reset pasted value
    };//close turn
    
    void cleaning() {
    	player.cleanToNewRound();
    	dealer.cleanToNewRound();;
    	//player.resetExposed();
    	//dealer.otherPlayValue(0);
    	wager = 0;
    }
    
    
    
     void showTurn() {
    	 //on progress
    	 
 		// TODO Auto-generated method stub
 		
 	}
    // compare the count and give back reward to player if win.
    //the player had wagered 10, the player would win 15 (i.e., his bankroll will increase by 15) if dealt a
   // natural 21.
	
}