//scores : 2 / 2
package week05;

public class partEX {

/*	In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of
	either replacing one occurrence of "XL" with "LX", or replacing one occurrence
	of "RX" with "XR". Given the starting string start and the ending string end, return True if and
	only if there exists a sequence of moves to transform one string to the other.(2 scores)
	Example:
	Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
	Output: True
	Explanation:
	We can transform start to end following these steps:
	RXXLRXRXL ->
	XRXLRXRXL ->
	XRLXRXRXL ->
	XRLXXRRXL ->
	XRLXXRRLX*/    
	//??? why at the last part 'rxrxl'   is 'xrrlx' not 'xrxrl'?
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		partEX t1 = new partEX();
		String str = "RXXLRXRXL";
		
		System.out.println(t1.isHave(str));
	}//end main
	
	
	private boolean isHave(String a) {
		String b;
		b = tranStr(a);
		
		if (b == a) {
			return false;
		}else 
			return true;
	}
	
	
	
	private static String tranStr(String string) {
		if (string == null || string.length()<2)
			return string;
		char[] str1 = string.toCharArray();
		char[] tmp;
		int len = str1.length;
		int y=1;//tto =judge if the work is done
			for (int i = 0;i<len-1;i++) {
				tmp =str1;
				   if (str1[i] == 'R' && str1[i+1] == 'X') {
						str1[i] = 'X';
						str1[i+1] = 'R';
						i++; 
					}else if (str1[i] == 'X' && str1[i+1] == 'L') {
					 
						str1[i] = 'L';
						str1[i+1] = 'X';
						i++;
					}else {
						i+=2;
					} 
				if (i == len -1  ) {
					y = 0;
				    break;
				}//end if
			}//end for loop
    return String.valueOf(str1);
	}//end method

}
