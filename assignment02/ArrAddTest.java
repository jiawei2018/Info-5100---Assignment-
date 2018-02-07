
public class ArrAddTest {
    
	／* 1, your method name should be lower case character
	*   2, what is return value? for example, it may like: "public int[] arrAddTest(int[] arrIn,int target) {"
	*   3, we always use System.out.println() in the main method and get the return value in the specific method.	
	*   4, i am sorry to say that i don't think your file can run in eclipse properly.
        *   5, i know you do not have java programming experience before. But please pay attention to this details next time.
		scores: 9 / 10    
        */
	public ArrAddTest(int[] arrIn,int target) {
		
		if(arrIn.length<=2) {
			System.out.println("Less than two nums.....");
			System.out.println(arrIn);
		}else {
			int i=0;
			boolean flag=false;
			for(i=0;i<arrIn.length;i++) {//outer loop
				if(flag==true)break;
				
				int j=i;
				for(j=i+1;j<arrIn.length;j++) {//inner loop
					if (arrIn[i]+arrIn[j]== target) {
						
						System.out.println("the answer is "+i+" and "+j);
						flag=true;
						break;
					}else if(i+1==arrIn.length){
						System.out.println("No answer.");
													
					}else{
						
					}//end else
					
				}//end innerloop
				
			}//end outer loop
			
		}//end elseif
		
	}//end method



   public static void main(String[] args) {
	  int[] test01= {1,2,5,8,11,13};
	  int target0=9;
   	 
	  new ArrAddTest(test01,target0);
	    
   }
   	   
}
