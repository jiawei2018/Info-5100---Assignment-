package midterm;

public class q2 {
	
/*	Question 2 of 5 7 pts
	Given an array of integers sorted in ascending order, find the starting and
	ending position of a given target value.
	Your algorithm's runtime complexity must be in the order of O(log n).
	If the target is not found in the array, return [-1, -1].
	For example,
	Given [5, 7, 7, 8, 8, 10] and target value 8,
	return [3, 4].
	class Solution {
	public int[] searchForRange(int[] nums, int target) {
	}
	}*/

	public static void main(String[] args) {
		int[] a1 = {5, 7, 7, 8, 8, 10};
		int[] a2 = {1,2,2,3,4,4,5,6,6,6,7,8,9,11,11,11,11};
		q2 t1 = new q2();
		//System.out.println(t1.searchForRange(a1, 7));
		//System.out.println(t1.searchForRange(a2, 9));
		
		q2.showme(t1.searchForRange(a1, 7));
		q2.showme(t1.searchForRange(a2, 9));
		
	}
	
	private static void showme(int[] ins) {
		for(int i =0 ; i< ins.length; i++)
			System.out.println(ins[i]);
	}
	
	public int[] searchForRange(int[] nums, int target) {
		
		int[] res = {-1,-1};
		if(nums == null || nums.length == 0) return res;
		if(nums.length == 1 ) {
			if(nums[0] == target){
				int[] a1 = {0,0};
				return a1; 
		    }else 
			    return res;
		}
		
		int mid;
		int start = 0;
		int end = nums.length-1;
		
		while(nums[start] < nums[end]) {//quit when nums[st] == target   and nums[ed] == target ;means the answer
			                            // also means we set the condition for loop to the answer;
			
			mid = start+(end -start)/2;
			if(nums[mid] > target) {
				end = mid-1;
			}else if(nums[mid]< target) {  
				start = mid +1;
			}else {//nums[mid] == target;  we shrink  the range at the edge by 1 every loop;
                if (nums[start] < target) start++;
                if (nums[end] > target) end--;
            }
		}//while
		
		if(nums[start] == target) {//for [2,2] , x=1
			res[0] = start;
			res[1] = end;
		}
		
		return res;
	}//method
	
	

	
	

}
