package porject_1_jw;

import java.util.Scanner;

public class human extends Player{

	human(int bankroll, int minimum) {
		super(bankroll, minimum);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int bet() {
	 	if(bankroll <= minimum) {
    		//System.out.println("Your are broke! hahahaha!  get out!");
    		return -1; 
    	}
    	Scanner sc1=new Scanner(System.in);//input for user
    	System.out.println("Your banlance is : "+bankroll+"input your bet ... the smallest is $"+minimum);
    	
    	int bet = Integer.valueOf(sc1.nextLine()); // need test here input
        while(bet > bankroll) {
        	System.out.println("input error. re-input your bet");
        	bet = Integer.valueOf(sc1.nextLine());
        }
    	
    	bankroll = bankroll - bet;
    	
    	//from scanner
    	return bet;
	}

	@Override
	public boolean draw(Card dealer) {
		//System.out.println("....................");
		Scanner sc = new Scanner(System.in);
		System.out.println((int)this.hand.getHandValue().getcount() +"  <--   your total point.       draw?(y/n)");
		
		boolean input = true;
		while(input) {
			
		    String in = sc.nextLine();
			if(in.equals("y")||in.equals("Y")) {
				//Card  ;
				
				//this.getCard(dealer, 0);//??? why name the card dealer
			     return true;
			}else if(in.equals("n") || in.equals("N")) {
				input =false;//do nothing
			}else
				input= false;
		}
		return false;
	}

	@Override
	public void expose(Card c) {
		//no need for human...
		// TODO Auto-generated method stub
		//we need a assistant method  to mem the card to make a recommendation
		//exposedToMe = c.getSpot().getValue();
		
	}

	@Override
	public void shuffled() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cleanInTrick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cleanToNewRound() {
	    this.hand.discardAll();
		// TODO Auto-generated method stub
	}
	private void recommand() {
		//something 
	}

	@Override
	public void getCard(Card c, int times) {
		// TODO Auto-generated method stub
		this.hand.addCard(c);
		
	}

}
