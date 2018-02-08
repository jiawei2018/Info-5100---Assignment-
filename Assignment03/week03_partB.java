package ass0302;
import java.util.*;

public class BBB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int[] test1= {1,1,2,0,-1,-1,3,4,-2,7,9,-5,-3,11,-8};
         int target=3;
         
         List<int[]> fee=new ArrayList<int[]>();
         fee=triPlus(test1);
         
         for(int[] u:fee) {
        	 for(int y:u) {
        		 System.out.print(y+" ");
        	 }
         System.out.println("");
         }
                  
	}
	
	public static List<int[]> triPlus(int[] ins) {
 
	     List<int[]>  resultL=new ArrayList<int[]>();
		 Set<String>  results=new HashSet<String>(); 
			 
		 if(ins.length<3) {
			 return null;
		 }else if(ins.length==3) {
			 if(ins[0]+ins[1]+ins[2]==0) {
				 String y=ins[0]+" "+ins[1]+" "+ins[2];
				 results.add(y);
			 }
		 }//end if
		 
			 for (int i=0;i<ins.length-1;i++) {
				 for(int j=i+1;j<ins.length-1;j++) {
					 for(int k=j+1;k<ins.length-1;k++) {
						 if(ins[i]+ins[j]+ins[k]==0) {
							 String t1=ins[i]+" "+ins[j]+" "+ins[k];
							 results.add(t1);
						 }//endif
					 }//inner loop
				 } //mid loop
			 }//end out loop
		
		 for(String ti:results) {
			resultL.add(strInt(ti));
		 }
 	 
	 	return resultL;
	}//end method
    
	 private static int[]    strInt(String str) {//String to int[]
		    ArrayList<String> str1=new ArrayList<String>();
			char[] t=str.toCharArray();
			
			for(int i=0;i<=t.length-1;i++) {
				if(t[i]=='-') {
					String y= Character.toString(t[i]) +Character.toString(t[i+1]) ;
				    str1.add(y);
				    i++;
				}else if(t[i]!=' '&&t[i]!='-') {
					str1.add(Character.toString(t[i]));
				}//end if
		    }//end for
			int[] results=new int[str1.size()];
			 
			for(int j=0;j<=str1.size()-1;j++) {
				results[j]= Integer.parseInt(str1.get(j)) ;
			}
		return results;
	}//end function strInt
	
}//end class
