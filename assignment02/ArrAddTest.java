
public class ArrAddTest {
    
	
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
