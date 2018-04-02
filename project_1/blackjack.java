package porject_1_jw;

import java.util.Scanner;
import java.util.regex.Pattern;

public class blackjack {
	
	//Deck tableDeck = new  Deck();// a table's deck for playing
	
	    	//The driver program, when run, takes three arguments:
    	//<bankroll> <tricks> <minimum-wager> [simple|counting]
   /* 	You are to put your implementation of this driver program in a file named blackjack.java.
    	The driver program, when run, takes three arguments:
    	<bankroll> <tricks> <minimum-wager> [simple|counting]
    	The first argument is an integer denoting the player¡¯s starting bankroll. The second argument is the
    	maximum number of tricks to play in the simulation. The third argument is the minimum wager in
    	one trick. You can assume that these three integers input by the user are positive (¡Ý1). The final
    	argument is one of the two strings ¡°simple¡± or ¡°counting¡±, denoting which of the two players to use in
    	the simulation. For example,
    	100 3 5 simple
    	Then*/

    public static void main(String[] args) throws DeckEmptyExecption {
	    // write your code here first you need to use system in to ask four parameter from
        // console. Then run the game and print the relevant game step.
    	
    	blackjack t1 = new blackjack();
             t1.driver();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
    public void driver() throws DeckEmptyExecption {
    	Scanner sc = new Scanner(System.in);   //input bankroll
        System.out.println("Input the initial bankroll for all users ");
    	String bankroll =   sc.nextLine() ; //judge100
    	while(!isInt(bankroll) || Integer.valueOf(bankroll)<=0) {
    		System.out.println("Input error, must be a positive Integer");
    		System.out.println("Input the initial bankroll for all users");
    		bankroll =   sc.nextLine() ;
    	}
    	int ba = Integer.valueOf(bankroll);
    	
    	System.out.println("Input the minumum wager."); //input min wager
    	String minimum = sc.nextLine();
    	while(!isInt(minimum) || Integer.valueOf(minimum)<=0 || Integer.valueOf(minimum) > ba) {
    		System.out.println("Input error, must be a positive Integer and wager must smaller than bankroll");
    		System.out.println("Input the minimum wager for all users");
    		minimum =   sc.nextLine() ;
    	}
    	int min = Integer.valueOf(minimum);
    	
    	System.out.println("Input the numbers of Tricks");
    	String tricks = sc.nextLine();
    	while(!isInt(tricks) || Integer.valueOf(tricks)<=0 ) {
    		System.out.println("Input error, must be a positive Integer ");
    		System.out.println("Input the numbers of Tricks");
    		tricks =   sc.nextLine() ;
    	}
    	int tr = Integer.valueOf(tricks);
    	
    	//System.out.println("Choose the player type Simple|counting|human(s|c)  "); // now i think type means this !!
    	//String str = sc.next();
    	String type;
    	int p;//0 means simple    ,  1  means counting  ,2 means human
    	while(true) {
    		System.out.println("Choose the player type Simple|counting|human(s|c)  "); // now i think type means this !!
        	String str = sc.next();
    		if(str.equals("s")||str.equals("S")) {
    			p = 0;
    			type = "s";
    			break;
    		}else if(str.equals("c")||str.equals("C")) {
    			p = 1;
    			type = "c";
    			break;
    		}else if(str.equals("h")||str.equals("H")) {
    			p = 2;
    			type = "h";
    			break;		
    		}else {
    			System.out.println("Input error, must be 's' or 'c' ");
    			//str = sc.nextLine();
    		}
    	}
    	
    	Deck deck = new Deck();//table holds the deck? 
    	
    	deck.shuffle(8);// we first shuffle 7 times or input
    	// or do we need to as k for times?
    	// add a random here
    	System.out.println("=====  a new start  ======");
    	Dealer dealer = new Dealer(ba,min);
    	
    	if(p == 0 ) {//we have our another simple// counting // human or input 
    		SimplePlayer player = new SimplePlayer(ba,min);
    		tsPlay(deck,dealer,player,type,tr);
    	}else if( p == 1 ){
    		CountingPlayer player = new CountingPlayer(ba,min);
    		tcPlay(deck,dealer,player,type,tr);
    	}else if( p == 2) {
    		human player = new human(ba,min);
    		thPlay(deck,dealer,player,type,tr);
    	}else {
    		return;
    	}
    }// method driver
    	
    	
    
    
    private void tsPlay(Deck deck,Dealer dealer,SimplePlayer player,String type,int times) throws DeckEmptyExecption {
    	//play with trick class	
    	//int remainBankroll = player.bankroll;
    	int minimum = player.minimum;//we all the same?
    	int bankroll = player.bankroll;
    	String headline ;
    	
    	Trick t = new Trick(type,bankroll,minimum);
    	
    	//System.out.println(type+" "+bankroll+" "+minimum+" ");
    	t.player = player;
    	t.dealer = dealer;
    	t.deck = deck;
    	for(int i = 1 ;i <= times; i++) {//tr times of tricks    
    		if(t.playerbroke) break;
    		headline = "Trick "+i+"  bankroll $"+player.bankroll;
    		System.out.println("");
    		System.out.println(headline);
    		System.out.println("remain "+deck.cards.size()+ " cards in deck ");
    		t.play();
            //type = c,h,s
    	}//for
    	
    }
    
    private void tcPlay(Deck deck,Dealer dealer,CountingPlayer player,String type,int times) throws DeckEmptyExecption {
    	//play with trick class
    	int minimum = player.minimum;//we all the same?
    	int bankroll = player.bankroll;
    	String headline ;
    	
    	Trick t = new Trick(type,bankroll,minimum);
    	
    	//System.out.println(type+" "+bankroll+" "+minimum+" ");
    	t.player = player;
    	t.dealer = dealer;
    	t.deck = deck;
    	for(int i = 1 ;i <= times; i++) {//tr times of tricks    
    		if(t.playerbroke) break;
    		headline = "Trick "+i+"  bankroll $"+player.bankroll;
    		System.out.println("");
    		System.out.println(headline);
    		System.out.println("remain "+deck.cards.size()+ " cards in deck ");
    		t.play();
            //type = c,h,s
    	}//for
    	
    }
    
    private void thPlay(Deck deck,Dealer dealer,human player,String type,int times) throws DeckEmptyExecption {
    	int minimum = player.minimum;//we all the same?
    	int bankroll = player.bankroll;
    	String headline ;
    	
    	Trick t = new Trick(type,bankroll,minimum);
    	
    	//System.out.println(type+" "+bankroll+" "+minimum+" ");
    	t.player = player;
    	t.dealer = dealer;
    	t.deck = deck;
    	for(int i = 1 ;i <= times; i++) {//tr times of tricks    
    		if(t.playerbroke) break;
    		headline = "Trick "+i+"  bankroll $"+player.bankroll;
    		System.out.println("");
    		System.out.println(headline);
    		System.out.println("remain "+deck.cards.size()+ " cards in deck ");
    		t.play();
            //type = c,h,s
    	}//for
    }
    
    
      
    
       
    
    public static boolean isInt(String str) {  //judge if a string is a int number
	    Pattern pattern = Pattern.compile("^[-+]?\\d+$"); 
	return pattern.matcher(str).matches();  
	}
    	
    
}