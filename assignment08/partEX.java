package assignment10;
import java.util.*;
public class partEX {
	
/*	Extra credit
	Given a string that contains only digits 0-9 and a target value, return all
	possibilities to add binary operators (not unary) +, -, or *between the digits
	so they evaluate to the target value.(2 scores)
	Examples:
	"123", 6 -> ["1+2+3", "1*2*3"]
	"232", 8 -> ["2*3+2", "2+3*2"]
	"105", 5 -> ["1*0+5","10-5"]
	"00", 0 -> ["0+0", "0-0", "0*0"]
	"3456237490", 9191 -> []*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		partEX t1 = new partEX();
		String s = "123456";
		//System.out.println(t1.addOperatorsC(s,6));
		//System.out.println(s.substring(1));//iawei
		//System.out.println(s.substring(3));//wei
	}
	
	
	
	
	    List<String> res;
	  
	    public List<String> addOperatorsC(String num, int target) {
	        helper(num, target, "", 0, 0);
	        return res;
	    }
	    
	    private void helper(String num, int target, String tmp, long currRes, long prevNum){

	        if(currRes == target && num.length() == 0){
	            String exp = new String(tmp);
	            res.add(exp);
	            return;
	        }

	        for(int i = 1; i <= num.length(); i++){
	            String currStr = num.substring(0, i);

	            if(currStr.length() > 1 && currStr.charAt(0) == '0'){

	                return;
	            }

	            long currNum = Long.parseLong(currStr);

	            String next = num.substring(i);

	            if(tmp.length() != 0){

	                helper(next, target, tmp+"*"+currNum, (currRes - prevNum) + prevNum * currNum, prevNum * currNum);//m
	          
	                helper(next, target, tmp+"+"+currNum, currRes + currNum, currNum);
	             
	                helper(next, target, tmp+"-"+currNum, currRes - currNum, -currNum); 
	            } else {
	             
	                helper(next, target, currStr, currNum, currNum);
	            }

	        }//for
	    }//method
	
	    
	    
	    
	
}
