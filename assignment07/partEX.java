package assignment07;

public class partEX {
	
/*	Extra credit
	Write a Java function to remove vowels in a string. (Score 2)
	i. The function should take a string as input.
	ii. Should return the input string after omitting the vowels. Here is
	the prototype you can work with
	public String removeVowelsFromString(String	input){
	// add your code here
	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "fwleiuhrtclierbdvdtjg;oijaas;rogj ae crm fnmbwaazZAREF SD";
		String s2 = "      a      ";
		String s3 = "e";
		partEX t1 = new partEX();
		System.out.println(t1.removeVowelsFromString(s2+"_<"));
		System.out.println(t1.removeVowelsFromString(s1)+"<<<");

	}
	
	
	public String removeVowelsFromString(String	input){// there will be space in string?
		if(input == null || input.length() ==0 ) return input; 
		char[] cr= input.toCharArray();
		int[] idx=new int[cr.length];
		int count =0;
		for(int i = 0;i < cr.length; i++) {
			if(cr[i] == 'a' || cr[i] == 'A') {
				idx[i]=1;
				count++;
			}
			if(cr[i] == 'e' || cr[i] == 'E') {
				idx[i]=1;
				count++;
			}
			if(cr[i] == 'i' || cr[i] == 'I'){
				idx[i]=1;
				count++;
			} 
			if(cr[i] == 'o' || cr[i] == 'O'){
				idx[i]=1;
				count++;
			} 
			if(cr[i] == 'u' || cr[i] == 'U') {
				idx[i]=1;
				count++;
			}
		}//for
		
		int newlen = cr.length-count;
		char[] res= new char[newlen];
		int j=0;
		
		for(int i = 0; i < cr.length; i++) {
			if(idx[i] != 1) {
				res[j] = cr[i];
				j++;
			}
		}
		return String.valueOf(res);
	}

}
