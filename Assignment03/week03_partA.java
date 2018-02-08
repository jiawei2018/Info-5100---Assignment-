package ass0302;



 
public class AAA {
	public static double employeeSalary(double hours){  
	    
		double results=0;
		if (hours>=0) {
			if(hours<=36) {
				results=hours*15;
			}else{
				results=36*15+(hours-36)*15*1.5;
			}
		}else {
			results=0;
		}
		
		
	return results;	
	}
	
	public static void main(String[] args) {
		 
		System.out.println(Math.pow(1.1, 100));
	}



}
