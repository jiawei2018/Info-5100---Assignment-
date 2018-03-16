package assignment07;

import java.util.*;

public class part05 {

	/*
	 * 5.There are two sorted arrays nums1 and nums2 of size m and n respectively.
	 * Find the median of the two sorted arrays. (Score 2) Example 1: nums1 = [1, 3]
	 * nums2 = [2] The median is 2.0 /median is just the middle position nums in an
	 * array? Example 2: nums1 = [1, 2] nums2 = [3, 4] The median is (2 + 3)/2 = 2.5
	 * Here is the prototype you can work with. Class solution{ public double
	 * findMedianSortedArrays(int[] nums1, int[] nums2) { // add your code here } }
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		int[] n1 = {1,2};
		int[] n2 = {3,4};
		int[] n3 = {1,3};
		int[] n4 = {2};
		
		int[] n5 = {1};
		int[] n6 = {2};
		int[] n7 = {1,3,7};
		int[] n8 = {2,4,8};
		int[] n9 = {-1,0};
		int[] n0 = {1,2};*/
		
		//part05 t1 = new part05();
		//System.out.println(t1.findMedianSortedArrays(n5, n6));

	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length == 0 && nums2.length == 0) return 0;
		int mid = 0;
		double a, b;
		List<Integer> la = new ArrayList<Integer>();
		// should merge the two array into one array first!
		int i = 0, j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j])
				la.add(nums1[i++]);
			else
				la.add(nums2[j++]);
		}
		
		while (i < nums1.length)
			la.add(nums1[i++]);

		while (j < nums2.length)
			la.add(nums2[j++]);

		mid = la.size() / 2;
		a = la.get(mid-1);
		b = la.get(mid);

		if (la.size() % 2 == 0)
			return (a + b) / 2;
		else
			return b;
	}//method
}
