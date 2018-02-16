package week04;
import java.math.*;
import java.util.*;
import java.util.regex.Pattern;

public class part4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		part4 t1=new part4();
		String st=t1.startG();//choose one number
		System.out.println("Now begin your guesses.you have only 10 times...Good luck");
		//System.out.println(">>>>>>>>>>>>>>>>"+st);
		t1.playMe(st);
	}//end main
	
	public  String startG() {//generate a random 4-dig number, we can have 0 at first digi...
		int i=0;
		String res="";
		while( i<4) {
			int j= (int)(Math.random()*10);
				res=res+j;
			i++;
		}//end loop	
	return res;	
	}//end method
	
	
	public static boolean isInt(String str) {  //judge if a string is a int number
	    Pattern pattern = Pattern.compile("^[-+]?\\d+$"); 
	return pattern.matcher(str).matches();  
	}//end method
	
	private void playMe(String str) {
		Scanner sc1=new Scanner(System.in);
		System.out.println("input 4-digis of nums");
		for (int i=1;i<=10;) 
		{
			System.out.println("input your No."+i+" guess");
			String tep=sc1.nextLine();
			if (tep.length()!=4||isInt(tep)==false) 
				System.out.println("Input error...MUST BE 4-digi NUMS");
			else {
				i++;
				String st=checkNums(str, tep);
				System.out.println(st);
				if(st.equals("4A0B")) {
					System.out.println("you are right....");
					sc1.close();
					break;
				}
			}//end else if
		}//end loop
	}//main play
	
	public static int charToInt(char ch) {  
	    return Integer.parseInt(String.valueOf(ch));  
	} //end method

	public static String checkNums(String in,String guess) {
		    int len=in.length();  
	        int i=0;  
	        int j=0;  
	        int count[]=new int[10];  
	       
	        for(int k=0;k<len;k++){  
	            int inInt=charToInt(in.charAt(k));  
	            int gsInt=charToInt(guess.charAt(k));  
	            if(gsInt==inInt){  
	                i++;  
	            }else{ 
		              
		                if(count[gsInt]>0)  {           
		                	j++;   
		                }
		                 
		                if(count[inInt]<0) {
		                    j++;
		                }
		                count[gsInt]--;                       
		                count[inInt]++;    
	                 }//end if else  
	        }//end for loop  
	        return i+"A"+j+"B";  
	}//end method
	
}
