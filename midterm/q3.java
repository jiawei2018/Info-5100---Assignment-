package midterm;
import java.util.*;
public class q3 {
	
/*	Question 3 of 5 7 pts
	Write a function rotate(ar[], d, n) that rotates arr[] of size n by d
	elements.
	1234567
	Rotation of the above array by 2 will make array
	3456712
	
	class RotateArray{
	Public void rotatedArray(int nums[], int d, int n){
	}
	}*/

	public static void main(String[] args) {
		
		int[] a1 = {1,2,3,4,5,6,7};
		q3 t1 = new q3();
		
		t1.rotatedArray(a1, 2, 7);
		
		 q3.showme(a1);
		// TODO Auto-generated method stub
	}
	
	private static void showme(int[] ins) {
		for(int i =0 ; i< ins.length; i++)
			System.out.println(ins[i]);
	}
	
	public void rotatedArray(int nums[], int d, int n){
		 d = nums.length -(d+1);
		 q3.ra(nums, 0, nums.length-1);
		 q3.ra(nums, 0, d);
		 q3.ra(nums, d+1, nums.length-1);
		
	}//method
	
	private static void ra(int[] ins , int start , int end) {
		int tmp=0;
		int i,j;
		i=start;j=end;
		
		while(i<j) {//swap
			tmp = ins[i];
			ins[i]= ins[j];
			ins[j]=tmp;
			i++;
			j--;
		}//while
	}//method
	

}
