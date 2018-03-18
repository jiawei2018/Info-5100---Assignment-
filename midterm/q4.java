package midterm;

public class q4 {

	/*
	 * Question 4 of 5 10 pts Given an array of integers and a number x, find the
	 * smallest subarray with sum greater than the given value. Examples: arr[] =
	 * {1, 4, 45, 6, 0, 19} x = 51 Output: 3 Minimum length subarray is {4, 45, 6}
	 * arr[] = {1, 10, 5, 2, 7} x = 9 Output: 1 Minimum length subarray is {10}
	 * arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250} x = 280 Output: 4 Minimum
	 * length subarray is {100, 1, 0, 200} arr[] = {1, 2, 4} x = 8 Output : Not
	 * Possible Whole array sum is smaller than 8. class SmallestSubArraySum{ public
	 * static int smallestSubWithSum(int arr[], int n, int x){ } }
	 */

	public static void main(String[] args) {
		int[] a1 = {1, 4, 45, 6, 0, 19};
		int x1 = 51;
		
		int[] a2 = {1, 10, 5, 2, 7};
		int x2 = 9;
		
		int[] a3 = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
		int x3 = 280;
		
		int[] a4 = {1, 2, 4};
		int x4 = 8;
		
		String s = q4.strRes(a4, x4);
		System.out.println(s+" ---answer");

		
		// TODO Auto-generated method stub

	}
	
	public static String strRes(int arr[],  int x) {
		if(arr.length == 0 || arr ==null) return "no answer";
		
		if(arr.length<2)
			if(arr[0] <= x ) return "no answer";
		
		String res ;
		int tmp = q4.smallestSubWithSum(arr, 0, x);
		
		if(tmp > arr.length)
			res ="Not Possible Whole array sum is smaller than "+x;
		else 
			res = String.valueOf(tmp);
		return res;
	}

	public static int smallestSubWithSum(int arr[], int n, int x) {
		// what is the meaning of input n?
		
		int start = 0;
        int sum = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			while(sum > x ) {
				min = i-start;
				sum -= arr[start];
				if(min == 1 ) return 1;
				start++;
			}// while
		}//for 
		
		//if(sum<x) return -1;

		return min;
	}

}
