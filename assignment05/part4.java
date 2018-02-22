package week05;

public class part4 {
	
	/*4.Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
	input string is valid. (2 scores)
	The brackets must close in the correct order, "()" and "()[]{}" are all valid
	but "(]" and "([)]" are not.*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		part4 t1 = new part4();
		String str = "{})([]";
		String str1 = "()()[][]{}";
		String str2 = "{}{}{}{}{}{}{}{}[][][][][(((((";
		String str3 = "()              {}[    ]   {       }";
		String str4 = "";
		String str5 = "(";
		String str6 = "[}";
		
		System.out.println(t1.isValid(str));
		System.out.println(t1.isValid(str1));
		System.out.println(t1.isValid(str2));
		System.out.println(t1.isValid(str3));
	    System.out.println(t1.isValid(str4));
	    System.out.println(t1.isValid(str5));
	    System.out.println(t1.isValid(str6));
	}
	
	public boolean isValid(String string) {
		if(string == null || string.length()<2)
			return false;
		
		char leftSB = '(';//short for small brackets.
		char rightSB = ')';
		char leftMB = '[';// middle brackets
		char rightMB = ']';
		char leftBB = '{'; // big brackets
		char rightBB = '}';

		char[] str = removeBlank(string.toCharArray()) ;
		int len = str.length;
		
		for (int i = 0;i<len;i++) {
			if (str[i] == leftSB){
				if (str[i+1] == rightSB) {
					if (i+1 == len)
						return true;
					else {
						i++;
						continue;
					}//end else
				}else
					return false;
			}else if (str[i] == leftMB){
					if (str[i+1] == rightMB) {
						if (i+1 == len)
							return true;
						else {
							i++;
							continue;
						}//end else
					}else
						return false;
			}else if (str[i] == leftBB){
					if (str[i+1] == rightBB) {
						if (i+1 == len)
							return true;
						else {
							i++;
							continue;
						}//end else
					}else
						return false;
			}else 
				return false;//end if bb
		}//end loop
		return true;
	}//end method
	
	private char[] removeBlank(char[] charArray) {
		char blank = ' ';
		int j = 0;
		
		for (char i:charArray) {
			if (i == blank)
				j++;
		}//end loop
		
		char[] temp = new char[charArray.length-j];
		int n=0;
		
		for (char i:charArray) {
			if (i != blank) {
				temp[n] = i;
			    n++;
			}//endif
		}//end loop
		return temp;
	}
}
