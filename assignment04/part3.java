package week04;
import java.util.Scanner;
public class part3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		part3 t1= new part3();
		Scanner sc1=new Scanner(System.in);
		System.out.println("Input an integer...");
		String tep=sc1.nextLine();
		int t=Integer.valueOf(tep);
		System.out.println("The answer is "+t1.addDigits(t));
        sc1.close();
	}
	
//	i. function takes an integer as input and returns its sum of digits.
//	ii. for example input = 37, sum = 3+7 = 10, sum = 1+0 = 1. result = 1.
//	Here is the prototype you can work with
	public int addDigits( int input){
		String temp=Integer.toString(input);
		char[] charstr1=temp.toCharArray();
		boolean out=true;
		int te=addAll(charstr1);
		if(te<10)
			return te;

		while(out) {
			if(te>9) {
				String tep1=Integer.toString(te);
				char[] c1=tep1.toCharArray();
				te=addAll(c1); 
			}else
				out=false;
		}//end loop
	    return te;
	}//end method
	
	private int addAll(char[] ins) {
		int all=0;
		for(int i=0;i<=ins.length-1;i++) 
		   all=all+Integer.valueOf((String.valueOf(ins[i])));
		return all;
	}//end method


}//end class
