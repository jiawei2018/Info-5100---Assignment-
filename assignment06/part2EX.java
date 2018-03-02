package assignment06;

import java.util.*;

public class part2EX {
	/*
	 * Given a matrix of m x n elements (m rows, n columns), return all elements of
	 * the matrix in spiral order. (Score 2) For example, Given the following
	 * matrix: {{1,2,3}, {4,5,6}, {7,8,9}} You should return {1,2,3,6,9,8,7,4,5}.
	 */

	public static void main(String[] args) {
		part2EX t1 = new part2EX();
		int[][] a1;
		int[][] a2;
		a1 = part2EX.makeArray(3, 3);
		a2 = part2EX.makeArray(5, 5);
		List<Integer> r1 = new ArrayList<Integer>();
		r1 = t1.spiralOrder(a1);
		System.out.println(r1);

	}

	public static int[][] makeArray(int m, int n) {// m rows,n columns
		int a = 0;
		int[][] res = new int[m][n];

		for (int i = 0; i <= m - 1; i++) {
			for (int j = 0; j <= n - 1; j++) {
				res[i][j] = a++;
			}  
		}  
		return res;
	}// end method

	public List<Integer> spiralOrder(int[][] matrix) {
		// write your code here
		List<Integer> res = new ArrayList<Integer>();
		int m = matrix.length;
		int n = matrix[0].length;
		int rb = 0, re = m - 1, cb = 0, ce = n - 1;

		while (rb <= re && cb <= ce) {//
			for (int i = cb; i <= ce; i++)
				res.add(matrix[rb][i]);
			rb++;

			for (int i = rb; i <= re; i++)
				res.add(matrix[i][ce]);
			ce--;

			if (rb <= re) {
				for (int i = ce; i >= cb; i--)
					res.add(matrix[re][i]);
			}//if
			re--;

			if (cb <= ce) {
				for (int i = re; i >= rb; i--)
					res.add(matrix[i][cb]);
			}//if
			cb++;
		} // end loop
		return res;
	}//end method

}
