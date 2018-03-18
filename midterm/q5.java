package midterm;

import java.util.ArrayList;

public class q5 {
	
	
/*	Question 5 of 5 10 pts
	Extra Credit
	A Maze is given as N*N binary matrix of blocks where source block is the
	upper left most block i.e., maze[0][0] and destination block is lower
	rightmost block i.e., maze[N1][N1]. A rat starts from source and has to
	reach destination. The rat can move only in two directions: forward and
	down.
	In the maze matrix, 0 means the block is dead end and 1 means the block
	can be used in the path from source to destination. Your function should
	take the maze as input and return an arrayList of the resulting path. If no
	path is found return empty list.
	Example:
	{1, 0, 0, 0}
	{1, 1, 1, 1}
	{0, 1, 0, 0}
	{1, 1, 1, 1}
	

	
	ex1:
	
	{1, 0, 0, 0, 1, 0, 1, 1}
	{1, 1, 1, 1, 1, 1, 0, 1}
	{1, 0, 1, 0, 0, 0, 1, 1}
	{1, 0, 1, 0, 1, 0, 1, 1}
	{1, 0, 1, 1, 1, 1, 1, 1}
	{1, 0, 1, 0, 0, 0, 1, 1}
	{1, 0, 1, 0, 1, 0, 1, 1}
	{1, 1, 1, 1, 1, 1, 1, 1}
	
	Output:
	[[0, 0], [1, 0], [1, 1], [2, 1], [3, 1], [3, 2], [3, 3]]
	class Cell{
	int x,y;
	Cell(int x, int y){
	this.x = x;
	this.y = y;
	}
	public String toString(){
	return "["+this.x +", "+this.y+ "]";
	}
	}
	class Solution{
	public ArrayList<Cell> findPath(int[][] maze){
	//your code
	}*/

	public static void main(String[] args) {
		
		int[][] a1={{1, 0, 0, 0},{1, 1, 1, 1},{0, 1, 0, 0},{1, 1, 1, 1}};
		q5 t1 = new q5();
		System.out.println("=========================================");
		q5.showme(t1.findPathB(a1) );
	}
	
	private static void showme(ArrayList<Cell>  arr) {
		for(int i =0 ; i< arr.size();i++) {
			System.out.println(arr.get(i));
		}
		
	}
	
	public ArrayList<Cell> findPathB(int[][] maze){
		ArrayList<Cell> res = new ArrayList<Cell>();
		if(maze.length == 0  || maze == null) return res;
		
		if(maze.length == 1 &&  maze[0].length == 1) {
			Cell c1 = new Cell(0,0);
			res.add(c1);
			return  res;
		}
		int[][] tmp = maze;
		q5.love(res,tmp, 0, 0);
		return res;
	}
	
	
	private static  void love(ArrayList<Cell> route,int[][] maze , int idx , int idy) {
		
//		System.out.println(idx+" <<x   "+ idy +" <<y");
		int row = maze.length;
		int col = maze[0].length;
		
		if(idx+1 == row-1 && idy == col-1) {
			Cell c = new Cell(idx+1,idy);
			route.add(0,c);
		}else if(idx == row-1  && idy+1 == col-1) {
			Cell c = new Cell(idx,idy+1);
			route.add(0,c);
		}
		
		 if((idx+1) <= row && (idy+1) <=col ) {
			 if(idx+1 == row && idy+1 == col) return;
				if(idx+1 == row && maze[idx][idy+1] == 1 ) {
					Cell c = new Cell(idx,idy);
					love(route,maze,idx,idy+1);
					route.add(0,c);
				}else if(idy+1 == col  &&  maze[idx+1][idy] == 1  ) {
					Cell c = new Cell(idx,idy);
					love(route ,maze,idx+1,idy);
					route.add(0,c);
				}else {
					if(maze[idx+1][idy] == 1 ) {
						Cell c = new Cell(idx,idy);
						love(route ,maze,idx+1,idy);
						route.add(0,c);
					}else if(maze[idx][idy+1] == 1 ) {
						Cell c = new Cell(idx,idy);
						love(route,maze,idx,idy+1);
						route.add(0,c);
					}else {
						maze[idx][idy] =0;
						route.remove(route.size()-1);
				}//last else
		     }//2rd if
		  }//end if
	  }//end method
}// public class

    class Cell{
	     int x,y;
		Cell(int x, int y){
			this.x = x;
			this.y = y;
		}
		public String toString(){
			return "["+this.x +", "+this.y+ "]";
			}
    }