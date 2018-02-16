package week04;
import java.util.*;

public class part2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 [Step 1] Use a hashMap and a for loop to store the element in the int
//		 array int[] A = [1,4,5,2,2,2,6,8,3,2,1]. 
//       [Step 2]Delete 6 and 8 in the hashMap.
//		 [Step 3]Return to boolean value that whether ¡°4¡± in the map. Print the
//		 results in step 1 ,2 and 3;(2 scores).
		part2 t1=new part2();
		HashMap hm=new HashMap();
		int[] A = {1,4,5,2,2,2,6,8,3,2,1};
		
	    hm=t1.putInt(A);
		System.out.println("step 1 "+hm);//step1

        t1.delIntOfHM(hm, 6);
        t1.delIntOfHM(hm, 8);
        System.out.println("step 2 "+hm);//step2
         
        t1.isHereHas(hm, 4);//step 3
	}
	
	public HashMap putInt(int[] ins) {
		HashMap hm=new HashMap();
		for(int i=0;i<=ins.length-1;i++)
			hm.put(i,ins[i]);
		return hm;
	}//end method
	
	public void delIntOfHM(HashMap inh,int del){
		Iterator  it=inh.keySet().iterator();//       entrySet().iterator();
		while(it.hasNext()) {
			Object key = it.next();
		    Object val = inh.get(key);
			if (Integer.valueOf(val.toString())==del)  
				 it.remove();
		}//end loop
	}//end method
	
	
	private void isHereHas(HashMap  inh,int i) {
		if(inh.containsValue(Integer.valueOf(i)))
		    System.out.println("Yes we have "+i+" in map.");
		else
			System.out.println("No we do not have "+i+" in map.");
	}//end method

}
