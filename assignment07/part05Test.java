package assignment07;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class part05Test {

	@BeforeAll
		static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	public void testFindMedianSortedArrays() {
		part05 t1 = new part05();
		
		int[] n1 = {1,2};
		int[] n2 = {3,4};
		int[] n3 = {1,3};
		int[] n4 = {2};
		
		int[] n5 = {1};
		int[] n6 = {2};
		int[] n7 = {1,3,7};
		int[] n8 = {2,4,8};
		int[] n9 = {-1,0};
		int[] n0 = {1,2};
		double a1= new part05().findMedianSortedArrays(n3, n4);
		double a2= new part05().findMedianSortedArrays(n1, n2);
		double a3= new part05().findMedianSortedArrays(n9, n0);
		double a4= new part05().findMedianSortedArrays(n5, n6);
		double a5= new part05().findMedianSortedArrays(n7, n8);
		
		Assert.assertTrue(2.0== a1);
		TestCase.assertTrue(2.5==a2);
		TestCase.assertTrue(0.5==a3);
		TestCase.assertTrue(1.5==a4);
		TestCase.assertTrue(3.5==a5);
		
	}

}
